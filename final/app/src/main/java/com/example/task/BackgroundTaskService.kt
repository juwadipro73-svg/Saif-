/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.task

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.MainActivity

/**
 * Keeps a running agent task alive while SAIF AI is in the background.
 *
 * The service is started as soon as a task begins. While it runs, the notification shows the
 * current step. When the task finishes, the service posts exactly **one** final notification:
 * "Work done sir".
 *
 * If the user is still inside the app when the task finishes, no notification is posted at all -
 * the result is already on screen, so a notification would only be noise. This is handled by
 * [com.example.LiveVoiceManager.isAppInForeground], which the activity keeps up to date.
 */
class BackgroundTaskService : android.app.Service() {

    companion object {
        const val CHANNEL_ID = "saif_agent_task_channel"
        const val NOTIF_ID = 9101
        const val DONE_NOTIF_ID = 9102
        const val ACTION_STOP = "com.example.task.ACTION_STOP"
        const val EXTRA_STEP = "extra_step"

        /** Shown once, when a task completes while the app is in the background. */
        const val DONE_TEXT = "Work done sir"

        private const val PREFS = "BackgroundTaskPrefs"
        private const val KEY_RUNNING = "task_running"

        fun start(context: Context, step: String = "Working on your task…") {
            val appContext = context.applicationContext
            appContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                .edit().putBoolean(KEY_RUNNING, true).apply()
            val intent = Intent(appContext, BackgroundTaskService::class.java)
                .putExtra(EXTRA_STEP, step)
            runCatching {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    appContext.startForegroundService(intent)
                } else {
                    appContext.startService(intent)
                }
            }
        }

        /** Updates the running notification. */
        fun updateStep(context: Context, step: String) {
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager ?: return
            manager.notify(NOTIF_ID, buildRunningNotification(context, step))
        }

        /**
         * Finishes the task.
         *
         * @param postedIfBackground false when the user is still looking at the app - in that case
         * the notification is skipped entirely.
         */
        fun finish(context: Context, postedIfBackground: Boolean) {
            val appContext = context.applicationContext
            appContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                .edit().putBoolean(KEY_RUNNING, false).apply()
            appContext.stopService(Intent(appContext, BackgroundTaskService::class.java))
            if (!postedIfBackground) return
            val manager = appContext.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager ?: return
            manager.notify(DONE_NOTIF_ID, buildDoneNotification(appContext))
        }

        fun isTaskRunning(context: Context): Boolean =
            context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getBoolean(KEY_RUNNING, false)

        private fun buildRunningNotification(context: Context, step: String): Notification =
            NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.stat_sys_download)
                .setContentTitle("SAIF AI is working")
                .setContentText(step)
                .setOngoing(true)
                .setOnlyAlertOnce(true)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentIntent(
                    PendingIntent.getActivity(
                        context, 0, Intent(context, MainActivity::class.java),
                        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                    )
                )
                .build()

        private fun buildDoneNotification(context: Context): Notification =
            NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_media_play)
                .setContentTitle("SAIF AI")
                .setContentText(DONE_TEXT)
                .setOngoing(false)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(
                    PendingIntent.getActivity(
                        context, 0, Intent(context, MainActivity::class.java),
                        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                    )
                )
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Agent tasks",
                NotificationManager.IMPORTANCE_LOW
            )
            channel.setShowBadge(false)
            getSystemService(NotificationManager::class.java)?.createNotificationChannel(channel)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action == ACTION_STOP) {
            stopSelf()
            return START_NOT_STICKY
        }
        val step = intent?.getStringExtra(EXTRA_STEP) ?: "Working on your task…"
        val notification = buildRunningNotification(this, step)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            startForeground(NOTIF_ID, notification, ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC)
        } else {
            startForeground(NOTIF_ID, notification)
        }
        // START_STICKY: if Android kills the process the task is resumed with the same notification.
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        // Never leave a stale "ongoing" notification behind.
        val manager = getSystemService(NotificationManager::class.java)
        manager?.cancel(NOTIF_ID)
        super.onDestroy()
    }
}
