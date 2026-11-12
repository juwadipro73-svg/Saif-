# Release gates

Each gate is a checklist a human closes before the build is shipped. Automated commands are
listed where they exist; the rest is review work.

## G1 — Build

- [x] `./gradlew :app:assembleStandardDebug` finishes with `BUILD SUCCESSFUL`
      (CI run `43230750497`, artefact `ci/SAIF-AI-debug.apk`).
- [ ] `./gradlew :app:assembleStandardRelease` succeeds with release signing supplied by the
      environment (no keystore in the repo).
- [x] No source file under `app/src/main/java` contains a syntax error (checked with the
      local tree-sitter pass in `scripts/syntax_fix.py` plus the compiler).

## G2 — No hub code

- [x] `grep -rn "AgyHubClient\|agyBackend\|connectGoogleFlow" app/src/main/java` returns nothing.
- [x] `app/src/main/proto/` and `proto_generator/` are deleted; the Wire plugin is gone.
- [x] Chat turns run through `AntigravityCustomApiAgentEngine` against the user's own provider.

## G3 — Placeholders

- [x] No fake "hub connected" state: `SystemConnectionState` is derived from the signed-in
      account plus the provider profile on disk.
- [x] Tools that cannot run (no Linux rootfs) report that honestly instead of pretending.
- [ ] Manual pass over every screen for placeholder copy.

## G4 — Tests

- [ ] Stale tests that referenced the hub are removed or rewritten.
- [ ] `./gradlew :app:testStandardDebugUnitTest` passes.

## G5 — Release hygiene

- [x] `app/saif-debug.jks` removed; `*.jks` / `*.keystore` ignored.
- [x] Release signing reads `SAIF_RELEASE_*` environment variables, nothing is committed.
- [ ] `app/google-services.json` moved to a CI secret (it is a public client config, but it
      still names the project).
- [ ] Play Console data-safety and privacy declarations completed.
- [ ] `docs/PRIVACY.md` reviewed against the actual permissions in `AndroidManifest.xml`.

## G6 — Third party

- [x] `docs/THIRD_PARTY_NOTICES.md` lists every runtime dependency and its licence.
- [ ] Decide on sora-editor (LGPL-2.1): keep unmodified with notice, or replace.
- [ ] Independent licence review of the notices file.

## G7 — Similarity / provenance

- [x] The reference ZIP was used only for comparison; no file was copied from it.
- [ ] Independent human similarity review of the final source tree against the reference ZIP.
- [ ] Independent legal review. Nothing in this repository claims legal certainty.
