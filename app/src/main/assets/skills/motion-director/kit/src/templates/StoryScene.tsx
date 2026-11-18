import React from "react";
import { AbsoluteFill, Img, interpolate, staticFile, useCurrentFrame, useVideoConfig, Easing } from "remotion";
import { theme, APPLE_EASE } from "../theme";
import { SFProFaces } from "../anim";
import { SfxAt } from "../Sfx";
import { Stickman, CharacterSheet, StickAction, Expression } from "./Stickman";
import { ColorGrade, GradePreset, gradeForMood } from "./ColorGrade";

/**
 * STORY SCENE v2 — one cinematic beat of CINEMATIC STORY MODE.
 *
 * Fixes the known failures:
 *  - TINY CHARACTER: `shot` drives a real framing system (wide/medium/closeup/ots/
 *    lowAngle/tracking). Medium = character fills ~55% of frame height, closeup =
 *    head+torso dominate. The character is the SUBJECT, never a speck.
 *  - FROZEN SCENE: `actions` is an in-scene timeline — walk, then stop, then turn,
 *    then react — so a scene evolves every 2-4s even on the same background.
 *  - COVERED ART: overlays are compact and semi-transparent; captions sit on a thin
 *    bottom scrim only; dialogue bubbles float clear of the character's head.
 *  - STATIC CAMERA: `follow` keeps the character framed during travel; push-ins land
 *    on the character, not on empty background.
 */
export type ShotType = "wide" | "medium" | "closeup" | "ots" | "lowAngle" | "tracking";
export type CameraMove = "pushIn" | "pullOut" | "panLeft" | "panRight" | "panUp" | "orbit" | "follow";

export type StoryCharacter = {
  sheet: CharacterSheet;
  action?: StickAction;
  expression?: Expression;
  facing?: 1 | -1;
  x?: number;   // % of frame
  y?: number;
  scale?: number;
  /** in-scene action timeline: at these frames the character switches action/expression/position */
  actions?: { at: number; action?: StickAction; expression?: Expression; facing?: 1 | -1; x?: number }[];
};

export type StorySceneProps = {
  bg: string;
  shot?: ShotType;
  camera?: CameraMove;
  grade?: GradePreset;
  mood?: string;
  characters: StoryCharacter[];
  dialogue?: string;
  speaker?: string;
  narration?: string;
  /** one-shot sfx timed inside the scene (e.g. knocks at frame 30) */
  sfx?: { at: number; name: string; volume?: number }[];
  length?: number;
};
export const storySceneDuration = (p: StorySceneProps) => p.length ?? 150;

/** Framing system: character scale + anchor per shot type. */
const SHOT_FRAME: Record<ShotType, { scale: number; y: number; bgScale: number }> = {
  wide:     { scale: 0.85, y: 74, bgScale: 1.04 },
  medium:   { scale: 1.9,  y: 78, bgScale: 1.08 },
  closeup:  { scale: 3.6,  y: 92, bgScale: 1.16 },
  ots:      { scale: 1.6,  y: 76, bgScale: 1.10 },
  lowAngle: { scale: 2.4,  y: 96, bgScale: 1.14 },
  tracking: { scale: 1.8,  y: 76, bgScale: 1.10 },
};

export const StoryScene: React.FC<StorySceneProps> = ({ bg, shot = "medium", camera = "pushIn", grade, mood = "dramatic", characters, dialogue, speaker, narration, sfx = [], length = 150 }) => {
  const frame = useCurrentFrame();
  const { durationInFrames } = useVideoConfig();
  const L = length || durationInFrames;
  const ease = Easing.bezier(...APPLE_EASE);
  const t = interpolate(frame, [0, L], [0, 1], { extrapolateLeft: "clamp", extrapolateRight: "clamp", easing: ease });
  const preset: GradePreset = grade ?? gradeForMood(mood);
  const shotF = SHOT_FRAME[shot] ?? SHOT_FRAME.medium;
  const lead = characters[0];

  // resolve the lead's CURRENT action from the in-scene timeline
  const resolve = (c: StoryCharacter) => {
    let action = c.action ?? "stand", expression = c.expression ?? "neutral", facing = c.facing ?? 1, x = c.x ?? 50;
    for (const step of c.actions ?? []) {
      if (frame >= step.at) {
        action = step.action ?? action; expression = step.expression ?? expression;
        facing = step.facing ?? facing; x = step.x ?? x;
      }
    }
    return { action, expression, facing, x };
  };
  const leadNow = lead ? resolve(lead) : null;

  // camera: follow keeps the lead framed; push-in/pull-out respect the shot's bg scale
  const leadX = leadNow ? leadNow.x : 50;
  const cam: React.CSSProperties =
    camera === "follow" ? { transform: `scale(${shotF.bgScale + 0.06}) translateX(${(50 - leadX) * 0.55}%)` } :
    camera === "pullOut" ? { transform: `scale(${shotF.bgScale + 0.08 - 0.06 * t})` } :
    camera === "panLeft" ? { transform: `scale(${shotF.bgScale + 0.06}) translateX(${t * 4}%)` } :
    camera === "panRight" ? { transform: `scale(${shotF.bgScale + 0.06}) translateX(${-t * 4}%)` } :
    camera === "panUp" ? { transform: `scale(${shotF.bgScale + 0.06}) translateY(${t * 3}%)` } :
    camera === "orbit" ? { transform: `scale(${shotF.bgScale + 0.06}) translate(${Math.sin(t * Math.PI * 2) * 1.6}%, ${Math.cos(t * Math.PI * 2) * 1}%)` } :
    { transform: `scale(${shotF.bgScale + 0.1 * t}) translateX(${(50 - leadX) * 0.25 * t}%)` }; // pushIn drifts toward the lead
  const dIn = interpolate(frame, [0, 12], [0, 1], { extrapolateLeft: "clamp", extrapolateRight: "clamp" });
  const dOut = interpolate(frame, [L - 10, L], [1, 0], { extrapolateLeft: "clamp", extrapolateRight: "clamp" });
  const asset = (u: string) => (/^https?:|^data:/.test(u) ? u : staticFile(u));
  const bubbleTop = Math.max(6, (lead?.y ?? shotF.y) - (shot === "closeup" ? 52 : shot === "wide" ? 22 : 36));
  return (
    <AbsoluteFill style={{ backgroundColor: "#0B0B0F" }}>
      <ColorGrade preset={preset}>
        <AbsoluteFill style={{ ...cam, overflow: "hidden" }}>
          <Img src={asset(bg)} style={{ width: "100%", height: "100%", objectFit: "cover" }} />
        </AbsoluteFill>
        {characters.map((c, i) => {
          const now = resolve(c);
          const base = i === 0 ? shotF : { scale: shotF.scale * 0.82, y: shotF.y + 2 };
          return (
            <Stickman key={c.sheet.id + i} sheet={c.sheet} action={now.action} expression={now.expression}
              facing={now.facing} x={now.x} y={c.y ?? base.y} scale={(c.scale ?? 1) * base.scale} />
          );
        })}
      </ColorGrade>
      {sfx.map((s, i) => <SfxAt key={i} frame={s.at} name={s.name} volume={s.volume ?? 0.45} />)}
      <SFProFaces />
      {dialogue && leadNow ? (
        <AbsoluteFill style={{ opacity: dIn, pointerEvents: "none" }}>
          <div style={{ position: "absolute", left: `${Math.min(80, Math.max(20, leadNow.x))}%`, top: `${bubbleTop}%`, transform: "translate(-50%, -100%)", maxWidth: 620, background: "rgba(255,255,255,0.88)", backdropFilter: "blur(8px)", borderRadius: 24, padding: "16px 28px", boxShadow: "0 14px 36px rgba(0,0,0,0.35)", fontFamily: `${theme.fontText}, "Kohinoor Devanagari", sans-serif` }}>
            {speaker ? <div style={{ fontSize: 19, fontWeight: 700, color: theme.accent, letterSpacing: 0.4, textTransform: "uppercase", marginBottom: 4 }}>{speaker}</div> : null}
            <div style={{ fontSize: 32, fontWeight: 600, color: theme.ink, lineHeight: 1.22 }}>{dialogue}</div>
          </div>
        </AbsoluteFill>
      ) : null}
      {narration ? (
        <AbsoluteFill style={{ justifyContent: "flex-end", alignItems: "center", pointerEvents: "none", opacity: dIn * dOut }}>
          <AbsoluteFill style={{ background: "linear-gradient(180deg, rgba(0,0,0,0) 74%, rgba(0,0,0,0.55) 100%)" }} />
          <div style={{ padding: "0 120px 70px", fontFamily: `${theme.fontDisplay}, "Kohinoor Devanagari", sans-serif`, fontSize: 50, fontWeight: 700, color: "#fff", textAlign: "center", textShadow: "0 6px 30px rgba(0,0,0,0.85)", letterSpacing: -1, lineHeight: 1.2 }}>{narration}</div>
        </AbsoluteFill>
      ) : null}
    </AbsoluteFill>
  );
};
