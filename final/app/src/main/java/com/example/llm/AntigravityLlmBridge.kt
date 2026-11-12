/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.llm

import android.app.Application
import com.example.agyext.AntigravityCustomApiAgentEngine
import com.example.agyext.AntigravityCustomApiManager
import com.example.data.local.AuthManager
import com.example.saif.data.agent.ChatSessionStore
import com.example.saif.data.remote.GoogleAccountBinding
import com.example.saif.domain.model.ChatAttachment
import com.example.saif.ui.chat.ChatViewModelHolder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.withContext
import java.util.UUID

/**
 * Lets SAIF AI's own features (the builder, the studio, the live coding bridge) reuse the
 * chat engine when the owner has not configured a separate key for them.
 *
 * Everything runs through [AntigravityCustomApiAgentEngine] - the owner's provider, the
 * owner's key. There is no remote hub and no shared account.
 */
object AntigravityLlmBridge {

    @Volatile
    private var appRef: Application? = null

    fun init(app: Application) {
        appRef = app
    }

    fun isAvailable(): Boolean {
        val app = appRef ?: return false
        return runCatching {
            val engine = ChatViewModelHolder.get(app)
            val provider = AntigravityCustomApiManager.getState(app)
            provider.isActiveAndReady &&
                GoogleAccountBinding.denialReason(AuthManager.currentUser.value, engine.accountInfo.value) == null
        }.getOrDefault(false)
    }

    suspend fun callIfAvailable(
        request: LlmRequest,
        preferredModel: String = "",
        onChunk: suspend (String) -> Unit = {},
        onThinking: (suspend (String) -> Unit)? = null
    ): Result<LlmResponse>? {
        val app = appRef ?: return null
        val engine = runCatching { ChatViewModelHolder.get(app) }.getOrNull() ?: return null
        val providerState = AntigravityCustomApiManager.getState(app)
        if (!providerState.isActiveAndReady) return null
        val accountIssue = GoogleAccountBinding.denialReason(AuthManager.currentUser.value, engine.accountInfo.value)
        if (accountIssue != null) return null
        val profile = providerState.activeProfile ?: return null
        val resolvedProfile = if (preferredModel.isNotBlank()) {
            val bare = preferredModel.substringAfter("::")
            val candidateModels = profile.effectiveModels()
            if (candidateModels.any { it == preferredModel || it == bare }) profile.copy(selectedModel = bare) else profile
        } else {
            profile
        }

        val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
        val store = ChatSessionStore()
        val agent = AntigravityCustomApiAgentEngine(
            appContext = app,
            scope = scope,
            store = store,
            isAutoApproveProvider = { true }
        )

        return try {
            val combinedPrompt = buildString {
                append("IMPORTANT EXECUTION RULE: Reply directly with the requested output in your message text ONLY. ")
                append("Do NOT execute terminal commands, file tools, browser tools, or subagents.\n\n")
                if (request.systemPrompt.isNotBlank()) {
                    append("System Instructions:\n")
                    append(request.systemPrompt.trim())
                    append("\n\n")
                }
                if (request.history.isNotEmpty()) {
                    append("Conversation Context:\n")
                    request.history.takeLast(10).forEach { (role, text) ->
                        val label = if (role.equals("user", true)) "User" else "Assistant"
                        append("$label: ${text.take(4000)}\n\n")
                    }
                }
                append(request.prompt)
            }

            val attachments = request.imagesBase64.mapIndexed { index, raw ->
                ChatAttachment(
                    name = "image_${index + 1}.png",
                    path = "",
                    localUri = null,
                    isImage = true,
                    mimeType = "image/png",
                    base64 = raw.substringAfter("base64,", raw)
                )
            }

            var streamed = 0
            val text = withContext(Dispatchers.IO) {
                agent.executeTurn(
                    sessionId = "bridge_" + UUID.randomUUID(),
                    profile = resolvedProfile,
                    displayUserText = request.prompt,
                    expandedAgentPrompt = combinedPrompt,
                    inlineAttachments = attachments,
                    temperature = (request.temperature ?: 0.7).toFloat(),
                    onStreamingText = { partial ->
                        if (partial.length > streamed) {
                            val delta = partial.substring(streamed)
                            streamed = partial.length
                            kotlinx.coroutines.runBlocking { onChunk(delta) }
                        }
                    }
                )
            }

            val thinking = store.messages.value.lastOrNull { it.thoughtText != null }?.thoughtText
            if (onThinking != null && !thinking.isNullOrBlank()) onThinking(thinking)

            Result.success(
                LlmResponse(
                    text = text,
                    finishReason = "STOP",
                    thinkingText = thinking
                )
            )
        } catch (err: Exception) {
            Result.failure(err)
        } finally {
            runCatching { agent.stopActiveExecution() }
            scope.cancel()
        }
    }
}
