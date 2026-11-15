package com.example.builder.agent

/**
 * What the user wants handed back at the end of a build: an installable APK, the source as a ZIP,
 * a website that opens in Chrome, a video file, a document, an image or audio.
 *
 * Rule: an explicit ask always wins ("zip do", "source code chahiye", "video banao"). When the user
 * says nothing, the default is the natural artifact for the request — an app becomes an APK, a
 * website becomes a direct browser link, a video becomes an MP4 download link. Pure logic, covered
 * by unit tests.
 */
enum class DeliverableFormat {
    APK,
    ZIP,
    WEBSITE,
    VIDEO,
    DOCUMENT,
    IMAGE,
    AUDIO;

    companion object {

        /**
         * Format the user explicitly named, or null when the request names none.
         * ZIP is checked before APK so "zip of the apk project" stays a ZIP.
         */
        fun detect(prompt: String): DeliverableFormat? {
            val p = prompt.lowercase()
            return when {
                looksLikeZip(p) -> ZIP
                looksLikeVideo(p) -> VIDEO
                looksLikeDocument(p) -> DOCUMENT
                looksLikeImage(p) -> IMAGE
                looksLikeAudio(p) -> AUDIO
                looksLikeWebsite(p) -> WEBSITE
                looksLikeApk(p) -> APK
                else -> null
            }
        }

        /** Explicit ask if there is one, else the natural default for this request. */
        fun resolve(prompt: String): DeliverableFormat = detect(prompt) ?: defaultFor(prompt)

        /** Natural artifact when the user named no format. */
        fun defaultFor(prompt: String): DeliverableFormat {
            val p = prompt.lowercase()
            return when (detectBuildStack(p)) {
                BuildStack.NATIVE, BuildStack.FLUTTER -> APK
                BuildStack.HTML -> if (looksLikeWebsite(p)) WEBSITE else APK
            }
        }

        private fun detectBuildStack(prompt: String): BuildStack = try {
            BuildAgent.detectBuildStack(prompt)
        } catch (_: Throwable) {
            BuildStack.HTML
        }

        private fun looksLikeZip(p: String): Boolean {
            val words = listOf(
                "zip", ".zip", "source code", "source-code", "sourcecode", "source files",
                "project files", "project zip", "code zip", "full code", "sara code",
                "source de", "source do", "code de do", "project de do"
            )
            return words.any { p.contains(it) }
        }

        private fun looksLikeVideo(p: String): Boolean {
            val words = listOf(
                "video", "vedio", "mp4", "reel", "short film", "animation clip",
                "storyboard video", "screen recording"
            )
            return words.any { p.contains(it) }
        }

        private fun looksLikeDocument(p: String): Boolean {
            return listOf("pdf", ".docx", " word file", "ppt", "pptx", "slide deck", "document file").any { p.contains(it) }
        }

        private fun looksLikeImage(p: String): Boolean {
            return listOf("image file", "photo file", "png", ".jpg", "jpeg", "poster", "wallpaper", "illustration").any { p.contains(it) }
        }

        private fun looksLikeAudio(p: String): Boolean {
            return listOf("mp3", "audio file", "voiceover", "voice over", "song", "podcast").any { p.contains(it) }
        }

        private fun looksLikeWebsite(p: String): Boolean {
            return listOf(
                "website", "web site", "webpage", "web page", "landing page", "html page",
                "static site", "site banao", "website banao", "chrome me khule", "chrome par khule",
                "browser me khule", "browser par open"
            ).any { p.contains(it) }
        }

        private fun looksLikeApk(p: String): Boolean {
            return listOf("apk", "installable", "install karke", "installable app", "play store").any { p.contains(it) }
        }

        /**
         * True when the turn produces something the user receives (app, site, video, document,
         * archive). Casual chat ("what is kotlin?") must not get a format rule.
         */
        fun isBuildRequest(prompt: String): Boolean {
            if (detect(prompt) != null) return true
            val p = prompt.lowercase()
            return listOf(
                "banao", "bana do", "banado", "banaye", "build", "create", "make me", "make a",
                "design a", "develop", "app", "application", "game", "tool", "dashboard",
                "calculator", "todo", "clone", "landing"
            ).any { p.contains(it) }
        }

        /** Format rule for this turn, or "" when the turn produces no artifact. */
        fun ruleFor(prompt: String): String =
            if (isBuildRequest(prompt)) instruction(resolve(prompt)) else ""

        /** Prompt block that tells the agent exactly which artifact to hand back. */
        fun instruction(format: DeliverableFormat): String = when (format) {
            APK ->
                "FORMAT RULE (this turn): hand back an installable signed APK. Build it with the APK build tool and end " +
                    "your answer with `⬇️ **Download link:** [<app>.apk](URL)`. Do not answer with a code dump or a ZIP."
            ZIP ->
                "FORMAT RULE (this turn): hand back the SOURCE as one .zip archive (zip the project folder, skipping " +
                    "build/, .gradle/, node_modules/), publish it with `saif-apk-link` and end your answer with " +
                    "`⬇️ **Download link:** [<project>.zip](URL)`. Do not substitute an APK for a ZIP request."
            WEBSITE ->
                "FORMAT RULE (this turn): hand back a website that opens directly in Chrome. Write ONE self-contained " +
                    "index.html (inline CSS + JS, no file:// paths), publish it with `saif-web-link /root/workspace/<slug>/index.html` " +
                    "and end your answer with `🌐 **Live link:** [Open website](URL)`. Do not wrap it in an APK for a website request."
            VIDEO ->
                "FORMAT RULE (this turn): hand back a video FILE (.mp4). Render it (ffmpeg if needed), publish it with " +
                    "`saif-apk-link` and end your answer with `⬇️ **Download link:** [<name>.mp4](URL)`."
            DOCUMENT ->
                "FORMAT RULE (this turn): hand back the document file (PDF/DOCX/PPTX) you produced, publish it with " +
                    "`saif-apk-link` and end your answer with `⬇️ **Download link:** [<name>](URL)`."
            IMAGE ->
                "FORMAT RULE (this turn): hand back the image file (PNG/JPG), publish it with `saif-apk-link` and end " +
                    "your answer with `⬇️ **Download link:** [<name>.png](URL)`."
            AUDIO ->
                "FORMAT RULE (this turn): hand back the audio file (MP3/WAV), publish it with `saif-apk-link` and end " +
                    "your answer with `⬇️ **Download link:** [<name>.mp3](URL)`."
        }

        /**
         * Standing defaults for prompts that say nothing about the format. Kept short enough to ship
         * in every system prompt.
         */
        const val DEFAULTS_RULE =
            "FORMAT DEFAULTS (when the user names no format): an app request → installable APK + `⬇️ **Download link:**`; " +
                "a website request → a direct Chrome-openable live link (`🌐 **Live link:**`) via `saif-web-link`; " +
                "a video request → an .mp4 download link. If the user names ANY format (ZIP/source code, APK, HTML, " +
                "MP4, PDF, PNG, MP3...), that exact format wins over these defaults."

        /** Shell command the agent must run to publish a website as a live link. */
        const val WEB_LINK_COMMAND = "saif-web-link <absolute-path-to-index.html>"
    }
}
