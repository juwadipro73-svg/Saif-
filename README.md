# SAIF AI

A native Android AI workspace: chat with your own API key (or, optionally, Google Antigravity), live voice, code editing and project creation. APK/video build requests now go through a **separately deployable cloud template**; this repository does not contain a live production builder or a configured downloads domain.

**Licence:** SAIF AI is free software under the **GNU GPL v3 or later**. It is built on [AntiGem by Santosh Kurmi](https://github.com/Santoshkurmi/antigem) (GPLv3). Everyone whose code is used is credited in [THIRD_PARTY_NOTICES.md](THIRD_PARTY_NOTICES.md), and in the app under Settings > About SAIF AI > Credits.

**Build status:** GitHub Actions produces a **debug preview APK**, not a production-signed release. Real-device sign-in, Play Integrity, Firebase RTDB, private Drive delivery and the separately deployed builder must be verified with the owner's accounts before cloud jobs can work.

## App behavior

- Startup uses the restored **email/password sign-in, sign-up, forgot-password and guest** screen. Firebase Email/Password accounts can request Firebase password-reset email. If Firebase is unavailable, a device-local account can be created; it is **not proof of email ownership** and cannot be remotely reset. Local passwords are PBKDF2-hashed with salt; older local SHA-256 rows are upgraded after successful sign-in. Firebase account passwords are not cached for offline fallback, so a Firebase password reset cannot be bypassed by an old device-local copy. Guest data is scoped to that guest session.
- **Your own API key is enough; Antigravity is optional.** After the app sign-in the chat opens directly (there is no "choose your provider" screen). Add an API key (OpenRouter, Gemini, OpenAI, Anthropic, Groq and more) and chat: no Antigravity sign-in is asked for, and no Antigravity account screen is shown while your key is in use. A key already saved in the AI provider settings is used automatically when Antigravity is not connected.
- **Storage clean-up.** Work in the Linux workspace downloads gigabytes of modules. When a project has been idle (30 minutes by default, changeable in Settings > Storage), re-downloadable folders are deleted: `node_modules`, Python virtual environments, Gradle build intermediates, and the npm, pip, Gradle, Maven and apt caches. Project files, `.git`, `.env` files and finished build outputs are never deleted, and projects with a running program are skipped. Returning to a project only needs its modules installed again (`npm install`, a new build); the agent is told to do that by itself. A log is kept at `/root/workspace/.config/saif-cleanup.md`.
- **Antigravity authentication is separate, inside SAIF AI.** The app login is not a Google OAuth identity and does not silently authorize Antigravity. To use Antigravity, connect its hub in the app. An old hub token is not silently reassigned to a different app account; reconnect Antigravity after switching SAIF AI accounts. Saved chats, project-chat histories, personal memory/PIN and imported GitHub skills are scoped to the active app owner. New memory PINs are salted PBKDF2 hashes (legacy PINs upgrade after a correct unlock), but this is a UI lock, **not encryption**. Unowned pre-migration data remains hidden rather than assigned to the next login. Project files and the shared local terminal environment are **not encrypted or securely isolated** across users of the same Android device.
- On app sign-in the local development environment and bridge start automatically if needed; progress/retry are in Settings. The standard package (`com.saifai.app`) uses ARM64 Ubuntu/PRoot; the classic terminal launcher style does not change the environment into a native Termux rootfs.
- The purple mic starts a **live voice conversation**. It is SAIF AI's own engine (`com.example.live`): it needs only the microphone permission and something that can answer (your provider API key, or the connected chat agent). It works with any provider: OpenAI, Groq and Gemini keys transcribe speech in the cloud, every other provider uses the on-device speech model (English, downloaded once on first use). Screen sharing is optional and is asked for inside the conversation. Notification permission and battery exemption are not startup requirements. Spoken coding tasks go to the same chat agent as typed ones. Tool approvals still require the user. A public GitHub repository/folder/SKILL.md import uses your chosen /command name and saves its skill text, references and scripts as one app-private Markdown document (up to 256 KB), scoped to the app account. Binary assets are listed by path, not embedded in the chat prompt; review untrusted skills before use.
- Chat keeps small text/photos under 3 MB inside the app. Attaching an APK, ZIP or video (or a supported >=3 MB photo/document) starts **one private website upload**, not an unsupported Antigravity binary attachment: stream to signed GCS, verify checksum, save to private Drive, then display a one-time download link in SAIF AI. Prompted project ZIPs can also be generated in the cloud. These features require the authenticated gateway, website routing, App Check and builder deployment in [cloud/README.md](cloud/README.md); the supplied demo URL is not verified as a live upload API. The app does not secretly send attached binary bytes to an AI model.
- Chat text, code snippets and **small images/text attachments (3 MB combined max)** stay in the app. Explicit APK/game compilation and MP4 renders are routed to `SaifAiCloudManager` and an authenticated backend. Project Studio build/export buttons no longer invoke the local APK compiler (the old Video Studio window has been removed entirely). A job card listens to Firebase RTDB and shows a private **SAIF AI DOWNLOADS** button when an artifact is ready. Cloud builds require separate service deployment; an unconfigured debug build fails closed and tells you what is missing.

## `/video` editing skill (permanent)

Typing `/video <request>` — or bare `/video`, which asks what you want — runs the bundled
**reference-style-matcher** skill and nothing else: it analyses a reference video's editing DNA (pacing,
cuts, framing, color, captions, audio), saves a reusable style template, and edits your raw footage to
match — all locally in the Linux workspace (`scripts/analyze_reference.py`,
`scripts/build_style_skill.py`). The old built-in Video Studio window has been removed from the app.
The skill files ship in the APK (`app/src/main/assets/skills/reference-style-matcher/`) and are
re-installed on-device automatically (`BundledSkillsInstaller`, also reachable via `VideoSkillInstaller`).

## `/rea` reverse-engineering skill (permanent)

Typing `/rea <target>` in chat runs the bundled **REA** (Reverse Engineer Anything, by
[morluto](https://github.com/morluto/rea), MIT) skill: decompile and analyse APKs, binaries and apps,
compare versions, and observe runtime behavior with evidence for every claim. The bundle ships in the APK
(`app/src/main/assets/skills/rea/`, snapshot at upstream commit `6938696`) and is re-installed
on-device automatically next to the `/video` skill.

## Advance Auto-Builder (always-on)

Every project build runs through the Advance Auto-Builder (`com.example.autobuild`) with no button needed:

- **Idea expansion** — a one-line idea becomes an ambitious brief (10+ must-features, wow delights, extra screens). Works offline via built-in heuristic briefs when no key/network is available.
- **Parallel agents** — independent code modules generate on up to 3 agents at once.
- **Quality gates** — each result is re-tested in the headless sandbox and scored 0-100; anything under 82/100 is automatically improved in rounds (max 3 per session).
- **Continue-forward rule** — files you didn't ask to touch stay frozen; if a new pass breaks older checks, the previous good version is restored automatically.
- **Checkpoints + resume** — prompts, file hashes, scores and findings persist per project, so interrupted work continues days later: on app start, every 6 hours in the background, or instantly when you reopen the project chat.
- **Auto app icon** — a category-matched launcher icon is AI-generated with your own provider key, or drawn procedurally offline. Manually set icons are never overwritten.

Background continuation only runs when a provider key is saved, and announces completion with the standard "Work done" notification when you are away from the app.

## Cloud/Drive/Firebase setup

See **[cloud/README.md](cloud/README.md)** for the complete backend, builder workflow, Firebase RTDB rules, GCS input staging, private Drive delivery, sponsor-placeholder website, one-time download claim, deployment secrets and known template limitations. The separate public `SaifAI-Builder` repository is readable, but its draft PR #2 still uses placeholder artifacts and is **not** merged, modified from this checkout, or deployed; see the concrete contract gaps in [cloud/README.md](cloud/README.md).

The checked-in `app/google-services.json` currently has no OAuth clients. **Google startup sign-in is not required** for this restored login; enable Firebase **Email/Password** and **Anonymous** providers plus appropriate Firebase database/security rules if you want cloud jobs. App Check / Play Integrity for a sideloaded debug APK may require additional private test setup; never publish a debug App Check token. Configure a signed production build for deployment. Keep the Firebase project owner's Firestore rules for admin role, bans and quotas secure—client UI alone cannot establish authority.

## Build and download

A push starts `.github/workflows/build-apk.yml`. It first runs the cloud-template tests, then compiles the Android app and runs its unit tests. A successful build uploads an [Actions APK artifact](https://github.com/juwadipro73-svg/claude-saif-ai/actions/workflows/build-apk.yml) and updates the [rolling debug prerelease](https://github.com/juwadipro73-svg/claude-saif-ai/releases/tag/saif-ai-apk). **Check the run's commit SHA and conclusion before installing**; an earlier release or artifact is not proof that later changes passed. The cloud URL variables may be empty for a sign-in/UI preview, but cloud jobs then cannot run. If the three public origins are set as this repository's Actions variables (or existing secrets with the same names), CI safely probes the gateway and portal routes before publishing the APK; a demo website or Google-login redirect cannot pass that preflight. This does not replace a real upload/device test.

For a local build install JDK 17, Android SDK/Build Tools, Go 1.22 and Gradle 9.x:

```bash
# Only AFTER deploying the backend/portal/RTDB (public HTTPS addresses, not secrets):
export SAIF_CLOUD_API_BASE_URL='https://YOUR-GATEWAY'
export SAIF_DOWNLOAD_PORTAL_URL='https://YOUR-GATEWAY'
export SAIF_FIREBASE_DATABASE_URL='https://YOUR-RTDB.firebasedatabase.app'
./gradlew :app:assembleStandardDebug :app:testStandardDebugUnitTest
```

Output: `app/build/outputs/apk/standard/debug/app-standard-debug.apk`. A committed debug keystore supports consistent install-over-debug updates, but is **not** a production signing key. Use your own private release key, an appropriate target SDK and real-device QA before shipping.

## Licence, credits and source

SAIF AI is free software: you may use, change and share it under the **GNU General Public License, version 3 or (at your option) any later version** ([LICENSE](LICENSE)). It comes with no warranty.

- Copyright (C) 2026 SAIF AI and contributors.
- The AI-agent workspace is based on [AntiGem by Santosh Kurmi](https://github.com/Santoshkurmi/antigem), Copyright (C) 2026 Santosh Kurmi, GPL v3 or later.
- Termux terminal components, PRoot, talloc, the GNU C Library, sora-editor and every other library are listed with their licences in **[THIRD_PARTY_NOTICES.md](THIRD_PARTY_NOTICES.md)**; the licence texts are in [`licenses/`](licenses).

When you share the app: keep these files with it, make the source of that exact version available to everyone who gets the APK (publishing from this public repository does that), and do not put a closed-source or "all rights reserved" licence on it. The checklist and the points that are still open are in sections 7 and 8 of THIRD_PARTY_NOTICES.md.

SAIF AI is an independent project and is not affiliated with Google, Anthropic, OpenAI, OpenCode, Arena, Termux or AntiGem. Their names are used only to say which tools the app works with. The repository owner controls this fork's code, builds and release settings; that does not transfer third-party copyright or Firebase/Google/Antigravity account ownership.
