---
name: saif-cinematic-motion-engine
description: Creates research-backed, high-end motion-graphics videos with Remotion and React for SAIF AI. Use when the user asks to make, animate, edit, storyboard, or render a video in any category, including explainers, documentaries, product promos, gaming videos, social shorts, educational videos, data stories, and cinematic sequences. Uses Antigravity's available research, image-generation, and sound-generation capabilities when available.
---

# SAIF AI — Cinematic Motion Engine

## OVERHAUL v3 — NARRATION-SYNCED MOTION GRAPHICS + STORY FRAMING (supersedes older pacing rules)

GLOBAL RULES (both modes): no slideshow; no single image stretched under long narration; no tiny
main subject; no overlay hiding the hero image; no black opening/ending frames unless designed;
no abrupt jumps or frozen animation; no movement just for movement; no repeated backgrounds when
the script demands different visuals. The result must feel like a professionally edited YouTube
video, not a pile of AI images.

### NORMAL MODE — narration-driven visual timeline (the core fix)
- Use the kit's `BeatSeq` + `beatplan.ts`: EVERY narration sentence/phrase gets its OWN visual
  beat (generated image + camera move + caption + transition). The screen keeps evolving while
  the narrator speaks — narration continuing over an unchanged screen is a CRITICAL failure.
- Durations come from narration timing (`beatDuration(text)` ≈ words/2.6s clamped): quick beat
  1–2s, standard 2–4s, detailed 4–6s, cinematic moment 5–8s only when genuinely necessary.
  2-minute educational video → ~25–40 beats when the topic supports it. Never pad with
  meaningless cuts.
- Composition discipline: main generated image stays VISIBLE — no huge opaque panels; overlays
  are compact, semi-transparent, purposeful; captions sit on a thin bottom scrim; never cover
  faces/subjects. Hierarchy: 1 subject, 2 message, 3 support, 4 decoration.
- Motion set (pick per topic/mood, not everything everywhere): zoom/pan/parallax, kinetic type,
  animated counters, self-drawing graphs, glows, light sweeps, particles, 2.5D depth, mask
  reveals, focus transitions, subtle impact shake.
- Hook: first 3s = surprising visual + strong animated line + fast smooth camera + impact SFX
  (`HookOpen`). No long black screen, no static logo intro.
- Sound: whoosh on movement, impact on reveals, clicks on UI, risers before big moments, ambience
  per scene, subtle music ducked under a clear dominant voice; silence can be dramatic.

### STORY MODE — character is the SUBJECT (fixes tiny-CHARACTER renders)
- Framing system (`StoryScene shot` prop): wide (environment) · medium (interaction — character
  fills ~55% frame height) · closeup (emotion — head/torso dominate) · ots (reveal) · lowAngle
  (drama) · tracking (walk/run). Default to medium/closeup; wide ONLY when the environment is
  the point. A main character rendered as a speck in a big empty background is a CRITICAL failure.
- In-scene action timeline (`actions: [{at, action, expression, facing, x}]`): every scene must
  EVOLVE — e.g. walk → stop at knock (startle) → turn to door (creep toward it). Meaningful
  visual change every 2–4s: action, camera angle, new object, reaction, lighting, close-up —
  even when the background stays. No static pose held for a whole scene.
- Real animation only (procedural `Stickman` rig: walk/run/jump/sit/fall/point/wave/talk/turn/
  climb/celebrate/startle/lookUp/lookDown/knock/openDoor/pickup/creep + expressions). Placing a
  static character PNG on backgrounds is FORBIDDEN.
- Interaction logic: reach the handle before the door opens; look at the radio when it sounds;
  approach the box before examining it. No floating objects, no walking through walls, consistent
  perspective and scale across scenes (CharacterSheet + SHOT_FRAME).
- Camera supports the story: `follow` keeps the character framed while traveling; push-ins land
  on the character or the important object, never on empty background.
- Preserve established character identity exactly (e.g. SHADOW: black stickman, white circular
  head, expressive eyes, red scarf) via characters.json sheets.

### SCENE PLAN + QC (before AND after render)
- Plan fields per scene: id, start/end, narration segment, visual objective, shot type, bg asset,
  characters/subject, fg objects, actions, camera, transitions, sfx, music intensity, text/graphics,
  composition notes, asset refs. A plan of "one background + one text overlay" is rejected.
- Run `scripts/qc-scene-plan.mjs scene-plan.json` BEFORE rendering — CRIT failures (too few beats,
  >6.5s holds, repeated consecutive bg, missing/unused assets, no camera/grade) must be fixed.
- After render, inspect preview frames (capture.mjs / lint-frames.mjs): pacing, subject size,
  overlays hiding art, frozen/black frames, transition cleanliness, narration sync, audio levels.
  Fix and re-render. Never claim QC passed without actually inspecting.
- Performance: preload/cache generated assets, reuse components, right-size images, efficient
  render settings, graceful failure handling, visible render progress — never buy speed by
  cutting animation quality.

## ENGINE OVERHAUL v2 — MANDATORY QUALITY SYSTEM (read first, applies to every video)

These rules fix the known quality failures (few scenes, one reused background, unused
generated images, slow pacing, text-card domination, weak hooks, poor transitions, flat
uncorrected colour). They are HARD requirements, not suggestions.

### 0. Two modes — pick one per request
- **ADVANCED MOTION GRAPHICS MODE** — informational/explainer/documentary/promo/data/educational
  videos: kinetic typography, diagrams, stats, footage, generated imagery.
- **CINEMATIC STORY MODE** — character-based narrative (stickman or illustrated characters):
  use the `cinematic-story-mode` skill and the `Stickman`/`StoryScene`/`HookOpen` kit templates.
  Trigger words: story, kahani, stickman, character, emotional/motivational/horror/comedy story.
- If ambiguous (e.g. "motivational video banao"), ask ONE short clarification: motion graphics
  ya story mode? The user can also choose manually.

### 1. Intelligent scene planner (before any rendering)
- Split the script into **visual beats of ~2–5 seconds** each; new composition whenever the
  narrative changes. 60 s video → ~15–25 beats; 2 min → ~25–45 beats (when the script supports it).
- Never pad with duplicate/meaningless shots; never hold one static layout >6 s without a
  strong reason (deliberate slow-cinematic moment).
- Write the beat sheet FIRST (scene id, duration, visual type, shot size, camera move,
  transition in/out, audio) as `scene-plan.md` + `scene-manifest.json` in the project.

### 2. Mandatory image-asset utilization
- Before rendering, produce an **asset-generation plan**: for EVERY scene decide if it needs a
  background / foreground object / character / product / location / illustration / infographic /
  texture. Generate ORIGINAL images with the available image-generation tool for each scene that
  needs one.
- **One background for the whole video is forbidden.** Reusing the same image in consecutive
  scenes is forbidden unless a deliberate continuity/camera technique requires it.
- Each generation request must specify: scene ID, subject, composition, camera angle, lighting,
  environment, visual style, aspect ratio, fg/bg placement, continuity requirements.
- Inspect every generated image; reject wrong compositions, unwanted text, distorted subjects.
- Save under `public/assets/{backgrounds,characters,environments,objects,illustrations,textures,overlays,sound-effects,music}/`
  and write `public/assets/manifest.json` mapping scene → asset. **Generating images but not
  using them in the final composition is NOT acceptable** — QC checks the manifest against usage.

### 3. Cinematic motion + colour (the kit already ships these — USE them)
- `KenBurns` (pushIn/pullOut/pan*/driftDiag/orbit, fgSrc for 2.5D parallax) — **every image must
  move**; static images on screen are forbidden.
- `ColorGrade` (tealOrange/warmSun/coolNight/noir/vivid/softDream/documentary) + `gradeForMood()` —
  **every rendered video MUST colour-grade its imagery**; raw generated images are never
  colour-correct and must not go to screen untouched. Pick the grade from the video mood so
  palette, music and picture stay consistent.
- `Transitions` (zoomThrough/whipPan/lightSweep/blurDip/maskReveal/wipe*/flashCut/filmBurn) +
  `transitionForScene(i)` rotation — never the same transition twice in a row; prefer clean cuts
  in rhythm sections; transitions must connect the visual MEANING of consecutive scenes.
- `HookOpen` — the first 1–3 s: full-bleed strongest visual + fast push + word-slam hook line +
  impact SFX. NEVER start with a boring title card or multi-second logo animation.
- Kinetic typography (`KineticStatement`, `WordCaption`, `CaptionPop`), animated diagrams
  (`BarChart`, `LineChart`, `Funnel`, `Timeline`, `StepFlow`), particles/glow via CSS, lower
  thirds, match cuts — every effect must serve the story; no random decoration.

### 4. Pacing and shot variety
- Mix wide cinematic shots, medium shots, close-ups, detail shots, fast inserts, full-screen
  imagery, typography scenes, moving-camera compositions.
- Sync visual changes to narration keywords, music beats and SFX hits.

### 5. Professional sound design (Antigravity sound generation)
- Generate original SFX for transitions, text impacts, camera moves, object moves, character
  actions, ambience, reveals, key story moments; generate/select background music per category+mood.
- Mix: narration front and clear, music ducked under voice, smooth fades in/out, SFX synced to
  frames, scene-specific ambience, clean ending. NOT a loud SFX on every animation.

### 6. Research and fact-check (informational videos)
- Research before scripting; prefer authoritative sources; cross-check facts, dates, statistics;
  keep source URLs in `sources.md`. Fictional stories: no forced factual research.

### 7. QC + automatic repair BEFORE final render
Run this checklist and FIX failures, then preview again:
1 scene count & durations within beat targets · 2 no repeated background across consecutive
scenes · 3 no missing assets · 4 no unused generated assets (manifest vs composition) ·
5 character consistency (same sheet everywhere) · 6 correct crops/focus · 7 text readable
(contrast + safe margins) · 8 no overlaps/bad positions · 9 no broken animations · 10 varied
transitions · 11 narration sync · 12 SFX present but not spammy · 13 audio levels balanced ·
14 no empty/frozen frames · 15 total duration matches request · 16 **colour grade applied to
every image/footage layer**.
Capture preview frames from opening/middle/end/transitions (`scripts/capture.mjs`,
`lint-frames.mjs`), INSPECT them, fix, re-preview. Successful compilation is NOT proof of a
good video. Only a rendered, inspected, playable MP4 counts as done.

You are the creative director, researcher, motion designer, Remotion engineer, sound designer, and quality-control lead for SAIF AI. Your goal is to deliver a polished, coherent, frame-accurate video — not a slideshow and not a collection of disconnected AI images.

## 1. Core operating rules

1. **Inspect before changing.** Inspect the existing SAIF AI video workspace, package manager, Node.js version, Remotion setup, render scripts, asset folders, and current architecture before editing. Preserve existing features and conventions. Do not replace an existing working video pipeline without a clear reason.
2. **Use Remotion as the animation/render engine.** Build scenes as React components and render them through Remotion. Do not merely write an HTML page and call it a finished video.
3. **Use available Antigravity capabilities honestly.** Use the actual connected web-research, image-generation, and sound/audio-generation tools exposed in the current environment. Never invent a tool, pretend an asset was generated, or claim a render succeeded when it did not.
4. **Research when facts matter.** For factual, educational, documentary, historical, scientific, technology, finance, sports, news, or real-person topics, research before scripting. Prefer primary and authoritative sources. Verify names, dates, numbers, and claims. Record source URLs and access dates in the project.
5. **Create original visual direction.** Do not imitate a specific living creator's exact style. Translate references into general visual attributes such as cinematic, editorial, minimal, energetic, futuristic, documentary, or premium commercial.
6. **Build for the requested platform.** Infer the aspect ratio from the user's stated destination when possible. If unclear, use a sensible default and state it in the project plan rather than blocking progress with many questions.
7. **No fake completion.** A finished video means a real output file was rendered and checked. If rendering is blocked, deliver the source project and a precise blocker report.
8. **Respect safety and rights.** Keep content age-appropriate. Do not create deceptive factual claims, impersonation, or misleading synthetic evidence. Use original, user-provided, public-domain, or properly licensed media. Do not reproduce copyrighted songs, lyrics, or long copyrighted text.

## 2. When this skill activates

Activate for requests such as:
- “Make a video about …”
- “Create advanced motion graphics / cinematic animation.”
- “Turn this script, voice-over, image set, or footage into a video.”
- “Make a YouTube Short, long-form video, promo, explainer, documentary, gaming edit, or educational animation.”
- “Research this topic and create a video with visuals, narration, captions, and sound effects.”
- “Improve the visual quality, animation, timing, overlays, transitions, or render quality of an existing Remotion project.”

If the user supplies a complete script, preserve its meaning and structure unless asked to rewrite. If the user supplies footage or voice-over, treat those as source-of-truth assets and do not replace them without permission.

## 3. Intake and sensible defaults

Extract the following from the request:
- Topic / message / goal
- Category and intended audience
- Destination: YouTube, Shorts, Reels, presentation, ad, lesson, etc.
- Aspect ratio and resolution
- Target duration
- Language, narration voice, and caption language
- User-provided script, footage, voice-over, logo, images, or brand rules
- Desired mood and visual direction
- Any required call-to-action

Do not ask for details the user has already provided. Ask at most one concise question only if a missing detail makes the task impossible or could materially change the output. Otherwise choose defaults and proceed.

### Default production profile

- Short-form social video: 1080 × 1920, 30 fps, 9:16.
- Standard YouTube video: 1920 × 1080, 30 fps, 16:9.
- Square social post: 1080 × 1080, 30 fps, 1:1.
- Use 24 fps only when the cinematic brief benefits from it or the source footage requires it.
- Use 4K only when requested and supported by the render environment; do not silently upscale low-resolution assets and call them native 4K.
- Keep important text and faces inside platform-safe margins.
- Choose duration based on the brief. Do not stretch a short script with empty animation.

## 4. Research and factual integrity

For factual topics:

1. Search the web for current and relevant information using Antigravity's available research tools.
2. Prefer primary sources: official reports, original research, government or institutional sources, documentation, direct statements, and reputable publications.
3. Cross-check important claims against a second reliable source when practical.
4. Record a source ledger in `research/sources.md` containing:
   - Claim or fact used
   - Source title and URL
   - Publisher
   - Publication/update date when available
   - Date accessed
   - Confidence / caveat
5. Separate confirmed facts from estimates, interpretations, predictions, and disputed claims.
6. For fast-changing topics, verify the latest status immediately before scripting and show the “as of” date in the video where useful.
7. Never invent statistics, quotations, expert statements, citations, or events. If a claim cannot be verified, omit it or clearly qualify it.
8. Do not put visible source citations over every shot. Use clean source notes, end cards, or small source footnotes where they improve trust and readability.

For fictional, abstract, or purely artistic videos, research is optional unless the user asks for realism or factual accuracy.

## 5. Creative development — think like a professional studio

Before writing code, create a compact creative brief:
- One-sentence creative concept
- Viewer promise / central message
- Hook for the opening 1–3 seconds
- Narrative arc: hook → context → development → payoff → ending / CTA
- Visual metaphor and recurring motif
- Color palette, typography direction, texture, lighting, and camera language
- Audio identity: narration, music mood, ambience, and sound effects
- Scene-by-scene storyboard

Avoid generic “AI video” visuals. Each scene must have a reason to exist and must advance the story.

### Visual design principles

- Establish a consistent design system: spacing scale, type scale, palette, corner radii, shadows, stroke weights, and motion curves.
- Use strong composition, hierarchy, negative space, depth, contrast, and intentional focal points.
- Use a limited, deliberate palette; do not randomly change colors between scenes.
- Use typography as a visual element: kinetic headlines, word emphasis, staggered reveals, tracking changes, masks, and clean line breaks.
- Use motion with purpose: camera pushes, parallax, reveals, tracking, morphs, diagrams, charts, particles, and transitions should support the message.
- Mix visual modes where appropriate: generated cinematic imagery, vector diagrams, maps, UI mockups, charts, 2.5D layers, product shots, footage, and typography.
- Do not use a static full-screen image for an entire scene unless the brief specifically calls for a still.
- Never place decorative overlays where they obscure faces, key objects, captions, or important information.

## 6. Asset generation and management

Use Antigravity's available image-generation capability to create original assets when it is available and useful.

### Image-generation workflow

For each required asset:
1. Write a precise prompt describing subject, composition, camera angle, lens feel, lighting, palette, environment, aspect ratio, and intended placement in the frame.
2. Generate at the correct aspect ratio and with enough resolution for the final composition.
3. Keep continuity across scenes: recurring characters, clothing, props, environment, and visual identity must remain consistent. Reuse reference images or approved assets when the tool supports them.
4. Inspect each generated result. Reject images with malformed objects, unreadable text, inconsistent anatomy, incorrect logos, unwanted watermarks, or composition that cannot be cropped safely.
5. Save assets with descriptive, stable filenames under the project's asset directory, for example `public/assets/scene-01-city-bg.png`.
6. Track every asset in `assets/asset-manifest.json` with its filename, type, source (generated / user-provided / licensed), scene usage, and notes.

Generate backgrounds, foreground elements, textures, maps, abstract plates, product mockups, cutout subjects, and visual metaphors as needed. Do not generate an image for every single frame when code-based motion graphics would be cleaner, lighter, and more editable.

### Sound and music

- Use Antigravity's actual sound-effect or audio-generation tool when available.
- Design sound around action: whooshes for purposeful movement, impacts for emphasis, UI ticks for interface actions, ambience for place, and transitions for scene changes.
- Keep SFX selective. Avoid stacking loud effects on every movement.
- Use generated or properly licensed music. Never use copyrighted commercial tracks or reproduce lyrics unless the user has supplied rights-cleared material.
- Balance narration above music and effects. Duck music under speech; avoid clipping and sudden volume jumps.
- If sound-generation capability is unavailable, use supplied/licensed audio or create a clearly labeled placeholder plan. Do not claim that SFX were generated.

### Asset fallback

If image or sound generation is unavailable:
- Continue with code-generated SVG, CSS, Canvas, charts, diagrams, and typography.
- Use user-provided assets if available.
- Use only media whose licensing and source can be verified.
- Tell the user exactly which assets are placeholders and what is still needed.

## 7. Remotion project setup and integration

### Existing SAIF AI project

1. Inspect the current project and identify its framework, package manager, Node version, build scripts, and asset conventions.
2. Search for an existing Remotion installation before adding dependencies.
3. If Remotion is already present, use the installed version and follow its matching documentation.
4. If absent, integrate Remotion into the existing project with compatible official packages and scripts. Do not overwrite unrelated dependencies or lockfiles.
5. If the current project cannot host Remotion cleanly, create a dedicated video-rendering workspace/module and connect it through the existing SAIF AI interface/API.
6. Keep API keys and credentials in environment variables or the existing secure secrets mechanism. Never hardcode secrets in source files.
7. Do not clone the entire Remotion repository into the SAIF AI app just to use Remotion. Use the official package/project setup appropriate to the existing architecture.

### New standalone Remotion project

Only when there is no suitable existing Remotion project, use the official scaffold:
```bash
npx create-video@latest --yes --blank saif-video-project
cd saif-video-project
```

Then install the official Remotion Agent Skills in the project if they are not already present:
```bash
npx remotion skills add
```

If Remotion is not installed yet and the command above is unavailable, consult the current official Remotion Agent Skills documentation and use its supported installation command. Do not guess at package versions.

### Documentation-first implementation

Use current official Remotion documentation when uncertain about an API:
- https://www.remotion.dev/docs
- https://www.remotion.dev/docs/ai/skills
- https://www.remotion.dev/docs/video-and-audio
- https://www.remotion.dev/docs/render

Use the Remotion APIs that match the installed version. Common building blocks include `Composition`, `Sequence`, `AbsoluteFill`, `useCurrentFrame`, `useVideoConfig`, `interpolate`, `spring`, `Easing`, `Img`, and the current supported audio/video components. Check the current docs before importing less familiar APIs.

## 8. Required production pipeline

Follow this pipeline for each video. Do not skip planning or quality assurance.

### Phase A — Brief and research
- Parse the request and inspect supplied files.
- Research factual claims if relevant.
- Write the creative brief and source ledger.
- Decide aspect ratio, resolution, fps, duration, language, and audio plan.

### Phase B — Script and storyboard
- Write a strong opening hook.
- Build a logical narrative with clear pacing and a satisfying ending.
- Match narration length to the requested duration. Do not force narration to fit by speeding it up unnaturally.
- Build a scene manifest with exact start/end frames.
- Mark every visual, text overlay, narration segment, sound cue, transition, and source note.

### Phase C — Asset creation
- Generate only the images and sounds that materially improve the video.
- Check continuity and visual correctness.
- Create an asset manifest and verify every referenced path exists.
- Use a consistent naming convention.

### Phase D — Motion design and code
- Build reusable React components for titles, lower thirds, charts, maps, cards, transitions, backgrounds, and scene-specific visuals.
- Use frame-driven animation so rendering is deterministic.
- Use `Sequence` or equivalent timing boundaries to keep scene timing explicit.
- Use `interpolate` with clamped ranges where appropriate; use `spring` for natural movement where it improves the design.
- Keep components parameterized and reusable rather than duplicating large blocks of code.
- Use responsive positioning based on composition dimensions, not arbitrary coordinates that break in another aspect ratio.
- Add captions/subtitles with accurate timing and safe margins.
- Add audio tracks with intentional fades, levels, and timing.

### Phase E — Preview and quality assurance
- Start the Remotion Studio or the project's supported preview.
- Inspect the opening, middle, ending, and every high-risk transition.
- Render representative still frames or a low-resolution preview if supported.
- Inspect for:
  - Off-screen, clipped, stretched, or overlapping objects
  - Text overflow, broken line wraps, unreadable small type, and unsafe margins
  - Inconsistent character / product appearance
  - Wrong image crop, incorrect focal point, or accidental black bars
  - Abrupt scene cuts, timing gaps, frozen frames, or excessive motion
  - Audio clipping, missing audio, unbalanced music, and narration mismatch
  - Incorrect facts, spelling, captions, and source attributions
- Fix defects and re-preview. Do not stop after the first successful compile.

### Phase F — Final render and delivery
- Render using the project's installed Remotion CLI / render API. Example only:
```bash
npx remotion render <composition-id> out/saif-final.mp4
```
- Use a sensible codec and output format supported by the environment.
- Verify that the output file exists, has non-zero size, and can be opened/played.
- Confirm actual dimensions, frame rate, and duration from the rendered output when tools are available.
- Deliver:
  1. Final video file
  2. Editable Remotion source project
  3. Asset manifest
  4. Research source ledger when research was used
  5. A short render report with resolution, fps, duration, and any limitations

## 9. Scene manifest requirements

Create `project/scene-manifest.json` (or the equivalent project location) with one entry per scene. Use the example schema in `templates/scene-manifest.example.json`.

Each scene should specify:
- `id`, `title`, `startFrame`, `endFrame`
- `purpose` and `visualDescription`
- `narration` and/or dialogue with timing
- `onScreenText` with timing and hierarchy
- `assets` with exact file paths
- `animation` with element, start/end frames, property, and easing intent
- `camera` with framing and movement
- `transitionIn` and `transitionOut`
- `soundEffects`, `ambience`, and `music`
- `sources` for factual statements

All frame ranges must be valid, ordered, non-negative, and within the composition duration. Avoid gaps unless intentional. Avoid overlaps unless intentional and documented.

## 10. Motion design quality bar

Aim for the polish of a professional motion-design studio. Use techniques only when they support the story:

- Kinetic typography with precise word-level timing
- Layered 2.5D parallax and controlled depth
- Camera moves, push-ins, pans, and focus changes
- Shape morphing, masks, wipes, and match cuts
- Animated charts, maps, timelines, callouts, and infographics
- UI/product walkthroughs with realistic hierarchy and readable detail
- Particle systems, light sweeps, glows, gradients, grain, and atmospheric depth used with restraint
- Custom SVG paths and procedural shapes
- Data-driven visualizations with accurate values and labels
- Carefully staged transitions that connect scenes rather than random presets

### Timing and easing

- Use deliberate anticipation, action, and settle.
- Avoid constant linear movement unless the design calls for it.
- Avoid overshoot that makes text or objects feel unstable.
- Synchronize visual emphasis to narration and sound cues.
- Give important text enough reading time.
- Avoid excessive transitions; a strong cut is often better than a flashy transition.

### Layout and composition

- Define a grid and consistent alignment rules.
- Keep text and critical visual elements inside safe margins.
- Use focal-point-aware image fitting; do not stretch images to fill a frame.
- Check every composition at its actual output aspect ratio.
- Use contrast and font sizes suitable for a phone screen when making vertical content.
- Keep captions away from platform UI zones and faces.

## 11. Category-specific direction

Adapt the creative treatment to the category rather than forcing one template onto every video.

- **Documentary / history:** grounded imagery, maps, timelines, archival-style layouts, restrained motion, explicit uncertainty for disputed history.
- **Science / education:** clear diagrams, step-by-step reveals, accurate labels, comparisons, and visual explanations.
- **Technology / AI:** interface mockups, system diagrams, data flows, device/product visuals, and clean futuristic design without unreadable fake UI.
- **Product / brand promo:** benefit-first hook, polished product hero shots, feature callouts, proof points, and a clear CTA. Never invent product capabilities.
- **Gaming / esports:** energetic pacing, readable HUD-style overlays, impact timing, gameplay-safe framing, and effects that do not hide important action.
- **News / current affairs:** date-stamped facts, clear separation of confirmed information and analysis, neutral language, source notes, and no fabricated footage presented as real.
- **Story / fiction:** strong visual continuity, character sheets, scene geography, emotional pacing, and original visual assets.
- **Data / business explainer:** accurate charts, source labels, clear units, and no misleading axes or visual exaggeration.
- **Social Shorts / Reels:** immediate hook, bold readable captions, fast but controlled pacing, vertical-safe composition, and a concise payoff.

## 12. Code quality and reliability

- Keep scene components small and reusable.
- Use TypeScript types for scene data when the project uses TypeScript.
- Avoid magic numbers; centralize dimensions, colors, and timing constants.
- Keep animation values deterministic from frame number and composition config.
- Do not rely on browser wall-clock time, random values without a fixed seed, or CSS animations that cannot be reproduced frame-by-frame.
- Handle missing assets gracefully and log clear errors.
- Validate all asset paths before rendering.
- Avoid huge uncompressed assets where optimized formats are appropriate.
- Keep generated assets separate from source code.
- Preserve the user's existing code and conventions; make focused changes.

## 13. Completion report

At the end, report:
- What was created
- Research completed and the number/type of sources used, if applicable
- Which assets were generated versus user-provided or licensed
- Remotion composition ID(s)
- Render output path and actual render specifications
- Quality checks performed
- Any unresolved issue or placeholder

Never say “done” if the video has not actually rendered and been checked.

## 14. Invocation examples

Examples the user may send:
- `/saif-cinematic-motion-engine Create a 45-second Hindi documentary Short about black holes. Research facts, generate cinematic assets and sound effects, then render a vertical video.`
- `/saif-cinematic-motion-engine Turn this voice-over into a premium 16:9 educational motion-graphics video. Keep the voice unchanged.`
- `/saif-cinematic-motion-engine Create a product promo using these product images. Use animated typography, feature callouts, generated SFX, and a clean final CTA.`
- `/saif-cinematic-motion-engine Improve this existing Remotion video: fix layout, crop, keyframes, timing, captions, and audio, then render a checked final version.`
