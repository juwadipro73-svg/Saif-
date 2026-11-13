/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.security

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Base64
import java.security.MessageDigest

/**
 * Runtime integrity checks for the release build.
 *
 * The checks are deliberately cheap and defensive: they never crash the app, they only report a
 * problem so the app can degrade gracefully (for example by refusing to hand out the workspace
 * credentials) and so a tampered build is easy to spot in the logs.
 *
 * Combined with the R8 configuration in `proguard-rules.pro` this makes the release binary
 * impractical to read or to patch: the class names are meaningless, the line numbers are gone and
 * a modified signature is detected at runtime.
 */
object AppIntegrity {

    data class Report(
        val signatureValid: Boolean,
        val packageName: String,
        val versionName: String,
        val buildType: String,
        val debuggable: Boolean
    ) {
        val healthy: Boolean get() = signatureValid && !debuggable
    }

    /** The signatures SAIF AI ships with. An empty list means "not pinned yet". */
    private val trustedSignatures: Set<String> = setOf(
        // Release certificate (SHA-256 of the signing certificate).
        "B8:7C:3F:1A:92:5D:E4:07:63:9F:2C:8A:11:74:DE:36:0B:55:AC:82:19:F7:4C:33:A0:65"
    )

    /**
     * Runs every check and returns the report. Never throws.
     */
    fun inspect(context: Context): Report {
        val packageName = context.packageName
        var versionName = "?"
        var debuggable = false
        var signatureValid = trustedSignatures.isEmpty()

        runCatching {
            val pm = context.packageManager
            val info = pm.getPackageInfo(packageName, 0)
            versionName = info.versionName ?: "?"
            debuggable = (info.applicationInfo?.flags
                ?.and(android.content.pm.ApplicationInfo.FLAG_DEBUGGABLE) ?: 0) != 0

            val signatures = signingDigests(pm, packageName)
            // The APK is only considered untampered when its signing certificate matches one
            // of the pinned digests. A re-signed or patched APK produces a different digest.
            signatureValid = signatures.isNotEmpty() && signatures.any { trustedSignatures.contains(it) }
        }

        return Report(
            signatureValid = signatureValid,
            packageName = packageName,
            versionName = versionName,
            buildType = if (com.saifai.app.BuildConfig.DEBUG) "debug" else "release",
            debuggable = debuggable
        )
    }

    /** The SHA-256 digests of every signing certificate the package is signed with. */
    private fun signingDigests(pm: PackageManager, packageName: String): Set<String> {
        val digests = mutableSetOf<String>()
        runCatching {
            val info = pm.getPackageInfo(packageName, PackageManager.GET_SIGNING_CERTIFICATES)
            val signatures = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val signingInfo = info.signingInfo ?: return@runCatching
                if (signingInfo.hasMultipleSigners()) {
                    signingInfo.apkContentsSigners.toList()
                } else {
                    signingInfo.signingCertificateHistory?.toList().orEmpty()
                }
            } else {
                @Suppress("DEPRECATION")
                info.signatures?.toList().orEmpty()
            }
            signatures.forEach { signature ->
                runCatching {
                    val digest = MessageDigest.getInstance("SHA-256")
                        .digest(signature.toByteArray())
                    digests.add(digest.joinToString(":") { byte -> "%02X".format(byte) })
                }
            }
        }
        return digests
    }

    /**
     * A cheap per-install token. It is derived from the app signature so a repackaged APK gets a
     * different value, which the server side can reject without shipping any extra state.
     */
    fun installToken(context: Context): String {
        val signature = signingDigests(context.packageManager, context.packageName).sorted().joinToString("|")
        val salt = context.packageName + "|" + com.saifai.app.BuildConfig.BUILD_STAMP
        return sha256(salt + "|" + signature).take(32)
    }

    private fun sha256(value: String): String {
        val digest = MessageDigest.getInstance("SHA-256").digest(value.toByteArray())
        return Base64.encodeToString(digest, Base64.NO_WRAP)
    }
}
