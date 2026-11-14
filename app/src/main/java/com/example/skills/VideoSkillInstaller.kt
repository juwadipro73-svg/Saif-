package com.example.skills

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import java.io.File

/**
 * Permanently installs the app's bundled agent skills (the `/video` and `/rea`
 * slash skills) from APK assets onto the device.
 *
 * Two copies of each skill are kept:
 * 1. Android side: `<filesDir>/skills/<slug>/` — always installed, survives app
 *    updates (re-seeded when the skill version changes).
 * 2. Linux workspace side: `<filesDir>/ubuntu/root/workspace/.agents/skills/<slug>/`,
 *    i.e. `/root/workspace/.agents/skills/<slug>/` as the terminal agent sees it —
 *    installed once the Ubuntu rootfs exists, so the agent can read SKILL.md files
 *    and execute bundled scripts directly.
 *
 * Safe to call from any thread. Call sites: app start (SaifApplication) and every
 * `/video` / `/rea` send (SaifAiApp) as a repair pass.
 */
data class BundledSkill(
    val slug: String,
    val version: String,
    /** A file that must exist for the install to count as fresh. */
    val markerFile: String
)

object BundledSkillsInstaller {
    private const val TAG = "BundledSkills"
    private const val VERSION_FILE = "skill_version.txt"

    val SKILLS: List<BundledSkill> = listOf(
        BundledSkill(
            slug = "reference-style-matcher",
            version = "1.0.0",
            markerFile = "SKILL.md"
        ),
        BundledSkill(
            slug = "rea",
            version = "62-6938696",
            markerFile = "skills/reverse-engineer-anything/SKILL.md"
        )
    )

    /** Linux-side absolute path of a skill as the terminal agent sees it. */
    fun workspaceSkillPath(slug: String): String = "/root/workspace/.agents/skills/$slug"

    fun androidSkillDir(context: Context, slug: String): File =
        File(context.applicationContext.filesDir, "skills/$slug")

    fun workspaceSkillDir(context: Context, slug: String): File =
        File(context.applicationContext.filesDir, "ubuntu/root/workspace/.agents/skills/$slug")

    private fun ubuntuRootfsPresent(context: Context): Boolean {
        val ubuntu = File(context.applicationContext.filesDir, "ubuntu")
        return File(ubuntu, "bin").isDirectory || File(ubuntu, "etc").isDirectory
    }

    private fun isFresh(dir: File, skill: BundledSkill): Boolean {
        return try {
            val stamp = File(dir, VERSION_FILE)
            val marker = File(dir, skill.markerFile)
            stamp.exists() && stamp.readText().trim() == skill.version &&
                marker.exists() && marker.length() > 1024
        } catch (_: Exception) {
            false
        }
    }

    private fun copyAssetPath(assets: AssetManager, assetPath: String, target: File) {
        val entries = try {
            assets.list(assetPath)
        } catch (_: Exception) {
            null
        }
        if (entries.isNullOrEmpty()) {
            try {
                target.parentFile?.mkdirs()
                assets.open(assetPath).use { input ->
                    target.outputStream().use { output -> input.copyTo(output) }
                }
            } catch (_: Exception) {
                target.mkdirs()
            }
        } else {
            target.mkdirs()
            for (entry in entries) {
                copyAssetPath(assets, "$assetPath/$entry", File(target, entry))
            }
        }
    }

    private fun installTo(context: Context, dir: File, skill: BundledSkill): Boolean {
        return try {
            if (isFresh(dir, skill)) return true
            copyAssetPath(context.applicationContext.assets, "skills/${skill.slug}", dir)
            File(dir, VERSION_FILE).writeText(skill.version)
            Log.i(TAG, "Installed ${skill.slug} v${skill.version} to ${dir.absolutePath}")
            isFresh(dir, skill)
        } catch (e: Exception) {
            Log.w(TAG, "Skill install to ${dir.absolutePath} failed: ${e.message}")
            false
        }
    }

    /**
     * Ensures every bundled skill is installed and current. Returns true when all
     * Android-side (permanent) copies are ready.
     */
    fun ensureInstalled(context: Context): Boolean {
        val app = context.applicationContext
        var allOk = true
        for (skill in SKILLS) {
            if (!installTo(app, androidSkillDir(app, skill.slug), skill)) allOk = false
            try {
                if (ubuntuRootfsPresent(app)) {
                    installTo(app, workspaceSkillDir(app, skill.slug), skill)
                }
            } catch (_: Exception) {
            }
        }
        return allOk
    }
}

/**
 * Facade kept for the `/video` skill's established API (used by tests and call sites).
 */
object VideoSkillInstaller {
    const val SKILL_SLUG = "reference-style-matcher"
    const val SKILL_VERSION = "1.0.0"

    /** Linux-side absolute path as the terminal agent sees it. */
    const val WORKSPACE_SKILL_PATH = "/root/workspace/.agents/skills/reference-style-matcher"

    /** Where chat attachments land for the Linux agent. */
    const val WORKSPACE_UPLOADS_PATH = "/root/uploads"

    fun androidSkillDir(context: Context): File =
        BundledSkillsInstaller.androidSkillDir(context, SKILL_SLUG)

    fun workspaceSkillDir(context: Context): File =
        BundledSkillsInstaller.workspaceSkillDir(context, SKILL_SLUG)

    /** Installs all bundled skills; returns true when the video skill copy is ready. */
    fun ensureInstalled(context: Context): Boolean {
        BundledSkillsInstaller.ensureInstalled(context)
        return try {
            val dir = androidSkillDir(context)
            File(dir, "SKILL.md").exists() && File(dir, "skill_version.txt").readText().trim() == SKILL_VERSION
        } catch (_: Exception) {
            false
        }
    }
}
