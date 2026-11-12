# SAIF AI — third-party notices

SAIF AI is built on open-source components. This file lists what the app links against and
under which licence. It is a notice file, not a legal opinion: an independent licence review
is still required before any store submission.

The SAIF proprietary `LICENSE` covers **only** the source code authored for SAIF AI
(`com.example.*`, `com.saifai.*`). Everything below remains under its own licence.

## Runtime libraries

| Component | Version | Licence | Used for |
| --- | --- | --- | --- |
| AndroidX Core / Activity / Lifecycle / Compose (BOM, Material 3, Foundation) | per `gradle/libs.versions.toml` | Apache-2.0 | App shell and all UI |
| Jetpack Navigation Compose | per version catalogue | Apache-2.0 | Screen navigation |
| Room (runtime, compiler, ktx) | per version catalogue | Apache-2.0 | Local chat/session database |
| DataStore Preferences | per version catalogue | Apache-2.0 | Settings persistence |
| WorkManager | per version catalogue | Apache-2.0 | Background jobs |
| OkHttp 4.12 / okio | pinned in `app/build.gradle.kts` | Apache-2.0 | HTTP to the user's own AI provider |
| kotlinx.coroutines / serialization / immutable collections | per version catalogue | Apache-2.0 | Concurrency and JSON |
| Coil (compose, svg) | 2.7.0 | Apache-2.0 | Avatars, image previews |
| Firebase Auth / Firestore / App Check / Crashlytics | BOM | Apache-2.0 (Google APIs Terms for the hosted service) | Account sign-in and cloud sync |
| Google Play Services (Auth, Location, Integrity) | per version catalogue | Android SDK licence | Sign-in, App Check |
| androidx.media3 (ExoPlayer) | per version catalogue | Apache-2.0 | Audio/video playback |
| Zoomable, Reorderable, Accompanist helpers | per version catalogue | Apache-2.0 | UI helpers |
| sora-editor (`io.github.Rosemoe.sora-editor`) | see note | **LGPL-2.1** | Code editor component |

### sora-editor (LGPL-2.1)

The code editor is unmodified and linked as a library. If you redistribute a *modified* copy of
sora-editor, LGPL-2.1 requires you to publish those modifications and to keep the library
replaceable. If that obligation is not acceptable, the editor must be replaced before release.

## Build-time only

| Component | Licence | Note |
| --- | --- | --- |
| Android Gradle Plugin, Kotlin compiler plugin, R8 | Apache-2.0 | Not shipped in the APK |
| Firebase / Google Services Gradle plugins | Apache-2.0 | Not shipped in the APK |

## Removed dependencies

The following were removed from the project because they would have re-created Google's
Antigravity hub/language-server client or were unused:

- Wire (protobuf/gRPC code generation) and `app/src/main/proto/LanguageServerService.proto`
- `proto_generator/` scratch tooling
- The Go `agy_ide_bridge` build step

## Assets

- Icons and illustrations are either authored for SAIF AI or come from Material Symbols
  (Apache-2.0).
- `app/src/main/assets/glibc-min-arm64.tar` was **not** kept in the tree; the workspace shell
  runs on the device's own `/system/bin/sh` instead.

## What SAIF AI does not include

- No Google Antigravity hub client, language-server client, or protocol code.
- No Termux, JARVIS or other third-party agent code.
- No GPL/AGPL dependency.
