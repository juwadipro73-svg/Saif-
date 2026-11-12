/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.ui

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.example.saif.domain.model.ChatMessage
import com.example.saif.domain.model.ToolType
import com.example.saif.ui.chat.ChatFeedCache
import com.example.saif.ui.chat.ChatFeedItem
import com.example.saif.ui.components.AgentWorkingSpinner
import com.example.saif.ui.components.AssistantMessageFooter
import com.example.saif.ui.components.FileLinkHandler
import com.example.saif.ui.components.LocalFileLinkHandler
import com.example.saif.ui.components.LocalQuestionPanelActive
import com.example.saif.ui.components.MarkdownBlockView
import com.example.saif.ui.components.MessageBubble
import com.example.saif.ui.components.ModelTypingIndicator
import com.example.saif.ui.components.ThinkingAccordion
import com.example.saif.ui.components.UserMessageBubble
import com.example.saif.ui.components.WaveDivider
import com.example.saif.ui.components.MarkdownBlock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private val AgentAccent = androidx.compose.ui.graphics.Color(0xFF3D6BF5)

/**
 * The chat transcript: markdown blocks (with code blocks), tool cards, approval buttons,
 * the thinking accordion and a retry footer.
 */
@Composable
internal fun HomeAgentFeed(
    messages: List<ChatMessage>,
    modelId: String,
    generating: Boolean,
    listState: LazyListState,
    viewModel: ChatViewModel,
    onRetry: () -> Unit
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val externalUris = LocalUriHandler.current
    val fileHandler = remember(context, scope) {
        FileLinkHandler(onOpenFile = { raw ->
            scope.launch {
                runCatching {
                    val path = android.net.Uri.decode(raw).removePrefix("file://").substringBefore("#")
                    val source = withContext(Dispatchers.IO) {
                        com.example.compiler.LinuxApkBuildBridge.resolveLinuxPathOnHost(context, path)
                            ?: java.io.File(path)
                    }
                    require(source.isFile && source.canRead()) { "File is not available" }
                    val name = source.name.replace(Regex("[^A-Za-z0-9._-]"), "_").ifBlank { "output" }
                    val folder = java.io.File(context.cacheDir, "agent-outputs").apply { mkdirs() }
                    val target = java.io.File(folder, name)
                    if (source.absolutePath != target.absolutePath) {
                        withContext(Dispatchers.IO) { source.copyTo(target, overwrite = true) }
                    }
                    if (target.extension.equals("apk", ignoreCase = true)) {
                        com.example.compiler.AppCompilerEngine.installApk(context, target)
                    } else {
                        val uri = androidx.core.content.FileProvider.getUriForFile(
                            context,
                            "${context.packageName}.fileprovider",
                            target
                        )
                        val ext = target.extension.lowercase()
                        val type = android.webkit.MimeTypeMap.getSingleton()
                            .getMimeTypeFromExtension(ext) ?: "application/octet-stream"
                        val intent = android.content.Intent(android.content.Intent.ACTION_VIEW)
                            .setDataAndType(uri, type)
                            .addFlags(
                                android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION or
                                    android.content.Intent.FLAG_ACTIVITY_NEW_TASK
                            )
                        context.startActivity(android.content.Intent.createChooser(intent, "Open ${target.name}"))
                    }
                }.onFailure { error ->
                    android.widget.Toast.makeText(
                        context,
                        "Cannot open file: ${error.localizedMessage}",
                        android.widget.Toast.LENGTH_LONG
                    ).show()
                }
            }
        })
    }
    val safeUris = remember(externalUris, fileHandler) {
        object : androidx.compose.ui.platform.UriHandler {
            override fun openUri(uri: String) {
                if (uri.startsWith("file://", true) || uri.startsWith("/")) {
                    fileHandler.handle(uri)
                } else {
                    runCatching { externalUris.openUri(uri) }.onFailure {
                        android.widget.Toast.makeText(context, "Cannot open link", android.widget.Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    val feed = remember(messages, modelId) { ChatFeedCache.buildFeedItems(messages, modelId) }
    val question = remember(messages) {
        com.example.saif.ui.agents.findPendingQuestion(com.example.saif.domain.model.AgentKind.CUSTOM, messages)
    }
    val approvals by viewModel.mainAgentApprovals.collectAsState()

    LaunchedEffect(feed.size, messages.lastOrNull(), generating) {
        val layout = listState.layoutInfo
        val nearBottom = layout.totalItemsCount == 0 ||
            (layout.visibleItemsInfo.lastOrNull()?.index ?: 0) >= layout.totalItemsCount - 3
        if (nearBottom && (feed.isNotEmpty() || generating)) {
            withFrameNanos { }
            val count = listState.layoutInfo.totalItemsCount
            if (count > 0) listState.scrollToItem(count - 1)
        }
    }

    CompositionLocalProvider(
        LocalQuestionPanelActive provides true,
        LocalFileLinkHandler provides { uri -> fileHandler.handle(uri) },
        LocalUriHandler provides safeUris
    ) {
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(top = 12.dp, bottom = 16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(feed, key = { it.key }, contentType = { it.contentType }) { item ->
                Box(Modifier.animateItem(fadeInSpec = tween(260), placementSpec = null, fadeOutSpec = null)) {
                    when (item) {
                        is ChatFeedItem.User -> UserMessageBubble(
                            message = item.message,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                        )

                        is ChatFeedItem.AssistantBlock -> Box(
                            Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 2.dp)
                        ) {
                            val block: @Composable () -> Unit = {
                                MarkdownBlockView(
                                    block = item.block,
                                    onApproveTool = { viewModel.approveMainTool(it, item.messageId, null) },
                                    onRejectTool = {
                                        if (it.toolType == ToolType.ASK_CHOICE) {
                                            viewModel.cancelMainChoices(it, item.messageId)
                                        } else {
                                            viewModel.rejectMainTool(it, item.messageId, null)
                                        }
                                    },
                                    onTerminateTool = { viewModel.terminateMainTool(it, item.messageId) },
                                    onSubmitChoices = { tool, responses, summary ->
                                        viewModel.submitMainChoices(tool, item.messageId, responses, summary)
                                    },
                                    onSkipChoices = { tool, responses ->
                                        viewModel.skipMainChoices(tool, item.messageId, responses)
                                    }
                                )
                            }
                            when (item.block) {
                                is MarkdownBlock.Paragraph, is MarkdownBlock.Header, is MarkdownBlock.Bullet,
                                is MarkdownBlock.Numbered, is MarkdownBlock.Task, is MarkdownBlock.Blockquote,
                                is MarkdownBlock.Alert, is MarkdownBlock.Table -> SelectionContainer { block() }

                                else -> block()
                            }
                        }

                        is ChatFeedItem.AssistantThinking -> ThinkingAccordion(
                            thoughtText = item.thoughtText,
                            durationMs = item.durationMs,
                            isStreaming = item.isStreaming,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )

                        is ChatFeedItem.AssistantTyping -> if (!generating) ModelTypingIndicator(modelId = item.modelId)

                        is ChatFeedItem.AssistantFooter -> AssistantMessageFooter(
                            message = item.message,
                            onRetry = { onRetry() }
                        )

                        is ChatFeedItem.StreamingMessage -> MessageBubble(
                            message = item.message,
                            modelId = modelId,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )

                        is ChatFeedItem.Summary -> MessageBubble(
                            message = item.message,
                            modelId = modelId,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )

                        is ChatFeedItem.Divider -> WaveDivider(label = item.label)
                    }
                }
            }
            if (generating && approvals.isEmpty() && question == null) {
                item(key = "home_agent_working") { AgentWorkingSpinner(color = AgentAccent) }
            }
        }
    }
}
