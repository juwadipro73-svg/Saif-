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
 * Verifies the bundled `/rea` skill assets install permanently onto the device.
 * Robolectric because the installer uses Context + APK assets.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ReaSkillInstallerTest {

    @Test
    fun `rea skill installs all bundle files`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        assertTrue(BundledSkillsInstaller.ensureInstalled(context))

        val dir = BundledSkillsInstaller.androidSkillDir(context, "rea")
        val expected = listOf(
            "LICENSE",
            "README.md",
            "DISCLAIMER.md",
            "SECURITY.md",
            "skills/reverse-engineer-anything/SKILL.md",
            "skills/reverse-engineer-anything/references/android-applications.md",
            "skills/reverse-engineer-anything/references/runtime-observation.md",
            "skills/reverse-engineer-anything/references/evidence-workflows.md",
            "skill_version.txt"
        )
        for (rel in expected) {
            val file = File(dir, rel)
            assertTrue("missing $rel", file.exists() && file.length() > 0)
        }
        assertTrue(File(dir, "skills/reverse-engineer-anything/SKILL.md").readText().contains("reverse-engineer-anything"))
        assertEquals(
            BundledSkillsInstaller.SKILLS.first { it.slug == "rea" }.version,
            File(dir, "skill_version.txt").readText().trim()
        )
    }

    @Test
    fun `rea install also keeps the video skill installed`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        assertTrue(BundledSkillsInstaller.ensureInstalled(context))
        val videoDir = BundledSkillsInstaller.androidSkillDir(context, "reference-style-matcher")
        assertTrue(File(videoDir, "SKILL.md").exists())
    }
}
