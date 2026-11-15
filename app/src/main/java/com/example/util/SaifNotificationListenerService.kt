package com.example.util

import android.content.Context

/**
 * Notification access has been REMOVED from this build.
 *
 * The old implementation was a `NotificationListenerService` that read every notification on the
 * device. That needs the system-level "Notification access" grant, which the user asked us to drop,
 * so the service is gone (it is not declared in the manifest any more) and this object only keeps
 * the API surface as a no-op. Nothing here can read notifications, and nothing asks for access.
 */
data class NotificationItem(
    val packageName: String,
    val appName: String,
    val title: String,
    val text: String,
    val timestamp: Long
)

object SaifNotificationListenerService {

    /** Always false: notification access is not available in this build. */
    fun isNotificationAccessGranted(context: Context): Boolean = false

    /** Kept for source compatibility; never opens the system notification-access screen. */
    fun openNotificationAccessSettings(context: Context) = Unit

    /** Always empty: the app no longer reads notifications. */
    fun getRecentNotifications(packageFilter: String? = null): List<NotificationItem> = emptyList()

    /** Plain "not available" text so callers show an honest answer instead of fake data. */
    fun getSummaryText(context: Context, packageFilter: String? = null): String =
        "Notification access is turned off in this build, so I cannot read notifications."
}
