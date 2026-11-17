import React from "react";
import { AbsoluteFill, useCurrentFrame, useVideoConfig, interpolate } from "remotion";

/**
 * COLOR GRADE — cinematic color correction layer. Wrap ANY scene (footage,
 * generated image, typography) in <ColorGrade preset="tealOrange">…</ColorGrade>
 * to fix flat/washed AI-generated visuals: lift-mid-drop curves via CSS filters,
 * split-tone wash, vignette, optional deterministic film grain.
 * Every rendered video MUST grade its imagery — raw generated images are never
 * color-correct and must not go to screen untouched.
 */
export type GradePreset =
  | "tealOrange"  // blockbuster: warm skin/highlights, teal shadows
  | "warmSun"     // golden-hour, inspirational/motivational
  | "coolNight"   // mystery/suspense/horror-fiction night look
  | "noir"        // desaturated high-contrast documentary/drama
  | "vivid"       // punchy social/promo
  | "softDream"   // low-contrast pastel, emotional/romantic
  | "documentary" // neutral-but-corrected: the safe factual look
  | "none";

type GradeDef = { filter: string; wash?: string; washOpacity?: number; vignette: number; grain?: number };
const GRADES: Record<GradePreset, GradeDef> = {
  tealOrange:  { filter: "contrast(1.14) saturate(1.18) brightness(1.02) sepia(0.10) hue-rotate(-8deg)", wash: "linear-gradient(180deg, rgba(255,150,60,0.10) 0%, rgba(0,0,0,0) 45%, rgba(10,80,110,0.16) 100%)", vignette: 0.34, grain: 0.05 },
  warmSun:     { filter: "contrast(1.08) saturate(1.14) brightness(1.05) sepia(0.16)", wash: "linear-gradient(180deg, rgba(255,190,90,0.14), rgba(255,120,40,0.05))", vignette: 0.26, grain: 0.04 },
  coolNight:   { filter: "contrast(1.16) saturate(0.92) brightness(0.92) hue-rotate(12deg)", wash: "linear-gradient(180deg, rgba(20,40,90,0.20), rgba(5,10,30,0.28))", vignette: 0.44, grain: 0.07 },
  noir:        { filter: "contrast(1.30) saturate(0.35) brightness(0.98)", vignette: 0.40, grain: 0.08 },
  vivid:       { filter: "contrast(1.18) saturate(1.35) brightness(1.03)", vignette: 0.22 },
  softDream:   { filter: "contrast(0.94) saturate(1.05) brightness(1.07) blur(0.2px)", wash: "linear-gradient(180deg, rgba(255,220,240,0.10), rgba(200,220,255,0.08))", vignette: 0.18 },
  documentary: { filter: "contrast(1.10) saturate(1.06) brightness(1.01)", vignette: 0.24, grain: 0.03 },
  none:        { filter: "none", vignette: 0 },
};

export type ColorGradeProps = {
  preset?: GradePreset;
  /** 0–1 strength of the whole look (0 = bypass). */
  intensity?: number;
  grain?: boolean;
  vignette?: boolean;
  children?: React.ReactNode;
};

export const ColorGrade: React.FC<ColorGradeProps> = ({ preset = "tealOrange", intensity = 1, grain = true, vignette = true, children }) => {
  const frame = useCurrentFrame();
  const { durationInFrames } = useVideoConfig();
  const g = GRADES[preset] ?? GRADES.tealOrange;
  const k = Math.max(0, Math.min(1, intensity));
  if (preset === "none" || k === 0) return <AbsoluteFill>{children}</AbsoluteFill>;
  // Deterministic grain: quantized frame-seeded shift of an SVG turbulence tile.
  const seed = Math.floor(frame / 2) % 8;
  const grainCss = `url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" width="160" height="160"><filter id="n${seed}"><feTurbulence type="fractalNoise" baseFrequency="0.9" numOctaves="2" seed="${seed + 3}"/></filter><rect width="160" height="160" filter="url(%23n${seed})" opacity="${(g.grain ?? 0) * k}"/></svg>')`;
  const fadeIn = interpolate(frame, [0, 8], [0.4, 1], { extrapolateLeft: "clamp", extrapolateRight: "clamp" });
  const fadeOut = interpolate(frame, [durationInFrames - 8, durationInFrames], [1, 0.4], { extrapolateLeft: "clamp", extrapolateRight: "clamp" });
  return (
    <AbsoluteFill>
      <AbsoluteFill style={{ filter: g.filter }}>{children}</AbsoluteFill>
      {g.wash ? <AbsoluteFill style={{ background: g.wash, opacity: (g.washOpacity ?? 1) * k * 0.9, mixBlendMode: "soft-light" }} /> : null}
      {grain && g.grain ? <AbsoluteFill style={{ backgroundImage: grainCss, opacity: k * fadeIn * fadeOut, mixBlendMode: "overlay", pointerEvents: "none" }} /> : null}
      {vignette && g.vignette ? <AbsoluteFill style={{ background: `radial-gradient(ellipse at center, rgba(0,0,0,0) 52%, rgba(0,0,0,${g.vignette * k}) 100%)`, pointerEvents: "none" }} /> : null}
    </AbsoluteFill>
  );
};

/** Pick a grade from the story/video mood — keeps palette, mood and picture consistent. */
export const gradeForMood = (mood: string): GradePreset => {
  const m = mood.toLowerCase();
  if (/(emotional|romantic|soft)/.test(m)) return "softDream";
  if (/(inspirational|motivational|uplift)/.test(m)) return "warmSun";
  if (/(mystery|suspense|horror|thriller|night)/.test(m)) return "coolNight";
  if (/(drama|noir|crime)/.test(m)) return "noir";
  if (/(comedy|promo|social|vivid|energetic)/.test(m)) return "vivid";
  if (/(educational|documentary|factual|news|explainer)/.test(m)) return "documentary";
  return "tealOrange";
};
