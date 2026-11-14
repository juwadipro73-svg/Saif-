# Style Template Skill Schema & Preset Reference

This reference explains how measured values in `style_telemetry.json` map into `style_profile.json`, FFmpeg filtergraphs, and HyperFrames caption compositions inside generated Style Template Skills.

---

## 1. `style_profile.json` Structure

```json
{
  "style_name": "kinetic-founder-reel",
  "version": "1.0.0",
  "format": {
    "aspect_ratio": "9:16",
    "width": 1080,
    "height": 1920,
    "fps": 30,
    "video_codec": "libx264",
    "audio_codec": "aac",
    "pixel_format": "yuv420p"
  },
  "pacing": {
    "hook_window_sec": 3.0,
    "hook_target_cuts": 2,
    "cuts_per_minute": 28.5,
    "target_shot_median_sec": 1.8,
    "target_shot_p25_sec": 1.1,
    "target_shot_p75_sec": 2.7,
    "opening_third_avg_shot_sec": 1.3,
    "middle_third_avg_shot_sec": 2.1,
    "closing_third_avg_shot_sec": 1.9,
    "silence_trim_threshold_sec": 0.25,
    "silence_noise_db": -35,
    "punch_in_scale": 1.14,
    "punch_in_alternation": "every_1_to_2_sentences"
  },
  "framing": {
    "layout_mode": "full_bleed_vertical",
    "face_center_y_ratio": 0.36,
    "safe_margin_top_pct": 12,
    "safe_margin_bottom_pct": 22,
    "safe_margin_sides_pct": 6
  },
  "color_grade": {
    "avg_luma_0_255": 118.4,
    "contrast_p95_p5": 176.0,
    "black_floor_p5": 14.0,
    "highlight_p95": 232.0,
    "saturation_mean_0_255": 98.2,
    "warmth_rb_ratio": 1.07,
    "palette_hex": ["#121417", "#F4EFEA", "#FFB703", "#2A324B", "#D90429"],
    "ffmpeg_vf_recipe": "eq=contrast=1.08:brightness=0.01:saturation=1.12,colorbalance=rs=0.03:bs=-0.03,unsharp=5:5:0.45:5:5:0.0"
  },
  "captions": {
    "enabled": true,
    "font_family": "Montserrat, Inter, Arial Black, sans-serif",
    "font_weight": 800,
    "casing": "uppercase",
    "max_words_per_chunk": 3,
    "max_lines": 2,
    "y_position_pct": 68,
    "font_size_px_at_1080p": 64,
    "text_color": "#FFFFFF",
    "highlight_color": "#FFD400",
    "stroke_px": 5,
    "stroke_color": "#000000",
    "shadow_css": "0 6px 18px rgba(0,0,0,0.85)",
    "pill_background": "none",
    "animation_style": "scale_pop_karaoke"
  },
  "transitions": {
    "primary_cut": "hard_jump_cut",
    "secondary_cut": "punch_in_zoom",
    "hook_transition": "fast_zoom_pop",
    "overlay_entry": "scale_up_120ms_back_out"
  },
  "audio": {
    "target_integrated_lufs": -14.0,
    "target_true_peak_db": -1.5,
    "target_lra": 7.0,
    "speech_wpm": 165.0,
    "music_duck_db": -22,
    "sfx_cues": ["subtle_pop_on_keyword", "soft_whoosh_on_broll_or_section"]
  }
}
```

---

## 2. Telemetry-to-FFmpeg Color Calibration Guide

Use measured `color_and_framing` stats from `style_telemetry.json` to derive a baseline FFmpeg filter chain, then visually verify against sampled frames of the edited output:

| Measured Metric | Reference Range | Baseline FFmpeg Adjustment |
|---|---|---|
| `contrast_p95_p5` | `< 130` (flat/soft) | `eq=contrast=0.92` |
| `contrast_p95_p5` | `130–175` (natural) | `eq=contrast=1.02` |
| `contrast_p95_p5` | `> 175` (punchy/high contrast) | `eq=contrast=1.08–1.14` |
| `saturation_mean_0_255` | `< 65` (moody/desaturated) | `eq=saturation=0.78–0.90` |
| `saturation_mean_0_255` | `65–105` (balanced) | `eq=saturation=1.02–1.08` |
| `saturation_mean_0_255` | `> 105` (vibrant/pop) | `eq=saturation=1.14–1.25` |
| `warmth_rb_ratio` | `> 1.08` (warm/amber) | `colorbalance=rs=0.04:gs=0.01:bs=-0.04` |
| `warmth_rb_ratio` | `< 0.94` (cool/crisp) | `colorbalance=rs=-0.04:bs=0.04` |
| `black_floor_p5` | `> 22` (lifted/faded blacks) | `curves=all='0/0.07 0.25/0.25 1/1'` |
| `avg_luma_0_255` | `< 95` (dark/moody) | `eq=brightness=-0.03:gamma=0.95` |

Always inspect the raw footage's own histogram before applying heavy `eq` values—if the raw footage is already high-contrast or warm, scale the adjustment back by ~50% to avoid clipping highlights or oversaturating skin tones.

---

## 3. HyperFrames Caption Archetypes (Reproducing Common Reference Styles)

### Archetype A — Bold Short-Form Pop / Hormozi-Style
- **Typography:** ExtraBold condensed/geometric sans, `uppercase`, `60–72px` at `1080x1920`, `line-height: 1.08`, 1–3 words per chunk.
- **Styling:** `#FFFFFF` base, `#FFD400` or `#39FF14` active keyword, `-webkit-text-stroke` or layered `text-shadow` outline (`4–6px` `#000000`) + deep drop shadow.
- **GSAP Motion:** Scale `0.84 -> 1.04 -> 1.0` over `0.12s` (`ease: "back.out(2)"`) at chunk start; active word switches color + scales `1.08x` on exact Whisper word timestamp.

### Archetype B — Clean Pill / Creator Box Captions
- **Typography:** SemiBold/Bold sans (`Inter`, `Plus Jakarta Sans`), `Sentence case` or `Title Case`, `44–54px` at `1080x1920`, 3–6 words per chunk, 1–2 lines.
- **Styling:** Dark translucent or solid brand pill (`background: rgba(15, 17, 21, 0.85)`, `border-radius: 14px`, `padding: 10px 22px`), optional accent word highlight pill.
- **GSAP Motion:** `y: 12 -> 0`, `opacity: 0 -> 1` over `0.14s` (`ease: "power2.out"`).

### Archetype C — Editorial / Documentary Minimal Subtitles
- **Typography:** Medium sans or serif accent, `Sentence case`, `38–46px` at `1080x1920` (or `34–42px` at `1920x1080`), lower safe zone (`y: 78–84%`).
- **Styling:** Crisp `#F8F9FA`, subtle `0 2px 10px rgba(0,0,0,0.75)` shadow, zero heavy stroke or bounce.
- **GSAP Motion:** Clean `0.08s` opacity fade or hard cut synced to speech phrase.
