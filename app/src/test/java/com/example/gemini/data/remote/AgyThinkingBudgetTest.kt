package com.example.gemini.data.remote

import com.example.gemini.domain.model.ThinkingLevel
import com.example.gemini.domain.model.ThinkingPreference
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * The in-app thinking selector used to be decorative: the Antigravity request was hard-coded to
 * 8192 tokens, so picking High/Off changed nothing. These tests pin the wiring.
 */
class AgyThinkingBudgetTest {

    @Test
    fun `default preference is at least the old hard-coded budget`() {
        // Must never regress below the previous behaviour.
        assertTrue(AgyThinkingBudget.resolve("gemini-3-pro", ThinkingPreference()) >= 8192)
    }

    @Test
    fun `high level asks for the full pro budget`() {
        val budget = AgyThinkingBudget.resolve(
            "gemini-3-pro",
            ThinkingPreference(level = ThinkingLevel.HIGH)
        )
        assertEquals(32768, budget)
    }

    @Test
    fun `off disables thinking`() {
        assertEquals(0, AgyThinkingBudget.resolve("gemini-3-pro", ThinkingPreference(level = ThinkingLevel.OFF)))
    }

    @Test
    fun `custom tokens are honored`() {
        val pref = ThinkingPreference(level = ThinkingLevel.CUSTOM, customTokens = 12000)
        assertEquals(12000, AgyThinkingBudget.resolve("MODEL_PLACEHOLDER_M1", pref))
    }

    @Test
    fun `budget is clamped to the ceiling`() {
        val pref = ThinkingPreference(level = ThinkingLevel.CUSTOM, customTokens = 999_999)
        assertEquals(AgyThinkingBudget.MAX_TOKENS, AgyThinkingBudget.resolve("gemini-3-pro", pref))
    }

    @Test
    fun `flash gets a smaller ceiling than pro`() {
        assertTrue(AgyThinkingBudget.ceilingFor("gemini-3-flash") < AgyThinkingBudget.ceilingFor("gemini-3-pro"))
    }

    @Test
    fun `tiny custom budgets are floored`() {
        val pref = ThinkingPreference(level = ThinkingLevel.CUSTOM, customTokens = 5)
        assertEquals(AgyThinkingBudget.MIN_TOKENS, AgyThinkingBudget.resolve("gemini-3-flash", pref))
    }
}
