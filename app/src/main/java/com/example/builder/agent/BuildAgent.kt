package com.example.builder.agent

import android.content.Context
import android.util.Log
import com.example.builder.safety.EnvelopeItem
import com.example.builder.safety.EnvelopeParser
import com.example.builder.safety.HtmlGuard
import com.example.builder.safety.PatchApplier
import com.example.autobuild.BuildCheckpointStore
import com.example.builder.safety.VersionManager
import com.example.data.local.ProviderSettingsManager
import com.example.llm.*
import com.example.ui.components.ProjectData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.util.UUID

/**
 * Autonomous Multi-Stage App Builder Engine.
 * Transforms any prompt (short 3-word or complex long) into a complete, working,
 * self-testing Android WebView mobile application through staged product architecture.
 */
object BuildAgent {
    private const val TAG = "BuildAgent"

    /** Maximum parallel agent lanes for one build (big tasks fan out up to this many). */
    const val MAX_PARALLEL_LANES = 8

    /**
     * First-try per-call output request for code generation. Models with a smaller real
     * maximum are handled by halving retries inside [callWithContinuation]; providers with
     * tight rate windows are clamped per call by [TokenBudgetManager]. Either way the loop
     * below keeps appending while the model reports length-truncation, so a file can grow
     * to whatever size the app genuinely needs instead of being cut off by a small cap.
     */
    const val CODER_MAX_OUTPUT_TOKENS = 16384

    /** How many times one generation may continue after a length-truncated response. */
    const val MAX_CONTINUATIONS = 8

    /**
     * True when the provider cut the response because it hit its output limit
     * (OpenAI "length", Gemini "MAX_TOKENS", Anthropic "max_tokens").
     */
    fun isLengthTruncation(finishReason: String?): Boolean {
        if (finishReason == null) return false
        val r = finishReason.trim().lowercase()
        return r == "length" || r == "max_tokens" || r == "maxtokens"
    }

    /**
     * Executes the autonomous multi-stage build pipeline.
     *
     * @param resumeFromCheckpoint when true, an identical in-progress plan keeps its spec,
     * plan and already-finished tasks: S1/S2 are loaded from disk and completed tasks are
     * skipped instead of rebuilt from scratch.
     */
    suspend fun run(
        context: Context,
        project: ProjectData,
        prompt: String,
        qualityMode: QualityMode = QualityMode.MAX,
        base64Images: List<String> = emptyList(),
        parallelAgents: Int = 1,
        frozenFiles: Set<String> = emptySet(),
        briefGuidance: String = "",
        onEvent: suspend (BuildEvent) -> Unit,
        resumeFromCheckpoint: Boolean = false
    ): Result<String> = withContext(Dispatchers.IO) {
        val sanitizedAppName = project.appName.replace(Regex("[^a-zA-Z0-9_]"), "_").ifBlank { "Project" }
        val projectDir = File(context.filesDir, "projects/$sanitizedAppName").apply { mkdirs() }
        val saifDir = File(projectDir, ".saif").apply { mkdirs() }
        val workDir = File(saifDir, "work").apply { mkdirs() }

        val rootHtml = File(projectDir, "index.html")
        val currentHtml = if (rootHtml.exists() && rootHtml.length() > 50) rootHtml.readText() else ""
        val isExistingApp = currentHtml.contains(Assembler.SAIF_BUILD_MARKER)

        val state = ProviderSettingsManager.loadState()
        val provider = state.providerName.ifBlank { "Gemini" }
        val keys = state.apiKeys.filter { it.isNotBlank() && !it.contains("MY_") }
        val activeKey = keys.firstOrNull() ?: ""
        val activeModel = state.buildModel.ifBlank { state.activeModel }

        val jobId = "job_${System.currentTimeMillis()}"

        // Advance Auto-Builder: every stage is checkpointed to disk so an interrupted
        // build (app kill, reboot, days of gap) can resume exactly where it stopped.
        suspend fun trackPhase(phase: BuildPhase, index: Int, total: Int) {
            try {
                BuildCheckpointStore.update(projectDir) {
                    it.copy(
                        status = BuildCheckpointStore.STATUS_RUNNING,
                        lastPhase = phase.name,
                        lastActiveAt = System.currentTimeMillis()
                    )
                }
            } catch (_: Exception) {}
            onEvent(BuildEvent.PhaseStarted(phase, index, total))
        }

        try {
            // -------------------------------------------------------------
            // STAGE S0: INTAKE & LANGUAGE/INTENT CLASSIFICATION
            // -------------------------------------------------------------
            trackPhase(BuildPhase.S0_INTAKE, 1, 10)
            val intent = classifyIntent(prompt, isExistingApp)
            val job = BuildJob(
                jobId = jobId,
                projectAppName = project.appName,
                originalPrompt = prompt,
                intent = intent,
                qualityMode = qualityMode,
                currentPhase = BuildPhase.S0_INTAKE,
                totalTasks = 8
            )
            saveJobState(saifDir, job)

            // If prompt is large, distill it into clean requirements
            val distilledPrompt = if (prompt.length > 3500) {
                File(saifDir, "original_prompt.txt").writeText(prompt)
                distillLongPrompt(prompt, provider, activeKey, activeModel)
            } else {
                prompt
            }

            onEvent(BuildEvent.Thought("Detected intent: $intent (${detectLanguage(prompt)})"))

            // -------------------------------------------------------------
            // STAGE S1: SPECIFICATION ("Product Brain")
            // -------------------------------------------------------------
            trackPhase(BuildPhase.S1_SPEC, 2, 10)
            val resumedSpec = if (resumeFromCheckpoint) loadSpecFromDisk(saifDir) else null
            val spec = if (resumedSpec != null) {
                onEvent(BuildEvent.Thought("Resuming: reusing the saved product spec (${resumedSpec.features.size} features, ${resumedSpec.screens.size} screens)..."))
                resumedSpec
            } else {
                onEvent(BuildEvent.Thought("Architecting comprehensive product spec with feature rubrics..."))
                val archetypeRules = loadArchetypeRules(context, prompt)
                val fresh = generateSpec(project.appName, distilledPrompt, intent, archetypeRules, provider, activeKey, activeModel, briefGuidance)
                File(saifDir, "spec.json").writeText(specToJson(fresh).toString(2))
                onEvent(BuildEvent.Thought("Spec ready: ${fresh.features.size} features defined across ${fresh.screens.size} screens"))
                fresh
            }

            // -------------------------------------------------------------
            // STAGE S2: TASK PLANNING & INTERFACE CONTRACT
            // -------------------------------------------------------------
            trackPhase(BuildPhase.S2_PLAN, 3, 10)
            val resumedPlan = if (resumeFromCheckpoint) loadPlanFromDisk(saifDir) else null
            val planIsResumed = resumedPlan != null
            val plan = if (resumedPlan != null) {
                onEvent(BuildEvent.Thought("Resuming: reusing the saved task plan (${resumedPlan.tasks.size} tasks)..."))
                resumedPlan
            } else {
                onEvent(BuildEvent.Thought("Splitting spec into modules for the agent swarm..."))
                val fresh = generatePlan(spec, qualityMode, provider, activeModel, isExistingApp, intent, prompt, frozenFiles)
                File(saifDir, "plan.json").writeText(planToJson(fresh).toString(2))
                fresh
            }
            saveJobState(saifDir, job.copy(totalTasks = plan.tasks.size, currentPhase = BuildPhase.S2_PLAN))

            val manifest = generateManifest(spec, plan)
            File(saifDir, "manifest.json").writeText(manifestToJson(manifest).toString(2))

            // Resume bookkeeping: remember this plan; when the stored signature matches,
            // already-finished tasks are skipped instead of rebuilt from scratch.
            val planSig = BuildCheckpointStore.planSignatureFor(plan.tasks.map { it.id to it.targetFiles.joinToString(",") })
            val previousCp = try {
                BuildCheckpointStore.load(projectDir)
            } catch (_: Exception) {
                BuildCheckpointStore.default(project.appName)
            }
            val planMatches = previousCp.planSignature.isNotBlank() && previousCp.planSignature == planSig
            val resumeSkips: Set<String> =
                if ((resumeFromCheckpoint || planIsResumed) && planMatches) {
                    previousCp.completedTaskIds.intersect(plan.tasks.map { it.id }.toSet())
                } else {
                    emptySet()
                }
            BuildCheckpointStore.update(projectDir) {
                it.copy(
                    plannedTaskIds = plan.tasks.map { t -> t.id },
                    planSignature = planSig,
                    completedTaskIds = if (resumeSkips.isNotEmpty()) it.completedTaskIds else emptyList()
                )
            }
            if (resumeSkips.isNotEmpty()) {
                onEvent(BuildEvent.Thought("Continuing exactly where we stopped — skipping ${resumeSkips.size} already-finished tasks, no rebuild from scratch."))
            }

            // -------------------------------------------------------------
            // STAGE S3: PARALLEL/INCREMENTAL CODE GENERATION
            // -------------------------------------------------------------
            trackPhase(BuildPhase.S3_GENERATE, 4, 10)
            val moduleFiles = mutableMapOf<String, String>()

            // Load existing module files if available
            val srcDir = File(projectDir, "src")
            if (srcDir.exists()) {
                srcDir.walkTopDown().filter { it.isFile }.forEach { f ->
                    val rel = "src/" + f.relativeTo(srcDir).path.replace('\\', '/')
                    moduleFiles[rel] = f.readText()
                }
            }

            val tasksToExecute = plan.tasks.filter { it.id !in resumeSkips }
            val freshPlanIsDelta = !planIsResumed && isDeltaRequest(isExistingApp, intent, prompt)
            // Full rebuild of an existing app: drop stale generated screens/features that the new
            // plan no longer owns, so old files can never be assembled twice. Delta runs never delete.
            if (isExistingApp && !planIsResumed && !freshPlanIsDelta) {
                val wanted = plan.tasks.flatMap { it.targetFiles }.toSet()
                val stale = synchronized(moduleFiles) {
                    moduleFiles.keys.filter { k ->
                        (k.startsWith("src/screens/") || k.startsWith("src/features/")) && k !in wanted
                    }
                }
                for (k in stale) {
                    synchronized(moduleFiles) { moduleFiles.remove(k) }
                    try {
                        File(srcDir, k.removePrefix("src/").removePrefix("/")).delete()
                    } catch (_: Exception) {
                    }
                }
                if (stale.isNotEmpty()) {
                    onEvent(BuildEvent.Thought("Full rebuild: cleared ${stale.size} stale generated files..."))
                }
            }
            // Continue-forward rule injected into every coder call. Delta runs get the lighter
            // version so the agent is free to touch exactly the files the request needs.
            val frozenInstruction = if (frozenFiles.isEmpty()) {
                ""
            } else if (freshPlanIsDelta) {
                "CONTINUE-FORWARD: this is a surgical change on a working app. Keep every existing feature " +
                    "working; modify ONLY what the request needs (you may edit existing files and add new ones " +
                    "via envelopes). Do not redesign, remove or rewrite anything else."
            } else {
                "STRICT CONTINUE-FORWARD RULE: keep every existing feature working. " +
                    "Do NOT rewrite, remove or redesign these existing files unless this task explicitly requires it: " +
                    frozenFiles.sorted().joinToString(", ") + "."
            }
            // Serializes progress events when several agents report at once.
            val eventMutex = Mutex()
            suspend fun emit(event: BuildEvent) = eventMutex.withLock { onEvent(event) }

            suspend fun executeTask(task: BuildTask, agentId: String = "", agentName: String = "") {
                emit(BuildEvent.TaskStarted(task.id, task.title, task.targetFiles.firstOrNull() ?: "", agentId, agentName))

                val generatedCode = generateTaskModules(
                    spec = spec,
                    manifest = manifest,
                    task = task,
                    existingModules = synchronized(moduleFiles) { moduleFiles.toMap() },
                    provider = provider,
                    apiKey = activeKey,
                    model = activeModel,
                    frozenInstruction = frozenInstruction,
                    onChunk = { snippet ->
                        emit(BuildEvent.Writing(task.targetFiles.firstOrNull() ?: "", snippet.length, snippet.takeLast(60), agentId, agentName))
                    },
                    onWaiting = { reason, sec ->
                        emit(BuildEvent.Waiting(reason, sec))
                    }
                )

                // Parse envelopes only (drops leaked chain of thought!)
                val envelopeResult = EnvelopeParser.parse(generatedCode)
                for (item in envelopeResult.items) {
                    when (item) {
                        is EnvelopeItem.FileEnvelope -> {
                            synchronized(moduleFiles) { moduleFiles[item.path] = item.content }
                            // Save to disk work cache
                            val workFile = File(workDir, item.path.replace('/', '_'))
                            try {
                                workFile.writeText(item.content)
                            } catch (_: Exception) {}
                        }
                        is EnvelopeItem.PatchEnvelope -> {
                            val original = synchronized(moduleFiles) { moduleFiles[item.path] ?: "" }
                            val patchRes = PatchApplier.apply(original, item.patchContent)
                            if (patchRes.success) {
                                synchronized(moduleFiles) { moduleFiles[item.path] = patchRes.updatedText }
                                emit(BuildEvent.Editing(item.path, patchRes.appliedHunks, agentId, agentName))
                            } else {
                                Log.w(TAG, "Patch failed for ${item.path}: ${patchRes.failedHunks.size} hunks failed")
                            }
                        }
                    }
                }
                try {
                    BuildCheckpointStore.update(projectDir) {
                        it.copy(
                            completedTaskIds = (it.completedTaskIds + task.id).distinct(),
                            lastActiveAt = System.currentTimeMillis()
                        )
                    }
                } catch (_: Exception) {}
            }

            // Live agent roster, shown in the chat so the user sees how many agents run
            // at once and what each one is doing right now.
            val roster = mutableListOf<BuildAgentStatus>()
            suspend fun publishRoster() = emit(BuildEvent.AgentsUpdate(roster.toList()))
            suspend fun setAgent(id: String, state: String, taskTitle: String = "", file: String = "") {
                val idx = roster.indexOfFirst { it.id == id }
                if (idx != -1) {
                    roster[idx] = roster[idx].copy(state = state, taskTitle = taskTitle, file = file)
                    publishRoster()
                }
            }

            if (parallelAgents > 1 && tasksToExecute.size > 1) {
                // Swarm mode: every lane is a named agent that owns its tasks round-robin.
                val lanes = parallelAgents.coerceIn(1, MAX_PARALLEL_LANES).coerceAtMost(tasksToExecute.size)
                for (i in 1..lanes) {
                    roster.add(BuildAgentStatus(id = "agent_$i", name = "Agent-$i", state = AGENT_WAITING))
                }
                emit(BuildEvent.Thought("Swarm mode: ${tasksToExecute.size} tasks across $lanes parallel agents..."))
                publishRoster()
                supervisorScope {
                    (0 until lanes).map { lane ->
                        async {
                            val agent = roster[lane]
                            for (ti in lane until tasksToExecute.size step lanes) {
                                ensureActive()
                                val task = tasksToExecute[ti]
                                setAgent(agent.id, AGENT_WORKING, task.title, task.targetFiles.firstOrNull() ?: "")
                                try {
                                    executeTask(task, agent.id, agent.name)
                                } finally {
                                    setAgent(agent.id, AGENT_WAITING)
                                }
                            }
                        }
                    }.awaitAll()
                }
                for (i in roster.indices) {
                    roster[i] = roster[i].copy(state = AGENT_DONE, taskTitle = "", file = "")
                }
                publishRoster()
            } else {
                if (tasksToExecute.isNotEmpty()) {
                    roster.add(BuildAgentStatus(id = "agent_1", name = "Agent-1", state = AGENT_WORKING))
                    publishRoster()
                    for (task in tasksToExecute) {
                        setAgent("agent_1", AGENT_WORKING, task.title, task.targetFiles.firstOrNull() ?: "")
                        executeTask(task, "agent_1", "Agent-1")
                    }
                    roster[0] = roster[0].copy(state = AGENT_DONE, taskTitle = "", file = "")
                    publishRoster()
                }
            }

            // Save all generated modules into projects/<App>/src/
            srcDir.mkdirs()
            for ((path, content) in moduleFiles) {
                val cleanRel = path.removePrefix("src/").removePrefix("/")
                val file = File(srcDir, cleanRel)
                file.parentFile?.mkdirs()
                file.writeText(content)
            }

            // -------------------------------------------------------------
            // STAGE S4: ASSEMBLE & STATIC CHECKS
            // -------------------------------------------------------------
            trackPhase(BuildPhase.S4_ASSEMBLE, 5, 10)
            onEvent(BuildEvent.Thought("Assembling modules into self-contained HTML document..."))

            var assembledHtml = Assembler.assemble(project.appName, spec, moduleFiles)
            val guardResult = HtmlGuard.validate(assembledHtml)
            onEvent(BuildEvent.StaticCheck(guardResult.isValid, guardResult.issues))

            // -------------------------------------------------------------
            // STAGE S5: SANDBOX TEST
            // -------------------------------------------------------------
            trackPhase(BuildPhase.S5_SANDBOX, 6, 10)
            onEvent(BuildEvent.Thought("Launching headless WebView sandbox and running DOM probes..."))

            var testReport = SandboxRunner.testHtml(context, assembledHtml, spec)
            onEvent(BuildEvent.SandboxRun(testReport.passed, testReport.issues.map { it.message }, testReport.passedCount, testReport.totalCount))

            // -------------------------------------------------------------
            // STAGE S6: SELF-FIX LOOP (Up to 3 rounds)
            // -------------------------------------------------------------
            if (!testReport.passed && qualityMode != QualityMode.QUICK) {
                trackPhase(BuildPhase.S6_FIX, 7, 10)
                var fixRound = 0
                val maxFixRounds = 3

                while (!testReport.passed && fixRound < maxFixRounds) {
                    fixRound++
                    val issueSummary = testReport.issues.firstOrNull()?.message ?: "Runtime error"
                    onEvent(BuildEvent.Fixing(fixRound, issueSummary))

                    val fixedModules = executeFixRound(
                        spec = spec,
                        manifest = manifest,
                        report = testReport,
                        moduleFiles = moduleFiles,
                        round = fixRound,
                        provider = provider,
                        apiKey = activeKey,
                        model = activeModel
                    )

                    moduleFiles.putAll(fixedModules)
                    assembledHtml = Assembler.assemble(project.appName, spec, moduleFiles)
                    testReport = SandboxRunner.testHtml(context, assembledHtml, spec)
                    onEvent(BuildEvent.SandboxRun(testReport.passed, testReport.issues.map { it.message }, testReport.passedCount, testReport.totalCount))
                }
            }

            // -------------------------------------------------------------
            // STAGE S7: POLISH PASS (Balanced & Max modes)
            // -------------------------------------------------------------
            if (qualityMode == QualityMode.MAX && testReport.passed) {
                trackPhase(BuildPhase.S7_POLISH, 8, 10)
                onEvent(BuildEvent.Thought("Running visual polish, animation timing, and contrast check..."))
                delay(300)
            }

            // -------------------------------------------------------------
            // STAGE S8: ATOMIC COMMIT TO DISK
            // -------------------------------------------------------------
            trackPhase(BuildPhase.S8_COMMIT, 9, 10)
            val commitResult = VersionManager.commitAtomic(
                projectDir = projectDir,
                htmlContent = assembledHtml,
                prompt = prompt,
                summary = "Generated ${spec.features.size} features for ${spec.appName}",
                changedFiles = listOf("index.html") + moduleFiles.keys.toList(),
                testPassedCount = testReport.passedCount,
                testTotalCount = testReport.totalCount
            )

            val versionNum = commitResult.getOrDefault(1)
            onEvent(BuildEvent.Committed(versionNum))

            // -------------------------------------------------------------
            // STAGE S9: SUMMARY REPORT & NEXT FEATURE IDEAS
            // -------------------------------------------------------------
            trackPhase(BuildPhase.S9_REPORT, 10, 10)
            val nextIdeas = generateNextFeatureIdeas(spec, prompt)
            val summaryText = buildSummaryReport(spec, testReport, versionNum)

            // Update persistent project memory
            updateProjectMemory(saifDir, spec, prompt, nextIdeas)

            onEvent(BuildEvent.ReportReady(summaryText, nextIdeas, testReport.qualityScore))

            Result.success(summaryText)
        } catch (e: Exception) {
            Log.e(TAG, "Build pipeline failed: ${e.message}", e)
            onEvent(BuildEvent.Failed(e.message ?: "Build failed", canResume = true))
            Result.failure(e)
        }
    }

    private fun detectLanguage(prompt: String): String {
        val lower = prompt.lowercase()
        val hindiMarkers = listOf("banao", "karo", "chahiye", "aur", "iska", "accha", "khol", "chalao")
        val isHindi = hindiMarkers.any { lower.contains(it) } || prompt.any { it in '\u0900'..'\u097F' }
        return if (isHindi) "Hinglish / Hindi" else "English"
    }

    private fun classifyIntent(prompt: String, isExistingApp: Boolean): BuildIntent {
        val lower = prompt.lowercase()
        return when {
            lower.contains("scratch se") || lower.contains("fresh start") || lower.contains("reset karo") || lower.contains("delete karke") ->
                BuildIntent.RESET
            !isExistingApp ->
                BuildIntent.NEW_APP
            lower.contains("ui") || lower.contains("design") || lower.contains("color") || lower.contains("anim") || lower.contains("theme") ->
                BuildIntent.RESTYLE
            lower.contains("fix") || lower.contains("bug") || lower.contains("error") || lower.contains("glitch") || lower.contains("thik karo") ->
                BuildIntent.FIX_BUG
            else ->
                BuildIntent.ADD_FEATURE
        }
    }

    private suspend fun distillLongPrompt(prompt: String, provider: String, key: String, model: String): String {
        val req = LlmRequest(
            prompt = "Extract and deduplicate all key functional and UI requirements from this long prompt as concise bullet points:\n\n$prompt",
            systemPrompt = "You are a senior requirements analyst. Output clean bullet points only.",
            mode = "coding"
        )
        val res = LlmGateway.call(LlmRole.PLANNER, provider, key, model, req)
        return res.getOrNull()?.text ?: prompt.take(3000)
    }

    private fun loadArchetypeRules(context: Context, prompt: String): String {
        return try {
            val jsonStr = context.assets.open("app_archetypes.json").bufferedReader().use { it.readText() }
            val root = JSONObject(jsonStr)
            val lower = prompt.lowercase()
            for (key in root.keys()) {
                val obj = root.getJSONObject(key)
                val keywords = obj.optJSONArray("keywords")
                if (keywords != null) {
                    for (i in 0 until keywords.length()) {
                        if (lower.contains(keywords.getString(i))) {
                            return "ARCHETYPE (${obj.optString("name")}):\n" + obj.optJSONArray("must_have")?.toString()
                        }
                    }
                }
            }
            ""
        } catch (e: Exception) {
            ""
        }
    }

    private suspend fun generateSpec(
        appName: String,
        prompt: String,
        intent: BuildIntent,
        archetypeRules: String,
        provider: String,
        key: String,
        model: String,
        briefGuidance: String = ""
    ): AppSpec {
        val briefSection = if (briefGuidance.isNotBlank()) {
            "\nADVANCE BRIEF (follow it strictly, exceed it where possible):\n$briefGuidance"
        } else {
            ""
        }
        val systemPrompt = """
            You are the Lead Product Architect for Saif AI.
            Create a complete, rich product spec in JSON format.
            RUBRIC:
            - At least 12 distinct user-visible features across at least 4 screens/tabs.
            - Include first-run guidance, empty states, error states, and local persistence.
            - Specify exact designSystem colors with contrast >= 4.5:1.
            $archetypeRules$briefSection
            Return ONLY valid JSON matching this schema:
            {
              "appName": "$appName",
              "vision": "string",
              "archetype": "string",
              "targetUser": "string",
              "features": [ {"id": "feat_1", "title": "...", "priority": "MUST", "acceptance": "...", "domProbes": ["#btn_start"]} ],
              "screens": ["home", "game", "stats", "settings"],
              "dataModel": "string summary",
              "designSystem": { "mood": "dark", "primaryColor": "#8B5CF6", "accentColor": "#38BDF8", "backgroundColor": "#0A0D14", "surfaceColor": "#131826", "textColor": "#F1F5F9" },
              "animationList": ["dice_roll", "modal_fade", "card_slide", "token_bounce", "winner_confetti"],
              "assumptions": ["Assumed 2-4 players", "Assumed local vs AI mode"]
            }
        """.trimIndent()

        val req = LlmRequest(
            prompt = "User prompt: $prompt\nApp Name: $appName",
            systemPrompt = systemPrompt,
            mode = "coding",
            jsonMode = true
        )

        val res = LlmGateway.call(LlmRole.PLANNER, provider, key, model, req)
        val text = res.getOrNull()?.text ?: ""
        return parseSpecJson(text, appName, prompt)
    }

    private fun parseSpecJson(raw: String, fallbackAppName: String, prompt: String): AppSpec {
        try {
            val clean = raw.trim().removePrefix("```json").removePrefix("```").removeSuffix("```").trim()
            val start = clean.indexOf('{')
            val end = clean.lastIndexOf('}')
            if (start != -1 && end > start) {
                val json = JSONObject(clean.substring(start, end + 1))
                val featuresArr = json.optJSONArray("features") ?: JSONArray()
                val featureList = mutableListOf<FeatureSpec>()
                for (i in 0 until featuresArr.length()) {
                    val fObj = featuresArr.getJSONObject(i)
                    val probesArr = fObj.optJSONArray("domProbes") ?: JSONArray()
                    val probes = (0 until probesArr.length()).map { probesArr.getString(it) }
                    featureList.add(FeatureSpec(
                        id = fObj.optString("id", "feat_$i"),
                        title = fObj.optString("title", "Feature $i"),
                        priority = fObj.optString("priority", "MUST"),
                        acceptance = fObj.optString("acceptance", ""),
                        domProbes = probes
                    ))
                }

                val screensArr = json.optJSONArray("screens") ?: JSONArray()
                val screenList = (0 until screensArr.length()).map { screensArr.getString(it) }

                val dsObj = json.optJSONObject("designSystem")
                val ds = DesignTokens(
                    mood = dsObj?.optString("mood", "dark_obsidian") ?: "dark_obsidian",
                    primaryColor = dsObj?.optString("primaryColor", "#8B5CF6") ?: "#8B5CF6",
                    accentColor = dsObj?.optString("accentColor", "#38BDF8") ?: "#38BDF8",
                    backgroundColor = dsObj?.optString("backgroundColor", "#0A0D14") ?: "#0A0D14",
                    surfaceColor = dsObj?.optString("surfaceColor", "#131826") ?: "#131826",
                    textColor = dsObj?.optString("textColor", "#F1F5F9") ?: "#F1F5F9"
                )

                val animArr = json.optJSONArray("animationList") ?: JSONArray()
                val animList = (0 until animArr.length()).map { animArr.getString(it) }

                val assumptionsArr = json.optJSONArray("assumptions") ?: JSONArray()
                val assumptionsList = (0 until assumptionsArr.length()).map { assumptionsArr.getString(it) }

                return AppSpec(
                    appName = json.optString("appName", fallbackAppName),
                    vision = json.optString("vision", prompt),
                    archetype = json.optString("archetype", "app"),
                    targetUser = json.optString("targetUser", "Mobile User"),
                    features = featureList,
                    screens = screenList.ifEmpty { listOf("home", "main", "settings") },
                    dataModel = json.optString("dataModel", "StateStore"),
                    designSystem = ds,
                    animationList = animList,
                    assumptions = assumptionsList
                )
            }
        } catch (e: Exception) {
            Log.w(TAG, "Failed parsing spec JSON: ${e.message}")
        }

        // Default rich fallback spec
        return AppSpec(
            appName = fallbackAppName,
            vision = prompt,
            archetype = "interactive_app",
            targetUser = "Android User",
            features = listOf(
                FeatureSpec("feat_core", "Core Interactive Engine", "MUST", "Functional interactive controls", listOf("#app-root")),
                FeatureSpec("feat_storage", "Persistent State", "MUST", "Saved stats in localStorage", listOf("#app-root")),
                FeatureSpec("feat_ui", "Liquid Dark Design System", "MUST", "Responsive 100dvh layout", listOf("body"))
            ),
            screens = listOf("home", "main", "settings"),
            dataModel = "SaifStore",
            designSystem = DesignTokens("dark", "#8B5CF6", "#38BDF8", "#0A0D14", "#131826", "#F1F5F9"),
            animationList = listOf("fade_in", "press_feedback", "pulse")
        )
    }

    /**
     * True when the user explicitly wants the whole app rebuilt (not a surgical change).
     * System continuation prompts and negated mentions ("never redesign", "dobara mat
     * banao") never count as rebuild requests. Pure logic, covered by unit tests.
     */
    fun promptMentionsEverything(prompt: String): Boolean {
        val lower = prompt.lowercase()
        // System continuation prompts always continue forward, never rebuild.
        if (lower.contains("continue-forward")) return false
        val keywords = listOf(
            "everything", "entire app", "whole app", "full app", "complete app",
            "scratch", "reset", "rebuild", "redesign", "rewrite",
            "sab", "poora", "pura", "sara", "dobara banao", "phir se banao", "naya banao"
        )
        var text = " $lower "
        for (kw in keywords) {
            val q = Regex.escape(kw)
            // Negation before the keyword, allowing a few words in between
            // ("never remove or redesign", "do not rewrite it").
            text = text.replace(Regex("""\b(do not|don't|dont|never|not|no|without|avoid)\s+(?:\S+\s+){0,3}?$q\b"""), " ")
            // Hindi negation after the keyword ("dobara mat banao", "scratch mat karo").
            text = text.replace(Regex("""\b$q(?:\s+\S+){0,2}?\s+(mat|nahi|nahin)\b"""), " ")
        }
        return keywords.any { Regex("""\b${Regex.escape(it)}\b""").containsMatchIn(text) }
    }

    /**
     * True when this run should only touch what the request needs instead of regenerating
     * the whole app: an existing app plus a focused follow-up prompt. Pure logic for tests.
     */
    fun isDeltaRequest(isExistingApp: Boolean, intent: BuildIntent, prompt: String): Boolean {
        if (!isExistingApp) return false
        if (intent == BuildIntent.NEW_APP || intent == BuildIntent.RESET) return false
        return !promptMentionsEverything(prompt)
    }

    /**
     * Builds the task list for a run. New / full-rebuild runs fan out: one task per screen
     * plus one task per feature group, so big apps spread across many parallel agents.
     * Follow-up runs on a working app get a small delta plan that only touches what the
     * request needs — never a scratch rebuild. Pure logic, covered by unit tests.
     */
    fun createTaskPlan(
        spec: AppSpec,
        isExistingApp: Boolean,
        intent: BuildIntent,
        prompt: String,
        frozenFiles: Set<String>
    ): List<BuildTask> {
        if (isDeltaRequest(isExistingApp, intent, prompt)) {
            return deltaTasksFor(prompt, frozenFiles)
        }
        return fullTasksFor(spec)
    }

    /** Full plan for a new app or an explicit full rebuild. One screen = one task. */
    fun fullTasksFor(spec: AppSpec): List<BuildTask> {
        val tasks = mutableListOf<BuildTask>()
        tasks.add(BuildTask("task_1_tokens", "Tokens & Base Styles", listOf("src/tokens.css", "src/base.css"), expectedOutputTokens = 3000))
        tasks.add(BuildTask("task_2_state", "Safe State Store & Utilities", listOf("src/state.js", "src/ui.js"), expectedOutputTokens = 3500))
        tasks.add(BuildTask("task_3_components", "Component Styling & Layouts", listOf("src/components.css"), expectedOutputTokens = 4000))
        val screens = spec.screens.filter { it.isNotBlank() }.distinct().take(12).ifEmpty { listOf("main") }
        screens.forEachIndexed { i, screen ->
            val slug = screen.lowercase().replace(Regex("[^a-z0-9]+"), "_").trim('_').ifBlank { "screen$i" }
            tasks.add(BuildTask("task_screen_$slug", "Screen: $screen", listOf("src/screens/$slug.html"), expectedOutputTokens = 4000))
        }
        val feats = spec.features
        if (feats.isEmpty()) {
            tasks.add(BuildTask("task_5_features", "Core Feature Logic", listOf("src/features/engine.js"), expectedOutputTokens = 6000))
        } else {
            feats.chunked(3).forEachIndexed { gi, group ->
                val file = if (gi == 0) "src/features/engine.js" else "src/features/group_${gi + 1}.js"
                val titles = group.joinToString(", ") { it.title.take(36) }
                tasks.add(BuildTask("task_feat_g${gi + 1}", "Features: $titles", listOf(file), expectedOutputTokens = 6000))
            }
        }
        tasks.add(BuildTask("task_6_main", "Main Controller & Event Wiring", listOf("src/main.js"), expectedOutputTokens = 3000))
        return tasks.take(24)
    }

    /**
     * Small plan for a follow-up on a working app: only base tasks whose files the prompt
     * actually touches, plus one targeted task for the requested change.
     */
    fun deltaTasksFor(prompt: String, frozenFiles: Set<String>): List<BuildTask> {
        val base = listOf(
            BuildTask("task_1_tokens", "Tokens & Base Styles", listOf("src/tokens.css", "src/base.css"), expectedOutputTokens = 3000),
            BuildTask("task_2_state", "Safe State Store & Utilities", listOf("src/state.js", "src/ui.js"), expectedOutputTokens = 3500),
            BuildTask("task_3_components", "Component Styling & Layouts", listOf("src/components.css"), expectedOutputTokens = 4000),
            BuildTask("task_6_main", "Main Controller & Event Wiring", listOf("src/main.js"), expectedOutputTokens = 3000)
        )
        val touched = base.filter { t -> t.targetFiles.any { f -> f !in frozenFiles } }
        val target = guessDeltaTarget(prompt)
        val short = prompt.trim().replace(Regex("\\s+"), " ").take(60).ifBlank { "requested change" }
        val delta = BuildTask(
            "task_delta_${(kotlin.math.abs(prompt.hashCode()) % 900) + 100}",
            "Requested change: $short",
            listOf(target),
            expectedOutputTokens = 6000
        )
        return (touched + delta).distinctBy { it.id }.ifEmpty { listOf(delta) }
    }

    /** Best-guess file for a follow-up change: an explicitly named file, else a category default. */
    fun guessDeltaTarget(prompt: String): String {
        Regex("""([A-Za-z0-9_\-/]+\.(css|js|html))\b""").find(prompt)?.let { m ->
            val hit = m.groupValues[1]
            return if (hit.startsWith("src/")) hit else "src/$hit"
        }
        val lower = prompt.lowercase()
        return when {
            listOf("color", "colour", "theme", "style", "css", "design", "look", "button color").any { lower.contains(it) } -> "src/components.css"
            listOf("screen", "page", "layout", "html", "menu", "tab", "navigation").any { lower.contains(it) } -> "src/screens/main.html"
            else -> "src/features/update.js"
        }
    }

    private fun generatePlan(
        spec: AppSpec,
        mode: QualityMode,
        provider: String,
        model: String,
        isExistingApp: Boolean,
        intent: BuildIntent,
        prompt: String,
        frozenFiles: Set<String>
    ): BuildPlan {
        val ceiling = TokenBudgetManager.calculateBudgetCeiling(provider, model)
        val targetTier = if (ceiling <= 10_000) "TINY" else if (ceiling <= 60_000) "MEDIUM" else "RICH"
        val tasks = createTaskPlan(spec, isExistingApp, intent, prompt, frozenFiles)
        return BuildPlan(tasks = tasks, targetTier = targetTier)
    }

    private fun generateManifest(spec: AppSpec, plan: BuildPlan): BuildManifest {
        val modules = mutableListOf(
            ModuleContract("src/tokens.css", cssClasses = listOf("app-theme")),
            ModuleContract("src/state.js", exportedFunctions = listOf("SaifStore.get", "SaifStore.set")),
            ModuleContract("src/ui.js", exportedFunctions = listOf("SaifUI.toast", "SaifUI.haptic")),
            ModuleContract("src/main.js", exportedFunctions = listOf("initApp"))
        )
        val screenFiles = plan.tasks.flatMap { it.targetFiles }.filter { it.startsWith("src/screens/") }.distinct().sorted()
        screenFiles.forEachIndexed { i, path ->
            val slug = path.substringAfterLast('/').removeSuffix(".html")
            // The alphabetically-first screen owns the shared shell; the rest are pure content.
            val ids = if (i == 0) listOf("app-root", "main-content", "screen-$slug") else listOf("screen-$slug")
            modules.add(ModuleContract(path, domIds = ids))
        }
        if (screenFiles.isEmpty()) {
            modules.add(ModuleContract("src/screens/main.html", domIds = listOf("app-root", "main-content")))
        }
        val featureFiles = plan.tasks.flatMap { it.targetFiles }.filter { it.startsWith("src/features/") }.distinct()
        featureFiles.forEach { path ->
            modules.add(ModuleContract(path, exportedFunctions = listOf("initFeatures")))
        }
        return BuildManifest(modules)
    }

    private suspend fun generateTaskModules(
        spec: AppSpec,
        manifest: BuildManifest,
        task: BuildTask,
        existingModules: Map<String, String>,
        provider: String,
        apiKey: String,
        model: String,
        frozenInstruction: String = "",
        onChunk: suspend (String) -> Unit,
        onWaiting: suspend (String, Int) -> Unit
    ): String {
        val targetFilesStr = task.targetFiles.joinToString(", ")
        val systemPrompt = """
            You are a Senior Front-End Engineer for Saif AI.
            Output ONLY raw envelopes:
            <file path="src/...">
            code
            </file>
            Do NOT include markdown, explanations, or prose outside the envelopes.
            Use standard Web APIs, modern CSS, inline SVG, and safe localStorage.
            No alert(), confirm(), or prompt(). 44px min touch targets.
            Screen files (src/screens/*.html) are fragments assembled into ONE page: each must be
            exactly one <section id="screen-<name>" class="saif-screen">...</section> block with no
            <html>/<head>/<body> tags. Only the alphabetically-first screen file owns the shared
            shell (<div id="app-root">, header, nav); every other screen holds just its own content.
            Never truncate: write every file completely, however long it needs to be.
        """.trimIndent()

        val frozenSection = if (frozenInstruction.isNotBlank()) "\n$frozenInstruction" else ""
        val prompt = """
            APP: ${spec.appName} - ${spec.vision}
            TASK: ${task.title}
            TARGET FILES: $targetFilesStr
            DESIGN: ${spec.designSystem.primaryColor} on ${spec.designSystem.backgroundColor}
            Write complete, production-quality code for: $targetFilesStr.$frozenSection
        """.trimIndent()

        return callWithContinuation(
            role = LlmRole.CODER,
            provider = provider,
            apiKey = apiKey,
            model = model,
            systemPrompt = systemPrompt,
            firstPrompt = prompt,
            onChunk = onChunk,
            onWaiting = onWaiting
        )
    }

    /**
     * Calls the model with a large output request and keeps appending while the provider
     * reports length-truncation — so a generated file can grow to whatever size the app
     * genuinely needs instead of being cut off by a per-call cap. If a model rejects the
     * large request outright, the request size halves and retries instead of failing.
     */
    private suspend fun callWithContinuation(
        role: LlmRole,
        provider: String,
        apiKey: String,
        model: String,
        systemPrompt: String,
        firstPrompt: String,
        onChunk: suspend (String) -> Unit,
        onWaiting: suspend (String, Int) -> Unit
    ): String {
        val fullText = StringBuilder()
        var nextPrompt = firstPrompt
        var continuations = 0
        var outputBudget = CODER_MAX_OUTPUT_TOKENS
        var halvings = 0
        while (true) {
            val req = LlmRequest(
                prompt = nextPrompt,
                systemPrompt = systemPrompt,
                mode = "coding",
                maxTokens = outputBudget
            )
            val res = LlmGateway.call(
                role = role,
                provider = provider,
                apiKey = apiKey,
                model = model,
                request = req,
                onChunk = onChunk,
                onWaiting = onWaiting
            )
            if (res.isFailure && fullText.isEmpty() && outputBudget > 2048 && halvings < 4) {
                val msg = (res.exceptionOrNull()?.message ?: "").lowercase()
                if (msg.contains("max_tokens") || msg.contains("max tokens") || msg.contains("too large") || msg.contains("maximum")) {
                    outputBudget /= 2
                    halvings++
                    Log.w(TAG, "Model rejected output budget, retrying with $outputBudget tokens")
                    continue
                }
            }
            val chunkText = res.getOrNull()?.text ?: ""
            fullText.append(chunkText)
            val cutOff = chunkText.isNotBlank() && isLengthTruncation(res.getOrNull()?.finishReason)
            if (!cutOff || continuations >= MAX_CONTINUATIONS) break
            continuations++
            nextPrompt = "Continue EXACTLY where you stopped — output ONLY the remaining raw envelopes, " +
                "no recap, no markdown, no explanations. The last lines so far:\n${chunkText.takeLast(1500)}"
        }
        return fullText.toString()
    }

    private suspend fun executeFixRound(
        spec: AppSpec,
        manifest: BuildManifest,
        report: TestReport,
        moduleFiles: Map<String, String>,
        round: Int,
        provider: String,
        apiKey: String,
        model: String
    ): Map<String, String> {
        val errorText = report.issues.joinToString("\n") { "• [${it.severity}] ${it.message}" }
        val prompt = """
            The following issues were trapped in the WebView sandbox:
            $errorText

            Provide surgical fix envelopes only:
            <file path="src/...">...</file>
            or
            <patch path="src/...">
            <<<<<<< SEARCH
            old
            =======
            new
            >>>>>>> REPLACE
            </patch>
        """.trimIndent()

        val text = callWithContinuation(
            role = LlmRole.FIXER,
            provider = provider,
            apiKey = apiKey,
            model = model,
            systemPrompt = "You are an expert debugger. Fix errors cleanly in envelopes only.",
            firstPrompt = prompt,
            onChunk = {},
            onWaiting = { _, _ -> }
        )
        val parsed = EnvelopeParser.parse(text)
        val fixed = mutableMapOf<String, String>()

        for (item in parsed.items) {
            when (item) {
                is EnvelopeItem.FileEnvelope -> fixed[item.path] = item.content
                is EnvelopeItem.PatchEnvelope -> {
                    val orig = moduleFiles[item.path] ?: ""
                    val pRes = PatchApplier.apply(orig, item.patchContent)
                    if (pRes.success) fixed[item.path] = pRes.updatedText
                }
            }
        }
        return fixed
    }

    private fun generateNextFeatureIdeas(spec: AppSpec, prompt: String): List<NextFeatureIdea> {
        return listOf(
            NextFeatureIdea("Add Sound Effects & Haptics", "Add Web Audio synthesizer sounds and haptic buzzes on actions"),
            NextFeatureIdea("Add Dark / Light Theme Toggle", "Add in-app theme switcher between OLED Dark and Minimal Light"),
            NextFeatureIdea("Add Multiplayer / Online Room", "Add 2-player pass-and-play and score leaderboards"),
            NextFeatureIdea("Add Detailed Statistics", "Add visual graphs, win rates, and daily achievements")
        )
    }

    private fun buildSummaryReport(spec: AppSpec, report: TestReport, version: Int): String {
        return buildString {
            append("Built **${spec.appName}** (Version v${String.format("%04d", version)})\n\n")
            append("**Features Added:**\n")
            spec.features.take(12).forEach { f ->
                append("• **${f.title}**: ${f.acceptance.ifBlank { "Interactive & verified" }}\n")
            }
            append("\n**Test & Sandbox Verification:**\n")
            append("• ${report.passedCount}/${report.totalCount} automated checks passed (Quality Score: ${report.qualityScore}/100)\n")
            if (report.jsErrors.isEmpty()) {
                append("• 0 JavaScript runtime errors\n")
            }
        }
    }

    private fun saveJobState(saifDir: File, job: BuildJob) {
        try {
            val file = File(saifDir, "job.json")
            val json = JSONObject().apply {
                put("jobId", job.jobId)
                put("appName", job.projectAppName)
                put("intent", job.intent.name)
                put("qualityMode", job.qualityMode.name)
                put("phase", job.currentPhase.name)
                put("status", job.status)
                put("lastUpdated", job.lastUpdated)
            }
            file.writeText(json.toString(2))
        } catch (ignored: Exception) {}
    }

    private fun updateProjectMemory(saifDir: File, spec: AppSpec, prompt: String, ideas: List<NextFeatureIdea>) {
        try {
            val file = File(saifDir, "memory.json")
            val json = JSONObject().apply {
                put("appName", spec.appName)
                put("vision", spec.vision)
                put("archetype", spec.archetype)
                put("featureCount", spec.features.size)
                put("lastPrompt", prompt)
                put("timestamp", System.currentTimeMillis())
            }
            file.writeText(json.toString(2))
        } catch (ignored: Exception) {}
    }

    /**
     * Loads a previously saved spec so a resumed run skips S1 instead of re-architecting.
     * Returns null when nothing usable is on disk (fresh planning then runs as usual).
     */
    private fun loadSpecFromDisk(saifDir: File): AppSpec? {
        return try {
            val file = File(saifDir, "spec.json")
            if (!file.exists() || file.length() < 50) return null
            val json = JSONObject(file.readText())
            if (json.optJSONArray("features") == null) return null
            // specToJson writes the same schema parseSpecJson understands.
            parseSpecJson(file.readText(), json.optString("appName", "Project"), json.optString("vision", ""))
        } catch (_: Exception) {
            null
        }
    }

    /**
     * Loads a previously saved task plan so a resumed run skips S2 and can skip the
     * tasks the checkpoint already marks finished. Null = plan fresh.
     */
    private fun loadPlanFromDisk(saifDir: File): BuildPlan? {
        return try {
            val file = File(saifDir, "plan.json")
            if (!file.exists() || file.length() < 20) return null
            val json = JSONObject(file.readText())
            val arr = json.optJSONArray("tasks") ?: return null
            if (arr.length() == 0) return null
            val tasks = (0 until arr.length()).map { i ->
                val o = arr.getJSONObject(i)
                val tf = o.optJSONArray("targetFiles")
                BuildTask(
                    id = o.optString("id", "task_$i"),
                    title = o.optString("title", "Task $i"),
                    targetFiles = (0 until (tf?.length() ?: 0)).map { tf!!.getString(it) },
                    expectedOutputTokens = o.optInt("expectedOutputTokens", 3000)
                )
            }
            BuildPlan(tasks = tasks, targetTier = json.optString("tier", "MEDIUM"))
        } catch (_: Exception) {
            null
        }
    }

    private fun specToJson(spec: AppSpec): JSONObject {
        return JSONObject().apply {
            put("appName", spec.appName)
            put("vision", spec.vision)
            put("archetype", spec.archetype)
            put("targetUser", spec.targetUser)
            put("dataModel", spec.dataModel)
            put("screens", JSONArray(spec.screens))
            put("animationList", JSONArray(spec.animationList))
            put("assumptions", JSONArray(spec.assumptions))
            put("designSystem", JSONObject().apply {
                put("mood", spec.designSystem.mood)
                put("primaryColor", spec.designSystem.primaryColor)
                put("accentColor", spec.designSystem.accentColor)
                put("backgroundColor", spec.designSystem.backgroundColor)
                put("surfaceColor", spec.designSystem.surfaceColor)
                put("textColor", spec.designSystem.textColor)
            })
            val featArr = JSONArray()
            spec.features.forEach { f ->
                featArr.put(JSONObject().apply {
                    put("id", f.id)
                    put("title", f.title)
                    put("priority", f.priority)
                    put("acceptance", f.acceptance)
                    put("domProbes", JSONArray(f.domProbes))
                })
            }
            put("features", featArr)
        }
    }

    private fun planToJson(plan: BuildPlan): JSONObject {
        return JSONObject().apply {
            put("tier", plan.targetTier)
            val tasksArr = JSONArray()
            plan.tasks.forEach { t ->
                tasksArr.put(JSONObject().apply {
                    put("id", t.id)
                    put("title", t.title)
                    put("targetFiles", JSONArray(t.targetFiles))
                    put("expectedOutputTokens", t.expectedOutputTokens)
                })
            }
            put("tasks", tasksArr)
        }
    }

    private fun manifestToJson(manifest: BuildManifest): JSONObject {
        return JSONObject().apply {
            val modArr = JSONArray()
            manifest.modules.forEach { m ->
                modArr.put(JSONObject().apply {
                    put("path", m.path)
                    put("functions", JSONArray(m.exportedFunctions))
                    put("domIds", JSONArray(m.domIds))
                })
            }
            put("modules", modArr)
        }
    }
}
