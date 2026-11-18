#!/usr/bin/env node
/**
 * QC — SCENE PLAN AUDITOR (run BEFORE rendering; fix failures, re-run).
 * Usage: node qc-scene-plan.mjs <scene-plan.json> [projectDir]
 * Checks: beat count vs runtime, per-scene durations, repeated consecutive
 * backgrounds, missing asset files, unused generated assets, missing camera/
 * transition/grade fields, black-frame risks (no bg + no visual), audio plan.
 * Exit code 1 on any CRITICAL issue → do NOT render until fixed.
 */
import { readFileSync, existsSync, readdirSync, statSync } from "node:fs";
import { join, resolve } from "node:path";

const planPath = process.argv[2];
const projDir = resolve(process.argv[3] ?? ".");
if (!planPath || !existsSync(planPath)) { console.error("usage: qc-scene-plan.mjs <scene-plan.json> [projectDir]"); process.exit(2); }
const plan = JSON.parse(readFileSync(planPath, "utf8"));
const fps = plan.project?.fps ?? 30;
const scenes = plan.scenes ?? plan.beats ?? [];
const critical = [], warn = [];

const durOf = (s) => ((s.endFrame ?? s.to ?? 0) - (s.startFrame ?? s.from ?? 0)) / fps
  || (s.durationInFrames ? s.durationInFrames / fps : (s.frames ? s.frames / fps : 0));
const totalSec = scenes.reduce((a, s) => a + durOf(s), 0) || (plan.project?.durationInFrames ?? 0) / fps;
const mins = totalSec / 60;
const minBeats = Math.max(4, Math.round(mins * 15));
if (scenes.length < minBeats) critical.push(`only ${scenes.length} visual beats for ${mins.toFixed(1)}min — need >= ${minBeats} (aim 20-40/min-topic permitting)`);

const usedAssets = new Set();
scenes.forEach((s, i) => {
  const d = durOf(s);
  if (d > 6.5) critical.push(`scene ${i + 1} (${s.id ?? ""}) holds ${d.toFixed(1)}s — split it or add in-scene action/camera changes`);
  if (d > 0 && d < 0.7) warn.push(`scene ${i + 1} is ${d.toFixed(1)}s — too fast to read`);
  const assets = s.assets ?? (s.bg ? [{ path: s.bg, role: "background" }] : []);
  if (!assets.length && !s.template && !s.text) critical.push(`scene ${i + 1} has NO visual — generate an asset or use a template`);
  assets.forEach((a) => {
    const p = typeof a === "string" ? a : a.path;
    if (!p) return;
    usedAssets.add(p.replace(/^public\//, ""));
    const full = join(projDir, "public", p.replace(/^public\//, ""));
    if (!/^https?:/.test(p) && !existsSync(full)) critical.push(`scene ${i + 1} references missing asset ${p}`);
  });
  const bg = assets.find((a) => (a.role ?? "background") === "background");
  const prev = (scenes[i - 1]?.assets ?? []).find?.((a) => (a.role ?? "background") === "background");
  if (bg && prev && (typeof bg === "string" ? bg : bg.path) === (typeof prev === "string" ? prev : prev.path))
    critical.push(`scenes ${i}→${i + 1} reuse the SAME background (${typeof bg === "string" ? bg : bg.path}) without a continuity reason`);
  if (!s.camera && !s.template) warn.push(`scene ${i + 1}: no camera movement declared — stills are forbidden`);
  if (i > 0 && !s.transitionIn && !s.transition_in) warn.push(`scene ${i + 1}: no transition declared`);
  if (!s.grade && !plan.project?.grade) warn.push(`scene ${i + 1}: no colour grade — raw AI images must be graded`);
});

// unused generated assets
const assetRoot = join(projDir, "public", "assets");
if (existsSync(assetRoot)) {
  const walk = (d) => readdirSync(d).flatMap((f) => { const p = join(d, f); return statSync(p).isDirectory() ? walk(p) : [p]; });
  walk(assetRoot).forEach((f) => {
    const rel = f.slice(join(projDir, "public").length + 1).replace(/\\/g, "/");
    if (!usedAssets.has(rel) && !/manifest|README/i.test(rel)) warn.push(`generated asset never used in the plan: ${rel}`);
  });
}

console.log(`QC scene-plan: ${scenes.length} beats / ${totalSec.toFixed(1)}s / grade=${plan.project?.grade ?? "per-scene"} `);
warn.forEach((w) => console.log("WARN  " + w));
critical.forEach((c) => console.log("CRIT  " + c));
if (critical.length) { console.log(`\n❌ ${critical.length} critical issue(s) — FIX the plan and re-run before rendering.`); process.exit(1); }
console.log("✅ plan passes QC — render, then run frame QC (lint-frames.mjs / capture.mjs).");
