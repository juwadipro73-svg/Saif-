# Reference ZIP vs final app — feature parity notes

The attached `Saif-a820c065da3d4c7eae0f1b9fe116f0358646f3bb.zip` was used **only as a
reference**: to see how the app behaved, never as source. The working project is `final/`.

| Area | Reference behaviour | Final app |
| --- | --- | --- |
| Chat engine | Talked to a remote hub that owned the models and the conversation ids | Runs against the provider profile the user configured with their own key; each local chat is one engine session |
| Model picker | Model list came from the hub | Model list is built from the user's provider profiles (`profile.name: model`) |
| Sign-in | Hub account required before anything worked | A SAIF account is required; provider keys are separate |
| Tool approval | Hub-side permission prompts | Approval decisions are held by the SAIF agent engine (`PendingToolApproval`), with per-session "allow all" |
| Workspace | Linux rootfs (proot/Ubuntu) inside the app | Device shell in the app workspace; no rootfs download, no fake install progress |
| Terminal settings | Downloaded and verified a Linux rootfs | Shows the workspace shell state; installer progress types exist for providers that do need a download |
| Google Flow | Connect Flow through the hub bridge | Removed; not part of SAIF AI |
| Language server / proto | Wire-generated gRPC client | Removed |
| Video / studio | Present | Present (unchanged) |
| Voice | Hub speech endpoint | `SttRouter` with the user's keys, falling back to the device recogniser |
| Settings | Hub settings sheet | `EmbeddedEngineSettings` (provider, workspace, skills, slash commands, voice, extensions, MCP, appearance) |

## Deliberately different

- No Antigravity hub, language-server client or protocol code is re-created.
- No "connected" state is shown unless an account is signed in and a provider profile is ready.
- Anything that cannot run on a device without a Linux install reports that honestly.
