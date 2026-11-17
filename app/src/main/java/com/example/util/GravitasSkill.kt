package com.example.util

import android.content.Context

/**
 * The Gravitas engineering-reliability policy, permanently bundled with the app
 * (source: github.com/udaysharmadev/Gravitas, MIT). It is loaded once from assets and
 * automatically activated for every detected engineering task - the user never has to
 * type a command. Casual conversation never sees it.
 */
object GravitasSkill {

    const val SOURCE = "udaysharmadev/Gravitas (MIT)"
    const val MARKER = "[GRAVITAS RELIABILITY POLICY - ACTIVE FOR THIS TASK]"

    @Volatile private var cached: String? = null

    fun policyText(context: Context): String {
        cached?.let { return it }
        val text = runCatching {
            context.assets.open("skills/gravitas/SKILL.md").bufferedReader().use { it.readText() }
        }.getOrDefault(FALLBACK)
        cached = text
        return text
    }

    /** Wrapped block appended to task prompts so the agent follows the policy. */
    fun block(context: Context): String = MARKER + "\n" + policyText(context)

    private const val FALLBACK = """
1. Ground before mutating: read targets before editing.
2. Stay in declared scope: only this task's project directory.
3. Completion needs evidence: a build/test/read-back passed after the last mutation.
4. Never exact-retry a failure: change diagnosis or strategy first.
5. Satisfy the contract: every user requirement needs its own proof.
6. Say what you can't verify: mark uncertainty instead of fabricating certainty.
"""
}
