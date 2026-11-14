package com.example.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.LiveVoiceManager

/**
 * Background work for the chat agent.
 *
 * [begin] starts the keep-alive service when a task starts. [end] stops it and, only if the task finished and the
 * person is NOT looking at SAIF AI, posts one "Work done, sir" notification. Inside the app there is no sound
 * and no notification.
 */
object AgentWorkNotifier {
    private const val CHANNEL_DONE = "saif_work_done"
    private const val DONE_ID = 7301

    fun begin(context: Context) {
        try {
            val app = context.applicationContext
            ContextCompat.startForegroundService(app, Intent(app, AgentWorkService::class.java))
        } catch (_: Throwable) {
            // Not allowed right now (for example while the app is hidden): the task still runs, just without the keep-alive.
        }
    }

    fun end(context: Context, completed: Boolean) {
        val app = context.applicationContext
        try {
            app.startService(Intent(app, AgentWorkService::class.java).setAction(AgentWorkService.ACTION_STOP))
        } catch (_: Throwable) {
            try { app.stopService(Intent(app, AgentWorkService::class.java)) } catch (_: Throwable) {}
        }
        if (!completed || LiveVoiceManager.isAppInForeground.value) return
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                val manager = app.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                if (manager.getNotificationChannel(CHANNEL_DONE) == null) {
                    manager.createNotificationChannel(
                        NotificationChannel(CHANNEL_DONE, "Work done", NotificationManager.IMPORTANCE_HIGH).apply {
                            description = "Tells you once when SAIF AI has finished a task while you were away"
                        }
                    )
                }
            }
            if (!NotificationManagerCompat.from(app).areNotificationsEnabled()) return
            val open = app.packageManager.getLaunchIntentForPackage(app.packageName)?.let {
                PendingIntent.getActivity(app, 1, it, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
            }
            val notification = NotificationCompat.Builder(app, CHANNEL_DONE)
                .setSmallIcon(app.applicationInfo.icon)
                .setContentTitle("Work done, sir")
                .setContentText("SAIF AI has finished your task. Tap to see the result.")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setContentIntent(open)
                .build()
            @Suppress("MissingPermission")
            NotificationManagerCompat.from(app).notify(DONE_ID, notification)
        } catch (_: Throwable) {
        }
    }
}
