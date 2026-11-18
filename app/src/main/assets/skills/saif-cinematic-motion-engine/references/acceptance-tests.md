# ACCEPTANCE TESTS — run both before declaring the video engine healthy

These are internal test projects. After any engine/pipeline change, build and render BOTH,
inspect the outputs against the checklists, and fix failures. Do not mark work complete
because code compiles — the rendered videos must demonstrate the quality.

## Test A — Normal Mode (Advanced Motion Graphics)
Topic: "Why Most YouTube Channels Fail" (60–90s, 16:9 or 9:16 per brief).
Must demonstrate:
- [ ] Hook in first 3s (HookOpen or equivalent): surprising visual + strong animated line + impact SFX; no black screen, no logo intro.
- [ ] Narration-synced BeatSeq: every sentence has its own visual beat (generated image + camera move); screen never static while narration continues.
- [ ] Beat count in target range (qc-scene-plan.mjs passes with 0 CRIT).
- [ ] At least one animated counter, one self-drawing graph, one kinetic-typography moment.
- [ ] Generated backgrounds stay visible — overlays compact/semi-transparent, no covered subjects.
- [ ] Transitions rotate (no same-kind twice in a row); ColorGrade applied to every image layer.
- [ ] Sound: whooshes on movement, impact on reveals, ducked music, clear dominant voice.
- [ ] Preview frames inspected at opening/middle/end/transition; frozen/black frames = fail.

## Test B — Story Mode (Cinematic Character Story)
Story: "The Last Human — Part 1" (60–120s). Character: SHADOW — black stickman, white
circular head, expressive eyes, red scarf (CharacterSheet saved in characters.json; identical
sheet reused in every scene).
Must demonstrate:
- [ ] Character clearly visible: medium/closeup shots dominate; SHADOW never a tiny speck.
- [ ] Real animation: walking cycle, stopping, head turn, startle reaction, cautious approach
      (in-scene actions timeline — e.g. three knocks: walk → startle → turn toward door → creep).
- [ ] Object interaction logic: reaches the handle before the door opens; looks at the radio when it sounds.
- [ ] Multiple camera angles: establishing wide (only where environment matters), medium, closeup on emotion, follow-cam on travel, push-in landing on the character.
- [ ] Dynamic pacing: meaningful visual change every 2–4s per scene; no frozen scene.
- [ ] Suspense sound design (coolNight grade): ambience, knock SFX synced to the visual hit, riser before the reveal, ducked score, clean ending.
- [ ] Smooth cinematic transitions; character identity identical across all scenes.
- [ ] qc-scene-plan.mjs passes; preview frames inspected at opening/middle/climax/end.

## Verdict format (write into the project as QC-REPORT.md)
For each test: PASS/FAIL per checklist line, the exact fixes applied for any FAIL, and the
final render path + duration + resolution. Only deliver after both PASS.
