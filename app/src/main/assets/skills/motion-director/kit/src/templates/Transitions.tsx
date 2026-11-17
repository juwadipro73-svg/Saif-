import React from "react";
import { AbsoluteFill, interpolate, useCurrentFrame, useVideoConfig, Easing } from "remotion";
import { APPLE_EASE, theme } from "../theme";

/**
 * TRANSITIONS — professional between-scene transitions. Render as an overlay
 * Sequence straddling two scenes (half over the outgoing, half over the incoming)
 * or as a standalone wipe. Rotate kinds across a video — never use the same
 * transition more than twice in a row; prefer clean cuts for rhythm sections.
 */
export type TransitionKind =
  | "zoomThrough"   // fast scale + blur punch — high energy
  | "whipPan"       // directional blur swipe L→R (or pan prop)
  | "lightSweep"    // cinematic glare bar across frame
  | "blurDip"       // defocus out/in — time passing
  | "maskReveal"    // circle/rect iris open
  | "wipeLeft" | "wipeRight" | "wipeUp" | "wipeDown"
  | "flashCut"      // 3-frame white hit — impact moments
  | "filmBurn";     // warm burn edge — nostalgic/emotional

export type TransitionsProps = {
  kind?: TransitionKind;
  pan?: "left" | "right" | "up" | "down";
  /** frames for the full transition (default 18 ≈ 0.6s @30fps) */
  length?: number;
  color?: string;
};
export const transitionsDuration = (p: TransitionsProps = {}) => p.length ?? 18;

export const Transitions: React.FC<TransitionsProps> = ({ kind = "zoomThrough", pan = "left", length = 18, color = "#FFFFFF" }) => {
  const frame = useCurrentFrame();
  const { durationInFrames } = useVideoConfig();
  const L = length || durationInFrames;
  const t = interpolate(frame, [0, L], [0, 1], { extrapolateLeft: "clamp", extrapolateRight: "clamp", easing: Easing.bezier(...APPLE_EASE) });
  const mid = t < 0.5;
  const col = color;

  if (kind === "flashCut") {
    const o = interpolate(frame, [0, 2, L], [0, 0.92, 0], { extrapolateLeft: "clamp", extrapolateRight: "clamp" });
    return <AbsoluteFill style={{ backgroundColor: col, opacity: o }} />;
  }
  if (kind === "zoomThrough") {
    const scale = interpolate(t, [0, 1], [1, mid ? 2.6 : 1], { extrapolateRight: "clamp" });
    const blur = interpolate(t, [0, 0.5, 1], [0, 26, 0]);
    const o = interpolate(t, [0, 0.5, 1], [0, 1, 0]);
    return <AbsoluteFill style={{ backgroundColor: "#000", opacity: o * 0.9, transform: `scale(${mid ? scale : 1})`, filter: `blur(${(mid ? blur : blur) * 0.3}px)` }} />;
  }
  if (kind === "whipPan") {
    const x = interpolate(t, [0, 1], [-110, 110]);
    return (
      <AbsoluteFill style={{ overflow: "hidden" }}>
        <AbsoluteFill style={{ transform: `translateX(${x}%)`, filter: "blur(18px)", background: `linear-gradient(${pan === "right" ? 270 : 90}deg, rgba(0,0,0,0) 0%, ${col} 30%, #111 70%, rgba(0,0,0,0) 100%)`, opacity: 0.9 }} />
      </AbsoluteFill>
    );
  }
  if (kind === "lightSweep") {
    const x = interpolate(t, [0, 1], [-60, 160]);
    return (
      <AbsoluteFill style={{ overflow: "hidden", mixBlendMode: "screen" }}>
        <AbsoluteFill style={{ transform: `translateX(${x}%) skewX(-18deg)`, background: `linear-gradient(90deg, rgba(255,255,255,0) 0%, rgba(255,255,255,0.85) 50%, rgba(255,255,255,0) 100%)`, width: "45%", filter: "blur(6px)" }} />
      </AbsoluteFill>
    );
  }
  if (kind === "blurDip") {
    const b = interpolate(t, [0, 0.5, 1], [0, 30, 0]);
    const o = interpolate(t, [0, 0.5, 1], [0, 0.55, 0]);
    return <AbsoluteFill style={{ backdropFilter: `blur(${b}px)`, backgroundColor: "#000", opacity: o + b / 90 }} />;
  }
  if (kind === "maskReveal") {
    const r = interpolate(t, [0, 1], [0, 150]);
    return <AbsoluteFill style={{ background: "#000", WebkitMaskImage: `radial-gradient(circle at 50% 50%, transparent ${r}%, black ${r + 8}%)`, maskImage: `radial-gradient(circle at 50% 50%, transparent ${r}%, black ${r + 8}%)` }} />;
  }
  if (kind === "filmBurn") {
    const o = interpolate(t, [0, 0.5, 1], [0, 1, 0]);
    return (
      <AbsoluteFill style={{ opacity: o * 0.85, mixBlendMode: "screen" }}>
        <AbsoluteFill style={{ background: "radial-gradient(ellipse at 20% 30%, rgba(255,140,50,0.9), rgba(255,60,20,0.25) 55%, rgba(0,0,0,0) 80%)" }} />
        <AbsoluteFill style={{ background: "radial-gradient(ellipse at 80% 70%, rgba(255,200,120,0.7), rgba(0,0,0,0) 60%)" }} />
      </AbsoluteFill>
    );
  }
  // directional wipes
  const axis = kind === "wipeUp" || kind === "wipeDown" ? "Y" : "X";
  const dir = kind === "wipeRight" || kind === "wipeDown" ? 1 : -1;
  const p = interpolate(t, [0, 1], [dir * -105, dir * 105]);
  return <AbsoluteFill style={{ backgroundColor: "#0B0B0F", transform: `translate${axis}(${p}%)`, boxShadow: `0 0 80px rgba(0,0,0,0.6)` }} />;
};

/** Rotation helper so the director never repeats the same transition twice in a row. */
export const TRANSITION_ROTATION: TransitionKind[] = ["zoomThrough", "wipeLeft", "lightSweep", "blurDip", "whipPan", "maskReveal", "filmBurn", "wipeUp", "flashCut"];
export const transitionForScene = (i: number): TransitionKind => TRANSITION_ROTATION[i % TRANSITION_ROTATION.length];
