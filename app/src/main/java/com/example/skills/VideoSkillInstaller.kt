package com.example.skills

import android.content.Context
import android.util.Log
import java.io.File

/**
 * Permanently installs the bundled "reference-style-matcher" video-editing skill
 * (the `/video` slash skill) from APK assets onto the device.
 *
 * Two copies are kept:
 * 1. Android side: `<filesDir>/skills/reference-style-matcher/` — always installed,
 *    survives app updates (re-seeded when [SKILL_VERSION] changes).
 * 2. Linux workspace side: `<filesDir>/ubuntu/root/workspace/.agents/skills/reference-style-matcher/`,
 *    i.e. `/root/workspace/.agents/skills/reference-style-matcher/` as the terminal agent sees it —
 *    installed once the Ubuntu rootfs exists, so the agent can read SKILL.md and execute
 *    `scripts/analyze_reference.py` + `scripts/build_style_skill.py` directly.
 *
 * Safe to call from any thread; small files (~60 KB total). Call sites:
 * app start (SaifApplication) and every `/video` send (SaifAiApp) as a repair pass.
 */
object VideoSkillInstaller {
    private const val TAG = "VideoSkillInstaller"

    const val SKILL_SLUG = "reference-style-matcher"
    const val SKILL_VERSION = "1.0.0"

    /** Linux-side absolute path as the terminal agent sees it. */
    const val WORKSPACE_SKILL_PATH = "/root/workspace/.agents/skills/reference-style-matcher"

    /** Where chat attachments land for the Linux agent. */
    const val WORKSPACE_UPLOADS_PATH = "/root/uploads"

    private const val ASSET_ROOT = "skills/reference-style-matcher"
    private const val VERSION_FILE = "skill_version.txt"

    private val SKILL_FILES = listOf(
        "SKILL.md",
        "README.md",
        "scripts/analyze_reference.py",
        "scripts/build_style_skill.py",
        "references/template_skill_schema.md"
    )

    fun androidSkillDir(context: Context): File =
        File(context.applicationContext.filesDir, "skills/$SKILL_SLUG")

    fun workspaceSkillDir(context: Context): File =
        File(context.applicationContext.filesDir, "ubuntu/root/workspace/.agents/skills/$SKILL_SLUG")

    private fun ubuntuRootfsPresent(context: Context): Boolean {
        val ubuntu = File(context.applicationContext.filesDir, "ubuntu")
        return File(ubuntu, "bin").isDirectory || File(ubuntu, "etc").isDirectory
    }

    private fun isFresh(dir: File): Boolean {
        return try {
            val stamp = File(dir, VERSION_FILE)
            val skill = File(dir, "SKILL.md")
            stamp.exists() && stamp.readText().trim() == SKILL_VERSION && skill.exists() && skill.length() > 1024
        } catch (_: Exception) {
            false
        }
    }

    private fun installTo(context: Context, dir: File): Boolean {
        return try {
            if (isFresh(dir)) return true
            val assets = context.applicationContext.assets
            dir.mkdirs()
            for (rel in SKILL_FILES) {
                val target = File(dir, rel)
                target.parentFile?.mkdirs()
                assets.open("$ASSET_ROOT/$rel").use { input ->
                    target.outputStream().use { output -> input.copyTo(output) }
                }
            }
            File(dir, VERSION_FILE).writeText(SKILL_VERSION)
            Log.i(TAG, "Installed $SKILL_SLUG v$SKILL_VERSION to ${dir.absolutePath}")
            true
        } catch (e: Exception) {
            Log.w(TAG, "Skill install to ${dir.absolutePath} failed: ${e.message}")
            false
        }
    }

    /**
     * Ensures both skill copies exist and are current. Returns true when the
     * Android-side copy (the permanent one) is ready.
     */
    fun ensureInstalled(context: Context): Boolean {
        val app = context.applicationContext
        val androidOk = installTo(app, androidSkillDir(app))
        try {
            if (ubuntuRootfsPresent(app)) {
                installTo(app, workspaceSkillDir(app))
            }
        } catch (_: Exception) {
        }
        return androidOk
    }
}
