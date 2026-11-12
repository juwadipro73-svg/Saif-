# Owner checklist

Things only the repository owner can do.

## Before installing

1. Download `ci/SAIF-AI-debug.apk` from the branch and install it. If the previous build is
   still installed, uninstall it first (the debug key changed).
2. Open **Settings → General → Configure provider**, add your own API key (OpenRouter, OpenAI,
   Gemini, Groq or a local endpoint) and pick a model.
3. Sign in to SAIF AI. Chat stays locked until an account is signed in *and* a ready provider
   profile exists.

## What to check by hand

- Empty state text on first launch, with no provider configured.
- Sending a message: the reply streams, tools ask for approval unless auto-approve is on.
- Stop button interrupts the running turn.
- Workspace shell: `ls` and `pwd` run in the app workspace; `apt` is not available.
- Attachments: image, PDF and video are staged and described.
- Voice input transcribes with the provider key you configured.

## Decisions left for you

- **Signing**: put your release keystore in CI as `SAIF_RELEASE_STORE_FILE` (base64-decoded
  before the build), `SAIF_RELEASE_STORE_PASSWORD`, `SAIF_RELEASE_KEY_ALIAS`,
  `SAIF_RELEASE_KEY_PASSWORD`.
- **google-services.json**: move it to a CI secret and delete it from the repository; CI must
  write it back before `assemble`.
- **sora-editor (LGPL-2.1)**: keep it unmodified with the notice, or replace it.
- **Tests**: tell me which suites you want kept; the old hub tests are stale.

## Required before store submission

- Play Console data-safety form and the privacy checklist (`docs/gates/RELEASE_GATES.md` G5).
- Independent licence review of `docs/THIRD_PARTY_NOTICES.md`.
- Independent human similarity review of the source tree against the reference ZIP, and an
  independent legal review. Nothing here claims legal certainty.
