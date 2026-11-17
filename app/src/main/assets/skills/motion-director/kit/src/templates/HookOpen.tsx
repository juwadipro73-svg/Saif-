import React from "react";
import { AbsoluteFill, Img, interpolate, spring, staticFile, useCurrentFrame, useVideoConfig, Easing } from "remotion";
import { theme, accentTint, APPLE_EASE } from "../theme";
import { SFProFaces } from "../anim";
import { SfxAt } from "../Sfx";
import { ColorGrade, GradePreset, gradeForMood } from "./ColorGrade";

/**
 * HOOK OPEN — the first 1–3 seconds. NEVER a title card, NEVER a long logo
 * animation: a full-bleed generated visual slams in with a fast push, the hook
 * line punches on top word-group by word-group, an impact SFX lands on frame 2.
 * Props carry the hook types: question, shocking stat, bold claim, or scene teaser.
 */
export type HookKind = "question" | "stat" | "claim" | "teaser";
export type HookOpenProps = {
  bg: string;                 // strongest generated image of the whole video
  line: string;               // the hook sentence
  kind?: HookKind;
  kicker?: string;            // tiny label above the line ("WAIT —", "सच ये है…")
  mood?: string;
  grade?: GradePreset;
  sound?: boolean;
  length?: number;            // keep 30–90 frames (1–3s)
};
export const hookOpenDuration = (p: HookOpenProps) => p.length ?? 72;

export const HookOpen: React.FC<HookOpenProps> = ({ bg, line, kind = "claim", kicker, mood = "dramatic", grade, sound = true, length = 72 }) => {
  const asset = (u: string) => (/^https?:|^data:/.test(u) ? u : staticFile(u));
  const frame = useCurrentFrame();
  const { fps, durationInFrames } = useVideoConfig();
  const L = length || durationInFrames;
  const ease = Easing.bezier(...APPLE_EASE);
  // violent fast push-in that settles — instant energy, never static
  const scale = interpolate(frame, [0, L], [1.34, 1.04], { extrapolateLeft: "clamp", extrapolateRight: "clamp", easing: ease });
  const slam = spring({ frame, fps, config: { damping: 14, mass: 0.7, stiffness: 150 } });
  const shake = frame < 8 ? (8 - frame) * 1.6 : 0;
  const preset: GradePreset = grade ?? gradeForMood(mood);
  const words = line.split(/\s+/);
  const per = Math.max(3, Math.floor((L * 0.55) / Math.max(1, words.length)));
  return (
    <AbsoluteFill style={{ backgroundColor: "#000" }}>
      <ColorGrade preset={preset} grain vignette>
        <AbsoluteFill style={{ transform: `scale(${scale}) translateX(${shake * (frame % 2 === 0 ? 1 : -1)}px)` }}>
          <Img src={asset(bg)} style={{ width: "100%", height: "100%", objectFit: "cover" }} />
        </AbsoluteFill>
        <AbsoluteFill style={{ background: "linear-gradient(180deg, rgba(0,0,0,0.10) 0%, rgba(0,0,0,0.18) 45%, rgba(0,0,0,0.72) 100%)" }} />
      </ColorGrade>
      {sound ? <SfxAt frame={2} name="impact" volume={0.6} /> : null}
      <SFProFaces />
      <AbsoluteFill style={{ justifyContent: "flex-end", alignItems: "center", padding: "0 90px 150px" }}>
        {kicker ? (
          <div style={{ fontFamily: theme.fontDisplay, fontSize: 34, fontWeight: 800, letterSpacing: 6, textTransform: "uppercase", color: theme.accentOnDark, marginBottom: 18, opacity: interpolate(frame, [4, 12], [0, 1], { extrapolateLeft: "clamp", extrapolateRight: "clamp" }) }}>{kicker}</div>
        ) : null}
        <div style={{ display: "flex", flexWrap: "wrap", justifyContent: "center", gap: "10px 22px", maxWidth: 1620, fontFamily: theme.fontDisplay, fontWeight: 800, fontSize: kind === "stat" ? 108 : 92, letterSpacing: -3, lineHeight: 1.06, transform: `scale(${interpolate(slam, [0, 1], [1.25, 1])})`, textShadow: `0 14px 50px rgba(0,0,0,0.8), 0 0 90px ${accentTint(0.25)}` }}>
          {words.map((w, i) => {
            const b = 4 + i * per;
            const o = interpolate(frame, [b, b + 5], [0, 1], { extrapolateLeft: "clamp", extrapolateRight: "clamp" });
            const y = interpolate(frame, [b, b + 7], [46, 0], { extrapolateLeft: "clamp", extrapolateRight: "clamp", easing: ease });
            const hot = kind === "stat" && /[0-9]/.test(w);
            return <span key={i} style={{ display: "inline-block", opacity: o, transform: `translateY(${y}px)`, color: hot ? theme.accentOnDark : "#FFFFFF" }}>{w}</span>;
          })}
        </div>
      </AbsoluteFill>
    </AbsoluteFill>
  );
};
