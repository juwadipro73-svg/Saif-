package com.example.skills

import android.content.Context
import android.util.Log

/**
 * Bundled Cinematic Motion Engine policy — the user-supplied SAIF AI video skills
 * (`saif-cinematic-motion-engine` + `motion-director` Remotion kit + the
 * `cinematic-story-mode` character-animation skill), shipped inside the APK so they
 * can never be lost, deleted, or skipped between versions.
 *
 * Injected into every video request (including the existing `/video` slash command)
 * so Antigravity produces advanced videos of every category — real Remotion renders
 * with generated images, colour grading, cinematic camera motion, sound design, and
 * two independent modes: ADVANCED MOTION GRAPHICS and CINEMATIC STORY MODE.
 */
object VideoSkillPolicy {
    private const val TAG = "VideoSkillPolicy"
    private const val CINE_ASSET = "skills/saif-cinematic-motion-engine/SKILL.md"
    private const val MOTION_ASSET = "skills/motion-director/SKILL.md"
    private const val STORY_ASSET = "skills/cinematic-story-mode/SKILL.md"
    private const val MAX_CHARS = 14_000
    private const val STORY_MAX_CHARS = 7_000

    @Volatile private var cached: String? = null
    @Volatile private var cachedStory: String? = null

    /** True when the user's message asks for video work (any language marker). */
    fun isVideoRequest(text: String): Boolean {
        val t = text.lowercase()
        if (t.startsWith("/video")) return true
        val markers = listOf(
            "video", "remotion", "motion graphic", "animation", "animate",
            "reel", "shorts", "youtube short", "cinematic", "banao video", "video banao",
            "video bana", "voiceover", "voice-over", "narration video", "explainer",
            "story mode", "kahani", "stickman"
        )
        return markers.any { t.contains(it) }
    }

    /** True when the request is character/story-driven → CINEMATIC STORY MODE. */
    fun isStoryRequest(text: String): Boolean {
        val t = text.lowercase()
        val markers = listOf(
            "stickman", "story mode", "kahani", "kissa", "character animation",
            "animated story", "story banao", "emotional story", "motivational story",
            "horror story", "comedy story", "success story", "sad story", "love story"
        )
        return markers.any { t.contains(it) }
    }

    fun policy(context: Context?, storyMode: Boolean = false): String {
        if (storyMode) {
            cachedStory?.let { return it }
        } else {
            cached?.let { return it }
        }
        val cine = readAsset(context, CINE_ASSET)
        val motion = readAsset(context, MOTION_ASSET)
        val story = readAsset(context, STORY_ASSET)
        val merged = buildString {
            appendLine("# MANDATORY VIDEO SKILL — SAIF AI Cinematic Motion Engine + Motion Director (bundled, permanent)")
            appendLine("You MUST follow the skills below for THIS video task. Build a real Remotion project (React scenes,")
            appendLine("programmatic animation), generate images with Antigravity image generation for visuals, add sound")
            appendLine("effects/music where supported, and RENDER a real output file. Categories: explainer, documentary,")
            appendLine("promo, gaming, shorts, educational, data story, cinematic, character story — whatever the user asked.")
            appendLine()
            appendLine("NON-NEGOTIABLE QUALITY RULES (ENGINE OVERHAUL v2):")
            appendLine("- Scene planner FIRST: ~2-5s visual beats; 60s video => 15-25 beats; 2min => 25-45 beats; never")
            appendLine("  duplicate shots for count; never hold one static layout >6s without a deliberate reason.")
            appendLine("- Image assets: generate an ORIGINAL image plan per scene (background/foreground/character/object/")
            appendLine("  location/illustration/infographic/texture). ONE background for the whole video is FORBIDDEN;")
            appendLine("  same image in consecutive scenes is FORBIDDEN (unless a deliberate continuity technique).")
            appendLine("  Save under public/assets/{backgrounds,characters,environments,objects,illustrations,textures,")
            appendLine("  overlays,sound-effects,music}/ + manifest.json. Generated-but-unused assets are NOT acceptable.")
            appendLine("- Colour: EVERY image/footage layer MUST be wrapped in the kit's ColorGrade (gradeForMood picks the")
            appendLine("  preset from the video mood). Raw uncorrected AI images must never reach the screen.")
            appendLine("- Camera: EVERY image moves via KenBurns (pushIn/pullOut/pan/driftDiag/orbit, fgSrc for 2.5D parallax).")
            appendLine("- Hook: open with HookOpen (1-3s, strongest visual + fast push + word-slam line + impact SFX).")
            appendLine("  NEVER a boring title card or multi-second logo intro.")
            appendLine("- Transitions: rotate kit Transitions kinds (transitionForScene(i)); never the same kind twice in a")
            appendLine("  row; clean cuts where they hit harder; transitions must connect visual meaning.")
            appendLine("- Sound: original SFX for transitions/impacts/camera moves/actions/ambience + mood music; ducked,")
            appendLine("  faded, synced mix — professional, not a loud SFX on every animation.")
            appendLine("- Research factual topics before scripting; keep source URLs; no fabricated facts.")
            appendLine("- QC BEFORE final render: beat durations, no repeated backgrounds, no missing/unused assets,")
            appendLine("  character consistency, readability, no frozen frames, narration sync, audio levels, grade applied.")
            appendLine("  Capture + inspect preview frames (capture.mjs / lint-frames.mjs), fix, re-preview. Compilation")
            appendLine("  success is NOT proof of a good video.")
            if (storyMode) {
                appendLine()
                appendLine("MODE = CINEMATIC STORY MODE (character-driven). Follow the story skill below COMPLETELY:")
                appendLine("original story with beginning/conflict/climax/ending, CharacterSheet consistency engine")
                appendLine("(characters.json, identity never drifts), procedural Stickman animation (no static character")
                appendLine("images), StoryScene assembly, per-scene generated environments, mood presets driving grade/music/")
                appendLine("lighting/pacing.")
                appendLine()
                appendLine("## Skill: cinematic-story-mode")
                appendLine(
                    if (story.isNullOrBlank()) FALLBACK_STORY else story.take(STORY_MAX_CHARS)
                )
            } else {
                appendLine()
                appendLine("MODE = ADVANCED MOTION GRAPHICS (informational/promo/data/educational). If the request is")
                appendLine("actually a character STORY (kahani/stickman), switch to Cinematic Story Mode rules instead.")
                appendLine("If genuinely ambiguous, ask ONE short clarification question offering: Motion Graphics / Story Mode.")
            }
            appendLine()
            appendLine("## Skill 1: saif-cinematic-motion-engine")
            appendLine(if (cine.isNullOrBlank()) FALLBACK_CINE else cine.take(MAX_CHARS))
            appendLine()
            appendLine("## Skill 2: motion-director (Remotion kit)")
            appendLine(if (motion.isNullOrBlank()) FALLBACK_MOTION else motion.take(MAX_CHARS))
            appendLine()
            appendLine("On-device copies: /root/workspace/.agents/skills/saif-cinematic-motion-engine/,")
            appendLine("/root/workspace/.agents/skills/motion-director/ (full Remotion kit incl. ColorGrade, KenBurns,")
            appendLine("Transitions, HookOpen, Stickman, StoryScene templates), and")
            appendLine("/root/workspace/.agents/skills/cinematic-story-mode/. READ them from disk and USE their")
            appendLine("scripts/templates for the render.")
        }
        val out = merged.trimEnd()
        if (storyMode) cachedStory = out else cached = out
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
YouTube by default. Plan ~2-5 second visual beats (15-25 per minute). Generate an original image per
scene (never one background for the whole video), wrap every image in ColorGrade (gradeForMood) and
KenBurns camera motion, open with HookOpen (1-3s, never a title card), rotate Transitions kinds, add
narration, captions, SFX and mood music with a ducked professional mix. Research facts before
scripting factual topics and cite sources. QC before the final render: beat durations, repeated or
unused assets, character consistency, readability, frozen frames, audio levels, grade applied — capture
and inspect preview frames, fix, re-preview. A finished video means a real rendered output file was
produced and checked — no fake completion; if the render is blocked, deliver the full source project
plus an exact blocker report.
"""

    private const val FALLBACK_MOTION = """
The motion-director kit lives at /root/workspace/.agents/skills/motion-director/kit with Remotion
templates (ColorGrade, KenBurns, Transitions, HookOpen, Stickman, StoryScene, kinetic typography,
charts, lower thirds), render scripts, brand logos (svg/paths.json), and sfx assets. Copy the closest
template, customize scenes/timing/transitions to the brief, wire generated images into KenBurns layers
with parallax motion, grade everything with ColorGrade, mix sound effects under narration, and render
through the kit's script to mp4.
"""

    private const val FALLBACK_STORY = """
Cinematic Story Mode: write an original story (beginning, conflict, climax, ending) with 2-4 characters
and natural dialogue in the user's language. Create a CharacterSheet per character (id, proportions,
colours, accessory) saved in characters.json — identity never drifts between scenes. Animate with the
procedural Stickman rig (walk/run/jump/sit/fall/point/wave/talk/turn/climb/celebrate + expressions),
assemble each beat with StoryScene (generated per-scene background + camera move + gradeForMood grade +
characters + dialogue bubble + narration caption). Never one background for the whole story; keep
lighting/palette continuity. Mood presets (emotional, inspirational, motivational, comedy, mystery,
horror fiction, adventure, suspense, educational, dramatic) drive palette, music, lighting, camera,
expressions, timing, SFX and transitions. Deliver the rendered, verified MP4 — no fake completion.
"""
}
