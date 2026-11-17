import React from "react";
import { AbsoluteFill, Img, interpolate, staticFile, useCurrentFrame, useVideoConfig, Easing } from "remotion";
import { theme, APPLE_EASE } from "../theme";
import { SFProFaces } from "../anim";
import { Stickman, CharacterSheet, StickAction, Expression } from "./Stickman";
import { ColorGrade, GradePreset, gradeForMood } from "./ColorGrade";
import { CameraMove } from "./KenBurns";

/**
 * STORY SCENE — one cinematic beat of CINEMATIC STORY MODE.
 * Layers: generated background image (with camera motion + color grade)
 *       → one or more consistent stickman characters (procedural animation)
 *       → dialogue bubble / narration caption → transition hook.
 * Backgrounds must VARY per scene (city, home, office, mountains…); never reuse
 * the same image for consecutive scenes.
 */
export type StoryCharacter = {
  sheet: CharacterSheet;
  action?: StickAction;
  expression?: Expression;
  facing?: 1 | -1;
  x?: number;   // % of frame
  y?: number;
  scale?: number;
};

export type StorySceneProps = {
  /** generated background in public/ (e.g. "assets/backgrounds/city-night.png") */
  bg: string;
  camera?: CameraMove;
  grade?: GradePreset;
  mood?: string;                 // used by gradeForMood when grade omitted
  characters: StoryCharacter[];
  /** spoken line — rendered as a bubble near the first character */
  dialogue?: string;
  speaker?: string;
  /** narration — bottom cinematic caption */
  narration?: string;
  length?: number;
};
export const storySceneDuration = (p: StorySceneProps) => p.length ?? 150;

export const StoryScene: React.FC<StorySceneProps> = ({ bg, camera = "pushIn", grade, mood = "dramatic", characters, dialogue, speaker, narration, length = 150 }) => {
  const asset = (u: string) => (/^https?:|^data:/.test(u) ? u : staticFile(u));
  const frame = useCurrentFrame();
  const { durationInFrames } = useVideoConfig();
  const L = length || durationInFrames;
  const ease = Easing.bezier(...APPLE_EASE);
  const t = interpolate(frame, [0, L], [0, 1], { extrapolateLeft: "clamp", extrapolateRight: "clamp", easing: ease });
  const travel = (k: number) => 1 + 0.1 * k;
  const cam: React.CSSProperties =
    camera === "pullOut" ? { transform: `scale(${travel(1 - t)})` } :
    camera === "panLeft" ? { transform: `scale(1.12) translateX(${t * 4}%)` } :
    camera === "panRight" ? { transform: `scale(1.12) translateX(${-t * 4}%)` } :
    camera === "panUp" ? { transform: `scale(1.12) translateY(${t * 3}%)` } :
    camera === "orbit" ? { transform: `scale(1.12) translate(${Math.sin(t * Math.PI * 2) * 1.6}%, ${Math.cos(t * Math.PI * 2) * 1}%)` } :
    { transform: `scale(${travel(t)})` };
  const dIn = interpolate(frame, [0, 12], [0, 1], { extrapolateLeft: "clamp", extrapolateRight: "clamp" });
  const dOut = interpolate(frame, [L - 10, L], [1, 0], { extrapolateLeft: "clamp", extrapolateRight: "clamp" });
  const preset: GradePreset = grade ?? gradeForMood(mood);
  const lead = characters[0];
  return (
    <AbsoluteFill style={{ backgroundColor: "#0B0B0F" }}>
      <ColorGrade preset={preset}>
        <AbsoluteFill style={cam}>
          <Img src={asset(bg)} style={{ width: "100%", height: "100%", objectFit: "cover" }} />
        </AbsoluteFill>
        {characters.map((c, i) => (
          <Stickman key={c.sheet.id + i} sheet={c.sheet} action={c.action ?? "stand"} expression={c.expression ?? "neutral"} facing={c.facing ?? 1} x={c.x ?? 50} y={c.y ?? 72} scale={c.scale ?? 1} />
        ))}
      </ColorGrade>
      <SFProFaces />
      {dialogue && lead ? (
        <AbsoluteFill style={{ opacity: dIn }}>
          <div style={{ position: "absolute", left: `${Math.min(78, Math.max(22, lead.x ?? 50))}%`, top: `${Math.max(8, (lead.y ?? 72) - 34)}%`, transform: "translate(-50%, -100%)", maxWidth: 720, background: "rgba(255,255,255,0.96)", borderRadius: 28, padding: "22px 34px", boxShadow: "0 18px 44px rgba(0,0,0,0.35)", fontFamily: `${theme.fontText}, "Kohinoor Devanagari", sans-serif` }}>
            {speaker ? <div style={{ fontSize: 22, fontWeight: 700, color: theme.accent, letterSpacing: 0.4, textTransform: "uppercase", marginBottom: 6 }}>{speaker}</div> : null}
            <div style={{ fontSize: 38, fontWeight: 600, color: theme.ink, lineHeight: 1.25 }}>{dialogue}</div>
            <div style={{ position: "absolute", bottom: -16, left: "46%", width: 0, height: 0, borderLeft: "16px solid transparent", borderRight: "16px solid transparent", borderTop: "18px solid rgba(255,255,255,0.96)" }} />
          </div>
        </AbsoluteFill>
      ) : null}
      {narration ? (
        <AbsoluteFill style={{ justifyContent: "flex-end", alignItems: "center", padding: "0 120px 90px", opacity: dIn * dOut }}>
          <div style={{ fontFamily: `${theme.fontDisplay}, "Kohinoor Devanagari", sans-serif`, fontSize: 54, fontWeight: 700, color: "#fff", textAlign: "center", textShadow: "0 6px 30px rgba(0,0,0,0.85)", letterSpacing: -1, lineHeight: 1.2 }}>{narration}</div>
        </AbsoluteFill>
      ) : null}
    </AbsoluteFill>
  );
};
