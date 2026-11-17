package com.example.gemini.data.agent.agy

/**
 * Compact power directives appended to outgoing user prompts on the Antigravity hub route.
 *
 * The hub daemon carries its own system prompt, so the only reliable place to enforce SAIF's
 * quality rules (completeness, project isolation, spec expansion, rebuild-before-link) is a
 * short directive block attached to the request itself. Only the rules relevant to the shape
 * of the prompt are included, so casual chat stays untouched and light.
 */
object PowerDirectives {

    private val LISTED_LINE = Regex("^([0-9]+[.)]|[-•*])\\s")

    /** True when the message is an actual task (build/edit/list) - casual chat stays untouched. */
    fun isTaskish(text: String): Boolean {
        val t = text.trim()
        if (t.isBlank()) return false
        val listed = t.lines().count { line ->
            val s2 = line.trim()
            s2.isNotBlank() && (LISTED_LINE.containsMatchIn(s2) || s2.length > 60)
        }
        val buildish = Regex("(?i)(bana|banao|banawo|build|create|make|app|website|apk|game|design|dashboard)")
            .containsMatchIn(t)
        val editish = Regex("(?i)(change|fix|bug|glitch|add|update|edit|improve|thik|badal|jod|feature)")
            .containsMatchIn(t)
        return t.length > 400 || listed >= 3 || listed >= 1 || buildish || editish
    }

    fun blockFor(
        text: String,
        freshSession: Boolean,
        oldDirs: List<String> = emptyList(),
        skillPolicy: String = ""
    ): String {
        val t = text.trim()
        if (t.isBlank() || !isTaskish(t)) return ""
        val listed = t.lines().count { line ->
            val s = line.trim()
            s.isNotBlank() && (LISTED_LINE.containsMatchIn(s) || s.length > 60)
        }
        val big = t.length > 400 || listed >= 3
        val short = t.length < 220
        val buildish = Regex("(?i)(bana|banao|banawo|build|create|make|app|website|apk|game|design|dashboard)")
            .containsMatchIn(t)
        val editish = Regex("(?i)(change|fix|bug|glitch|add|update|edit|improve|thik|badal|jod|feature)")
            .containsMatchIn(t)

        val rules = mutableListOf<String>()
        var n = 1

        if (big) {
            rules.add(
                "${n++}. COMPLETENESS: split my message into a numbered list of EVERY requirement and implement " +
                    "all of them in order - every screen, button, behaviour and fix. Never end the turn while any " +
                    "requirement is untouched or half-done. Close your reply with a numbered audit marking each " +
                    "requirement DONE (or the exact reason it could not be done)."
            )
            rules.add(
                "${n++}. SPEED+PRECISION: fan independent parts out to parallel subagents, work in many small " +
                    "verified steps (one file or one coherent change per tool call, verify after each), and merge " +
                    "everything into one finished result."
            )
        }
        if (short && buildish) {
            rules.add(
                "${n++}. SPEC EXPANSION: this request is underspecified - first expand it yourself into a full " +
                    "product spec (8-15 concrete features, every screen, navigation flow, design language, colours, " +
                    "animations, empty/error states, offline behaviour), then build that spec COMPLETELY. A short " +
                    "prompt must still deliver an advanced, polished, feature-rich app - never a bare skeleton."
            )
        }
        if (buildish) {
            rules.add(
                "${n++}. UI-IMAGE-FIRST PLANNING: while planning, FIRST generate a design image for EVERY UI screen " +
                    "(image-generation tool; save them under `design/` in the project) - then write the code to match " +
                    "those images exactly: layout, colours, spacing, components. If image generation is unavailable, " +
                    "write a detailed per-screen design spec first and match it exactly. Never design blindly."
            )
            rules.add(
                "${n++}. RESEARCH-FIRST FEATURES: for each core feature, first research HOW that feature actually " +
                    "works (working principle, best practice, real-world apps) with the research/web tools, then " +
                    "implement the ADVANCED version of that principle - never a naive copy. Also add thoughtful " +
                    "improvements of your own (validation, empty/error states, polish) so the result beats what a " +
                    "weaker model would produce."
            )
        }
        if (buildish || editish) {
            rules.add(
                "${n++}. REGRESSION GUARD: before delivering, list EVERY feature the app already has and verify each " +
                    "one still works after your change - adding 1 new feature must never break the existing ones. " +
                    "Read (do not rewrite) untouched working code; if anything regressed, fix it in THIS turn before " +
                    "replying. A new feature delivered with broken old features is a failed turn."
            )
            rules.add(
                "${n++}. SELF-REVIEW LOOP: after the build, act as a strict QA reviewer of your own app - exercise " +
                    "every feature, judge the design and quality honestly. If any feature does not work or the " +
                    "quality/design is weak, FIX it and rebuild. Deliver only the version that passes your own " +
                    "review, and say in one line what you reviewed and fixed."
            )
        }
        if (buildish) {
            rules.add(
                "${n++}. TRIPLE DELIVERY: the final reply for a finished app must end with THREE fresh links from " +
                    "THIS build: 📦 **App ZIP:** (runnable package), ⬇️ **Download link:** [app.apk](URL), and " +
                    "🧾 **Source code ZIP:** (source only, excluding build/, .gradle/, node_modules/). Publish each " +
                    "with saif-apk-link; never reuse an old link."
            )
        }
        if (editish) {
            rules.add(
                "${n++}. FEATURE/EDIT RULE: read EVERY file the change touches, wire the change into the real UI so " +
                    "a user can reach it, keep all existing features working, then REBUILD and finish with the FRESH " +
                    "download link the build returns. For a tiny glitch: one surgical patch + one rebuild - fast path, " +
                    "no re-planning. Never answer with an old link or without rebuilding. CONTINUE IN PLACE: the " +
                    "project's existing code stays - edit its files directly, never delete, recreate or restart the " +
                    "project directory for a fix; only the files the fix touches may change."
            )
        }
        if (freshSession && oldDirs.isNotEmpty()) {
            rules.add(
                "${n++}. NEW-CHAT ISOLATION: directories already present from OLDER conversations: " +
                    oldDirs.joinToString(", ") +
                    ". They are off-limits in this chat - never edit, overwrite or build them here, and NEVER deliver, " +
                    "link, copy or re-publish any file, APK or output produced by them: everything you hand over in " +
                    "this chat must be generated fresh inside this chat. A new app goes " +
                    "into a fresh directory (next free `-2`, `-3` suffix if the name collides)."
            )
        }
        if (rules.isEmpty()) return ""
        val head = "[SAIF POWER DIRECTIVES - follow exactly]\n" + rules.joinToString("\n")
        return if (skillPolicy.isNotBlank()) head + "\n\n" + skillPolicy else head
    }
}
