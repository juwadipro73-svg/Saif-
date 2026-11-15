package com.example.gemini.domain.model

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Antigravity reports ids like `MODEL_PLACEHOLDER_M319`; detection must read the display name
 * too, otherwise every model is treated as "no thinking" and the reasoning budget is dropped.
 */
class ModelThinkingUnitTest {

    @Test
    fun `placeholder ids with a pro display name support thinking`() {
        val model = AiModel.fromApi("MODEL_PLACEHOLDER_M319", "Gemini 3 Pro (High)")
        assertTrue(model.supportsThinking)
    }

    @Test
    fun `placeholder ids with a flash display name support thinking`() {
        assertTrue(AiModel.fromApi("MODEL_PLACEHOLDER_M12", "Gemini 3 Flash").supportsThinking)
    }

    @Test
    fun `claude models support thinking`() {
        assertTrue(AiModel.fromApi("MODEL_PLACEHOLDER_M99", "Claude Sonnet 4.5 (Thinking)").supportsThinking)
    }

    @Test
    fun `lite models do not support thinking`() {
        assertFalse(AiModel.fromApi("MODEL_PLACEHOLDER_L1", "Gemini 2.0 Flash Lite").supportsThinking)
        assertFalse(AiModel.isThinkingCapable("gemini-nano", "Nano"))
    }

    @Test
    fun `explicit id keywords still work`() {
        assertTrue(AiModel.isThinkingCapable("gemini-3-pro", ""))
        assertTrue(AiModel.isThinkingCapable("claude-opus-4", ""))
    }
}
