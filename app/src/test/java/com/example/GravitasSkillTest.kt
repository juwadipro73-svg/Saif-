package com.example

import com.example.gemini.data.agent.agy.PowerDirectives
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * The Gravitas reliability policy ships inside the APK and switches on automatically for
 * engineering tasks only - casual chat must stay free of it.
 */
class GravitasSkillTest {

    private val repoRoot: File = listOf(File("."), File("..")).first { File(it, "settings.gradle.kts").isFile }
    private val skill = File(repoRoot, "app/src/main/assets/skills/gravitas/SKILL.md")

    @Test
    fun theSkillIsPermanentlyBundledInTheApk() {
        assertTrue("gravitas SKILL.md must ship in assets", skill.isFile)
        val text = skill.readText()
        assertTrue(text.contains("6 INVARIANTS"))
        assertTrue(text.contains("Ground before mutating"))
        assertTrue(text.contains("Completion needs evidence"))
        assertTrue(text.contains("VERDICT: PASS"))
        assertTrue("MIT attribution must stay", text.contains("MIT"))
    }

    @Test
    fun casualChatGetsNoDirectivesAndNoSkill() {
        listOf("hello", "hi bro", "kya hal hai", "thanks!").forEach { msg ->
            val block = PowerDirectives.blockFor(msg, freshSession = true, oldDirs = listOf("old-app"), skillPolicy = "POLICY")
            assertFalse("casual message must stay clean: $msg", block.contains("POLICY"))
            assertFalse(block.contains("GRAVITAS"))
            assertTrue(block.isEmpty())
        }
    }

    @Test
    fun taskPromptsActivateTheSkillAutomatically() {
        val block = PowerDirectives.blockFor(
            "mere liye ek todo app banao",
            freshSession = false,
            skillPolicy = "[GRAVITAS RELIABILITY POLICY - ACTIVE FOR THIS TASK]"
        )
        assertTrue(block.contains("GRAVITAS RELIABILITY POLICY"))
        assertTrue(block.contains("SPEC EXPANSION"))
    }

    @Test
    fun editPromptsCarryRebuildAndSkillRules() {
        val block = PowerDirectives.blockFor(
            "app me dark mode fix karo",
            freshSession = false,
            skillPolicy = "POLICY"
        )
        assertTrue(block.contains("FEATURE/EDIT RULE"))
        assertTrue(block.contains("POLICY"))
    }
}
