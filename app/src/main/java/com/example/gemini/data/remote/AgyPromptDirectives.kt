package com.example.gemini.data.remote

import com.example.builder.agent.BuildAgent
import com.example.builder.agent.BuildStack

/**
 * Compact operating rules prepended to every Antigravity (hub) turn.
 *
 * The daemon used to receive the bare user text, so nothing told it that a small change must stay
 * a small change, which stack the user wants, or that a produced file needs a download link. That
 * is why a two-line fix cost as much time as a full build, and why pinned native asks drifted.
 * Pure logic, covered by unit tests.
 */
object AgyPromptDirectives {

    /** Rules that apply to every turn. */
    const val EDIT_RULE =
        "- A small change stays small: for a fix, a tweak or one small feature on existing code, inspect only the affected files and patch them. Never rebuild or re-plan a whole project for a small change."

    const val FINISH_RULE =
        "- Finish the work instead of describing it: write the real files and verify them (compile, run, or test) before you answer."

    const val NO_PLACEHOLDER_RULE =
        "- No placeholders, no TODOs and no \"rest of the code here\": write complete files only."

    const val DOWNLOAD_RULE =
        "- If the turn produces a file the user can install or open, end your answer with `⬇️ **Download link:** [name](url)`."

    /** The full prompt sent to Antigravity: rules, stack pin, then the user's own words. */
    fun compile(userText: String, modelId: String = ""): String {
        val text = userText.trim()
        if (text.isBlank()) return userText
        val rules = buildString {
            appendLine("OPERATING RULES FOR THIS TURN (keep them even if an older habit says otherwise):")
            appendLine(EDIT_RULE)
            appendLine(FINISH_RULE)
            appendLine(NO_PLACEHOLDER_RULE)
            appendLine(DOWNLOAD_RULE)
            stackRule(text)?.let { appendLine(it) }
        }
        return rules + "\nUSER REQUEST:\n" + text
    }

    /** Stack pin for native / flutter asks; null for ordinary (HTML/web or non-build) turns. */
    fun stackRule(userText: String): String? = try {
        when (BuildAgent.detectBuildStack(userText)) {
            BuildStack.NATIVE ->
                "- STACK: this request is a NATIVE Android app. Build a Java project (app/src/main/AndroidManifest.xml, java/, res/) and deliver an installable signed APK — never an HTML/WebView wrapper."
            BuildStack.FLUTTER ->
                "- STACK: this request is a FLUTTER app. Build a Dart project (pubspec.yaml, lib/main.dart, lib/screens/) — never HTML or native Java."
            BuildStack.HTML -> null
        }
    } catch (_: Throwable) {
        null
    }
}
