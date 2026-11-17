# SAIF AI — Cinematic Motion Engine

An installable Antigravity Agent Skill for research-backed, high-end Remotion motion-graphics production.

## What it does

- Uses Remotion + React for frame-accurate animated videos.
- Plans scripts, storyboards, scene timing, and visual direction.
- Uses Antigravity's available research tools for fact-checking.
- Uses available image-generation and sound-generation tools for original assets.
- Builds animated typography, diagrams, charts, maps, UI visuals, transitions, captions, and layered scenes.
- Requires preview, quality checks, and a verified final render before reporting completion.

## Install in Antigravity

### Workspace install (recommended for the SAIF AI project)

1. Extract this ZIP.
2. Copy the folder `saif-cinematic-motion-engine` into your SAIF AI project's:
   `.agents/skills/`
3. The final path should be:
   `.agents/skills/saif-cinematic-motion-engine/SKILL.md`
4. Restart the Antigravity conversation / reload skills if needed.
5. Invoke it by typing:
   `/saif-cinematic-motion-engine`

### Global install

Copy the folder into:
`~/.gemini/config/skills/saif-cinematic-motion-engine/`

This makes the skill available across Antigravity projects on that machine.

Antigravity's current default workspace path is `.agents/skills`. It also documents backward compatibility for `.agent/skills`.

## First-time Remotion setup

The skill will inspect the current project before changing it. If the project has no Remotion setup, it will use the official Remotion setup flow appropriate to that project. In a new standalone project, the official starter command is:

```bash
npx create-video@latest --yes --blank saif-video-project
cd saif-video-project
npx remotion skills add
```

Do not paste the entire Remotion GitHub repository into the SAIF AI app. Remotion is a React-based video framework and should be integrated through the appropriate project dependencies and rendering workflow.

## Example request

```text
/saif-cinematic-motion-engine Create a 60-second Hindi vertical video about how black holes work. Research the science, write a strong hook, generate cinematic background images and original sound effects using the available Antigravity tools, build advanced Remotion motion graphics, preview the scenes, fix visual issues, and render the final MP4.
```

## Important capability note

This skill gives Antigravity a detailed production workflow. Actual image generation, sound generation, web research, and video rendering still depend on the tools, permissions, packages, and compute environment available to your SAIF AI setup. The skill instructs the agent not to pretend a missing capability worked.

## Official references

- Remotion repository: https://github.com/remotion-dev/remotion
- Remotion docs: https://www.remotion.dev/docs
- Remotion Agent Skills: https://www.remotion.dev/docs/ai/skills
- Antigravity Agent Skills: https://antigravity.google/docs/skills
- Remotion licensing: https://www.remotion.dev/docs/license/pricing
