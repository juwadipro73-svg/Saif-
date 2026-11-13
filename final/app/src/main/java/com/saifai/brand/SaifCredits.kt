/* Copyright (c) SAIF AI. All rights reserved. */

package com.saifai.brand

/**
 * Every credit SAIF AI shows, in one place.
 *
 * The settings panel used to spread the licences over several sections. They now live in a single
 * list that is rendered as one long, small-font line, with SAIF AI pinned to the top.
 */
object SaifCredits {

    const val PRODUCT = "SAIF AI"

    /** The headline credit. Shown large, always first. */
    const val HEADLINE = "SAIF AI"

    const val HEADLINE_SUB = "Intelligent Autonomous Workspace · Built by SAIF"

    /**
     * Every third-party component SAIF AI builds on, with the licence it ships under.
     * Kept as one list so the UI can render it as a single flowing line.
     */
    val thirdParty: List<Pair<String, String>> = listOf(
        "Android Jetpack (Compose, Lifecycle, Room, Navigation, WorkManager, DataStore) — Apache License 2.0",
        "Kotlin & kotlinx.coroutines, kotlinx.serialization — Apache License 2.0",
        "OkHttp & Okio — Apache License 2.0",
        "Coil (image loading) — Apache License 2.0",
        "Termux Terminal Emulator — GPL-3.0",
        "Rosemoe Sora Editor (code editor) — Apache License 2.0",
        "Markwon & JLaTeXMath (Markdown & LaTeX) — Apache License 2.0",
        "jsoup (HTML parsing) — MIT License",
        "Apache Commons Compress & XZ for Java — Apache License 2.0",
        "JSch (SSH client) — BSD 3-Clause License",
        "Firebase (Auth, Firestore, Realtime Database, App Check) — Apache License 2.0",
        "AndroidX Media3 (ExoPlayer) — Apache License 2.0",
        "AndroidX Security Crypto — Apache License 2.0",
        "Guava ListenableFuture (Android port) — Apache License 2.0",
        "Google Play App Check (Play Integrity) — Apache License 2.0",
        "SAIF AI own components: app compiler, terminal harness, agent engine, on-device APK builder — All rights reserved"
    )

    /** The whole third-party list as one long line. */
    val thirdPartyOneLine: String
        get() = thirdParty.joinToString("  ·  ")

    /** The complete credit block: SAIF AI first, then every dependency on one long line. */
    val fullCreditLine: String
        get() = "$HEADLINE — $HEADLINE_SUB  ·  ${thirdPartyOneLine}"
}
