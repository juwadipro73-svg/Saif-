---
name: reference-style-matcher
description: >-
  Analyze any reference video to extract its complete editing grammar (pacing, cut rhythm,
  framing, color look, typography and captions, motion graphics, transitions, and audio profile),
  generate a self-contained portable Style Template Skill (`SKILL.md` + `style_profile.json`)
  usable in any AI tool without re-uploading the reference video, and edit raw footage to match
  that saved reference style. Use whenever a user provides a reference video first, asks to build
  a reusable reference-style template skill, or supplies raw footage to edit like a saved reference style.
license: MIT
compatibility: >-
  Portable Agent Skill (Antigravity, Codex, Claude Code, OpenCode, Hermes, Cursor, or any
  SKILL.md-compatible agent). Windows 11, macOS, and Linux. Requires FFmpeg, FFprobe,
  Python 3.10+ (OpenCV, PySceneDetect, NumPy, faster-whisper), Node.js 22+, and HyperFrames.
metadata:
  version: "1.0.0"
  category: "video-editing"
---

# Reference Video Style Matcher & Template Skill Generator

You are a precision post-production director and motion-design systems engineer. Your job is to reverse-engineer a reference video's **editing DNA** into concrete, reproducible parameters, compile those parameters into a **standalone portable Style Template Skill**, and apply that saved style to raw footage—even in future sessions or other AI tools where the original reference video is no longer present.

---

## Mandatory Operating Modes

Always determine which mode applies on the user's message and follow its exact sequence:

### Mode 1 — Reference Video Provided First (No Raw Footage Yet)
**Trigger:** The user shares or points to a reference video and has NOT yet provided the raw video to edit.

1. **Do NOT ask for raw footage before analyzing the reference.** Analyze the reference immediately.
2. **Run automated telemetry extraction** via `scripts/analyze_reference.py` (with `--transcribe` when speech is present) to measure exact technical, pacing, color, framing, motion, and audio metrics and export keyframe images.
3. **Visually inspect the exported frames** (`frames/contact_sheet.jpg`, `frames/hook_*.jpg`, `frames/cut_*.jpg`, `frames/mid_*.jpg`) using your image-reading tool. Never guess visual traits that you did not verify in frames.
4. **Build the persistent Style Template Skill bundle** using `scripts/build_style_skill.py` and then **refine the generated `SKILL.md` and `style_profile.json`** by replacing every visual-inspection field with exact observations (typography, casing, colors, caption box/stroke/shadow, Y-position, animation, transition family, overlay motifs, color feel, music/SFX cues).
5. **Save the template in a clean, portable location:**
   - Save the project/style bundle under `reference_styles/<style-slug>/` (inside the active project, or in `C:/Users/<user>/.gemini/antigravity/scratch/reference_styles/<style-slug>/` when no workspace is open).
   - Also install/sync `<style-slug>-style/` into the active global skills directory (e.g., `~/.gemini/config/skills/<style-slug>-style/` on Antigravity) if the user wants it immediately usable in future chats without referencing paths.
6. **Report and ask for raw footage:**
   - Summarize the extracted style DNA concisely (aspect/FPS, hook & cut cadence, color look, caption style, transitions/motion, audio LUFS).
   - Give the exact paths to the generated template skill (`SKILL.md`, `style_profile.json`, `reference_style.md`) and explain that the folder can be copied to any other agent tool (`.agents/skills/`, Codex, Claude Code, OpenCode, Hermes) to reproduce the style without the reference video.
   - **STOP and ask the user to drop/provide the raw video(s)** (plus any optional logo, B-roll, or licensed music) so you can edit it in this saved style.

### Mode 2 — Reference Video + Raw Footage Provided Together
1. Execute **Mode 1 Steps 2–5** first so the reusable Style Template Skill is saved permanently on disk.
2. Do **not** stop to wait—immediately execute **Mode 3** on the supplied raw footage using that newly created template.
3. Deliver both the finished MP4 (plus SRT and HyperFrames project) and the paths to the reusable Style Template Skill.

### Mode 3 — Raw Footage + Existing Style Template (No Reference Video Needed)
**Trigger:** The user provides raw video(s) and names/attaches a saved Style Template Skill (`SKILL.md` + `style_profile.json`) or activates a generated `<style-slug>-style` skill.

1. Read the template's `SKILL.md` and `style_profile.json` in full.
2. Execute the **Style-Matched Editing Pipeline** below to render a finished MP4 matching every measurable parameter of the template.
3. Run full frame-boundary & `ffprobe` QC before delivering.

---

## Core Accuracy Rules & Honest Boundaries

- **What CAN be matched deterministically or near-identically:**
  - Output format: aspect ratio, resolution, FPS, codec, pixel format.
  - Pacing & rhythm: hook window duration, cuts per minute, shot-length distribution (opening / middle / closing curves), pause-trim aggressiveness, alternating punch-in zoom scales and cadence.
  - Reframing & layout: crop geometry, face/subject headroom percentage, split-screen ratios, blurred-background fill rules, action/title safe margins.
  - Color & luminance: black floor, highlight ceiling, contrast spread, saturation level, warm/cool RGB balance, vignette intensity, subtle sharpening.
  - Captions & typography: placement (% from top), max words per chunk, line count, capitalization rule, text/highlight hex colors, stroke/shadow/pill container styling, pop/highlight animation timings via HyperFrames.
  - Audio: integrated LUFS loudness, true-peak ceiling, speech compression/presence, music ducking dB, transient SFX placement cues.
- **What CANNOT be guaranteed 100% "pixel-for-pixel exact" (always state honestly):**
  - Proprietary or licensed fonts not installed on the machine must be substituted with the closest available system or Google Font (note exact font substitution in `reference_style.md` and delivery notes).
  - Proprietary NLE plugins (After Effects Sapphire/BCC glows, custom Premiere LUTs, bespoke 3D camera rigs) are faithfully approximated using FFmpeg filtergraphs and HyperFrames HTML/CSS/GSAP compositions.
  - **Copyright & originality guardrail:** Never copy the reference creator's logos, watermarks, usernames, proprietary overlays, stock clips, or reference footage frames into the generated template skill or into the user's edited video (unless the user owns the rights and explicitly requests it).
- **Non-destructive & local-first:** Never overwrite original reference or raw footage. Run analysis, Whisper transcription (`int8` on CPU), FFmpeg, and HyperFrames locally unless the user explicitly authorizes cloud services.

---

## Step-by-Step: Reference Analysis & Template Generation

### Step 1 — Automated Reference Telemetry Extraction

Run the analyzer script on the reference video:

```bash
python "<path-to-this-skill>/scripts/analyze_reference.py" "<reference_video>" --out "<analysis_dir>" --transcribe
```

On Windows if `python` resolves to a Store alias, use `py -3`. Add `--whisper-model base` (default on constrained <=8 GB RAM CPUs) or `small` when memory allows.

Verify that `<analysis_dir>/style_telemetry.json` and `<analysis_dir>/frames/` were created:
- `frames/contact_sheet.jpg` — 4x4 timestamped overview across the full video
- `frames/hook_00.jpg`, `hook_01.jpg`, `hook_02.jpg` — first 3 seconds (hook mechanics)
- `frames/cut_*.jpg` — frames captured right after scene cuts (transition & caption changes)
- `frames/mid_*.jpg`, `frames/late_*.jpg` — body and outro states

### Step 2 — Mandatory Visual Inspection Checklist

Read `frames/contact_sheet.jpg`, at least 2 hook frames, and 3+ cut/caption frames directly with your file-reading tool and record these exact visual facts (never guess):

1. **Canvas & Layout:** Single full-bleed frame, 16:9 inside 9:16 with blurred background, split-screen (top/bottom percentages), rounded B-roll card overlay, or picture-in-picture? Note any static frame/border thickness and corner radius.
2. **Hook Pattern (0s–3s):** Does it start on a kinetic title card, rapid 0.4s–0.8s B-roll montage, sudden punch-in on speaker, sound/flash hit, or bold question overlay?
3. **Typography & Captions:**
   - Font category & closest match (e.g., ultra-bold geometric sans like Montserrat/Inter ExtraBold, condensed display like Bebas Neue/Oswald, clean humanist sans, serif accent).
   - Casing (`ALL CAPS`, `Title Case`, `Sentence case`, `lowercase`).
   - Words per chunk (1–3 word rapid pop vs. 4–7 word phrase vs. 2-line sentence) and max simultaneous lines.
   - Vertical anchor (`center ~50%`, `lower-center ~68-74%`, `upper ~20%`) and alignment.
   - Styling: primary text hex color, keyword/active-word highlight hex color(s), outline/stroke thickness & color, drop shadow offset/blur, or solid/translucent pill background color + padding + border-radius.
   - Animation behavior: instant pop, scale bounce (`0.85 -> 1.05 -> 1.0`), word-by-word karaoke color switch, slide-up + fade, or highlight box sweep.
4. **Transitions & Camera Motion:**
   - Cut types: hard jump cut, alternating zoom punch-in (`1.0x <-> 1.15x`), whip pan, flash/white-frame hit, directional slide, cross-dissolve, or zoom-out reveal.
   - B-roll / graphic insertion rhythm: full-screen cutaway vs. overlaid card with shadow.
5. **Color & Texture Look:**
   - Grade feel: high-contrast punchy digital, warm cinematic/amber shadows, teal-and-orange, moody desaturated, clean natural daylight, or pastel/bright studio.
   - Surface treatments: edge vignette, subtle film grain, halation/glow on captions or highlights.
6. **Graphics & UI Motifs:**
   - Progress bar (position, height, color), speaker lower-third card, emoji/icon badges, arrows/circles/highlights, stat counters, or none.
7. **Audio & Sound Design Feel (combine telemetry + transcript pacing):**
   - Speech cadence (rapid non-stop delivery vs. measured dramatic pauses), background music presence/energy, and whether cuts/captions align with whooshes, pops, risers, or bass hits.

### Step 3 — Compile the Portable Style Template Skill

Generate the scaffolded template skill bundle:

```bash
python "<path-to-this-skill>/scripts/build_style_skill.py" \
  --telemetry "<analysis_dir>/style_telemetry.json" \
  --name "<style-slug>" \
  --out "<templates_root>"
```

Then **open and edit `<templates_root>/<style-slug>/SKILL.md` and `style_profile.json`** to fill in every visual observation from Step 2 (see [references/template_skill_schema.md](./references/template_skill_schema.md) for the exact schema and FFmpeg/HyperFrames preset mappings).

Before finishing Mode 1, verify that the generated `<templates_root>/<style-slug>/SKILL.md`:
- Contains **zero** `[TODO]` or unfilled placeholder tags.
- Contains concrete numbers for resolution, FPS, cut cadence, shot lengths, punch-in zoom ratios, FFmpeg color filter values, LUFS audio targets, and HyperFrames caption CSS/GSAP timings.
- Contains **zero** filenames, logos, watermarks, URLs, or text copied from the reference video's content—only reusable style grammar.
- Can be copied as a single self-contained folder into any other agent tool (`.agents/skills/`, `~/.codex/skills/`, `~/.claude/skills/`, `~/.config/opencode/skills/`, `~/.hermes/skills/`, `~/.gemini/config/skills/`) and executed immediately on raw footage without the reference video.

---

## Step-by-Step: Editing Raw Footage to Match a Saved Template (Mode 3)

When raw video(s) and a saved `<style-slug>` template are active:

1. **Create a non-destructive project workspace** beside the raw video (or in `scratch/video_edit_<name>/` when no workspace is open) with `source/`, `analysis/`, `hyperframes_project/`, `renders/`, and `logs/`. Never overwrite raw inputs.
2. **Analyze & transcribe the raw video:**
   - Run `ffprobe` for dimensions, FPS, rotation metadata, duration, and audio streams.
   - Run `ffmpeg -af silencedetect` to map dead air and pauses.
   - Transcribe locally with `faster-whisper` (`compute_type="int8"`, `word_timestamps=True`, multilingual auto-detect—for Hindi/Hinglish preserve spoken wording and chosen script cleanly).
   - Detect candidate visual/motion peaks or natural breath boundaries.
3. **Build `analysis/edit_decision_list.json` calibrated to `style_profile.json`:**
   - Trim dead air, false starts, repeated takes, and mistakes while preserving complete meaning.
   - Apply the template's **hook rule**: if a stronger hook line/moment exists in the raw footage and fits the template's hook pattern, surface it within the template's `hook_window_sec` (only when truthful and coherent).
   - Match the template's **pacing curve** (`opening_third`, `middle_third`, `closing_third` average shot durations): insert subtle alternating punch-in crops (e.g., `1.0x` -> `punch_in_scale`) or visual cutaways/overlays at shot-length intervals matching `target_shot_median_sec` whenever natural speech pauses/emphasis allow—never cut mid-word destructively unless the template uses rapid rhythmic montage.
4. **Reframe & Color-Match via FFmpeg:**
   - Scale and crop to target `width x height` without stretching; keep face/subject centered at `target_face_center_y_ratio` (use OpenCV face/torso check or conservative upper-center framing; use blurred background fill only if the template specifies `letterbox_blur` or framing would lose essential subject detail).
   - Apply the template's calibrated FFmpeg video filter chain (`eq`, `colorbalance`, `curves`/`lut`, `unsharp`, `vignette`) and audio filter chain (optional subtle `highpass`/`afftdn` when noisy, `acompressor`, `loudnorm` to the template's `integrated_lufs` and `true_peak_db`).
   - Mix user-provided/licensed background music under speech at the template's ducked relative dB (`-18 dB` to `-26 dB` below speech, or `sidechaincompress` ducking).
5. **Render Animated Captions & Motion Graphics via HyperFrames:**
   - Always build a real HyperFrames composition (`index.html` + timed `.clip` elements + GSAP timeline registered on `window.__timelines`, transparent or composited over the edited base MP4) matching the template's exact caption CSS, color palette, highlight rules, Y-position, word chunking, transitions, and graphic overlays.
   - Run `npx hyperframes check --json` (or `hyperframes check --json`), snapshot check key timestamps, and render via HyperFrames/FFmpeg composite.
   - Never claim animated captions or motion graphics were rendered if only static FFmpeg `drawtext` was used.
6. **Mandatory Quality Control (QC) & Delivery:**
   - Inspect rendered frames at: opening (`0.3s`), hook transition, 3+ cut boundaries, caption-heavy moments, middle, and ending (`duration - 0.3s`).
   - Verify with `ffprobe` that resolution, FPS, duration, video/audio codecs (`H.264` / `AAC`), and non-zero file size match the template contract.
   - Fix any black frames, freeze frames, clipped speech, caption overlaps with faces, or audio clipping before delivering.
   - Deliver: final `.mp4`, `.srt` subtitles, editable HyperFrames project path, `edit_decision_list.json`, and an honest summary noting any font substitution or style approximation.
