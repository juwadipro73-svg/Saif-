package com.example.slash

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Plain JVM tests for the permanent `/video` editing skill wiring.
 * - Bare `/video` keeps opening Video Studio (existing behavior).
 * - `/video <request>` expands into the full skill instructions for the agent.
 */
class VideoSlashSkillTest {

    @Test
    fun `bare video opens the studio`() {
        assertEquals(SaifAppSlashAction.OPEN_VIDEO_STUDIO, SaifSlashCommandRegistry.resolveAppAction("/video"))
        assertEquals(SaifAppSlashAction.OPEN_VIDEO_STUDIO, SaifSlashCommandRegistry.resolveAppAction("  /VIDEO  "))
    }

    @Test
    fun `video with request is not an app action`() {
        assertNull(SaifSlashCommandRegistry.resolveAppAction("/video edit my vlog like this reel"))
    }

    @Test
    fun `video request expands into skill instructions`() {
        val expanded = SaifSlashCommandRegistry.expandBuiltInCommandIfMatched("/video edit my vlog like this reel")
        assertNotNull(expanded!!)
        assertTrue(expanded.contains("reference-style-matcher"))
        assertTrue(expanded.contains("/root/workspace/.agents/skills/reference-style-matcher/SKILL.md"))
        assertTrue(expanded.contains("analyze_reference.py"))
        assertTrue(expanded.contains("build_style_skill.py"))
        assertTrue(expanded.contains("MODE 1"))
        assertTrue(expanded.contains("MODE 3"))
        assertTrue(expanded.contains("edit my vlog like this reel"))
    }

    @Test
    fun `bare video expansion asks the routing question`() {
        val expanded = SaifSlashCommandRegistry.expandBuiltInCommandIfMatched("/video")
        assertNotNull(expanded!!)
        assertTrue(expanded.contains("reference-style-matcher"))
        assertTrue(expanded.contains("reference video"))
    }
}
