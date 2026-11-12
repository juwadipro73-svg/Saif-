/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.saif.domain.model

/**
 * Domain model facade.
 *
 * SAIF AI keeps exactly one set of chat models, defined in [com.example.saif.core].
 * This package re-exports them so older call sites keep compiling while the codebase
 * converges on a single implementation.
 */

typealias MessageRole = com.example.saif.core.MessageRole
typealias ToolType = com.example.saif.core.ToolType
typealias ToolCall = com.example.saif.core.ToolCall
typealias ChatMessage = com.example.saif.core.ChatMessage
typealias ChatAttachment = com.example.saif.core.ChatAttachment
typealias PendingToolApproval = com.example.saif.core.PendingToolApproval

/** Which agent backend produced a turn. */
enum class AgentKind {
    AGY,
    CLAUDE,
    CUSTOM
}

data class TokenUsage(
    val promptTokens: Int = 0,
    val completionTokens: Int = 0,
    val totalTokens: Int = 0
)

/**
 * A model the user can pick from the composer. Always derived from the provider profiles
 * the user configured with their own API keys - SAIF AI ships no built-in model list.
 */
data class AiModel(
    val id: String,
    val displayName: String,
    val description: String = "",
    /** Alias used for lookups (historical field name). */
    val key: String = id
) {
    companion object {
        fun fromApi(id: String, displayName: String, description: String = ""): AiModel =
            AiModel(id = id, displayName = displayName, description = description, key = id)
    }
}

/** A question the agent asks the user before it continues a tool step. */
data class AgentQuestion(
    val id: String,
    val messageId: String,
    val prompt: String,
    val options: List<String> = emptyList(),
    val allowFreeText: Boolean = true
)
