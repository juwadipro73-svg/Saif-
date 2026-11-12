# SAIF AI — final report

## What was done

The Android app in `final/` now compiles and produces an installable debug APK that runs chat
against **the owner's own AI provider**, with no dependency on Google's Antigravity hub.

### Chat engine

- `ChatViewModel` no longer holds a hub backend. It exposes
  - `antigravityModels` / `antigravitySelectedModel`, derived from the provider profiles the
    user configured with their own API key (`AntigravityCustomApiManager`),
  - `antigravityConnection` (`SystemConnectionState`: `SignedOut`, `NotConfigured`,
    `ProviderOffline`, `Connected`) and `antigravityAuthInfo` (the signed-in SAIF account),
  - approvals, tool termination and choice answers, all forwarded to the SAIF agent engine.
- `AntigravityLlmBridge` is rewritten on `AntigravityCustomApiAgentEngine`, so the builder,
  studio and live-coding flows reuse the user's own key when they have no separate one.
- Deleted: the hub chat backend stub, the Google-Flow MCP setup path, hub quota handling.
- Tool execution is real: commands run through `/system/bin/sh` in the app workspace
  (`LocalEnvironmentManager`), with `/root/workspace` and `/root/uploads` mapped onto the
  device directories. There is no bundled Linux root filesystem, and the app says so instead
  of faking an install.

### UI

- `SaifEngineScreens.kt`: new empty state (offline / sign-in / starting / no provider) and a
  connection dialog that offers *Configure provider* and *Sign in*.
- `EmbeddedEngineSettings`: provider status and key management, workspace shell entry,
  auto-approve switch, saved skills, slash commands, voice, extensions, MCP, appearance.
- `HomeAgentFeed`: rebuilt on SAIF's own chat widgets and markdown block renderer, including
  tool cards, approval buttons, the thinking accordion and retry.
- The Google-Flow menu entry and the hub login dialogs are gone.

### Build and release hygiene

- Removed `app/src/main/proto/`, `proto_generator/`, the Wire plugin and its dependencies.
- Removed the committed debug keystore; release signing now reads `SAIF_RELEASE_*`
  environment variables; `*.jks` / `*.keystore` are ignored.
- Added `docs/THIRD_PARTY_NOTICES.md`, `docs/gates/RELEASE_GATES.md`, this report and the
  owner checklist.

## Build artefact

- CI run `43230750497`: `BUILD SUCCESSFUL`, 0 Kotlin errors.
- APK: `ci/SAIF-AI-debug.apk` (≈49 MB), `ci/SAIF-AI-debug.apk.md5`.
- Download: <https://github.com/juwadipro73-svg/Saif-/raw/arena/64ef18d1-saif/ci/SAIF-AI-debug.apk>
- The APK is debug-signed with Gradle's default debug key, so install it with
  `adb install -r` or uninstall the previous build first.

## What is not done

- Release (signed, minified) build: needs the owner's keystore.
- Unit/instrumentation tests: the suite still has to be reviewed and repaired.
- `google-services.json` is still committed; it should move to a CI secret.
- sora-editor (LGPL-2.1) decision.
- Play Console declarations and the privacy checklist.

## Review status

The code was written for SAIF AI; the reference ZIP was only compared against, never copied
from. That comparison is not a legal opinion, and an **independent human similarity review and
an independent legal review are still required** before release.
