"""Generate a portable, standalone Style Template Skill bundle from style_telemetry.json."""

from __future__ import annotations

import argparse
import json
import re
import sys
from pathlib import Path
from typing import Any


def slugify(name: str) -> str:
    slug = re.sub(r"[^a-z0-9]+", "-", name.lower()).strip("-")
    return slug or "custom-reference-style"


def derive_ffmpeg_grade(color: dict[str, Any]) -> str:
    filters: list[str] = []
    contrast_span = color.get("contrast_p95_p5") or 150.0
    sat_mean = color.get("saturation_mean_0_255") or 85.0
    luma = color.get("avg_luma_0_255") or 115.0
    warmth = color.get("warmth_rb_ratio") or 1.0
    black_floor = color.get("black_floor_p5") or 10.0

    contrast = 1.0
    if contrast_span > 175:
        contrast = 1.08
    elif contrast_span < 125:
        contrast = 0.94

    saturation = 1.0
    if sat_mean > 105:
        saturation = 1.12
    elif sat_mean < 65:
        saturation = 0.85

    brightness = 0.0
    if luma < 85:
        brightness = -0.02
    elif luma > 155:
        brightness = 0.02

    filters.append(f"eq=contrast={contrast:.2f}:brightness={brightness:.2f}:saturation={saturation:.2f}")

    if warmth > 1.08:
        filters.append("colorbalance=rs=0.03:gs=0.01:bs=-0.03")
    elif warmth < 0.93:
        filters.append("colorbalance=rs=-0.03:bs=0.03")

    if black_floor > 22:
        filters.append("curves=all='0/0.06 0.25/0.25 1/1'")

    filters.append("unsharp=5:5:0.40:5:5:0.0")
    return ",".join(filters)


def build_style_profile(telemetry: dict[str, Any], style_slug: str) -> dict[str, Any]:
    media = telemetry.get("media", {})
    pacing = telemetry.get("pacing", {})
    audio = telemetry.get("audio", {})
    color = telemetry.get("color_and_framing", {})
    speech = telemetry.get("speech_cadence", {})

    width = media.get("width") or 1080
    height = media.get("height") or 1920
    fps = round(media.get("fps") or 30.0)
    if fps <= 0:
        fps = 30

    shot_median = pacing.get("shot_median_sec") or 2.0
    hook_cuts = pacing.get("hook_3s_cuts") or 1
    punch_cuts = color.get("same_scene_jump_or_punch_cuts_sampled") or 0

    return {
        "style_name": style_slug,
        "version": "1.0.0",
        "format": {
            "aspect_ratio": media.get("aspect_ratio") or "9:16",
            "width": width,
            "height": height,
            "fps": fps,
            "video_codec": "libx264",
            "audio_codec": "aac",
            "pixel_format": "yuv420p",
        },
        "pacing": {
            "hook_window_sec": 3.0,
            "hook_target_cuts": hook_cuts,
            "first_cut_sec": pacing.get("first_cut_sec"),
            "cuts_per_minute": pacing.get("cuts_per_minute") or 20.0,
            "target_shot_min_sec": pacing.get("shot_min_sec") or 0.6,
            "target_shot_p25_sec": pacing.get("shot_p25_sec") or 1.2,
            "target_shot_median_sec": shot_median,
            "target_shot_p75_sec": pacing.get("shot_p75_sec") or 2.8,
            "opening_third_avg_shot_sec": pacing.get("opening_third_avg_shot_sec") or shot_median,
            "middle_third_avg_shot_sec": pacing.get("middle_third_avg_shot_sec") or shot_median,
            "closing_third_avg_shot_sec": pacing.get("closing_third_avg_shot_sec") or shot_median,
            "silence_trim_threshold_sec": 0.25 if (pacing.get("cuts_per_minute") or 0) >= 18 else 0.4,
            "silence_noise_db": -35,
            "punch_in_scale": 1.14 if punch_cuts >= 2 else 1.08,
            "punch_in_alternation": "every_1_to_2_sentences" if punch_cuts >= 2 else "emphasis_only",
        },
        "framing": {
            "layout_mode": color.get("layout_hint") or "full_bleed",
            "face_center_y_ratio": color.get("face_center_y_ratio") or 0.38,
            "face_height_ratio": color.get("face_height_ratio"),
            "safe_margin_top_pct": 12 if height > width else 8,
            "safe_margin_bottom_pct": 22 if height > width else 12,
            "safe_margin_sides_pct": 6,
        },
        "color_grade": {
            "avg_luma_0_255": color.get("avg_luma_0_255"),
            "contrast_p95_p5": color.get("contrast_p95_p5"),
            "black_floor_p5": color.get("black_floor_p5"),
            "highlight_p95": color.get("highlight_p95"),
            "saturation_mean_0_255": color.get("saturation_mean_0_255"),
            "warmth_rb_ratio": color.get("warmth_rb_ratio"),
            "palette_hex": color.get("dominant_palette_hex") or ["#111111", "#FFFFFF"],
            "ffmpeg_vf_recipe": derive_ffmpeg_grade(color),
            "visual_grade_notes": "VISUAL_INSPECTION_REQUIRED: Describe mood, vignette, grain, or glow seen in frames.",
        },
        "captions": {
            "enabled": True,
            "font_family": "VISUAL_INSPECTION_REQUIRED (e.g., Montserrat, Inter, Arial Black, sans-serif)",
            "font_weight": 800,
            "casing": "VISUAL_INSPECTION_REQUIRED (uppercase | title_case | sentence_case)",
            "max_words_per_chunk": 3 if (pacing.get("cuts_per_minute") or 0) >= 20 else 5,
            "max_lines": 2,
            "y_position_pct": 68 if height > width else 82,
            "font_size_px": round(height * 0.034),
            "text_color": "#FFFFFF",
            "highlight_color": "VISUAL_INSPECTION_REQUIRED (e.g., #FFD400)",
            "stroke_px": 4,
            "stroke_color": "#000000",
            "shadow_css": "0 4px 14px rgba(0,0,0,0.8)",
            "pill_background": "VISUAL_INSPECTION_REQUIRED (none | rgba(...))",
            "animation_style": "VISUAL_INSPECTION_REQUIRED (scale_pop_karaoke | slide_up | clean_fade)",
        },
        "transitions": {
            "primary_cut": "hard_jump_cut",
            "secondary_cut": "punch_in_zoom" if punch_cuts >= 2 else "subtle_reframe",
            "hook_transition": "VISUAL_INSPECTION_REQUIRED",
            "overlay_entry": "VISUAL_INSPECTION_REQUIRED",
        },
        "graphics_and_overlays": {
            "motifs": ["VISUAL_INSPECTION_REQUIRED (progress bar, b-roll cards, lower-third, emojis, etc.)"],
        },
        "audio": {
            "target_integrated_lufs": round(audio.get("integrated_lufs") or -14.0, 1),
            "target_true_peak_db": min(-1.0, round(audio.get("true_peak_db") or -1.5, 1)),
            "target_lra": min(11.0, max(4.0, round(audio.get("loudness_range_lu") or 7.0, 1))),
            "speech_wpm": speech.get("words_per_minute_active") or speech.get("words_per_minute_overall"),
            "music_duck_db": -22,
            "sfx_notes": "VISUAL_INSPECTION_REQUIRED (whooshes, pops, risers, ambient bed, or speech-only)",
        },
    }


def render_skill_md(profile: dict[str, Any]) -> str:
    slug = profile["style_name"]
    skill_name = f"{slug}-style"
    fmt = profile["format"]
    pac = profile["pacing"]
    frm = profile["framing"]
    col = profile["color_grade"]
    cap = profile["captions"]
    trn = profile["transitions"]
    gfx = profile["graphics_and_overlays"]
    aud = profile["audio"]
    palette_str = ", ".join(col["palette_hex"])

    return f"""---
name: {skill_name}
description: >-
  Edit raw video footage in the saved "{slug}" reference style ({fmt['aspect_ratio']} {fmt['width']}x{fmt['height']}
  at {fmt['fps']} fps, ~{pac['cuts_per_minute']} cuts/min, median shot {pac['target_shot_median_sec']}s)
  without needing the original reference video. Use whenever the user asks to apply the "{slug}" style to raw footage.
license: MIT
compatibility: >-
  Self-contained portable Style Template Skill for Antigravity, Codex, Claude Code, OpenCode, Hermes,
  or any Agent Skills-compatible editor. Requires FFmpeg, FFprobe, Python 3.10+, faster-whisper, Node.js 22+, and HyperFrames.
metadata:
  version: "{profile['version']}"
  category: "video-style-template"
---

# {slug.replace('-', ' ').title()} — Style Template Skill

You are an autonomous video post-production editor. Apply this **exact saved style specification** to the user's raw footage—delivering a finished MP4 without requiring the original reference video.

> **Originality & Rights Rule:** Reproduce the style grammar, pacing, color grade, caption styling, framing, and audio targets below. Never copy external watermarks, logos, or third-party footage. Only use user-provided or licensed music/B-roll.

---

## 1. Output & Technical Contract

- **Aspect Ratio & Resolution:** `{fmt['aspect_ratio']}` — `{fmt['width']}x{fmt['height']}`
- **Frame Rate:** `{fmt['fps']} fps`
- **Codecs & Format:** MP4 (`{fmt['video_codec']}`, pixel format `{fmt['pixel_format']}`, `{fmt['audio_codec']}` audio)
- **Non-destructive Project Layout:** Create `video_edit_project/` beside the raw footage with `source/`, `analysis/`, `hyperframes/`, `renders/`, and `logs/`. Never overwrite raw inputs.

---

## 2. Pacing, Hook & Cut Rules

- **Hook Window (first `{pac['hook_window_sec']}s`):** Aim for `{pac['hook_target_cuts']}` visual beat/cut(s) inside the opening 3 seconds (first cut around `{pac['first_cut_sec']}`s if supported by speech/action). Surface the strongest truthful opening line from the raw video.
- **Cut Cadence:** Target `~{pac['cuts_per_minute']} cuts/min` overall.
- **Shot Duration Targets:**
  - Range (P25–P75): `{pac['target_shot_p25_sec']}s` to `{pac['target_shot_p75_sec']}s` (median `{pac['target_shot_median_sec']}s`, min `{pac['target_shot_min_sec']}s`)
  - Opening third average: `{pac['opening_third_avg_shot_sec']}s`
  - Middle third average: `{pac['middle_third_avg_shot_sec']}s`
  - Closing third average: `{pac['closing_third_avg_shot_sec']}s`
- **Pause & Mistake Removal:** Trim dead air longer than `{pac['silence_trim_threshold_sec']}s` (detected around `{pac['silence_noise_db']} dB`), repeated false starts, and filler gaps—while preserving complete sentences, natural emphasis pauses, and original meaning.
- **Punch-In Zooms:** Apply `{pac['punch_in_scale']}x` center/face-centered crop alternation (`{pac['punch_in_alternation']}`) to maintain visual rhythm without jarring jump cuts.

---

## 3. Framing & Composition

- **Canvas Layout Mode:** `{frm['layout_mode']}`
- **Subject / Face Vertical Anchor:** Center speaker eyes/head around `{frm['face_center_y_ratio']}` of frame height (approx `{round(float(frm['face_center_y_ratio']) * 100)}%` from top). Never stretch video. If horizontal footage must fit vertical `9:16` without losing wide action, use blurred background fill matching this layout.
- **Safe Margins:** Keep subjects and graphics inside `{frm['safe_margin_top_pct']}%` top, `{frm['safe_margin_bottom_pct']}%` bottom, `{frm['safe_margin_sides_pct']}%` left/right.

---

## 4. Color Look & Surface Treatment

- **Measured Reference Palette:** `{palette_str}`
- **Baseline FFmpeg Filtergraph:**
  ```text
  {col['ffmpeg_vf_recipe']}
  ```
- **Visual Grade Notes:** {col['visual_grade_notes']}
- *Calibration rule:* Inspect a sampled frame of the raw footage first; if the raw footage is already high-contrast or warm, scale `eq` contrast/saturation deltas by ~50% to avoid clipping skin tones.

---

## 5. Captions, Typography & Motion Graphics (HyperFrames)

Build a real **HyperFrames** composition (`index.html` + timed `.clip` layers + GSAP timeline on `window.__timelines`) for captions and graphic overlays; run `npx hyperframes check --json` before rendering.

- **Font Stack:** `{cap['font_family']}` (weight `{cap['font_weight']}`)
- **Font Size:** `{cap['font_size_px']}px` at `{fmt['width']}x{fmt['height']}`
- **Casing:** `{cap['casing']}`
- **Chunking:** Maximum `{cap['max_words_per_chunk']}` words per chunk, `{cap['max_lines']}` line(s) max
- **Placement:** Centered horizontally at `{cap['y_position_pct']}%` from top (verify face-safe non-overlap!)
- **Colors & Container:**
  - Base text: `{cap['text_color']}`
  - Highlight/active accent: `{cap['highlight_color']}`
  - Stroke: `{cap['stroke_px']}px {cap['stroke_color']}`
  - Drop shadow: `{cap['shadow_css']}`
  - Background pill: `{cap['pill_background']}`
- **Caption Motion:** `{cap['animation_style']}`
- **Transitions:** Primary `{trn['primary_cut']}` | Secondary `{trn['secondary_cut']}` | Hook `{trn['hook_transition']}` | Overlay entry `{trn['overlay_entry']}`
- **Graphic Motifs:** {', '.join(gfx['motifs'])}

---

## 6. Audio Mix & Sound Design

- **Loudness Target:** Integrated `{aud['target_integrated_lufs']} LUFS`, True Peak `<= {aud['target_true_peak_db']} dBTP`, LRA `~{aud['target_lra']} LU` via FFmpeg `loudnorm`.
- **Target Speech Cadence:** `{aud['speech_wpm']} WPM` (achievable by trimming dead air, not unnatural chipmunk speedups).
- **Music & SFX:** Keep any user-provided/licensed background music ducked `{aud['music_duck_db']} dB` under speech. {aud['sfx_notes']}

---

## 7. End-to-End Execution Steps on Raw Video

1. **Inspect & Transcribe Raw Video:** Probe raw video with `ffprobe`, detect silences with `ffmpeg -af silencedetect=noise={pac['silence_noise_db']}dB:d={pac['silence_trim_threshold_sec']}`, and transcribe locally with `faster-whisper` (`compute_type="int8"`, `word_timestamps=True`, auto language detection).
2. **Generate `analysis/edit_decision_list.json`:** Plan cuts that remove dead air/mistakes and align shot durations + `{pac['punch_in_scale']}x` punch-ins to Section 2 targets without mid-word clipping.
3. **Render Base Cut & Graded Video (`ffmpeg`):** Cut, concatenate, smart-crop (`{fmt['width']}x{fmt['height']}`), apply the Section 4 grade, and loudness-normalize audio (`{aud['target_integrated_lufs']} LUFS`).
4. **Render HyperFrames Captions & Overlays:** Generate timed `.clip` captions matching Section 5 CSS/GSAP rules from exact Whisper word timestamps, run `npx hyperframes check --json`, snapshot key timestamps to confirm face-safe placement, render overlay, and composite onto the graded base MP4.
5. **Mandatory QC & Delivery:**
   - Visually inspect opening, hook cut, 3+ cut boundaries, caption-heavy sections, middle, and ending frames.
   - Verify final MP4 with `ffprobe` (`{fmt['width']}x{fmt['height']}`, `{fmt['fps']} fps`, non-zero size, audio + video streams intact).
   - Deliver the final `.mp4`, `.srt` subtitles, editable HyperFrames project, and honest notes (including any font substitution).
"""


def render_reference_md(telemetry: dict[str, Any], profile: dict[str, Any]) -> str:
    fmt = profile["format"]
    pac = profile["pacing"]
    col = profile["color_grade"]
    aud = profile["audio"]
    src = telemetry.get("media", {}).get("filename", "reference_video")
    return f"""# Reference Style Breakdown: `{profile['style_name']}`

Derived from: `{src}`

## Technical & Pacing Summary
- **Format:** {fmt['aspect_ratio']} ({fmt['width']}x{fmt['height']}) @ {fmt['fps']} fps
- **Cut Density:** {pac['cuts_per_minute']} cuts/min | **Hook (first 3s):** {pac['hook_target_cuts']} cut(s) (first cut at {pac['first_cut_sec']}s)
- **Shot Length Distribution:** min `{pac['target_shot_min_sec']}s`, P25 `{pac['target_shot_p25_sec']}s`, median `{pac['target_shot_median_sec']}s`, P75 `{pac['target_shot_p75_sec']}s`
- **Pacing Curve (Opening / Mid / Closing avg):** `{pac['opening_third_avg_shot_sec']}s` / `{pac['middle_third_avg_shot_sec']}s` / `{pac['closing_third_avg_shot_sec']}s`

## Color, Framing & Audio
- **Layout Hint:** `{profile['framing']['layout_mode']}` | **Face Y Ratio:** `{profile['framing']['face_center_y_ratio']}`
- **Luminance / Contrast / Saturation:** Luma `{col['avg_luma_0_255']}`, Contrast spread `{col['contrast_p95_p5']}`, Saturation `{col['saturation_mean_0_255']}`, R/B Warmth `{col['warmth_rb_ratio']}`
- **Dominant Palette:** {', '.join(col['palette_hex'])}
- **FFmpeg Filter Baseline:** `{col['ffmpeg_vf_recipe']}`
- **Audio Target:** `{aud['target_integrated_lufs']} LUFS`, True Peak `{aud['target_true_peak_db']} dBTP`, Speech WPM `{aud['speech_wpm']}`
"""


def render_readme(style_slug: str) -> str:
    skill_name = f"{style_slug}-style"
    return f"""# {skill_name} (Portable Video Style Template Skill)

Generated by `reference-style-matcher`. This folder is a **self-contained Agent Skill** that lets any AI coding/video agent edit raw videos in the `{style_slug}` reference style **without needing the original reference video**.

## Files
- `SKILL.md` — Complete editing instructions, format contract, pacing targets, color recipe, caption/motion specs, and QC workflow.
- `style_profile.json` — Machine-readable style parameters.
- `reference_style.md` — Human-readable summary of measured style metrics.

## Use in Any AI Tool
Copy this entire folder into the target agent's skills directory (named `{skill_name}/`):
- **Antigravity:** `~/.gemini/config/skills/{skill_name}/` (or project `.agents/skills/{skill_name}/`)
- **Codex:** `~/.agents/skills/{skill_name}/` or `~/.codex/skills/{skill_name}/`
- **Claude Code:** `~/.claude/skills/{skill_name}/` or `.claude/skills/{skill_name}/`
- **OpenCode:** `~/.config/opencode/skills/{skill_name}/`
- **Hermes:** `~/.hermes/skills/{skill_name}/`

Then give the agent your raw video and say: *"Edit this video using the {skill_name} skill."*
"""


def main() -> int:
    parser = argparse.ArgumentParser(description="Build a portable Style Template Skill from telemetry JSON.")
    parser.add_argument("--telemetry", type=Path, required=True, help="Path to style_telemetry.json")
    parser.add_argument("--name", required=True, help="Descriptive style name or slug (e.g. dark-kinetic-reel)")
    parser.add_argument("--out", type=Path, required=True, help="Parent directory where <slug>-style/ will be created")
    parser.add_argument("--install-global", action="store_true", help="Also copy to ~/.gemini/config/skills/<slug>-style/")
    args = parser.parse_args()

    telemetry_path = args.telemetry.expanduser().resolve()
    if not telemetry_path.exists():
        print(f"Telemetry JSON not found: {telemetry_path}", file=sys.stderr)
        return 1

    telemetry = json.loads(telemetry_path.read_text(encoding="utf-8"))
    slug = slugify(args.name)
    profile = build_style_profile(telemetry, slug)

    bundle_dir = args.out.expanduser().resolve() / f"{slug}-style"
    bundle_dir.mkdir(parents=True, exist_ok=True)

    (bundle_dir / "style_profile.json").write_text(json.dumps(profile, indent=2), encoding="utf-8")
    (bundle_dir / "SKILL.md").write_text(render_skill_md(profile), encoding="utf-8")
    (bundle_dir / "reference_style.md").write_text(render_reference_md(telemetry, profile), encoding="utf-8")
    (bundle_dir / "README.md").write_text(render_readme(slug), encoding="utf-8")

    print(f"Created portable Style Template Skill at: {bundle_dir}")

    if args.install_global:
        global_dir = Path.home() / ".gemini" / "config" / "skills" / f"{slug}-style"
        global_dir.mkdir(parents=True, exist_ok=True)
        for fname in ("style_profile.json", "SKILL.md", "reference_style.md", "README.md"):
            (global_dir / fname).write_text((bundle_dir / fname).read_text(encoding="utf-8"), encoding="utf-8")
        print(f"Also installed globally at: {global_dir}")

    return 0


if __name__ == "__main__":
    raise SystemExit(main())
