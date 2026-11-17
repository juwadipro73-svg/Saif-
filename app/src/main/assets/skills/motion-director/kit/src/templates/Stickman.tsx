import React from "react";
import { interpolate, useCurrentFrame, useVideoConfig } from "remotion";

/**
 * STICKMAN — procedural, code-driven character rig for CINEMATIC STORY MODE.
 * No static images: every pose is computed per frame from a walk/run cycle,
 * so characters actually WALK, RUN, JUMP, SIT, GESTURE and TALK.
 *
 * CHARACTER CONSISTENCY: one `CharacterSheet` object per character ID defines
 * proportions + colors + accessory ONCE; every scene renders from the same
 * sheet, so the character never changes identity mid-story.
 */
export type Expression = "neutral" | "happy" | "sad" | "angry" | "shocked" | "determined" | "thinking";
export type StickAction = "stand" | "walk" | "run" | "jump" | "sit" | "fall" | "point" | "wave" | "talk" | "turn" | "climb" | "celebrate";

export type CharacterSheet = {
  id: string;
  /** head radius in scene units (default 26) */
  head?: number;
  /** torso length (default 78) */
  torso?: number;
  /** limb length upper/lower (default 52/50) */
  arm?: number;
  leg?: number;
  stroke?: number;
  color?: string;        // limb/ink color
  headFill?: string;     // head fill (classic: white head, black outline)
  accessory?: "none" | "cap" | "tie" | "crown" | "glasses" | "scarf" | "briefcase";
  accessoryColor?: string;
};

export type StickmanProps = {
  sheet: CharacterSheet;
  action?: StickAction;
  expression?: Expression;
  /** facing: 1 = right, -1 = left */
  facing?: 1 | -1;
  /** cycle speed multiplier (walk 1, run ~1.9) */
  speed?: number;
  /** talking: mouth flaps on these beats (frames within the clip) */
  talkBeats?: number[];
  /** whole-body position offset in % of frame */
  x?: number;
  y?: number;
  scale?: number;
};

const cyc = (frame: number, speed: number, phase = 0) => Math.sin((frame / 9) * speed + phase);

/** Joint solver: returns angles (radians) for the current action + frame. */
function pose(action: StickAction, frame: number, speed: number) {
  const c = cyc(frame, speed);
  const c2 = cyc(frame, speed, Math.PI);
  switch (action) {
    case "walk":  return { hipL: 0.55 * c, hipR: 0.55 * c2, kneeL: 0.35 * Math.max(0, c2), kneeR: 0.35 * Math.max(0, c), shL: 0.45 * c2, shR: 0.45 * c, elL: 0.25, elR: 0.25, bob: 2.2 * Math.abs(c), lean: 0.06 };
    case "run":   return { hipL: 0.95 * c, hipR: 0.95 * c2, kneeL: 0.9 * Math.max(0, c2), kneeR: 0.9 * Math.max(0, c), shL: 0.85 * c2, shR: 0.85 * c, elL: 0.9, elR: 0.9, bob: 4.5 * Math.abs(c), lean: 0.22 };
    case "jump": {
      const t = Math.min(1, frame / 45);
      const air = Math.sin(t * Math.PI);
      return { hipL: -0.9 + 1.4 * (1 - air), hipR: -0.7 + 1.2 * (1 - air), kneeL: 1.2 * (1 - air), kneeR: 1.0 * (1 - air), shL: -2.2 * air - 0.3, shR: -2.4 * air - 0.3, elL: 0.3, elR: 0.3, bob: -70 * air, lean: 0.1 * air };
    }
    case "sit":   return { hipL: -1.45, hipR: -1.45, kneeL: 1.45, kneeR: 1.45, shL: 0.25, shR: 0.2, elL: 0.5, elR: 0.4, bob: 46, lean: 0.05 };
    case "fall": {
      const t = Math.min(1, frame / 40);
      return { hipL: -0.4 - 1.1 * t, hipR: 0.3 - 1.3 * t, kneeL: 0.5 * t, kneeR: 0.7 * t, shL: -1.9 * t, shR: -2.3 * t, elL: 0.5, elR: 0.4, bob: 90 * t * t, lean: 1.15 * t };
    }
    case "point": return { hipL: 0.12, hipR: -0.12, kneeL: 0.06, kneeR: 0.06, shL: 0.3, shR: -1.45, elL: 0.3, elR: 0.03, bob: 1.5 * Math.sin(frame / 14), lean: 0.04 };
    case "wave":  return { hipL: 0.08, hipR: -0.08, kneeL: 0.04, kneeR: 0.04, shL: 0.3, shR: -2.5 + 0.35 * Math.sin(frame / 4), elL: 0.3, elR: 0.5 + 0.4 * Math.sin(frame / 4), bob: 1.5 * Math.sin(frame / 16), lean: 0 };
    case "talk":  return { hipL: 0.05, hipR: -0.05, kneeL: 0.03, kneeR: 0.03, shL: 0.35 + 0.12 * Math.sin(frame / 11), shR: -0.35 - 0.12 * Math.sin(frame / 13), elL: 0.4, elR: 0.4, bob: 1.2 * Math.sin(frame / 15), lean: 0.02 };
    case "turn": {
      const t = Math.min(1, frame / 30);
      return { hipL: 0.2 * t, hipR: -0.2 * t, kneeL: 0.1 * t, kneeR: 0.1 * t, shL: 0.3, shR: -0.3, elL: 0.3, elR: 0.3, bob: 2 * t, lean: 0.1 * t };
    }
    case "climb": return { hipL: 0.9 * c, hipR: 0.9 * c2, kneeL: 0.8 * Math.max(0, c), kneeR: 0.8 * Math.max(0, c2), shL: -2.2 + 0.9 * c2, shR: -2.2 + 0.9 * c, elL: 0.7, elR: 0.7, bob: 3 * c - 30 * (frame / 60), lean: 0.15 };
    case "celebrate": return { hipL: 0.3 * c, hipR: 0.3 * c2, kneeL: 0.4 * Math.abs(c), kneeR: 0.4 * Math.abs(c2), shL: -2.6 + 0.3 * c, shR: -2.6 + 0.3 * c2, elL: 0.35, elR: 0.35, bob: 8 * Math.abs(c) - 6, lean: 0 };
    default:      return { hipL: 0.04, hipR: -0.04, kneeL: 0.02, kneeR: 0.02, shL: 0.18 + 0.05 * Math.sin(frame / 20), shR: -0.18 - 0.05 * Math.sin(frame / 20), elL: 0.15, elR: 0.15, bob: 1.1 * Math.sin(frame / 22), lean: 0 };
  }
}

const Face: React.FC<{ r: number; expr: Expression; frame: number; talking: boolean; color: string }> = ({ r, expr, frame, talking, color }) => {
  const ex = r * 0.34, ey = -r * 0.12;
  const eyes = expr === "shocked"
    ? <><circle cx={-ex} cy={ey} r={r * 0.14} fill={color} /><circle cx={ex} cy={ey} r={r * 0.14} fill={color} /></>
    : <><line x1={-ex - r * 0.12} y1={ey} x2={-ex + r * 0.12} y2={ey} stroke={color} strokeWidth={r * 0.09} strokeLinecap="round" /><line x1={ex - r * 0.12} y1={ey} x2={ex + r * 0.12} y2={ey} stroke={color} strokeWidth={r * 0.09} strokeLinecap="round" /></>;
  let mouth: React.ReactNode = <line x1={-r * 0.22} y1={r * 0.38} x2={r * 0.22} y2={r * 0.38} stroke={color} strokeWidth={r * 0.08} strokeLinecap="round" />;
  if (talking) {
    const open = r * (0.10 + 0.14 * Math.abs(Math.sin(frame / 3.2)));
    mouth = <ellipse cx={0} cy={r * 0.4} rx={r * 0.16} ry={open} fill={color} />;
  } else if (expr === "happy" || expr === "determined") mouth = <path d={`M ${-r * 0.24} ${r * 0.32} Q 0 ${r * 0.56} ${r * 0.24} ${r * 0.32}`} stroke={color} strokeWidth={r * 0.08} fill="none" strokeLinecap="round" />;
  else if (expr === "sad") mouth = <path d={`M ${-r * 0.22} ${r * 0.48} Q 0 ${r * 0.26} ${r * 0.22} ${r * 0.48}`} stroke={color} strokeWidth={r * 0.08} fill="none" strokeLinecap="round" />;
  else if (expr === "angry") mouth = <><line x1={-r * 0.2} y1={r * 0.42} x2={r * 0.2} y2={r * 0.36} stroke={color} strokeWidth={r * 0.09} strokeLinecap="round" /><line x1={-ex - r * 0.16} y1={ey - r * 0.22} x2={-ex + r * 0.14} y2={ey - r * 0.1} stroke={color} strokeWidth={r * 0.08} strokeLinecap="round" /><line x1={ex + r * 0.16} y1={ey - r * 0.22} x2={ex - r * 0.14} y2={ey - r * 0.1} stroke={color} strokeWidth={r * 0.08} strokeLinecap="round" /></>;
  else if (expr === "shocked") mouth = <ellipse cx={0} cy={r * 0.42} rx={r * 0.14} ry={r * 0.2} fill={color} />;
  else if (expr === "thinking") mouth = <line x1={-r * 0.1} y1={r * 0.4} x2={r * 0.2} y2={r * 0.36} stroke={color} strokeWidth={r * 0.08} strokeLinecap="round" />;
  return <>{eyes}{mouth}</>;
};

export const Stickman: React.FC<StickmanProps> = ({ sheet, action = "stand", expression = "neutral", facing = 1, speed = action === "run" ? 1.9 : 1, talkBeats = [], x = 50, y = 72, scale = 1 }) => {
  const frame = useCurrentFrame();
  const { fps } = useVideoConfig();
  const head = sheet.head ?? 26, torso = sheet.torso ?? 78, armU = sheet.arm ?? 52, legU = sheet.leg ?? 50;
  const sw = sheet.stroke ?? 9;
  const ink = sheet.color ?? "#0B0B0F";
  const headFill = sheet.headFill ?? "#FFFFFF";
  const p = pose(action, frame, speed);
  const talking = action === "talk" || talkBeats.some((b) => Math.abs(frame - b) < fps * 0.6);

  // limb endpoint from an origin, angle (0 = straight down) and length
  const seg = (ox: number, oy: number, a: number, len: number) => ({ x: ox + Math.sin(a) * len, y: oy + Math.cos(a) * len });
  const hipY = torso;
  const shY = 6; // shoulder line just below neck
  // angle 0 = hanging straight down; negative swings forward/up (point, wave, celebrate)
  const lArm1 = seg(0, shY, p.shL + p.lean, armU * 0.55);
  const lArm2 = seg(lArm1.x, lArm1.y, p.shL + p.lean + p.elL, armU * 0.55);
  const rArm1 = seg(0, shY, p.shR + p.lean, armU * 0.55);
  const rArm2 = seg(rArm1.x, rArm1.y, p.shR + p.lean + p.elR, armU * 0.55);
  const lLeg1 = seg(0, hipY, p.hipL, legU * 0.55);
  const lLeg2 = seg(lLeg1.x, lLeg1.y, p.hipL + p.kneeL, legU * 0.55);
  const rLeg1 = seg(0, hipY, p.hipR, legU * 0.55);
  const rLeg2 = seg(rLeg1.x, rLeg1.y, p.hipR + p.kneeR, legU * 0.55);
  // forward travel for walk/run so the character crosses the frame
  const travelPx = action === "walk" ? frame * 2.4 * speed * facing : action === "run" ? frame * 5.2 * speed * facing : 0;

  const W = 420, H = 420;
  return (
    <div style={{ position: "absolute", left: `${x}%`, top: `${y}%`, transform: `translate(-50%, -50%) translateX(${travelPx}px) scale(${facing * scale}, ${scale})` }}>
      <svg width={W} height={H} viewBox={`${-W / 2} ${-head - 12} ${W} ${H}`} style={{ overflow: "visible" }}>
        <g transform={`translate(0, ${p.bob}) rotate(${(p.lean * 180) / Math.PI})`}>
          {/* legs */}
          <path d={`M 0 ${hipY} L ${lLeg1.x} ${lLeg1.y} L ${lLeg2.x} ${lLeg2.y}`} stroke={ink} strokeWidth={sw} fill="none" strokeLinecap="round" strokeLinejoin="round" />
          <path d={`M 0 ${hipY} L ${rLeg1.x} ${rLeg1.y} L ${rLeg2.x} ${rLeg2.y}`} stroke={ink} strokeWidth={sw} fill="none" strokeLinecap="round" strokeLinejoin="round" />
          {/* torso */}
          <line x1={0} y1={shY - 4} x2={0} y2={hipY} stroke={ink} strokeWidth={sw + 1} strokeLinecap="round" />
          {/* arms */}
          <path d={`M 0 ${shY} L ${lArm1.x} ${lArm1.y} L ${lArm2.x} ${lArm2.y}`} stroke={ink} strokeWidth={sw} fill="none" strokeLinecap="round" strokeLinejoin="round" />
          <path d={`M 0 ${shY} L ${rArm1.x} ${rArm1.y} L ${rArm2.x} ${rArm2.y}`} stroke={ink} strokeWidth={sw} fill="none" strokeLinecap="round" strokeLinejoin="round" />
          {/* head */}
          <circle cx={0} cy={-head * 0.55} r={head} fill={headFill} stroke={ink} strokeWidth={sw} />
          <g transform={`translate(0, ${-head * 0.55})`}>
            <Face r={head} expr={expression} frame={frame} talking={talking} color={ink} />
          </g>
          {/* accessories — part of the identity sheet, never improvised per scene */}
          {sheet.accessory === "cap" ? <path d={`M ${-head} ${-head * 1.05} A ${head} ${head} 0 0 1 ${head} ${-head * 1.05} L ${head * 1.5} ${-head * 1.02} L ${head * 1.5} ${-head * 0.86} L ${-head} ${-head * 0.9} Z`} fill={sheet.accessoryColor ?? "#E11D48"} /> : null}
          {sheet.accessory === "tie" ? <path d={`M 0 ${shY + 4} l ${-7} 14 l 7 30 l 7 -30 Z`} fill={sheet.accessoryColor ?? "#2563EB"} /> : null}
          {sheet.accessory === "crown" ? <path d={`M ${-head * 0.7} ${-head * 1.5} l ${head * 0.35} ${head * 0.4} l ${head * 0.35} ${-head * 0.55} l ${head * 0.35} ${head * 0.55} l ${head * 0.35} ${-head * 0.4} l 0 ${head * 0.62} l ${-head * 1.4} 0 Z`} fill={sheet.accessoryColor ?? "#F59E0B"} stroke="#92400E" strokeWidth={2} /> : null}
          {sheet.accessory === "glasses" ? <g stroke={ink} strokeWidth={3} fill="none"><circle cx={-head * 0.34} cy={-head * 0.67} r={head * 0.2} /><circle cx={head * 0.34} cy={-head * 0.67} r={head * 0.2} /><line x1={-head * 0.14} y1={-head * 0.67} x2={head * 0.14} y2={-head * 0.67} /></g> : null}
          {sheet.accessory === "scarf" ? <path d={`M ${-head * 0.75} ${shY - 8} q ${head * 0.75} 12 ${head * 1.5} 0 l 4 26 l -12 2 Z`} fill={sheet.accessoryColor ?? "#10B981"} /> : null}
          {sheet.accessory === "briefcase" ? <g transform={`translate(${rArm2.x}, ${rArm2.y})`}><rect x={-16} y={0} width={32} height={24} rx={3} fill={sheet.accessoryColor ?? "#7C3AED"} /><rect x={-6} y={-5} width={12} height={6} rx={2} fill="none" stroke={sheet.accessoryColor ?? "#7C3AED"} strokeWidth={3} /></g> : null}
        </g>
      </svg>
    </div>
  );
};
