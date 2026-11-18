import React from "react";
import { AbsoluteFill, Audio, Img, Sequence, interpolate, staticFile, useCurrentFrame, useVideoConfig, Easing } from "remotion";
import { Beat, beatFrames } from "../beatplan";
import { theme, APPLE_EASE } from "../theme";
import { SFProFaces } from "../anim";
import { SfxAt } from "../Sfx";
import { ColorGrade, GradePreset, gradeForMood } from "./ColorGrade";
import { Transitions, TransitionKind, transitionForScene } from "./Transitions";

/**
 * BEAT SEQ — the narration-driven visual timeline. One <BeatSeq> renders a whole
 * explainer: every narration sentence gets its OWN visual (generated image with
 * camera motion), its own kinetic caption, its own transition. The screen keeps
 * evolving while the narrator speaks — this is the anti-slideshow component.
 *
 * narration: parallel <Audio> files per beat (TTS of beat.text) OR one full mix
 * (`voSrc`) laid under the computed beat timings.
 */
export type BeatSeqProps = {
  beats: Beat[];
  voSrc?: string;            // single narration mix aligned to the beat plan
  grade?: GradePreset;
  mood?: string;
  transition?: TransitionKind | "rotate" | "cut";
  captions?: boolean;
};
export const beatSeqDuration = (p: BeatSeqProps) => beatFrames(p.beats ?? [{ text: "x" }]).reduce((a, b) => a + b, 0);

export const BeatSeq: React.FC<BeatSeqProps> = ({ beats, voSrc, grade, mood = "documentary", transition = "rotate", captions = true }) => {
  const { fps, durationInFrames } = useVideoConfig();
  const frames = beatFrames(beats, fps);
  const preset: GradePreset = grade ?? gradeForMood(mood);
  const asset = (u: string) => (/^https?:|^data:/.test(u) ? u : staticFile(u));
  let acc = 0;
  const starts = frames.map((f) => { const s = acc; acc += f; return s; });
  return (
    <AbsoluteFill style={{ backgroundColor: "#0B0B0F" }}>
      {voSrc ? <Audio src={asset(voSrc)} /> : null}
      <ColorGrade preset={preset}>
        {beats.map((b, i) => {
          const cam = b.camera ?? (i % 2 === 0 ? "pushIn" : "driftDiag");
          return (
            <Sequence key={i} from={starts[i]} durationInFrames={frames[i]}>
              <BeatVisual src={b.src} camera={cam} />
              {b.sfx ? <SfxAt frame={2} name={b.sfx} volume={0.4} /> : null}
              {captions && b.text ? <BeatCaption text={b.text} emphasis={b.emphasis ?? []} /> : null}
            </Sequence>
          );
        })}
      </ColorGrade>
      {beats.map((_, i) => {
        if (i === 0) return null;
        const kind = transition === "rotate" ? transitionForScene(i) : transition;
        if (kind === "cut") return null;
        const len = 14;
        return (
          <Sequence key={"t" + i} from={Math.max(0, starts[i] - len / 2)} durationInFrames={len} layout="none">
            <Transitions kind={kind as TransitionKind} length={len} />
          </Sequence>
        );
      })}
    </AbsoluteFill>
  );
};

const BeatVisual: React.FC<{ src?: string; camera: NonNullable<Beat["camera"]> }> = ({ src, camera }) => {
  const frame = useCurrentFrame();
  const { durationInFrames } = useVideoConfig();
  const ease = Easing.bezier(...APPLE_EASE);
  const t = interpolate(frame, [0, durationInFrames], [0, 1], { extrapolateLeft: "clamp", extrapolateRight: "clamp", easing: ease });
  const asset = (u: string) => (/^https?:|^data:/.test(u) ? u : staticFile(u));
  let tr: string;
  switch (camera) {
    case "pullOut": tr = `scale(${1.12 - 0.08 * t})`; break;
    case "panLeft": tr = `scale(1.12) translateX(${t * 4}%)`; break;
    case "panRight": tr = `scale(1.12) translateX(${-t * 4}%)`; break;
    case "panUp": tr = `scale(1.12) translateY(${t * 3}%)`; break;
    case "panDown": tr = `scale(1.12) translateY(${-t * 3}%)`; break;
    case "driftDiag": tr = `scale(${1.02 + 0.08 * t}) translate(${-t * 2}%, ${t * 1.4}%)`; break;
    case "orbit": tr = `scale(1.12) translate(${Math.sin(t * Math.PI * 2) * 1.6}%, ${Math.cos(t * Math.PI * 2) * 1}%)`; break;
    default: tr = `scale(${1.02 + 0.1 * t})`;
  }
  if (!src) return <AbsoluteFill style={{ background: `linear-gradient(135deg, ${theme.ink} 0%, #1a1030 100%)` }} />;
  return (
    <AbsoluteFill style={{ transform: tr, overflow: "hidden" }}>
      <Img src={asset(src)} style={{ width: "100%", height: "100%", objectFit: "cover" }} />
    </AbsoluteFill>
  );
};

/** Caption that never hides the subject: bottom scrim only, concise text, emphasis pops. */
const BeatCaption: React.FC<{ text: string; emphasis: string[] }> = ({ text, emphasis }) => {
  const frame = useCurrentFrame();
  const words = text.split(/\s+/);
  const per = Math.max(3, Math.floor(70 / Math.max(1, words.length) * 2));
  const strip = (x: string) => x.replace(/[.,!?।:;"""]/g, "").toLowerCase();
  return (
    <AbsoluteFill style={{ justifyContent: "flex-end", pointerEvents: "none" }}>
      <AbsoluteFill style={{ background: "linear-gradient(180deg, rgba(0,0,0,0) 62%, rgba(0,0,0,0.55) 100%)" }} />
      <SFProFaces />
      <div style={{ padding: "0 110px 84px", display: "flex", flexWrap: "wrap", gap: "6px 18px", justifyContent: "center", fontFamily: `${theme.fontDisplay}, "Kohinoor Devanagari", sans-serif`, fontWeight: 700, fontSize: 56, letterSpacing: -1.4, lineHeight: 1.18, textShadow: "0 6px 26px rgba(0,0,0,0.85)" }}>
        {words.map((w, i) => {
          const b = i * per;
          const o = interpolate(frame, [b, b + 5], [0, 1], { extrapolateLeft: "clamp", extrapolateRight: "clamp" });
          const hot = emphasis.some((e) => strip(w) === strip(e));
          return <span key={i} style={{ opacity: o, color: hot ? theme.accentOnDark : "#fff" }}>{w}</span>;
        })}
      </div>
    </AbsoluteFill>
  );
};
