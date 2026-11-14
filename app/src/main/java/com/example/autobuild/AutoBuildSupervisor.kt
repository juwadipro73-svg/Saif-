package com.example.autobuild

import android.content.Context
import android.util.Log
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.example.data.local.ProviderSettingsManager
import com.example.ui.components.ProjectData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

/**
 * Advance Auto-Builder — always-on supervisor.
 *
 * Keeps unfinished project work moving with zero taps from the user:
 * - on every app start, quietly resumes interrupted builds after a short settle delay,
 * - every 6 hours, a battery-friendly worker continues anything still pending
 *   (LLM calls need network, so the worker requires connectivity).
 *
 * Completion is announced with the standard "Work done" notification only when the
 * user is away from the app (see AgentWorkNotifier); inside the app there is no noise.
 */
object AutoBuildSupervisor {
    private const val TAG = "AutoBuildSupervisor"
    private const val WORK_NAME = "saif_autobuild_continue"
    private const val STARTUP_SETTLE_MS = 20_000L

    fun onAppStart(context: Context) {
        val app = context.applicationContext
        try {
            schedulePeriodic(app)
        } catch (e: Exception) {
            Log.w(TAG, "Periodic scheduling skipped: ${e.message}")
        }
        try {
            CoroutineScope(Dispatchers.IO).launch {
                delay(STARTUP_SETTLE_MS)
                try {
                    val lines = AutoBuildOrchestrator.continuePendingWork(app)
                    if (lines.isNotEmpty()) Log.i(TAG, "Startup resume: $lines")
                } catch (e: Exception) {
                    Log.w(TAG, "Startup resume skipped: ${e.message}")
                }
            }
        } catch (e: Exception) {
            Log.w(TAG, "Startup resume launch skipped: ${e.message}")
        }
    }

    fun schedulePeriodic(context: Context) {
        val request = PeriodicWorkRequestBuilder<AutoBuildWorker>(6, TimeUnit.HOURS)
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .setRequiresBatteryNotLow(true)
                    .build()
            )
            .addTag(WORK_NAME)
            .build()
        WorkManager.getInstance(context.applicationContext)
            .enqueueUniquePeriodicWork(WORK_NAME, ExistingPeriodicWorkPolicy.KEEP, request)
    }

    fun hasPendingWork(context: Context, appName: String): Boolean {
        return try {
            val dir = BuildCheckpointStore.projectDirFor(context.applicationContext, appName)
            BuildCheckpointStore.hasPendingWork(dir)
        } catch (_: Exception) {
            false
        }
    }

    suspend fun continueProjectNow(context: Context, project: ProjectData): String {
        return try {
            AutoBuildOrchestrator.continueOneProject(context.applicationContext, project)
        } catch (e: Exception) {
            "Continue me dikkat aayi (${e.message}). Baad me khud retry hoga."
        }
    }
}

/**
 * Battery-friendly periodic continuation. Always returns success: anything still
 * pending is simply picked up by the next run — no retry storms, no quota burn.
 */
class AutoBuildWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        return try {
            try {
                ProviderSettingsManager.init(applicationContext)
            } catch (_: Exception) {
            }
            AutoBuildOrchestrator.continuePendingWork(applicationContext)
            Result.success()
        } catch (_: Exception) {
            Result.success()
        }
    }
}
