/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.saif.data.agent

import android.content.Context
import com.example.saif.core.ChatAttachment
import com.example.saif.core.ChatMessage
import com.example.saif.domain.model.AgentKind
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Which agent backends the user has enabled.
 *
 * Provider credentials live in [com.example.agyext.AntigravityCustomApiManager]; this class
 * only remembers which of SAIF AI's own engines may be used in a session.
 */
class AgentPreferences(private val context: Context) {

    companion object {
        private val _enabledFlow = MutableStateFlow<Set<AgentKind>>(setOf(AgentKind.CUSTOM))
        val enabledAgents: StateFlow<Set<AgentKind>> = _enabledFlow.asStateFlow()

        fun enabledSync(@Suppress("UNUSED_PARAMETER") context: Context): Set<AgentKind> = _enabledFlow.value

        /** Flags the local bridge advertises so it only reports enabled engines. */
        fun bridgeFlags(@Suppress("UNUSED_PARAMETER") context: Context): String =
            _enabledFlow.value.joinToString(",") { it.name.lowercase() }
    }

    /** Enabled engines for this screen. */
    val enabled: StateFlow<Set<AgentKind>> get() = enabledAgents

    fun isAgentEnabled(kind: AgentKind): Boolean = kind in _enabledFlow.value

    fun setEnabled(set: Set<AgentKind>) {
        _enabledFlow.value = set
    }
}

/**
 * Holds the turns of one chat session while it is being rendered.
 *
 * Deliberately dumb storage: the agent engine writes into [messages] and [attachments] and
 * the UI observes them. Persistence lives in the engine and in Room.
 */
class ChatSessionStore {

    val messages: MutableStateFlow<List<ChatMessage>> = MutableStateFlow(emptyList())

    /** Attachments staged for the next turn. */
    val attachments: MutableStateFlow<List<ChatAttachment>> = MutableStateFlow(emptyList())

    fun appendMessage(message: ChatMessage) {
        messages.value = messages.value + message
    }

    fun replaceMessage(id: String, transform: (ChatMessage) -> ChatMessage) {
        messages.value = messages.value.map { if (it.id == id) transform(it) else it }
    }

    fun clear() {
        messages.value = emptyList()
        attachments.value = emptyList()
    }
}
