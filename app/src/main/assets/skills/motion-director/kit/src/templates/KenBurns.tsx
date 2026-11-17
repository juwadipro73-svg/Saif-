import React from "react";
import { AbsoluteFill, Img, interpolate, staticFile, useCurrentFrame, useVideoConfig, Easing } from "remotion";
import { APPLE_EASE } from "../theme";

/**
 * KEN BURNS / CAMERA MOTION — every generated image must MOVE. Static images
 * on screen for >3s are forbidden. Supports push-in, pull-out, pans, diagonal
 * drift and 2.5D parallax (foreground layer moves faster than background).
 */
export type CameraMove = "pushIn" | "pullOut" | "panLeft" | "panRight" | "panUp" | "panDown" | "driftDiag" | "orbit";
export type KenBurnsProps = {
  src: string;                 // generated background image (public/…)
  fgSrc?: string;              // optional foreground cutout for 2.5D parallax
  move?: CameraMove;
  /** total scale travel, e.g. 0.12 = 112% at the end (default) */
  travel?: number;
  length?: number;
  focusX?: number;             // 0–1 subject anchor
  focusY?: number;
};
export const kenBurnsDuration = (p: KenBurnsProps) => p.length ?? 120;

export const KenBurns: React.FC<KenBurnsProps> = ({ src, fgSrc, move = "pushIn", travel = 0.12, length = 120, focusX = 0.5, focusY = 0.5 }) => {
  const asset = (u: string) => (/^https?:|^data:/.test(u) ? u : staticFile(u));
  const frame = useCurrentFrame();
  const { durationInFrames } = useVideoConfig();
  const L = length || durationInFrames;
  const t = interpolate(frame, [0, L], [0, 1], { extrapolateLeft: "clamp", extrapolateRight: "clamp", easing: Easing.bezier(...APPLE_EASE) });
  const s = (k: number) => 1 + k * travel;
  const px = (k: number) => k * travel * 100;
  let bg: React.CSSProperties;
  switch (move) {
    case "pullOut":  bg = { transform: `scale(${s(1 - t)})` }; break;
    case "panLeft":  bg = { transform: `scale(${s(1)}) translateX(${px(t) * 0.5}%)` }; break;
    case "panRight": bg = { transform: `scale(${s(1)}) translateX(${-px(t) * 0.5}%)` }; break;
    case "panUp":    bg = { transform: `scale(${s(1)}) translateY(${px(t) * 0.5}%)` }; break;
    case "panDown":  bg = { transform: `scale(${s(1)}) translateY(${-px(t) * 0.5}%)` }; break;
    case "driftDiag":bg = { transform: `scale(${s(t)}) translate(${-px(t) * 0.3}%, ${px(t) * 0.2}%)` }; break;
    case "orbit":    bg = { transform: `scale(${s(1)}) translate(${Math.sin(t * Math.PI * 2) * travel * 30}%, ${Math.cos(t * Math.PI * 2) * travel * 18}%)` }; break;
    default:         bg = { transform: `scale(${s(t)}) translate(${(0.5 - focusX) * travel * 40}%, ${(0.5 - focusY) * travel * 40}%)` };
  }
  return (
    <AbsoluteFill style={{ overflow: "hidden", backgroundColor: "#000" }}>
      <AbsoluteFill style={bg}>
        <Img src={asset(src)} style={{ width: "100%", height: "100%", objectFit: "cover", objectPosition: `${focusX * 100}% ${focusY * 100}%` }} />
      </AbsoluteFill>
      {fgSrc ? (
        <AbsoluteFill style={{ transform: `scale(${s(1 + t * 0.6)}) translateX(${-px(t) * 1.4}%)`, transformOrigin: `${focusX * 100}% ${focusY * 100}%` }}>
          <Img src={asset(fgSrc)} style={{ width: "100%", height: "100%", objectFit: "contain" }} />
        </AbsoluteFill>
      ) : null}
    </AbsoluteFill>
  );
};
