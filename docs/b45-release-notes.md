# b45 — Stack routing + no-cap output

## Already fixed (carried over, verified present on this branch)
- SaifTamperGuard, ForceUpdateGate, parallel-agent fan-out, tools-only chat build rule.

## New in b45
- **Stack routing**: "native android / java / kotlin" builds a real native app
  (Java + manifest + resources, compiled on-device into an APK);
  "flutter / dart" builds a complete Flutter project (source + ZIP + build guide);
  everything else keeps the instant HTML path.
- **No small-output cap**: code budgets raised to full-size chunks, the rate-window
  governor keeps a usable floor with a 5-minute wait circuit breaker, and
  auto-continue rises from 8 to 64 rounds — output scales to the requirement.
- **Honest Flutter delivery**: full source project + `BUILD_GUIDE.md` + ZIP
  (compiled with the Flutter SDK on a PC — the app says so instead of faking an APK).
- **Stack-aware verify/commit/audit**: native and Flutter trees get their own static
  verification, versioned snapshots, result files and quality audit.
- 25 new JVM tests (`BuildStackUnitTest`).

## Try it
- `calculator banao native android java mein` → real APK in Downloads.
- `flutter me chat app banao` → Flutter project ZIP in Downloads + guide.
- `game banao` → instant HTML app as before.
