/**
 * BEAT PLANNER — narration-synchronized timing math shared by BeatSeq and the
 * scene-plan tooling. Scene durations come from the NARRATION, not from guesses:
 * words → seconds at the speaking rate, clamped to cinematic beat targets.
 */
export type Beat = {
  /** narration sentence/phrase spoken over this beat */
  text: string;
  /** visual for this beat: generated image path/url, or a kit template id */
  src?: string;
  camera?: "pushIn" | "pullOut" | "panLeft" | "panRight" | "panUp" | "panDown" | "driftDiag" | "orbit";
  /** on-screen emphasis word(s) for kinetic captions */
  emphasis?: string[];
  /** override the computed duration (frames) */
  frames?: number;
  sfx?: string;
};

/** Hindi/English narration averages ~2.6 words/sec; clamp to beat targets. */
export const beatDuration = (text: string, fps = 30, wps = 2.6): number => {
  const words = text.trim().split(/\s+/).filter(Boolean).length;
  const secs = Math.min(6, Math.max(1.2, words / wps + 0.6)); // 1-2s quick, 2-4s standard, 4-6s detailed
  return Math.round(secs * fps);
};

export const beatFrames = (beats: Beat[], fps = 30): number[] =>
  beats.map((b) => b.frames ?? beatDuration(b.text, fps));

export const totalFrames = (beats: Beat[], fps = 30): number =>
  beatFrames(beats, fps).reduce((a, b) => a + b, 0);

/** Warn when a plan is slideshow-ish: too few beats for the runtime, or repeats. */
export const planIssues = (beats: Beat[], fps = 30): string[] => {
  const issues: string[] = [];
  const total = totalFrames(beats, fps);
  const mins = total / fps / 60;
  const expected = Math.round(mins * 20); // ~20 beats/min lower bound (target 25-40 per 2min)
  if (beats.length < expected) issues.push(`only ${beats.length} beats for ${mins.toFixed(1)} min - aim for >= ${expected}`);
  beats.forEach((b, i) => {
    const f = (b.frames ?? beatDuration(b.text, fps)) / fps;
    if (f > 6.5) issues.push(`beat ${i + 1} runs ${f.toFixed(1)}s - split it or justify the long hold`);
    if (i > 0 && b.src && b.src === beats[i - 1].src) issues.push(`beat ${i + 1} reuses the previous background (${b.src})`);
    if (!b.src) issues.push(`beat ${i + 1} has no visual asset - generate one or reuse deliberately`);
  });
  return issues;
};
