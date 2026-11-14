package com.example.icon

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import java.util.Calendar
import java.util.concurrent.TimeUnit

/**
 * The launcher icon follows the clock. It is the same icon all day: only its colours and small details (sun, moon,
 * stars) change, in eight steps. A launcher draws a static picture, so Android cannot fade it; the steps are
 * small on purpose, so each hour looks like a gentle shift of the one before.
 *
 * Mechanism: the manifest holds [PHASE_COUNT] launcher aliases (`com.example.IconPhase0` ...). Exactly one is
 * enabled. [sync] enables the alias that fits the hour and disables the others without restarting the app.
 */
object TimeAwareIcon {
    const val PHASE_COUNT = 8
    private const val WORK_NAME = "saif_time_icon"
    private const val PREFS = "saif_time_icon"
    private const val KEY_ENABLED = "enabled_phase"

    /** Phase for an hour of the day (0-23): dawn, morning, noon, afternoon, sunset, evening, night, late night. */
    fun phaseForHour(hour: Int): Int = when (((hour % 24) + 24) % 24) {
        in 4..6 -> 0
        in 7..9 -> 1
        in 10..13 -> 2
        in 14..16 -> 3
        in 17..18 -> 4
        in 19..21 -> 5
        22, 23, 0 -> 6
        else -> 7 // 1..3
    }

    fun currentPhase(): Int = phaseForHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))

    private fun alias(context: Context, phase: Int) = ComponentName(context, "com.example.IconPhase$phase")

    /** Makes the launcher show the icon for the current hour. Cheap when nothing changes. */
    fun sync(context: Context) {
        try {
            val app = context.applicationContext
            val pm = app.packageManager
            val wanted = currentPhase()
            val prefs = app.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            val wantedState = pm.getComponentEnabledSetting(alias(app, wanted))
            val alreadyOn = wantedState == PackageManager.COMPONENT_ENABLED_STATE_ENABLED ||
                (wantedState == PackageManager.COMPONENT_ENABLED_STATE_DEFAULT && wanted == 2 && !prefs.contains(KEY_ENABLED))
            if (alreadyOn && prefs.getInt(KEY_ENABLED, wanted) == wanted) return

            // Enable the new alias first so the app never vanishes from the launcher.
            pm.setComponentEnabledSetting(
                alias(app, wanted), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
            )
            for (p in 0 until PHASE_COUNT) {
                if (p == wanted) continue
                pm.setComponentEnabledSetting(
                    alias(app, p), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP
                )
            }
            prefs.edit().putInt(KEY_ENABLED, wanted).apply()
        } catch (_: Throwable) {
            // The icon is cosmetic. Never let it break start-up.
        }
    }

    /** Re-checks the clock about every hour, also while the app is closed. */
    fun schedule(context: Context) {
        try {
            val request = PeriodicWorkRequestBuilder<Worker>(1, TimeUnit.HOURS, 15, TimeUnit.MINUTES).build()
            WorkManager.getInstance(context.applicationContext)
                .enqueueUniquePeriodicWork(WORK_NAME, ExistingPeriodicWorkPolicy.KEEP, request)
        } catch (_: Throwable) {
        }
    }

    class Worker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
        override suspend fun doWork(): Result {
            sync(applicationContext)
            return Result.success()
        }
    }
}
