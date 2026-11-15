package com.example

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * The owner asked for calls, SMS, contacts and notification access to be removed from the app.
 * These checks fail the build if any of them creeps back into the manifest or into the code that
 * would ask for them.
 */
class PermissionRemovalTest {

    private val repoRoot: File = listOf(File("."), File("..")).first { File(it, "settings.gradle.kts").isFile }
    private fun read(path: String) = File(repoRoot, path).readText()

    private val manifest = read("app/src/main/AndroidManifest.xml")

    private val removedPermissions = listOf(
        "CALL_PHONE", "ANSWER_PHONE_CALLS", "PROCESS_OUTGOING_CALLS",
        "READ_PHONE_STATE", "READ_PHONE_NUMBERS", "READ_CALL_LOG", "WRITE_CALL_LOG",
        "READ_CONTACTS", "WRITE_CONTACTS", "GET_ACCOUNTS",
        "READ_SMS", "SEND_SMS", "RECEIVE_SMS", "RECEIVE_MMS"
    )

    @Test
    fun `telephony, sms and contacts permissions are stripped from the merged manifest`() {
        removedPermissions.forEach { perm ->
            val line = manifest.lines().firstOrNull {
                it.contains("android.permission.$perm\"") && it.contains("uses-permission")
            }
            assertTrue("android.permission.$perm must be declared with tools:node=\"remove\"", line != null)
            assertTrue("android.permission.$perm must be stripped", line!!.contains("tools:node=\"remove\""))
        }
    }

    @Test
    fun `no runtime request is left for the removed permissions`() {
        val sources = listOf(
            "app/src/main/java/com/example/util/DeviceActionManager.kt",
            "app/src/main/java/com/example/agent/skills/CallSkill.kt"
        )
        sources.forEach { path ->
            val text = read(path)
            listOf("Manifest.permission.CALL_PHONE", "Manifest.permission.SEND_SMS", "Manifest.permission.READ_CONTACTS")
                .forEach { perm ->
                    assertFalse("$path still references $perm", text.contains(perm))
                }
        }
    }

    @Test
    fun `notification access is gone`() {
        assertFalse(manifest.contains("BIND_NOTIFICATION_LISTENER_SERVICE"))
        assertFalse(manifest.contains("android.service.notification.NotificationListenerService"))
        val listener = read("app/src/main/java/com/example/util/SaifNotificationListenerService.kt")
        assertFalse("the listener service must not be extended any more", listener.contains("NotificationListenerService()"))
        assertFalse("notification access must not be read", listener.contains("enabled_notification_listeners"))
    }

    @Test
    fun `the contacts provider is never queried`() {
        val store = read("app/src/main/java/com/example/agent/skills/ContactAliasStore.kt")
        assertFalse(store.contains("ContactsContract"))
        val deviceActions = read("app/src/main/java/com/example/util/DeviceActionManager.kt")
        assertFalse(deviceActions.contains("ContactsContract"))
    }

    @Test
    fun `the parser cannot trigger a call or an sms`() {
        val parser = read("app/src/main/java/com/example/util/DeviceActionParser.kt")
        assertFalse(parser.contains("DeviceAction.DialPhone("))
        assertFalse(parser.contains("DeviceAction.SendSms("))
    }
}
