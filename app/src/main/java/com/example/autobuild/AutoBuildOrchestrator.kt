package com.example.autobuild

import android.content.Context
import android.util.Log
import com.example.builder.agent.Assembler
import com.example.builder.agent.BuildAgent
import com.example.builder.agent.BuildEvent
import com.example.builder.agent.BuildPhase
import com.example.builder.agent.DesignTokens
import com.example.builder.agent.FeatureSpec
import com.example.builder.agent.AppSpec
import com.example.builder.agent.QualityMode
import com.example.builder.agent.SandboxRunner
import com.example.builder.agent.TestIssue
import com.example.builder.agent.TestReport
import com.example.builder.safety.VersionManager
import com.example.data.local.ProviderSettingsManager
import com.example.service.AgentWorkNotifier
import com.example.builder.agent.BuildService
import com.example.ui.components.ProjectData
import com.example.util.ProjectDataManager
import org.json.JSONObject
import java.io.File
import java.util.concurrent.ConcurrentHashMap

/**
 * Advance Auto-Builder — always-on multi-agent orchestrator.
 *
 * What it does on EVERY build (no button needed):
 * 1. Expands a small idea into an ambitious brief ([IdeaExpander]).
 * 2. Runs the staged pipeline with a swarm of up to 8 parallel agents.
 * 3. Freezes files the user didn't ask to touch (continue-forward rule).
 * 4. Re-tests the result and auto-improves it in rounds until the quality gate passes.
 * 5. Guards against regressions: if a new pass breaks older features, the previous
 *    good version is restored automatically.
 * 6. Forges a category-matched app icon ([AutoIconForge]).
 * 7. Checkpoints everything to disk ([BuildCheckpointStore]) so work can continue
 *    days later, in the background, without losing earlier features.
 */
data class AdvanceOutcome(
    val summary: String,
    val finalScore: Int,
    val autoRounds: Int,
    val iconCategory: String,
    val iconSource: String,
    val needsContinue: Boolean
)

private data class AuditBundle(
    val audit: QualityAudit,
    val report: TestReport,
    val allProbes: List<String>
)

object AutoBuildOrchestrator {
    private const val TAG = "AutoBuildX"
    const val TARGET_SCORE = DeepQualityAudit.TARGET_SCORE
    const val MAX_AUTO_ROUNDS = 3
    /** Big tasks fan out across this many parallel agents (BuildAgent caps lanes by task count). */
    const val PARALLEL_AGENTS = 8

    private val activeBuilds = ConcurrentHashMap.newKeySet<String>()

    suspend fun runAdvancedBuild(
        context: Context,
        project: ProjectData,
        prompt: String,
        qualityMode: QualityMode,
        base64Images: List<String>,
        onEvent: suspend (BuildEvent) -> Unit,
        isResume: Boolean = false
    ): Result<AdvanceOutcome> {
        val key = project.appName.lowercase()
        if (!activeBuilds.add(key)) {
            return Result.failure(IllegalStateException("A build is already running for '${project.appName}' — continuing that one instead of starting over."))
        }
        return try {
            runInternal(context, project, prompt, qualityMode, base64Images, onEvent, isResume)
        } finally {
            activeBuilds.remove(key)
        }
    }

    private suspend fun runInternal(
        context: Context,
        project: ProjectData,
        prompt: String,
        qualityMode: QualityMode,
        base64Images: List<String>,
        onEvent: suspend (BuildEvent) -> Unit,
        isResume: Boolean
    ): Result<AdvanceOutcome> {
        val app = context.applicationContext
        val projectDir = BuildCheckpointStore.projectDirFor(app, project.appName).apply { mkdirs() }
        BuildCheckpointStore.appendPrompt(projectDir, project.appName, prompt)

        val state = ProviderSettingsManager.loadState()
        val provider = state.providerName.ifBlank { "Gemini" }
        val keys = state.apiKeys.filter { it.isNotBlank() && !it.contains("MY_") }
        val activeKey = keys.firstOrNull() ?: ""
        val activeModel = state.buildModel.ifBlank { state.activeModel }

        val rootHtml = File(projectDir, "index.html")
        val isNewApp = try {
            !(rootHtml.exists() && rootHtml.length() > 50 && rootHtml.readText().contains(Assembler.SAIF_BUILD_MARKER))
        } catch (_: Exception) {
            true
        }

        // Continue-forward rule: freeze everything the user didn't ask to touch.
        val frozen = if (isNewApp) emptySet() else BuildCheckpointStore.frozenFilesFor(projectDir, prompt)
        BuildCheckpointStore.update(projectDir) {
            it.copy(
                status = BuildCheckpointStore.STATUS_RUNNING,
                lastPhase = BuildPhase.S0_INTAKE.name,
                frozenFiles = frozen.toList(),
                lastActiveAt = System.currentTimeMillis(),
                lastError = null,
                autoRoundsUsed = 0
            )
        }

        // Idea expansion for new / tiny prompts; chat-aware resume otherwise.
        var brief: IdeaBrief? = null
        var guidance: String
        val wordCount = prompt.trim().split(Regex("\\s+")).size
        if (isNewApp || wordCount < 25) {
            onEvent(BuildEvent.Thought("Advance mode: expanding your idea into a rich product brief..."))
            brief = try {
                IdeaExpander.expand(project.appName, prompt, provider, activeKey, activeModel)
            } catch (e: Exception) {
                Log.w(TAG, "Expansion failed, heuristic brief: ${e.message}")
                IdeaExpander.heuristicBrief(project.appName, prompt)
            }
            guidance = IdeaExpander.toGuidance(brief)
        } else {
            val chatCtx = BuildCheckpointStore.recentChatContext(app, project.appName)
            guidance = if (chatCtx.isNotBlank()) {
                "$chatCtx\nCONTINUE-FORWARD RULE: continue exactly where the previous work stopped. " +
                    "Keep every existing feature working. Only change what the user asked for now."
            } else {
                "CONTINUE-FORWARD RULE: keep every existing feature working. Only change what the user asked for now."
            }
        }

        // Keep-alive: survives screen-off / app-switch without any button.
        AgentWorkNotifier.begin(app)
        var buildServiceStarted = false
        try {
            if (!BuildService.isBuildRunning) {
                BuildService.start(app, project.appName, "Advance Auto-Builder working on ${project.appName}...")
                buildServiceStarted = true
            }
        } catch (e: Exception) {
            Log.w(TAG, "BuildService start skipped: ${e.message}")
        }

        try {
            // ---- Main pass: staged pipeline with the parallel agent swarm ----
            val mainResult = BuildAgent.run(
                context = app,
                project = project,
                prompt = prompt,
                qualityMode = qualityMode,
                base64Images = base64Images,
                parallelAgents = PARALLEL_AGENTS,
                frozenFiles = frozen,
                briefGuidance = guidance,
                onEvent = onEvent,
                resumeFromCheckpoint = isResume
            )
            if (mainResult.isFailure) {
                val err = mainResult.exceptionOrNull()?.message ?: "Build failed"
                BuildCheckpointStore.update(projectDir) {
                    it.copy(status = BuildCheckpointStore.STATUS_FAILED, lastError = err, lastActiveAt = System.currentTimeMillis())
                }
                AgentWorkNotifier.end(app, completed = false)
                stopServiceIfNeeded(app, buildServiceStarted)
                return Result.failure(mainResult.exceptionOrNull() ?: IllegalStateException(err))
            }

            // ---- Quality gate + automatic improvement rounds ----
            var bundle = runAudit(app, projectDir)
            onEvent(BuildEvent.QualityGate(bundle.audit.score, !bundle.audit.needsImprovement()))
            var rounds = 0
            while (bundle.audit.needsImprovement() && rounds < MAX_AUTO_ROUNDS) {
                rounds++
                val roundSnapshot = rounds
                BuildCheckpointStore.update(projectDir) {
                    it.copy(autoRoundsUsed = roundSnapshot, lastActiveAt = System.currentTimeMillis())
                }
                onEvent(BuildEvent.Thought("Advance mode: auto-improvement round $rounds (quality ${bundle.audit.score}/100, target $TARGET_SCORE)..."))
                val baselinePassed = bundle.report.passedCount
                val fixPrompt = DeepQualityAudit.improvementPrompt(bundle.audit)
                val frozenNow = BuildCheckpointStore.frozenFilesFor(projectDir, fixPrompt)
                val roundResult = BuildAgent.run(
                    context = app,
                    project = project,
                    prompt = fixPrompt,
                    qualityMode = QualityMode.BALANCED,
                    base64Images = emptyList(),
                    parallelAgents = 2,
                    frozenFiles = frozenNow,
                    briefGuidance = "",
                    onEvent = onEvent
                )
                if (roundResult.isFailure) {
                    Log.w(TAG, "Improvement round $rounds failed, keeping previous good state")
                    break
                }
                val next = runAudit(app, projectDir)
                // Regression guard: fewer passing checks than before = older features broke.
                if (baselinePassed > 0 && next.report.passedCount < baselinePassed) {
                    try {
                        VersionManager.restorePrevious(projectDir)
                    } catch (_: Exception) {
                    }
                    onEvent(BuildEvent.Thought("Advance mode: round $rounds weakened older features — restored the previous good version."))
                    bundle = runAudit(app, projectDir)
                    onEvent(BuildEvent.QualityGate(bundle.audit.score, !bundle.audit.needsImprovement()))
                    break
                }
                bundle = next
                onEvent(BuildEvent.QualityGate(bundle.audit.score, !bundle.audit.needsImprovement()))
            }

            // ---- Auto icon ----
            var iconCategory = ""
            var iconSource = "skipped"
            try {
                val vision = brief?.vision ?: prompt.take(500)
                val feats = brief?.mustFeatures?.joinToString(" ").orEmpty()
                val iconResult = AutoIconForge.ensureIcon(app, projectDir, project.appName, vision, feats, provider, activeKey, activeModel)
                iconCategory = iconResult.category
                iconSource = iconResult.source
                if (iconResult.created) {
                    onEvent(BuildEvent.Thought("Advance mode: app icon forged (${iconResult.category}, ${iconResult.source})."))
                }
            } catch (e: Exception) {
                Log.w(TAG, "Auto icon skipped: ${e.message}")
            }

            // ---- Finalize checkpoint ----
            val finalAudit = bundle.audit
            val finalReport = bundle.report
            val needsContinue = finalAudit.needsImprovement()
            BuildCheckpointStore.update(projectDir) {
                it.copy(
                    status = if (needsContinue) BuildCheckpointStore.STATUS_NEEDS_CONTINUE else BuildCheckpointStore.STATUS_DONE,
                    lastPhase = BuildPhase.S9_REPORT.name,
                    fileHashes = BuildCheckpointStore.snapshotHashes(projectDir),
                    passedProbes = bundle.allProbes.filter { probe -> !finalReport.failedDomProbes.contains(probe) },
                    lastPassedCount = finalReport.passedCount,
                    lastTotalCount = finalReport.totalCount,
                    lastScore = finalAudit.score,
                    lastFindings = (finalAudit.mustFix + finalAudit.findings).take(10),
                    lastActiveAt = System.currentTimeMillis(),
                    lastError = null
                )
            }

            AgentWorkNotifier.end(app, completed = true)
            stopServiceIfNeeded(app, buildServiceStarted)

            val summary = buildString {
                appendLine("Advance Auto-Builder finished '${project.appName}' — quality ${finalAudit.score}/100 (grade ${finalAudit.grade}).")
                if (rounds > 0) appendLine("Automatic improvement rounds: $rounds.")
                if (iconCategory.isNotBlank() && iconSource != "skipped") appendLine("App icon: $iconCategory ($iconSource).")
                if (needsContinue) {
                    appendLine("Some polish is still pending — it will continue automatically in the background. Nothing breaks meanwhile.")
                }
            }.trim()
            return Result.success(AdvanceOutcome(summary, finalAudit.score, rounds, iconCategory, iconSource, needsContinue))
        } catch (e: Exception) {
            Log.e(TAG, "Advance build failed: ${e.message}", e)
            BuildCheckpointStore.update(projectDir) {
                it.copy(status = BuildCheckpointStore.STATUS_FAILED, lastError = e.message, lastActiveAt = System.currentTimeMillis())
            }
            try {
                onEvent(BuildEvent.Failed(e.message ?: "Build failed", canResume = true))
            } catch (_: Exception) {
            }
            AgentWorkNotifier.end(app, completed = false)
            stopServiceIfNeeded(app, buildServiceStarted)
            return Result.failure(e)
        }
    }

    private fun stopServiceIfNeeded(app: Context, started: Boolean) {
        if (!started) return
        try {
            BuildService.stop(app)
        } catch (_: Exception) {
        }
    }

    // ------------------------------------------------------------------
    // Auditing: spec + document + fresh headless sandbox run.
    // ------------------------------------------------------------------

    private suspend fun runAudit(app: Context, projectDir: File): AuditBundle {
        var featureCount = 0
        var screenCount = 0
        var spec: AppSpec? = null
        val allProbes = mutableListOf<String>()
        try {
            val specFile = File(projectDir, ".saif/spec.json")
            if (specFile.exists()) {
                val json = JSONObject(specFile.readText())
                val featuresArr = json.optJSONArray("features")
                featureCount = featuresArr?.length() ?: 0
                val screensArr = json.optJSONArray("screens")
                screenCount = screensArr?.length() ?: 0
                val feats = mutableListOf<FeatureSpec>()
                if (featuresArr != null) {
                    for (i in 0 until featuresArr.length()) {
                        val obj = featuresArr.optJSONObject(i) ?: continue
                        val probesArr = obj.optJSONArray("domProbes")
                        val probes = (0 until (probesArr?.length() ?: 0)).map { probesArr!!.getString(it) }
                        allProbes.addAll(probes)
                        feats.add(
                            FeatureSpec(
                                id = obj.optString("id", "feat_$i"),
                                title = obj.optString("title", "Feature $i"),
                                priority = obj.optString("priority", "MUST"),
                                acceptance = obj.optString("acceptance", ""),
                                domProbes = probes
                            )
                        )
                    }
                }
                val screens = (0 until (screensArr?.length() ?: 0)).map { screensArr!!.getString(it) }
                spec = AppSpec(
                    appName = json.optString("appName", projectDir.name),
                    vision = json.optString("vision", ""),
                    archetype = json.optString("archetype", "app"),
                    targetUser = "Mobile User",
                    features = feats,
                    screens = screens.ifEmpty { listOf("home") },
                    dataModel = "SaifStore",
                    designSystem = DesignTokens("dark", "#8B5CF6", "#38BDF8", "#0A0D14", "#131826", "#F1F5F9"),
                    animationList = emptyList()
                )
            }
        } catch (e: Exception) {
            Log.w(TAG, "Audit spec read failed: ${e.message}")
        }

        val html = try {
            File(projectDir, "index.html").takeIf { it.exists() }?.readText().orEmpty()
        } catch (_: Exception) {
            ""
        }

        val report = try {
            SandboxRunner.testHtml(app, html, spec)
        } catch (e: Exception) {
            Log.w(TAG, "Audit sandbox failed: ${e.message}")
            TestReport(
                passed = false,
                passedCount = 0,
                totalCount = 1,
                issues = listOf(TestIssue("ERROR", "Sandbox unavailable: ${e.message}"))
            )
        }

        val audit = DeepQualityAudit.audit(
            specFeatures = featureCount,
            screens = screenCount,
            html = html,
            passedCount = report.passedCount,
            totalCount = report.totalCount,
            jsErrors = report.jsErrors,
            failedProbes = report.failedDomProbes,
            blankScreen = report.isBlankScreen,
            horizontalOverflow = report.hasHorizontalOverflow,
            smallTapTargets = report.smallTapTargetsCount
        )
        return AuditBundle(audit, report, allProbes.distinct())
    }

    // ------------------------------------------------------------------
    // Background continuation (days later, no button).
    // ------------------------------------------------------------------

    /**
     * Continues every project with pending work. Returns one human-readable line per project.
     * Safe to call from app start, the periodic worker, or the chat screen.
     */
    suspend fun continuePendingWork(
        context: Context,
        onEvent: suspend (BuildEvent) -> Unit = {}
    ): List<String> {
        val results = mutableListOf<String>()
        if (BuildService.isBuildRunning) return results
        val app = context.applicationContext
        val state = try {
            ProviderSettingsManager.loadState()
        } catch (_: Exception) {
            return results
        }
        val hasKey = state.apiKeys.any { it.isNotBlank() && !it.contains("MY_") }
        if (!hasKey) return results
        for (dir in BuildCheckpointStore.listProjectDirs(app)) {
            if (!BuildCheckpointStore.hasPendingWork(dir)) continue
            val cp = BuildCheckpointStore.load(dir)
            val project = projectFor(app, cp.appName) ?: continue
            results.add(continueOneProjectInternal(app, project, onEvent))
        }
        return results
    }

    /**
     * Continues a single project right now (used when the user reopens its chat).
     * Returns a user-facing summary line.
     */
    suspend fun continueOneProject(
        context: Context,
        project: ProjectData,
        onEvent: suspend (BuildEvent) -> Unit = {}
    ): String {
        val dir = BuildCheckpointStore.projectDirFor(context.applicationContext, project.appName)
        if (!BuildCheckpointStore.hasPendingWork(dir)) return "Sab kaam pehle se poora hai — kuch baaki nahi."
        return continueOneProjectInternal(context.applicationContext, project, onEvent)
    }

    private suspend fun continueOneProjectInternal(
        app: Context,
        project: ProjectData,
        onEvent: suspend (BuildEvent) -> Unit
    ): String {
        val projectDir = BuildCheckpointStore.projectDirFor(app, project.appName)
        val cp = BuildCheckpointStore.load(projectDir)
        AgentWorkNotifier.begin(app)
        return try {
            val findings = cp.lastFindings.take(8)
            val resumePrompt = buildString {
                appendLine("Continue this project forward from where it stopped. Do NOT redesign or remove anything.")
                if (findings.isNotEmpty()) {
                    appendLine("Resolve these pending quality items:")
                    findings.forEach { appendLine("- $it") }
                } else if (cp.lastError != null) {
                    appendLine("The previous run failed with: ${cp.lastError}. Fix the cause and complete the work.")
                } else {
                    appendLine("Review the app, fix any weakness found, and raise overall quality.")
                }
                appendLine("Keep every existing feature working.")
            }.trim()
            val result = runAdvancedBuild(app, project, resumePrompt, QualityMode.BALANCED, emptyList(), onEvent, isResume = true)
            if (result.isSuccess) {
                val outcome = result.getOrNull()!!
                "'${project.appName}' aage badh gaya — quality ${outcome.finalScore}/100." +
                    if (outcome.needsContinue) " Baaki polish background me jaari rahega." else " Kaam poora ho gaya. ✅"
            } else {
                "'${project.appName}' continue nahi ho paya (${result.exceptionOrNull()?.message}). Baad me khud retry hoga."
            }
        } catch (e: Exception) {
            "'${project.appName}' me dikkat aayi (${e.message}). Baad me khud retry hoga."
        } finally {
            AgentWorkNotifier.end(app, completed = true)
        }
    }

    private fun projectFor(context: Context, appName: String): ProjectData? {
        if (appName.isBlank()) return null
        try {
            ProjectDataManager.getProject(context, appName)?.let { return it }
        } catch (_: Exception) {
        }
        return try {
            val sanitized = BuildCheckpointStore.sanitize(appName)
            val pkg = "com.example." + sanitized.lowercase().replace(Regex("[^a-z0-9]"), "").ifBlank { "app" }
            ProjectData(
                appName = appName,
                packageName = pkg,
                minSdk = 24,
                targetSdk = 34,
                buildStudio = "SAIF AI Studio",
                language = "Java",
                iconBitmap = try {
                    ProjectDataManager.loadProjectIcon(context, appName)
                } catch (_: Exception) {
                    null
                }
            )
        } catch (_: Exception) {
            null
        }
    }
}
