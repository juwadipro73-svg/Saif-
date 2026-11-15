package com.example.gemini.data.remote

import com.example.gemini.domain.model.ThinkingLevel
import com.example.gemini.domain.model.ThinkingPreference

/**
 * Resolves the reasoning ("thinking") budget that is actually sent to Antigravity.
 *
 * Before this existed the budget was hard-coded to 8192 and the in-app thinking selector was
 * never wired to the request, so picking "High" changed nothing and pro models felt weaker
 * than the same models inside Antigravity itself. Pure logic, covered by unit tests.
 */
object AgyThinkingBudget {

    /** Budget for a plain pro/flash turn when the user has not touched the selector. */
    const val DEFAULT_TOKENS = 8192

    /** Hard ceiling accepted by the current Antigravity models. */
    const val MAX_TOKENS = 32768

    /**
     * Effective thinking budget for [modelId] under [preference].
     * Returns 0 when thinking is explicitly switched off (the caller then disables thinking).
     */
    fun resolve(modelId: String, preference: ThinkingPreference = ThinkingPreference()): Int {
        if (preference.level == ThinkingLevel.OFF) return 0
        val requested = when (preference.level) {
            ThinkingLevel.CUSTOM -> preference.customTokens
            ThinkingLevel.OFF -> 0
            else -> preference.level.tokens
        }
        val budget = if (requested > 0) requested else DEFAULT_TOKENS
        return budget.coerceIn(MIN_TOKENS, ceilingFor(modelId))
    }

    /** Per-model ceiling: big pro/opus models reason deeper than flash-class models. */
    fun ceilingFor(modelId: String): Int {
        val lower = modelId.lowercase()
        return when {
            lower.contains("opus") -> MAX_TOKENS
            lower.contains("pro") -> MAX_TOKENS
            lower.contains("claude") || lower.contains("sonnet") -> 24576
            lower.contains("flash") -> 24576
            else -> MAX_TOKENS
        }
    }

    /** Smallest budget that still lets the model plan a multi-file change. */
    const val MIN_TOKENS = 1024
}
