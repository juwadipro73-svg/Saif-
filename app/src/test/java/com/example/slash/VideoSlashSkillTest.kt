package com.example.slash

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Plain JVM tests for the permanent `/video` editing skill wiring.
 * The old Video Studio window has been removed: bare `/video` is NOT an app
 * action anymore — it expands into the reference-style-matcher skill, exactly
 * like `/video <request>`.
 */
class VideoSlashSkillTest {

    @Test
    fun `bare video is not an app action anymore`() {
        assertNull(SaifSlashCommandRegistry.resolveAppAction("/video"))
        assertNull(SaifSlashCommandRegistry.resolveAppAction("  /VIDEO  "))
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
