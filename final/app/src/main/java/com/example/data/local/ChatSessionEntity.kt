/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * A chat conversation. Every row is owned by the verified account UID so that history never
 * leaks between accounts that share one device.
 */
@Entity(tableName = "chat_sessions")
data class ChatSessionEntity(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val title: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val isPinned: Boolean = false,
    /** "general", "project", "video", "live" - drives which workspace the session belongs to. */
    val mode: String = "general",
    /** Firebase UID of the signed-in owner. Empty means "not yet claimed". */
    val ownerUid: String = ""
)
