# Reference Video Style Matcher

A portable, cross-tool Agent Skill that reverse-engineers any reference video into quantitative telemetry plus a **standalone reusable Style Template Skill** (`SKILL.md` + `style_profile.json`).

Once generated from a reference video, the resulting Style Template Skill works in **any** Agent Skills-compatible tool (Antigravity, Codex, Claude Code, OpenCode, Hermes, Cursor) **without ever needing the reference video again**.

## Included Files

- `SKILL.md` — full end-to-end instructions for reference analysis, template skill generation, and style-matched editing.
- `scripts/analyze_reference.py` — extracts container, pacing, shot-length curve, color/luminance/palette, framing/face-position, audio LUFS, optional Whisper WPM, and labeled keyframe contact sheets.
- `scripts/build_style_skill.py` — compiles telemetry JSON into a portable Style Template Skill (`SKILL.md`, `style_profile.json`, `reference_style.md`, `README.md`).
- `references/template_skill_schema.md` — schema reference, FFmpeg filter mapping formulas, and HyperFrames caption CSS/GSAP presets.

## Cross-Tool Portability

To install this skill in another AI coding/video tool, copy the entire `reference-style-matcher/` folder to that tool's skills directory:

| Tool | Skills Directory |
|---|---|
| Antigravity | `~/.gemini/config/skills/reference-style-matcher/` (or project `.agents/skills/`) |
| Codex | `~/.agents/skills/reference-style-matcher/` (or `~/.codex/skills/`) |
| Claude Code | `~/.claude/skills/reference-style-matcher/` (or `.claude/skills/`) |
| OpenCode | `~/.config/opencode/skills/reference-style-matcher/` |
| Hermes Agent | `~/.hermes/skills/reference-style-matcher/` |
| Project-scoped (shared) | `<project-root>/.agents/skills/reference-style-matcher/` |

Generated style templates (`<style-slug>-style/`) follow the exact same directory structure and can be copied into any of the locations above so any agent can apply that style to new raw videos without the original reference clip.
