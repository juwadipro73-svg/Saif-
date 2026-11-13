/*
 * SAIF AI - time-based launcher icon palette.
 * Copyright (C) 2026 SAIF AI contributors.
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package com.example.util

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit

/** Rotates the launcher palette on a two-hour clock; Android launchers control how quickly they repaint it. */
object DynamicLauncherIcon {
    private const val WORK_NAME = "saif_launcher_icon_rotation"
    private val aliases = listOf("LauncherIconViolet", "LauncherIconCyan", "LauncherIconAmber")
    private val periodMs = TimeUnit.HOURS.toMillis(2)

    fun initialize(context: Context) {
        applyCurrent(context.applicationContext)
        val delay = periodMs - (System.currentTimeMillis() % periodMs)
        val work = PeriodicWorkRequestBuilder<LauncherIconWorker>(2, TimeUnit.HOURS, 15, TimeUnit.MINUTES)
            .setInitialDelay(delay, TimeUnit.MILLISECONDS)
            .build()
        WorkManager.getInstance(context.applicationContext).enqueueUniquePeriodicWork(
            WORK_NAME, ExistingPeriodicWorkPolicy.UPDATE, work
        )
    }

    internal fun applyCurrent(context: Context) {
        val current = ((System.currentTimeMillis() / periodMs) % aliases.size).toInt()
        val pm = context.packageManager
        val settings = aliases.mapIndexed { index, alias ->
            PackageManager.ComponentEnabledSetting(
                ComponentName(context, "${context.packageName}.$alias"),
                if (index == current) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
                else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            pm.setComponentEnabledSettings(settings)
        } else {
            // Keep an active launcher entry throughout the switch on older package managers.
            pm.setComponentEnabledSetting(settings[current].componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP)
            settings.forEachIndexed { index, setting ->
                if (index != current) pm.setComponentEnabledSetting(setting.componentName,
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)
            }
        }
    }
}

class LauncherIconWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result = try {
        DynamicLauncherIcon.applyCurrent(applicationContext)
        Result.success()
    } catch (_: Exception) {
        Result.retry()
    }
}
