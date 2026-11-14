package com.example.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

/**
 * Keeps SAIF AI's process alive while a task is running, so the work goes on if the person leaves the app or
 * locks the phone. It shows one quiet "working" notification and stops itself when the task ends.
 */
class AgentWorkService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action == ACTION_STOP) {
            stopForegroundCompat()
            stopSelf()
            return START_NOT_STICKY
        }
        val notification = buildNotification(this)
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                startForeground(NOTIFICATION_ID, notification, ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC)
            } else {
                startForeground(NOTIFICATION_ID, notification)
            }
        } catch (_: Throwable) {
            stopSelf()
        }
        return START_NOT_STICKY
    }

    private fun stopForegroundCompat() {
        try {
            if (Build.VERSION.SDK_INT >= 24) stopForeground(STOP_FOREGROUND_REMOVE) else @Suppress("DEPRECATION") stopForeground(true)
        } catch (_: Throwable) {
        }
    }

    companion object {
        const val ACTION_STOP = "com.example.service.AgentWorkService.STOP"
        const val CHANNEL_WORKING = "saif_work_running"
        const val NOTIFICATION_ID = 7300

        fun ensureChannel(context: Context) {
            if (Build.VERSION.SDK_INT < 26) return
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (manager.getNotificationChannel(CHANNEL_WORKING) == null) {
                manager.createNotificationChannel(
                    NotificationChannel(CHANNEL_WORKING, "Task running", NotificationManager.IMPORTANCE_LOW).apply {
                        description = "Shown while SAIF AI works on a task in the background"
                        setShowBadge(false)
                    }
                )
            }
        }

        private fun buildNotification(context: Context): Notification {
            ensureChannel(context)
            val open = context.packageManager.getLaunchIntentForPackage(context.packageName)?.let {
                android.app.PendingIntent.getActivity(
                    context, 0, it, android.app.PendingIntent.FLAG_UPDATE_CURRENT or android.app.PendingIntent.FLAG_IMMUTABLE
                )
            }
            return NotificationCompat.Builder(context, CHANNEL_WORKING)
                .setSmallIcon(context.applicationInfo.icon)
                .setContentTitle("SAIF AI is working")
                .setContentText("Your task keeps running in the background.")
                .setOngoing(true)
                .setOnlyAlertOnce(true)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentIntent(open)
                .build()
        }
    }
}
