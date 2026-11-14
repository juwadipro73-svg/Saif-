"""Analyze a reference video and extract quantitative editing-style telemetry and keyframes."""

from __future__ import annotations

import argparse
import json
import math
import subprocess
import sys
from pathlib import Path
from typing import Any

import cv2
import numpy as np


def run_cmd(cmd: list[str], timeout: int = 120) -> subprocess.CompletedProcess[str]:
    return subprocess.run(cmd, capture_output=True, text=True, timeout=timeout)


def parse_fps(rate_str: str | None) -> float:
    if not rate_str or rate_str == "0/0":
        return 30.0
    if "/" in rate_str:
        num, den = rate_str.split("/", 1)
        try:
            d = float(den)
            return round(float(num) / d, 3) if d else 30.0
        except ValueError:
            return 30.0
    try:
        return round(float(rate_str), 3)
    except ValueError:
        return 30.0


def infer_aspect_label(width: int, height: int) -> str:
    if not width or not height:
        return "unknown"
    ratio = width / height
    candidates = [
        ("9:16", 9 / 16),
        ("16:9", 16 / 9),
        ("4:5", 4 / 5),
        ("1:1", 1.0),
        ("4:3", 4 / 3),
        ("21:9", 21 / 9),
    ]
    best_label, best_diff = min(candidates, key=lambda item: abs(item[1] - ratio))
    if best_diff < 0.06:
        return best_label
    g = math.gcd(width, height)
    return f"{width // g}:{height // g}"


def probe_media(video_path: Path) -> dict[str, Any]:
    cmd = [
        "ffprobe",
        "-v",
        "error",
        "-print_format",
        "json",
        "-show_format",
        "-show_streams",
        str(video_path),
    ]
    proc = run_cmd(cmd)
    if proc.returncode != 0:
        raise RuntimeError(f"ffprobe failed: {proc.stderr.strip()}")
    data = json.loads(proc.stdout)
    streams = data.get("streams", [])
    v_stream = next((s for s in streams if s.get("codec_type") == "video"), None)
    a_stream = next((s for s in streams if s.get("codec_type") == "audio"), None)
    if not v_stream:
        raise RuntimeError("No video stream found in reference file.")

    width = int(v_stream.get("width", 0))
    height = int(v_stream.get("height", 0))
    duration = float(data.get("format", {}).get("duration") or v_stream.get("duration") or 0.0)
    fps = parse_fps(v_stream.get("avg_frame_rate") or v_stream.get("r_frame_rate"))
    return {
        "filename": video_path.name,
        "width": width,
        "height": height,
        "aspect_ratio": infer_aspect_label(width, height),
        "fps": fps,
        "duration_sec": round(duration, 3),
        "video_codec": v_stream.get("codec_name"),
        "pixel_format": v_stream.get("pix_fmt"),
        "has_audio": a_stream is not None,
        "audio_codec": a_stream.get("codec_name") if a_stream else None,
        "audio_sample_rate": int(a_stream["sample_rate"]) if a_stream and a_stream.get("sample_rate") else None,
        "audio_channels": int(a_stream["channels"]) if a_stream and a_stream.get("channels") else None,
        "bitrate_kbps": round(int(data.get("format", {}).get("bit_rate", 0)) / 1000, 1),
    }


def detect_cuts(video_path: Path, duration_sec: float) -> dict[str, Any]:
    cut_times: list[float] = []
    method = "scenedetect_content"
    try:
        from scenedetect import ContentDetector, detect

        scenes = detect(str(video_path), ContentDetector(threshold=26.0, min_scene_len=6))
        if len(scenes) > 1:
            cut_times = [round(float(s[0].seconds if hasattr(s[0], "seconds") else s[0].get_seconds()), 3) for s in scenes[1:]]
    except Exception:
        method = "ffmpeg_scene_fallback"

    if not cut_times:
        cmd = [
            "ffmpeg",
            "-hide_banner",
            "-i",
            str(video_path),
            "-filter:v",
            "select='gt(scene,0.32)',showinfo",
            "-f",
            "null",
            "-",
        ]
        proc = run_cmd(cmd, timeout=180)
        for line in proc.stderr.splitlines():
            if "pts_time:" in line:
                part = line.split("pts_time:", 1)[1].split()[0]
                try:
                    t = round(float(part), 3)
                    if t > 0.15 and (not cut_times or t - cut_times[-1] >= 0.25):
                        cut_times.append(t)
                except ValueError:
                    continue
        if method == "scenedetect_content" and not cut_times:
            method = "single_shot_or_subtle_cuts"

    boundaries = [0.0] + [t for t in cut_times if 0.0 < t < duration_sec] + [duration_sec]
    shot_durations = [
        round(boundaries[i + 1] - boundaries[i], 3)
        for i in range(len(boundaries) - 1)
        if boundaries[i + 1] - boundaries[i] > 0.05
    ]
    if not shot_durations and duration_sec > 0:
        shot_durations = [round(duration_sec, 3)]

    arr = np.array(shot_durations, dtype=float)
    third = duration_sec / 3.0 if duration_sec > 0 else 1.0
    opening_shots = [boundaries[i + 1] - boundaries[i] for i in range(len(boundaries) - 1) if boundaries[i] < third]
    middle_shots = [boundaries[i + 1] - boundaries[i] for i in range(len(boundaries) - 1) if third <= boundaries[i] < 2 * third]
    closing_shots = [boundaries[i + 1] - boundaries[i] for i in range(len(boundaries) - 1) if boundaries[i] >= 2 * third]

    return {
        "method": method,
        "cut_count": len(cut_times),
        "cuts_per_minute": round((len(cut_times) / duration_sec) * 60.0, 2) if duration_sec > 0 else 0.0,
        "cut_timestamps_sec": cut_times[:120],
        "first_cut_sec": cut_times[0] if cut_times else None,
        "hook_3s_cuts": sum(1 for t in cut_times if t <= 3.0),
        "hook_5s_cuts": sum(1 for t in cut_times if t <= 5.0),
        "shot_count": len(shot_durations),
        "shot_min_sec": round(float(np.min(arr)), 3),
        "shot_p25_sec": round(float(np.percentile(arr, 25)), 3),
        "shot_median_sec": round(float(np.median(arr)), 3),
        "shot_mean_sec": round(float(np.mean(arr)), 3),
        "shot_p75_sec": round(float(np.percentile(arr, 75)), 3),
        "shot_max_sec": round(float(np.max(arr)), 3),
        "opening_third_avg_shot_sec": round(float(np.mean(opening_shots)), 3) if opening_shots else None,
        "middle_third_avg_shot_sec": round(float(np.mean(middle_shots)), 3) if middle_shots else None,
        "closing_third_avg_shot_sec": round(float(np.mean(closing_shots)), 3) if closing_shots else None,
    }


def analyze_audio(video_path: Path, has_audio: bool, duration_sec: float) -> dict[str, Any]:
    if not has_audio or duration_sec <= 0:
        return {"has_audio": False}

    loud_cmd = [
        "ffmpeg",
        "-hide_banner",
        "-i",
        str(video_path),
        "-af",
        "loudnorm=I=-16:TP=-1.5:LRA=11:print_format=json",
        "-f",
        "null",
        "-",
    ]
    loud_proc = run_cmd(loud_cmd, timeout=180)
    loud_stats: dict[str, Any] = {}
    stderr = loud_proc.stderr
    json_start = stderr.rfind("{")
    json_end = stderr.rfind("}")
    if json_start != -1 and json_end > json_start:
        try:
            parsed = json.loads(stderr[json_start : json_end + 1])
            loud_stats = {
                "integrated_lufs": float(parsed["input_i"]),
                "true_peak_db": float(parsed["input_tp"]),
                "loudness_range_lu": float(parsed["input_lra"]),
                "threshold_lu": float(parsed["input_thresh"]),
            }
        except Exception:
            loud_stats = {}

    sil_cmd = [
        "ffmpeg",
        "-hide_banner",
        "-i",
        str(video_path),
        "-af",
        "silencedetect=noise=-35dB:d=0.25",
        "-f",
        "null",
        "-",
    ]
    sil_proc = run_cmd(sil_cmd, timeout=180)
    silence_durations: list[float] = []
    for line in sil_proc.stderr.splitlines():
        if "silence_duration:" in line:
            try:
                val = float(line.split("silence_duration:", 1)[1].strip().split()[0])
                silence_durations.append(val)
            except ValueError:
                continue

    total_silence = round(sum(silence_durations), 3)
    return {
        "has_audio": True,
        **loud_stats,
        "silence_events_gt_250ms": len(silence_durations),
        "total_silence_sec": total_silence,
        "silence_ratio": round(min(total_silence / duration_sec, 1.0), 3),
    }


def extract_palette_hex(bgr_frames: list[np.ndarray], k: int = 5) -> list[str]:
    if not bgr_frames:
        return []
    samples = []
    for frame in bgr_frames:
        small = cv2.resize(frame, (64, 64), interpolation=cv2.INTER_AREA)
        samples.append(small.reshape(-1, 3))
    pixels = np.vstack(samples).astype(np.float32)
    if len(pixels) > 15000:
        idx = np.linspace(0, len(pixels) - 1, 15000, dtype=int)
        pixels = pixels[idx]
    criteria = (cv2.TERM_CRITERIA_EPS + cv2.TERM_CRITERIA_MAX_ITER, 15, 1.0)
    _, labels, centers = cv2.kmeans(pixels, k, None, criteria, 3, cv2.KMEANS_PP_CENTERS)
    counts = np.bincount(labels.flatten(), minlength=k)
    order = np.argsort(-counts)
    palette: list[str] = []
    chosen_centers: list[np.ndarray] = []
    for i in order:
        center = centers[i]
        if any(float(np.linalg.norm(center - prev)) < 18.0 for prev in chosen_centers):
            continue
        chosen_centers.append(center)
        b, g, r = [int(max(0, min(255, round(c)))) for c in center]
        palette.append(f"#{r:02X}{g:02X}{b:02X}")
    return palette


def analyze_visuals_and_export_frames(
    video_path: Path,
    duration_sec: float,
    cut_timestamps: list[float],
    frames_dir: Path,
) -> dict[str, Any]:
    frames_dir.mkdir(parents=True, exist_ok=True)
    cap = cv2.VideoCapture(str(video_path))
    if not cap.isOpened():
        raise RuntimeError(f"OpenCV failed to open {video_path}")

    sample_count = 16
    sample_times = np.linspace(
        min(0.2, duration_sec * 0.05),
        max(0.2, duration_sec - 0.2),
        sample_count,
    ).tolist()

    lumas, p5s, p95s, sats, sat90s, rb_ratios = [], [], [], [], [], []
    sampled_bgr: list[np.ndarray] = []
    contact_tiles: list[np.ndarray] = []
    face_centers_y, face_heights = [], []
    border_dark_votes, border_blur_votes = 0, 0

    cascade_path = Path(cv2.data.haarcascades) / "haarcascade_frontalface_default.xml"
    face_cascade = cv2.CascadeClassifier(str(cascade_path)) if cascade_path.exists() else None

    for ts in sample_times:
        cap.set(cv2.CAP_PROP_POS_MSEC, ts * 1000.0)
        ok, frame = cap.read()
        if not ok or frame is None:
            continue
        sampled_bgr.append(frame)

        hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
        gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
        lumas.append(float(np.mean(gray)))
        p5s.append(float(np.percentile(gray, 5)))
        p95s.append(float(np.percentile(gray, 95)))
        sats.append(float(np.mean(hsv[:, :, 1])))
        sat90s.append(float(np.percentile(hsv[:, :, 1], 90)))
        mean_b, _, mean_r, _ = cv2.mean(frame)
        rb_ratios.append(mean_r / max(mean_b, 1.0))

        h, w = gray.shape
        top_band = gray[: max(1, int(h * 0.12)), :]
        bot_band = gray[int(h * 0.88) :, :]
        mid_band = gray[int(h * 0.25) : int(h * 0.75), int(w * 0.15) : int(w * 0.85)]
        if np.mean(top_band) < 12 and np.mean(bot_band) < 12 and np.mean(mid_band) > 25:
            border_dark_votes += 1
        top_lap = cv2.Laplacian(top_band, cv2.CV_64F).var()
        mid_lap = cv2.Laplacian(mid_band, cv2.CV_64F).var()
        if mid_lap > 40 and top_lap < mid_lap * 0.12 and np.mean(top_band) >= 12:
            border_blur_votes += 1

        if face_cascade is not None:
            scale = 480.0 / max(w, h)
            small_g = cv2.resize(gray, (max(1, int(w * scale)), max(1, int(h * scale))))
            faces = face_cascade.detectMultiScale(small_g, scaleFactor=1.15, minNeighbors=5, minSize=(28, 28))
            if len(faces) > 0:
                fx, fy, fw, fh = max(faces, key=lambda b: b[2] * b[3])
                sh = small_g.shape[0]
                face_centers_y.append((fy + fh / 2.0) / sh)
                face_heights.append(fh / sh)

        tile = cv2.resize(frame, (320, max(180, int(320 * h / max(w, 1)))), interpolation=cv2.INTER_AREA)
        if tile.shape[0] > 569:
            tile = cv2.resize(tile, (320, 569), interpolation=cv2.INTER_AREA)
        label = f"{int(ts // 60):02d}:{ts % 60:05.2f}"
        cv2.rectangle(tile, (4, 4), (116, 30), (0, 0, 0), -1)
        cv2.putText(tile, label, (10, 23), cv2.FONT_HERSHEY_SIMPLEX, 0.55, (255, 255, 255), 1, cv2.LINE_AA)
        contact_tiles.append(tile)

    # Save contact sheet (4 columns)
    if contact_tiles:
        cols = 4
        th, tw = contact_tiles[0].shape[:2]
        norm_tiles = [cv2.resize(t, (tw, th)) for t in contact_tiles]
        rows = math.ceil(len(norm_tiles) / cols)
        while len(norm_tiles) < rows * cols:
            norm_tiles.append(np.zeros((th, tw, 3), dtype=np.uint8))
        grid_rows = [np.hstack(norm_tiles[r * cols : (r + 1) * cols]) for r in range(rows)]
        cv2.imwrite(str(frames_dir / "contact_sheet.jpg"), np.vstack(grid_rows), [cv2.IMWRITE_JPEG_QUALITY, 88])

    # Export key hook, mid, late, and post-cut frames for direct visual inspection
    key_targets: list[tuple[str, float]] = [
        ("hook_00.jpg", min(0.2, duration_sec * 0.1)),
        ("hook_01.jpg", min(1.1, duration_sec * 0.3)),
        ("hook_02.jpg", min(2.4, duration_sec * 0.5)),
        ("mid_50pct.jpg", duration_sec * 0.5),
        ("late_80pct.jpg", duration_sec * 0.8),
    ]
    if cut_timestamps:
        step = max(1, len(cut_timestamps) // 6)
        for idx, ct in enumerate(cut_timestamps[::step][:6], start=1):
            key_targets.append((f"cut_{idx:02d}_{ct:.2f}s.jpg", min(duration_sec - 0.05, ct + 0.18)))

    for fname, ts in key_targets:
        cap.set(cv2.CAP_PROP_POS_MSEC, max(0.0, ts) * 1000.0)
        ok, frame = cap.read()
        if ok and frame is not None:
            cv2.imwrite(str(frames_dir / fname), frame, [cv2.IMWRITE_JPEG_QUALITY, 90])

    # Estimate punch-in / jump-cut pairs across detected cuts
    punch_cuts = 0
    for ct in cut_timestamps[:20]:
        cap.set(cv2.CAP_PROP_POS_MSEC, max(0.0, ct - 0.12) * 1000.0)
        ok1, f1 = cap.read()
        cap.set(cv2.CAP_PROP_POS_MSEC, min(duration_sec - 0.05, ct + 0.12) * 1000.0)
        ok2, f2 = cap.read()
        if not (ok1 and ok2 and f1 is not None and f2 is not None):
            continue
        h1 = cv2.calcHist([cv2.cvtColor(f1, cv2.COLOR_BGR2HSV)], [0, 1], None, [16, 16], [0, 180, 0, 256])
        h2 = cv2.calcHist([cv2.cvtColor(f2, cv2.COLOR_BGR2HSV)], [0, 1], None, [16, 16], [0, 180, 0, 256])
        cv2.normalize(h1, h1)
        cv2.normalize(h2, h2)
        sim = cv2.compareHist(h1, h2, cv2.HISTCMP_CORREL)
        if sim >= 0.82:
            punch_cuts += 1

    cap.release()

    avg_p5 = float(np.mean(p5s)) if p5s else 0.0
    avg_p95 = float(np.mean(p95s)) if p95s else 255.0
    layout_hint = "full_bleed"
    if border_dark_votes >= max(3, len(sampled_bgr) // 2):
        layout_hint = "letterboxed_or_pillarboxed"
    elif border_blur_votes >= max(3, len(sampled_bgr) // 2):
        layout_hint = "blurred_background_fill"

    return {
        "avg_luma_0_255": round(float(np.mean(lumas)), 1) if lumas else None,
        "black_floor_p5": round(avg_p5, 1),
        "highlight_p95": round(avg_p95, 1),
        "contrast_p95_p5": round(avg_p95 - avg_p5, 1),
        "saturation_mean_0_255": round(float(np.mean(sats)), 1) if sats else None,
        "saturation_p90_0_255": round(float(np.mean(sat90s)), 1) if sat90s else None,
        "warmth_rb_ratio": round(float(np.mean(rb_ratios)), 3) if rb_ratios else 1.0,
        "dominant_palette_hex": extract_palette_hex(sampled_bgr),
        "layout_hint": layout_hint,
        "face_detected_frames": len(face_centers_y),
        "face_center_y_ratio": round(float(np.median(face_centers_y)), 3) if face_centers_y else None,
        "face_height_ratio": round(float(np.median(face_heights)), 3) if face_heights else None,
        "same_scene_jump_or_punch_cuts_sampled": punch_cuts,
        "exported_frames_dir": str(frames_dir),
    }


def analyze_speech_cadence(video_path: Path, model_size: str, duration_sec: float) -> dict[str, Any]:
    try:
        from faster_whisper import WhisperModel
    except Exception as exc:
        return {"ok": False, "error": f"faster-whisper unavailable: {exc}"}

    model = WhisperModel(model_size, device="cpu", compute_type="int8")
    segments, info = model.transcribe(str(video_path), word_timestamps=True, vad_filter=True)
    seg_list = list(segments)
    words = [w for seg in seg_list for w in (getattr(seg, "words", None) or [])]
    spoken_secs = sum(max(0.0, seg.end - seg.start) for seg in seg_list)
    word_count = len(words) if words else sum(len(seg.text.split()) for seg in seg_list)
    return {
        "ok": True,
        "language": getattr(info, "language", None),
        "language_probability": round(float(getattr(info, "language_probability", 0.0)), 3),
        "speech_segments_count": len(seg_list),
        "word_count": word_count,
        "spoken_duration_sec": round(spoken_secs, 2),
        "words_per_minute_overall": round((word_count / duration_sec) * 60.0, 1) if duration_sec > 0 else 0.0,
        "words_per_minute_active": round((word_count / spoken_secs) * 60.0, 1) if spoken_secs > 0 else 0.0,
        "avg_words_per_segment": round(word_count / len(seg_list), 1) if seg_list else 0.0,
    }


def main() -> int:
    parser = argparse.ArgumentParser(description="Analyze a reference video for style matching.")
    parser.add_argument("video", type=Path, help="Path to the reference video file.")
    parser.add_argument("--out", type=Path, required=True, help="Output directory for telemetry and frames.")
    parser.add_argument("--transcribe", action="store_true", help="Run local faster-whisper speech cadence analysis.")
    parser.add_argument("--whisper-model", default="base", help="Whisper model size (default: base).")
    args = parser.parse_args()

    video_path = args.video.expanduser().resolve()
    if not video_path.exists():
        print(f"Reference video not found: {video_path}", file=sys.stderr)
        return 1

    out_dir = args.out.expanduser().resolve()
    out_dir.mkdir(parents=True, exist_ok=True)
    frames_dir = out_dir / "frames"

    media = probe_media(video_path)
    pacing = detect_cuts(video_path, media["duration_sec"])
    audio = analyze_audio(video_path, media["has_audio"], media["duration_sec"])
    visuals = analyze_visuals_and_export_frames(
        video_path, media["duration_sec"], pacing["cut_timestamps_sec"], frames_dir
    )
    speech = (
        analyze_speech_cadence(video_path, args.whisper_model, media["duration_sec"])
        if args.transcribe and media["has_audio"]
        else {"ok": False, "skipped": True}
    )

    telemetry = {
        "media": media,
        "pacing": pacing,
        "audio": audio,
        "color_and_framing": visuals,
        "speech_cadence": speech,
    }

    out_json = out_dir / "style_telemetry.json"
    out_json.write_text(json.dumps(telemetry, indent=2), encoding="utf-8")
    print(f"Wrote {out_json}")
    print(f"Exported frames to {frames_dir}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
