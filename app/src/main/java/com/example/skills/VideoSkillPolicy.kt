package com.example.skills

import android.content.Context
import android.util.Log

/**
 * Bundled Cinematic Motion Engine policy — the user-supplied SAIF AI video skills
 * (`saif-cinematic-motion-engine` + `motion-director`, Remotion-based), shipped inside
 * the APK so they can never be lost, deleted, or skipped between versions.
 *
 * Injected into every video request (including the existing `/video` slash command)
 * so Antigravity produces advanced videos of every category — with generated images
 * and sound effects — instead of a plain slideshow.
 */
object VideoSkillPolicy {
    private const val TAG = "VideoSkillPolicy"
    private const val CINE_ASSET = "skills/saif-cinematic-motion-engine/SKILL.md"
    private const val MOTION_ASSET = "skills/motion-director/SKILL.md"
    private const val MAX_CHARS = 12_000

    @Volatile private var cached: String? = null

    /** True when the user's message asks for video work (any language marker). */
    fun isVideoRequest(text: String): Boolean {
        val t = text.lowercase()
        if (t.startsWith("/video")) return true
        val markers = listOf(
            "video", "remotion", "motion graphic", "animation", "animate",
            "reel", "shorts", "youtube short", "cinematic", "banao video", "video banao",
            "video bana", "voiceover", "voice-over", "narration video", "explainer"
        )
        return markers.any { t.contains(it) }
    }

    fun policy(context: Context?): String {
        cached?.let { return it }
        val cine = readAsset(context, CINE_ASSET)
        val motion = readAsset(context, MOTION_ASSET)
        val merged = buildString {
            appendLine("# MANDATORY VIDEO SKILL — SAIF AI Cinematic Motion Engine + Motion Director (bundled, permanent)")
            appendLine("You MUST follow the skills below for THIS video task. Build a real Remotion project (React scenes,")
            appendLine("programmatic animation), generate images with Antigravity image generation for visuals, add sound")
            appendLine("effects/music where supported, and RENDER a real output file. Categories: explainer, documentary,")
            appendLine("promo, gaming, shorts, educational, data story, cinematic — whatever the user asked for.")
            appendLine("Do NOT deliver an HTML slideshow as a video. Do NOT skip steps. If rendering is blocked, deliver")
            appendLine("the full Remotion source project + exact blocker report, never a fake completion.")
            appendLine()
            appendLine("## Skill 1: saif-cinematic-motion-engine")
            appendLine(if (cine.isNullOrBlank()) FALLBACK_CINE else cine.take(MAX_CHARS))
            appendLine()
            appendLine("## Skill 2: motion-director (Remotion kit)")
            appendLine(
                if (motion.isNullOrBlank()) FALLBACK_MOTION else motion.take(MAX_CHARS)
            )
            appendLine()
            appendLine("On-device copies: /root/workspace/.agents/skills/saif-cinematic-motion-engine/ and")
            appendLine("/root/workspace/.agents/skills/motion-director/ (with the full Remotion kit: templates,")
            appendLine("scripts, logos, sfx). READ them from disk and USE their scripts/templates for the render.")
        }
        val out = merged.trimEnd()
        cached = out
        return out
    }

    private fun readAsset(context: Context?, path: String): String? {
        val ctx = context ?: return null
        return try {
            ctx.assets.open(path).bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            Log.w(TAG, "read $path failed: ${e.message}")
            null
        }
    }

    private const val FALLBACK_CINE = """
Use Remotion as the animation/render engine: build scenes as React components, animate with spring()
and interpolate(), respect platform-safe margins, 1080x1920@30fps for shorts / 1920x1080@30fps for
YouTube by default. Research facts before scripting factual topics and cite sources. Generate original
visuals with the available image-generation tool; add narration, captions, and sound effects. A finished
video means a real rendered output file was produced and checked — no fake completion; if the render is
blocked, deliver the full source project plus an exact blocker report.
"""

    private const val FALLBACK_MOTION = """
The motion-director kit lives at /root/workspace/.agents/skills/motion-director/kit with Remotion
templates, render scripts, brand logos (svg/paths.json), and sfx assets. Copy the closest template,
customize scenes/timing/transitions to the brief, wire generated images into <Img> layers with Ken Burns
or parallax motion, mix sound effects under narration, and render through the kit's script to mp4.
"""
}
