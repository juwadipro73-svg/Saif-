package com.example.skills

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.File

/**
 * Verifies the bundled `/video` skill assets install permanently onto the device.
 * Robolectric because the installer uses Context + APK assets.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class VideoSkillInstallerTest {

    @Test
    fun `skill installs all bundle files`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        assertTrue(VideoSkillInstaller.ensureInstalled(context))

        val dir = VideoSkillInstaller.androidSkillDir(context)
        val expected = listOf(
            "SKILL.md",
            "README.md",
            "scripts/analyze_reference.py",
            "scripts/build_style_skill.py",
            "references/template_skill_schema.md",
            "skill_version.txt"
        )
        for (rel in expected) {
            val file = File(dir, rel)
            assertTrue("missing $rel", file.exists() && file.length() > 0)
        }
        assertTrue(File(dir, "SKILL.md").readText().contains("reference-style-matcher"))
        assertEquals(VideoSkillInstaller.SKILL_VERSION, File(dir, "skill_version.txt").readText().trim())
    }

    @Test
    fun `install is idempotent`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        assertTrue(VideoSkillInstaller.ensureInstalled(context))
        val first = File(VideoSkillInstaller.androidSkillDir(context), "SKILL.md").readText()
        assertTrue(VideoSkillInstaller.ensureInstalled(context))
        val second = File(VideoSkillInstaller.androidSkillDir(context), "SKILL.md").readText()
        assertEquals(first, second)
    }
}
