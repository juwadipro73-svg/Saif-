---
name: cinematic-story-mode
description: Character-based cinematic storytelling for SAIF AI — original stickman/character animation with Remotion. Use when the user asks for a story video, kahani, character-driven narrative, emotional/motivational/horror/comedy/mystery/adventure animated story, or explicitly picks Story Mode. Pairs with saif-cinematic-motion-engine and the motion-director kit (Stickman, StoryScene, HookOpen, ColorGrade, Transitions templates).
---

# SAIF AI — Cinematic Story Mode (stickman / character animation)

Create ORIGINAL, professionally paced character-driven animated stories. Reference concept:
minimalist stickman storytelling reels (rags-to-riches, emotional journeys). Never copy exact
frames, characters, or protected expression from any reference — build original stories.

## 1. Story Mode UX
When the user activates video creation, offer two distinct choices when the mode is unclear:
1. **Motion Graphics**  2. **Story Mode**
When Story Mode is chosen, collect (from the request; never re-ask what's given): story topic,
idea/prompt, duration, language, animation style, mood, character-consistency notes. Then
proceed WITHOUT unnecessary questions.

## 2. Automatic story writing (topic → finished video)
For a topic like "Ek stickman ki kahani jo zero se successful businessman banta hai":
1. Understand topic & audience. 2. Write an ORIGINAL engaging story with beginning, conflict,
climax, ending. 3. Create interesting characters (2–4). 4. Write natural dialogue/narration in
the user's language. 5. Divide into detailed scenes. 6. Storyboard every scene. 7. Generate all
character/environment assets. 8. Build animations. 9. Sync narration, dialogue, music, SFX.
10. QC (see motion-engine skill §7). 11. Render and verify the final MP4.

## 3. Character consistency engine (CRITICAL)
- Before any scene, create a **character reference sheet** per character as a
  `CharacterSheet` object (kit: `templates/Stickman.tsx`):
  `{ id: "stickman_main", head, torso, arm, leg, stroke, color, headFill, accessory, accessoryColor }`
  Classic look: white circular head, black stick limbs, consistent proportions, distinctive
  accessory (cap/tie/crown/glasses/scarf/briefcase) when the story needs identity.
- Save all sheets in `characters.json` in the project. EVERY scene renders from these sheets —
  head shape, proportions, clothing, accessories, colours, face and identity NEVER drift.
- Multiple characters = separate ids/sheets. For generated-image characters, keep a written
  design description and pass it verbatim in every image request (continuity requirement).

## 3b. Framing + in-scene evolution (v3 — fixes tiny characters and frozen scenes)
- `StoryScene` ships a shot system: wide / medium / closeup / ots / lowAngle / tracking.
  MEDIUM is the default (character ≈55% frame height); CLOSEUP for emotions and discoveries;
  WIDE only when the environment itself is the story point. A main character rendered tiny in a
  big empty background is a CRITICAL failure — reframe and re-render.
- Every scene needs an in-scene action timeline: `actions: [{at, action, expression, facing, x}]`
  so the character evolves (walk → stop → startle at the knock → turn → creep to the door).
  A meaningful visual change every 2–4 seconds even on the same background: action, angle,
  camera, new object, reaction, lighting. No static pose held through a scene.
- Camera: use `follow` for travel; push-ins must land on the character or the key object.
- Interaction logic is mandatory: reach the handle before the door opens, look at the radio when
  it sounds, approach the box before examining it. No floating objects, no walking through walls.
- New rig actions available: startle, lookUp, lookDown, knock, openDoor, pickup, creep (plus the
  original set). Overlays stay compact and semi-transparent — never cover the character's head
  or the key subject; captions sit on a thin bottom scrim.

## 4. Advanced stickman animation (no static images)
Use the procedural rig — actions: stand, walk, run, jump, sit, fall, point, wave, talk, turn,
climb, celebrate; expressions: neutral, happy, sad, angry, shocked, determined, thinking;
`facing`, `speed`, `talkBeats`, per-character `x/y/scale`. Animation is frame-driven SVG —
deterministic and smooth. Combine generated backgrounds with animated characters via
`StoryScene` (bg image + camera move + grade + characters + dialogue bubble + narration caption).
Characters must interact naturally with the environment and each other (positions, facing,
gesture timing matched to dialogue).

## 5. Scene construction
Every scene declares: description, characters present, positions, actions, background, camera
framing + movement, dialogue, narration, SFX, transition, start/end frames. Example beats:
lonely stickman in an empty city (slow push-in, sad, soft ambience) → walking through a busy
street while others pass (side-track, walk cycle, mocking narration) → discovers an opportunity
(close-up → dramatic push-in, determined, cinematic impact SFX). Generate ORIGINAL scenes from
the actual story — examples are not a script.

## 6. Visual variety & continuity
Never one background for the whole story. Generate per-scene environments: city streets, homes,
offices, schools, mountains, villages, roads, shops, cinematic/fantasy locations. Vary camera
angles and composition; keep lighting/palette continuity between consecutive scenes
(`ColorGrade` preset fixed by mood unless a scene deliberately shifts).

## 7. Mood presets (influence palette, music, lighting, camera, expression, timing, SFX, transitions)
emotional · inspirational · motivational · comedy · mystery · horror-fiction · adventure ·
suspense · educational · dramatic. Map moods to grades with `gradeForMood()`
(emotional→softDream, inspirational/motivational→warmSun, mystery/suspense/horror→coolNight,
drama→noir, comedy/promo→vivid, educational→documentary, default tealOrange).

## 8. Sound & delivery
Dialogue/narration via available TTS/sound tools; ambience + score per mood; SFX on impacts,
footsteps, transitions — professionally mixed (ducking, fades, clean ending). Deliver: scene
plan, characters.json, asset manifest, Remotion project, preview-frame QC report, final
verified MP4. No fake completion — if render is blocked, deliver full source + exact blocker.
