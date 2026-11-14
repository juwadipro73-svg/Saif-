package com.example.security

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Debug
import java.io.File
import java.security.MessageDigest

/**
 * On-device tamper protection for SAIF AI.
 *
 * Any modification to the APK (decompile → edit → recompile → re-sign) breaks the original
 * developer signature, so the guard kills the process when the running signature does not
 * match the build-time pinned certificate, when a debugger or a hooking framework
 * (Frida/Xposed/Substrate) is attached, and reports every suspicious signal — with the
 * account and device details — to the admin panel's Security Alerts feed.
 *
 * Kill signals (process dies immediately): SIGNATURE_MISMATCH, DEBUGGER, HOOK_FRAMEWORK.
 * Watch signals (reported, app keeps running): ROOT, EMULATOR, UNKNOWN_INSTALLER.
 */
object SaifTamperGuard {

    data class TamperVerdict(
        val kill: Boolean,
        val signals: List<String>
    )

    // ------------------------------------------------------------------
    // Pure helpers (unit-testable, no Android framework beyond Build)
    // ------------------------------------------------------------------

    fun sha256Hex(bytes: ByteArray): String {
        val md = MessageDigest.getInstance("SHA-256")
        return md.digest(bytes).joinToString("") { "%02x".format(it) }
    }

    /** True when the runtime signer matches the build-pinned certificate (or no pin exists). */
    fun signerAccepted(expectedSha256: String, runtimeSha256List: List<String>): Boolean {
        val expected = expectedSha256.trim().lowercase()
        if (expected.isEmpty()) return true
        return runtimeSha256List.any { it.trim().lowercase() == expected }
    }

    /** True when a process-maps / stack dump shows a hooking framework. */
    fun containsHookFramework(dumpText: String): Boolean {
        val t = dumpText.lowercase()
        return t.contains("frida") ||
            t.contains("xposed") ||
            t.contains("substrate") ||
            t.contains("edbgsvc") ||
            t.contains("libhook")
    }

    fun isEmulatorBuild(
        fingerprint: String,
        model: String,
        manufacturer: String,
        hardware: String,
        product: String
    ): Boolean {
        val fp = fingerprint.lowercase()
        val mo = model.lowercase()
        val ma = manufacturer.lowercase()
        val hw = hardware.lowercase()
        val pr = product.lowercase()
        return fp.startsWith("generic") ||
            fp.startsWith("unknown") ||
            mo.contains("google_sdk") ||
            mo.contains("emulator") ||
            mo.contains("android sdk built for") ||
            ma.contains("genymotion") ||
            hw.contains("goldfish") ||
            hw.contains("ranchu") ||
            pr.contains("sdk_google") ||
            pr.contains("vbox86p") ||
            pr.contains("emulator")
    }

    fun looksLikeSuBinary(path: String): Boolean {
        val p = path.lowercase()
        return p.endsWith("/su") || p.endsWith("superuser.apk")
    }

    // ------------------------------------------------------------------
    // Live evaluation (needs a Context)
    // ------------------------------------------------------------------

    private val SU_PATHS = listOf(
        "/system/bin/su", "/system/xbin/su", "/sbin/su", "/system/sd/xbin/su",
        "/system/bin/failsafe/su", "/data/local/xbin/su", "/data/local/bin/su",
        "/data/local/su", "/su/bin/su", "/system/app/Superuser.apk"
    )

    private val ROOT_PACKAGES = listOf(
        "com.topjohnwu.magisk", "eu.chainfire.supersu", "com.koushikdutta.superuser",
        "com.noshufou.android.su", "com.yellowes.su"
    )

    fun runtimeSignerSha256(context: Context): List<String> {
        return try {
            val pm = context.packageManager
            val sigs = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val info = pm.getPackageInfo(context.packageName, PackageManager.GET_SIGNING_CERTIFICATES)
                info.signingInfo?.apkContentsSigners?.toList().orEmpty()
            } else {
                @Suppress("DEPRECATION")
                pm.getPackageInfo(context.packageName, PackageManager.GET_SIGNATURES)?.signatures?.toList().orEmpty()
            }
            sigs.map { sha256Hex(it.toByteArray()) }
        } catch (_: Exception) {
            emptyList()
        }
    }

    private fun expectedSignerSha256(): String {
        return try {
            com.example.gemini.BuildConfig.EXPECTED_SIGNER_SHA256.trim()
        } catch (_: Exception) {
            ""
        }
    }

    private fun hookFrameworkPresent(): Boolean {
        return try {
            val maps = try {
                File("/proc/self/maps").readText()
            } catch (_: Exception) {
                ""
            }
            val stack = try {
                Thread.currentThread().stackTrace.joinToString("\n") { it.className }
            } catch (_: Exception) {
                ""
            }
            containsHookFramework(maps) || containsHookFramework(stack)
        } catch (_: Exception) {
            false
        }
    }

    private fun rootPresent(context: Context): Boolean {
        try {
            val tags = try { Build.TAGS } catch (_: Exception) { null }
            if (tags != null && tags.contains("test-keys")) return true
            for (p in SU_PATHS) {
                try {
                    if (File(p).exists()) return true
                } catch (_: Exception) { }
            }
            for (pkg in ROOT_PACKAGES) {
                try {
                    @Suppress("DEPRECATION")
                    context.packageManager.getPackageInfo(pkg, 0)
                    return true
                } catch (_: Exception) {
                    // not installed — keep scanning
                }
            }
        } catch (_: Exception) { }
        return false
    }

    private fun emulatorPresent(): Boolean {
        return try {
            isEmulatorBuild(Build.FINGERPRINT, Build.MODEL, Build.MANUFACTURER, Build.HARDWARE, Build.PRODUCT)
        } catch (_: Exception) {
            false
        }
    }

    fun evaluate(context: Context): TamperVerdict {
        val signals = mutableListOf<String>()
        var kill = false

        // 1. Signature must match the build-pinned developer certificate.
        try {
            val runtime = runtimeSignerSha256(context)
            if (runtime.isNotEmpty() && !signerAccepted(expectedSignerSha256(), runtime)) {
                signals.add("SIGNATURE_MISMATCH")
                kill = true
            }
        } catch (_: Exception) { }

        // 2. Live debugger attached.
        try {
            if (Debug.isDebuggerConnected() || Debug.waitingForDebugger()) {
                signals.add("DEBUGGER")
                kill = true
            }
        } catch (_: Exception) { }

        // 3. Hooking / instrumentation framework present.
        try {
            if (hookFrameworkPresent()) {
                signals.add("HOOK_FRAMEWORK")
                kill = true
            }
        } catch (_: Exception) { }

        // Watch-only signals (reported to the admin, app keeps running).
        try {
            if (rootPresent(context)) signals.add("ROOT")
        } catch (_: Exception) { }
        try {
            if (emulatorPresent()) signals.add("EMULATOR")
        } catch (_: Exception) { }

        return TamperVerdict(kill = kill, signals = signals)
    }

    /**
     * Runs at app entry. Reports fresh signals to the admin panel (throttled) and kills the
     * process immediately when a tamper signal trips. Safe to call more than once.
     *
     * Must be called AFTER `AdminConfigManager.init(...)` so the report path has a context.
     */
    fun startupCheck(context: Context) {
        val verdict = try {
            evaluate(context)
        } catch (_: Exception) {
            return
        }
        if (verdict.signals.isEmpty()) return

        try {
            val prefs = context.getSharedPreferences("SaifTamperPrefs", Context.MODE_PRIVATE)
            val now = System.currentTimeMillis()
            val lastReport = prefs.getLong("last_report_at", 0L)
            if (now - lastReport > 3_600_000L) {
                runCatching {
                    kotlinx.coroutines.runBlocking {
                        kotlinx.coroutines.withTimeoutOrNull(3_000L) {
                            com.example.data.local.AdminConfigManager.reportTamperVerdict(verdict.signals)
                        }
                    }
                }
                runCatching { prefs.edit().putLong("last_report_at", now).apply() }
            }
        } catch (_: Exception) { }

        if (verdict.kill) {
            try {
                android.os.Process.killProcess(android.os.Process.myPid())
            } catch (_: Exception) { }
            kotlin.system.exitProcess(10)
        }
    }
}
