/*
 * SAIF AI - licence and credits screen.
 * Copyright (C) 2026 SAIF AI contributors.
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package com.example.ui.components

/** The licence and credit texts bundled in `assets/legal`, and where the source code lives. */
object SaifLegalNotices {
    const val SOURCE_URL = "https://github.com/juwadipro73-svg/Saif-"
    const val CREDITS_PAGE = "THIRD_PARTY_NOTICES.md"
    const val LICENSE_PAGE = "LICENSE"

    /** Tab label to file below `assets/legal/`. The credits come first: they name everyone whose code is used. */
    val PAGES: List<Pair<String, String>> = listOf(
        "Credits" to CREDITS_PAGE,
        "GPL-3.0 (SAIF AI)" to LICENSE_PAGE,
        "Apache-2.0" to "licenses/Apache-2.0.txt",
        "LGPL-2.1" to "licenses/LGPL-2.1.txt",
        "LGPL-3.0" to "licenses/LGPL-3.0.txt",
        "GPL-2.0" to "licenses/GPL-2.0.txt",
        "EPL-2.0" to "licenses/EPL-2.0.txt",
        "MIT" to "licenses/MIT.txt",
        "BSD-3-Clause" to "licenses/BSD-3-Clause.txt",
        "BSD-2-Clause" to "licenses/BSD-2-Clause.txt"
    )

    /** Shown at the bottom of Settings. The GPL asks for a visible copyright, no-warranty and licence notice. */
    const val SHORT_NOTICE =
        "Copyright (C) 2026 SAIF AI and contributors. Built on AntiGem by Santosh Kurmi (GPLv3). Free software " +
            "under the GNU GPL v3 or later, with ABSOLUTELY NO WARRANTY. Tap to read the licences, the credits " +
            "and where to get the source code."

    /** The first credit line on the About screen. SAIF AI always comes first. */
    const val OWN_CREDIT =
        "SAIF AI \u2022 Copyright (C) 2026 SAIF AI and contributors \u2022 Free software under the GNU GPL v3 or later, with " +
            "ABSOLUTELY NO WARRANTY \u2022 Source code of every build: $SOURCE_URL"

    /**
     * Everyone else, as a few long lines of small text for the About screen. Keep this in step with section 1 to 4 of
     * THIRD_PARTY_NOTICES.md: a name that is in the app must be named here with its licence.
     */
    val CREDIT_LINES: List<String> = listOf(
        "Built on AntiGem by Santosh Kurmi (GPL-3.0-or-later) \u2022 Termux terminal view and emulator, from Terminal Emulator " +
            "for Android by Jack Palevich (Apache-2.0) \u2022 PRoot by STMicroelectronics (GPL-2.0-or-later) \u2022 talloc by " +
            "Andrew Tridgell and the Samba team (LGPL-3.0-or-later) \u2022 GNU C Library by the Free Software Foundation " +
            "(LGPL-2.1-or-later) \u2022 Chrome API type definitions by Microsoft and DefinitelyTyped contributors (MIT)",
        "Libraries (Apache-2.0): AndroidX and Jetpack, Kotlin, kotlinx, JetBrains annotations, OkHttp, Okio, Wire (Square), " +
            "Coil, AndroidSVG, Accompanist (Google), Firebase and Google open-source parts, gRPC, PerfMark, Tink, Gson, Guava, " +
            "apksig, Apache Commons, Markwon, Vosk and Kaldi (Alpha Cephei), SnakeYAML Engine, JNA, JSR-305, Error Prone, " +
            "J2ObjC, JSpecify, javax.inject \u2022 Protocol Buffers (BSD-3-Clause, Google) \u2022 commonmark-java (BSD-2-Clause, " +
            "Robin Stocker) \u2022 JSch fork (BSD-3-Clause, JCraft and Matthias Wiedemann) \u2022 jsoup (MIT, Jonathan Hedley) \u2022 " +
            "Joni and JCodings (MIT, JRuby Team) \u2022 Checker Framework and Animal Sniffer annotations (MIT) \u2022 XZ for Java " +
            "(public domain, Lasse Collin and Igor Pavlov)",
        "sora-editor by Rosemoe (LGPL-2.1) \u2022 Eclipse TM4E and JDT annotations (EPL-2.0, Eclipse Foundation) \u2022 " +
            "JLaTeXMath (GPL-2.0-or-later with linking exception, Calixte Denizet and contributors) \u2022 Workspace bridge Go " +
            "modules: Go standard library and x/sys (BSD-3-Clause, The Go Authors), gorilla/websocket (BSD-2-Clause), google/uuid, " +
            "bigfft, modernc.org sqlite, libc, mathutil, memory (BSD-3-Clause), go-humanize, go-isatty, go-strftime (MIT)",
        "Sign-in and app protection use Google's Firebase Authentication, Play services, Google Identity, Play Integrity and " +
            "reCAPTCHA under Google's own terms. Antigravity, Gemini, Claude, ChatGPT, OpenCode and other names belong to their " +
            "owners; SAIF AI is independent and not affiliated with them, Termux or AntiGem. Components keep their own " +
            "copyright and licence; full licence texts and the exact list ship with the source code."
    )
}
