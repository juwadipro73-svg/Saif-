/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.saif.ui.chat

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.ViewModel
import com.example.agyext.AntigravityCustomApiManager
import com.example.data.local.AuthManager
import com.example.saif.data.remote.SaifAccountInfo
import com.example.saif.data.remote.SystemConnectionState
import com.example.saif.domain.model.ChatMessage
import com.example.saif.domain.model.MessageRole
import com.example.saif.ui.components.MarkdownBlock
import com.example.saif.ui.components.parseMarkdownBlocks
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/** Tool approvals are the domain type; this package only re-exports it for call sites that live here. */
typealias PendingToolApproval = com.example.saif.core.PendingToolApproval

/** One row of the chat feed. */
sealed class ChatFeedItem {
    abstract val key: String
    abstract val contentType: String

    data class User(val message: ChatMessage) : ChatFeedItem() {
        override val key: String = "user_${message.id}"
        override val contentType: String = "user"
    }

    data class AssistantBlock(
        val message: ChatMessage,
        val messageId: String,
        val block: MarkdownBlock,
        val index: Int
    ) : ChatFeedItem() {
        override val key: String = "assistant_${message.id}_$index"
        override val contentType: String = "assistant_block"
    }

    data class AssistantThinking(
        val thoughtText: String,
        val durationMs: Long? = null,
        val isStreaming: Boolean = false,
        val messageId: String = ""
    ) : ChatFeedItem() {
        override val key: String = "thinking_$messageId"
        override val contentType: String = "thinking"
    }

    data class AssistantTyping(val modelId: String) : ChatFeedItem() {
        override val key: String = "typing_$modelId"
        override val contentType: String = "typing"
    }

    data class AssistantFooter(val message: ChatMessage) : ChatFeedItem() {
        override val key: String = "footer_${message.id}"
        override val contentType: String = "footer"
    }

    data class StreamingMessage(val message: ChatMessage) : ChatFeedItem() {
        override val key: String = "stream_${message.id}"
        override val contentType: String = "stream"
    }

    data class Summary(val message: ChatMessage) : ChatFeedItem() {
        override val key: String = "summary_${message.id}"
        override val contentType: String = "summary"
    }

    data class Divider(val label: String) : ChatFeedItem() {
        override val key: String = "divider_$label"
        override val contentType: String = "divider"
    }
}

/**
 * Turns a conversation into renderable rows: markdown blocks for text, one card per tool call,
 * a thinking accordion when the model exposed reasoning, and a footer for the finished turn.
 */
object ChatFeedCache {
    fun buildFeedItems(messages: List<ChatMessage>, modelId: String): List<ChatFeedItem> {
        val items = mutableListOf<ChatFeedItem>()
        messages.forEach { message ->
            when (message.role) {
                MessageRole.USER -> items.add(ChatFeedItem.User(message))
                MessageRole.ASSISTANT -> {
                    val thought = message.thoughtText
                    if (!thought.isNullOrBlank()) {
                        items.add(
                            ChatFeedItem.AssistantThinking(
                                thoughtText = thought,
                                durationMs = message.thoughtDurationMs,
                                isStreaming = message.isStreaming,
                                messageId = message.id
                            )
                        )
                    }
                    val blocks = parseMarkdownBlocks(message.content)
                    if (message.isStreaming) {
                        items.add(ChatFeedItem.StreamingMessage(message))
                    } else {
                        blocks.forEachIndexed { index, block ->
                            items.add(ChatFeedItem.AssistantBlock(message, message.id, block, index))
                        }
                        message.toolCalls.forEachIndexed { index, toolCall ->
                            items.add(
                                ChatFeedItem.AssistantBlock(
                                    message = message,
                                    messageId = message.id,
                                    block = MarkdownBlock.ToolCallBlock(toolCall),
                                    index = blocks.size + index
                                )
                            )
                        }
                        if (message.content.isBlank() && message.toolCalls.isEmpty()) {
                            items.add(ChatFeedItem.AssistantTyping(modelId))
                        }
                        if (message.content.isNotBlank()) {
                            items.add(ChatFeedItem.AssistantFooter(message))
                        }
                    }
                }

                MessageRole.SUMMARY -> items.add(ChatFeedItem.Summary(message))
                else -> Unit
            }
        }
        return items
    }
}

/**
 * Process-wide engine state shared by the chat screen, the drawer and the settings sheets.
 *
 * There is no remote hub account any more: the "connection" is the locally configured AI
 * provider (user's own API key) plus the Firebase account of the person using the app.
 */
class SaifSharedChatViewModel(private val app: Application) : ViewModel() {

    private val connectivity = app.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager

    private val _isNetworkConnected = MutableStateFlow(true)
    val isNetworkConnectedState: StateFlow<Boolean> = _isNetworkConnected.asStateFlow()

    private val _isBusy = MutableStateFlow(false)
    val isAuthBusy: StateFlow<Boolean> = _isBusy.asStateFlow()

    private val _feedback = MutableStateFlow<CharSequence>("")
    val authFeedbackMessage: StateFlow<CharSequence> = _feedback.asStateFlow()

    private val _connection = MutableStateFlow<SystemConnectionState>(SystemConnectionState.NotConfigured)
    /** Readiness of the chat engine: a signed-in account and one usable provider profile. */
    val systemConnectionState: StateFlow<SystemConnectionState> = _connection.asStateFlow()

    private val _account = MutableStateFlow(SaifAccountInfo())
    val accountInfo: StateFlow<SaifAccountInfo> = _account.asStateFlow()

    init {
        observeNetwork()
        refresh()
    }

    private fun observeNetwork() {
        val manager = connectivity ?: return
        _isNetworkConnected.value = currentNetworkAvailable()
        manager.registerNetworkCallback(
            NetworkRequest.Builder().addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET).build(),
            object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    _isNetworkConnected.value = true
                }

                override fun onLost(network: Network) {
                    _isNetworkConnected.value = currentNetworkAvailable()
                }
            }
        )
    }

    private fun currentNetworkAvailable(): Boolean {
        val manager = connectivity ?: return true
        val capabilities = manager.getNetworkCapabilities(manager.activeNetwork) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    /** Recomputes the connection state from the provider settings that are on disk. */
    fun refresh() {
        AntigravityCustomApiManager.init(app)
        val apiState = AntigravityCustomApiManager.getState(app)
        val signedIn = AuthManager.currentUser.value != null
        val next = when {
            !signedIn -> SystemConnectionState.SignedOut
            apiState.isActiveAndReady -> SystemConnectionState.Connected(
                providerName = apiState.activeProfile?.name.orEmpty(),
                modelId = apiState.activeProfile?.selectedModel.orEmpty()
            )

            apiState.profiles.isEmpty() -> SystemConnectionState.NotConfigured
            else -> SystemConnectionState.ProviderOffline
        }
        _connection.value = next
        _account.value = SaifAccountInfo(
            status = if (signedIn) "AUTHENTICATED" else "UNAUTHENTICATED",
            isLoggedIn = signedIn,
            email = AuthManager.currentUser.value?.email.orEmpty(),
            fullName = AuthManager.currentUser.value?.name.orEmpty(),
            displayName = AuthManager.currentUser.value?.name.orEmpty(),
            planName = apiState.activeProfile?.name.orEmpty(),
            profilePictureUrl = AuthManager.currentUser.value?.profilePicturePath
        )
        _isNetworkConnected.value = currentNetworkAvailable()
    }

    /** Retry after a failure: reloads provider state; the provider settings dialog does the rest. */
    fun retryConnections() {
        val apiState = AntigravityCustomApiManager.getState(app)
        if (apiState.profiles.isEmpty()) {
            _feedback.value = "Add your own AI provider API key in Settings → AI provider."
        }
        refresh()
    }

    fun reportFeedback(message: String) {
        _feedback.value = message
    }
}

object ChatViewModelHolder {
    @Volatile
    private var instance: SaifSharedChatViewModel? = null

    fun get(application: Application): SaifSharedChatViewModel =
        instance ?: synchronized(this) {
            instance ?: SaifSharedChatViewModel(application).also { instance = it }
        }
}
