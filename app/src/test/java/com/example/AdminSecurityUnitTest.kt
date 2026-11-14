package com.example

import com.example.compiler.OnDeviceApkBuildManager
import com.example.data.local.AdminConfigManager
import com.example.data.local.AdminGlobalConfig
import com.example.security.SaifTamperGuard
import com.example.ui.components.ForceUpdateGate
import com.example.util.SaifIdentity
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Plain JVM tests for the admin kill switch, engagement analytics, tamper-guard
 * detection helpers and the auto-download-link prompt wiring.
 */
class AdminSecurityUnitTest {

    private fun configWith(forceActive: Boolean, minCode: Int = 0) = AdminGlobalConfig(
        forceUpdateActive = forceActive,
        forceUpdateMinCode = minCode,
        forceUpdateDownloadUrl = "https://example.com/latest.apk"
    )

    // --- Kill switch gate ---

    @Test
    fun gateOpenWhenSwitchOff() {
        assertFalse(ForceUpdateGate.shouldBlock(configWith(false), 1000L, false))
    }

    @Test
    fun gateBlocksEveryoneWhenSwitchOnWithoutMinCode() {
        assertTrue(ForceUpdateGate.shouldBlock(configWith(true), 9999L, false))
    }

    @Test
    fun gateBlocksOnlyOldBuildsWhenMinCodeSet() {
        assertTrue(ForceUpdateGate.shouldBlock(configWith(true, 1041), 1040L, false))
        assertFalse(ForceUpdateGate.shouldBlock(configWith(true, 1041), 1041L, false))
        assertFalse(ForceUpdateGate.shouldBlock(configWith(true, 1041), 5000L, false))
    }

    @Test
    fun gateNeverBlocksAdmins() {
        assertFalse(ForceUpdateGate.shouldBlock(configWith(true), 1L, true))
        assertFalse(ForceUpdateGate.shouldBlock(configWith(true, 99999), 1L, true))
    }

    // --- Engagement analytics ---

    @Test
    fun recentlyActiveWindowIsSevenDays() {
        val now = System.currentTimeMillis()
        val day = 24L * 60L * 60L * 1000L
        assertTrue(AdminConfigManager.isRecentlyActive(now, now))
        assertTrue(AdminConfigManager.isRecentlyActive(now - 6 * day, now))
        assertFalse(AdminConfigManager.isRecentlyActive(now - 8 * day, now))
        assertFalse(AdminConfigManager.isRecentlyActive(0L, now))
    }

    // --- Tamper-guard pure helpers ---

    @Test
    fun signerPinAcceptsExactMatchOnly() {
        val pin = "ab".repeat(32)
        assertTrue(SaifTamperGuard.signerAccepted(pin, listOf(pin)))
        assertTrue(SaifTamperGuard.signerAccepted(pin.uppercase(), listOf(pin)))
        assertFalse(SaifTamperGuard.signerAccepted(pin, listOf("cd".repeat(32))))
        assertFalse(SaifTamperGuard.signerAccepted(pin, emptyList()))
        // No pin baked in (should not happen) must fail open, not brick installs.
        assertTrue(SaifTamperGuard.signerAccepted("", listOf("cd".repeat(32))))
    }

    @Test
    fun hookFrameworkFingerprintsDetected() {
        assertTrue(SaifTamperGuard.containsHookFramework("/data/app/libfrida-gadget.so"))
        assertTrue(SaifTamperGuard.containsHookFramework("de.robv.android.xposed.XposedBridge"))
        assertTrue(SaifTamperGuard.containsHookFramework("com.saurik.substrate.MS_MethodPointer"))
        assertFalse(SaifTamperGuard.containsHookFramework("/system/lib64/libandroid.so\n/system/framework/boot.oat"))
    }

    @Test
    fun emulatorBuildsDetected() {
        assertTrue(
            SaifTamperGuard.isEmulatorBuild(
                "generic_x86_64-userdebug", "sdk_gphone64_x86_64", "Google", "ranchu", "sdk_google"
            )
        )
        assertFalse(
            SaifTamperGuard.isEmulatorBuild(
                "RQ3A.211001.001", "Pixel 6", "Google", "exynos2100", "oriole"
            )
        )
    }

    // --- Prompt wiring (compile-time constants, no class init) ---

    @Test
    fun chatApkBuildRuleIsToolsOnly() {
        val rule = OnDeviceApkBuildManager.CHAT_APK_BUILD_RULE
        assertTrue(rule.contains("NEVER write", ignoreCase = true))
        assertTrue(rule.contains("build_android_apk", ignoreCase = true))
        assertFalse(rule.contains("<saif-apk", ignoreCase = true))
    }

    @Test
    fun identityRuleRefusesPromptAndSecretExtraction() {
        val rule = SaifIdentity.RULE
        assertTrue(rule.contains("system prompts", ignoreCase = true))
        assertTrue(rule.contains("API keys", ignoreCase = true))
        assertTrue(rule.contains("refuse", ignoreCase = true))
    }
}
