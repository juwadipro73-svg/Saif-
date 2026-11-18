package com.example

import com.example.gemini.data.agent.agy.PowerDirectives
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Request 24 lock: app builds must plan UI images first, research feature principles,
 * guard against regressions, self-review before delivery, and end with THREE fresh
 * links (App ZIP + APK + Source ZIP). Casual chat stays clean.
 */
class BuildQualityDirectivesTest {

    @Test
    fun buildPromptsCarryTheFullQualityEngine() {
        val block = PowerDirectives.blockFor("mere liye ek todo app banao", freshSession = false)
        assertTrue(block.contains("UI-IMAGE-FIRST PLANNING"))
        assertTrue(block.contains("RESEARCH-FIRST FEATURES"))
        assertTrue(block.contains("REGRESSION GUARD"))
        assertTrue(block.contains("SELF-REVIEW LOOP"))
        assertTrue(block.contains("TRIPLE DELIVERY"))
        assertTrue(block.contains("Source code ZIP"))
    }

    @Test
    fun editPromptsGuardAgainstRegressions() {
        val block = PowerDirectives.blockFor("app me dark mode fix karo", freshSession = false)
        assertTrue(block.contains("REGRESSION GUARD"))
        assertTrue(block.contains("SELF-REVIEW LOOP"))
        assertTrue(block.contains("FEATURE/EDIT RULE"))
        assertFalse("small edits must not demand triple archives", block.contains("TRIPLE DELIVERY"))
    }

    @Test
    fun gameRequestsGetFullGameEnginePower() {
        val block = PowerDirectives.blockFor("ek 3d racing game banao", freshSession = false)
        assertTrue(block.contains("GAME ENGINE POWER"))
        assertTrue(block.contains("FULL POTENTIAL"))
        assertTrue(block.contains("three.js"))
    }

    @Test
    fun casualChatStaysClean() {
        listOf("hello", "hi bro", "thanks!").forEach { msg ->
            assertTrue(PowerDirectives.blockFor(msg, freshSession = true).isEmpty())
        }
    }
}
