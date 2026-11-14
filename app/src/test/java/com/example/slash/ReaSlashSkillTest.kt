package com.example.slash

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Plain JVM tests for the permanent `/rea` reverse-engineering skill wiring
 * (REA bundle by morluto, bundled under APK assets `skills/rea/`).
 */
class ReaSlashSkillTest {

    @Test
    fun `rea is not an app action`() {
        assertNull(SaifSlashCommandRegistry.resolveAppAction("/rea"))
        assertNull(SaifSlashCommandRegistry.resolveAppAction("  /REA  "))
        assertNull(SaifSlashCommandRegistry.resolveAppAction("/rea analyze this apk"))
    }

    @Test
    fun `rea request expands into skill instructions`() {
        val expanded = SaifSlashCommandRegistry.expandBuiltInCommandIfMatched("/rea analyze this apk")
        assertNotNull(expanded!!)
        assertTrue(expanded.contains("/root/workspace/.agents/skills/rea/skills/reverse-engineer-anything/SKILL.md"))
        assertTrue(expanded.contains("reverse-engineer-anything"))
        assertTrue(expanded.contains("android-applications"))
        assertTrue(expanded.contains("DISCLAIMER.md"))
        assertTrue(expanded.contains("analyze this apk"))
    }

    @Test
    fun `bare rea expansion asks for the target`() {
        val expanded = SaifSlashCommandRegistry.expandBuiltInCommandIfMatched("/rea")
        assertNotNull(expanded!!)
        assertTrue(expanded.contains("reverse-engineer-anything"))
        assertTrue(expanded.contains("which app/binary/version"))
    }

    @Test
    fun `rea is listed as a workflow command`() {
        val item = SaifSlashCommandRegistry.WORKFLOW_COMMANDS.firstOrNull { it.command == "/rea" }
        assertNotNull(item!!)
        assertTrue(item.description.contains("REA", ignoreCase = true))
    }
}
