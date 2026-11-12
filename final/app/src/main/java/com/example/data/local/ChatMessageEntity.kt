/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/** One stored chat turn. Tool calls and attachments are kept as JSON so the schema stays flat. */
@Entity(tableName = "chat_messages")
data class ChatMessageEntity(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val sessionId: String,
    val role: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis(),
    val thoughtText: String? = null,
    val isError: Boolean = false,
    val toolCallsJson: String? = null,
    val attachmentsJson: String? = null,
    /** Comma separated content URIs of the files the user attached to this turn. */
    val attachmentUris: String? = null,
    val isBookmarked: Boolean = false,
    /** Model id that produced an assistant turn, when known. */
    val modelId: String? = null
)
