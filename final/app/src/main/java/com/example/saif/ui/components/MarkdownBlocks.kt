/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.saif.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.saif.data.remote.dto.AskQuestionResponseItemDto
import com.example.saif.domain.model.ToolCall
import com.example.saif.domain.model.ToolType

/**
 * One rendered piece of an assistant turn.
 *
 * [com.example.ui.HomeAgentFeed] decides whether a block may live inside a `SelectionContainer`,
 * so every plain text block is a separate type while tool/code blocks stay interactive.
 */
sealed class MarkdownBlock {
    data class Paragraph(val text: String) : MarkdownBlock()
    data class Header(val level: Int, val text: String) : MarkdownBlock()
    data class Bullet(val text: String, val depth: Int = 0) : MarkdownBlock()
    data class Numbered(val number: Int, val text: String) : MarkdownBlock()
    data class Task(val checked: Boolean, val text: String) : MarkdownBlock()
    data class Blockquote(val text: String) : MarkdownBlock()
    data class Alert(val kind: String, val text: String) : MarkdownBlock()
    data class Table(val headers: List<String>, val rows: List<List<String>>) : MarkdownBlock()
    data class Code(val language: String, val code: String) : MarkdownBlock()
    data class ToolCallBlock(val toolCall: ToolCall) : MarkdownBlock()
}

private val FENCE = Regex("^```\\s*([A-Za-z0-9_+.#-]*)\\s*$")
private val HEADER = Regex("^(#{1,6})\\s+(.*)$")
private val BULLET = Regex("^(\\s*)[-*+]\\s+(.*)$")
private val NUMBERED = Regex("^(\\s*)(\\d+)[.)]\\s+(.*)$")
private val TASK = Regex("^(\\s*)[-*]\\s+\\[([ xX])]\\s+(.*)$")
private val TABLE_ROW = Regex("^\\s*\\|(.*)\\|\\s*$")

/**
 * Splits assistant markdown into renderable blocks. Deliberately small and predictable:
 * fenced code, headers, lists, tasks, quotes, tables, alerts and paragraphs.
 */
fun parseMarkdownBlocks(content: String): List<MarkdownBlock> {
    val blocks = mutableListOf<MarkdownBlock>()
    val paragraph = StringBuilder()

    fun flushParagraph() {
        val text = paragraph.toString().trim()
        if (text.isNotEmpty()) blocks.add(MarkdownBlock.Paragraph(text))
        paragraph.setLength(0)
    }

    val lines = content.split('\n')
    var index = 0
    while (index < lines.size) {
        val line = lines[index]
        val fence = FENCE.matchEntire(line.trim())
        if (fence != null) {
            flushParagraph()
            val language = fence.groupValues[1]
            val code = StringBuilder()
            index++
            while (index < lines.size && !lines[index].trim().startsWith("```")) {
                code.append(lines[index]).append('\n')
                index++
            }
            blocks.add(MarkdownBlock.Code(language.ifBlank { "text" }, code.toString().trimEnd('\n')))
            index++
            continue
        }

        val header = HEADER.matchEntire(line)
        if (header != null) {
            flushParagraph()
            blocks.add(MarkdownBlock.Header(header.groupValues[1].length, header.groupValues[2].trim()))
            index++
            continue
        }

        val task = TASK.matchEntire(line)
        if (task != null) {
            flushParagraph()
            blocks.add(MarkdownBlock.Task(task.groupValues[2].equals("x", true), task.groupValues[3].trim()))
            index++
            continue
        }

        val bullet = BULLET.matchEntire(line)
        if (bullet != null) {
            flushParagraph()
            blocks.add(MarkdownBlock.Bullet(bullet.groupValues[2].trim(), bullet.groupValues[1].length / 2))
            index++
            continue
        }

        val numbered = NUMBERED.matchEntire(line)
        if (numbered != null) {
            flushParagraph()
            blocks.add(MarkdownBlock.Numbered(numbered.groupValues[2].toIntOrNull() ?: 1, numbered.groupValues[3].trim()))
            index++
            continue
        }

        val row = TABLE_ROW.matchEntire(line)
        if (row != null) {
            flushParagraph()
            val rows = mutableListOf<List<String>>()
            while (index < lines.size) {
                val current = TABLE_ROW.matchEntire(lines[index]) ?: break
                val cells = current.groupValues[1].split('|').map { it.trim() }
                if (cells.none { it.matches(Regex("^:?-{2,}:?$")) }) rows.add(cells)
                index++
            }
            if (rows.size >= 2) {
                blocks.add(MarkdownBlock.Table(rows.first(), rows.drop(1)))
            } else if (rows.size == 1) {
                blocks.add(MarkdownBlock.Paragraph(rows.first().joinToString("  ")))
            }
            continue
        }

        val trimmed = line.trim()
        when {
            trimmed.startsWith(">") -> {
                flushParagraph()
                blocks.add(MarkdownBlock.Blockquote(trimmed.removePrefix(">").trim()))
            }

            trimmed.startsWith(":::").not() && BooleanAlert(trimmed) -> {
                flushParagraph()
                val kind = trimmed.substringBefore(':').trim().uppercase()
                blocks.add(MarkdownBlock.Alert(kind, trimmed.substringAfter(':').trim()))
            }

            trimmed.isEmpty() -> flushParagraph()

            else -> {
                if (paragraph.isNotEmpty()) paragraph.append('\n')
                paragraph.append(line.trimEnd())
            }
        }
        index++
    }
    flushParagraph()
    return blocks
}

private fun BooleanAlert(line: String): Boolean {
    val head = line.substringBefore(':').trim().uppercase()
    return head == "NOTE" || head == "TIP" || head == "IMPORTANT" || head == "WARNING" || head == "CAUTION"
}

@Composable
fun MarkdownBlockView(
    block: MarkdownBlock,
    onApproveTool: (ToolCall) -> Unit = {},
    onRejectTool: (ToolCall) -> Unit = {},
    onTerminateTool: (ToolCall) -> Unit = {},
    onSubmitChoices: (ToolCall, List<AskQuestionResponseItemDto>, String) -> Unit = { _, _, _ -> },
    onSkipChoices: (ToolCall, List<AskQuestionResponseItemDto>) -> Unit = { _, _ -> },
    modifier: Modifier = Modifier
) {
    when (block) {
        is MarkdownBlock.Paragraph -> Text(
            text = block.text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier.fillMaxWidth()
        )

        is MarkdownBlock.Header -> Text(
            text = block.text,
            fontSize = when (block.level) {
                1 -> 22.sp
                2 -> 19.sp
                3 -> 17.sp
                else -> 15.sp
            },
            fontWeight = FontWeight.SemiBold,
            modifier = modifier.fillMaxWidth().padding(top = 6.dp)
        )

        is MarkdownBlock.Bullet -> Row(modifier = modifier.fillMaxWidth().padding(start = (block.depth * 14).dp)) {
            Text("•", style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.width(7.dp))
            Text(block.text, style = MaterialTheme.typography.bodyMedium)
        }

        is MarkdownBlock.Numbered -> Row(modifier = modifier.fillMaxWidth()) {
            Text("${block.number}.", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium)
            Spacer(Modifier.width(7.dp))
            Text(block.text, style = MaterialTheme.typography.bodyMedium)
        }

        is MarkdownBlock.Task -> Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(if (block.checked) "☑" else "☐", style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.width(7.dp))
            Text(block.text, style = MaterialTheme.typography.bodyMedium)
        }

        is MarkdownBlock.Blockquote -> Surface(
            shape = RoundedCornerShape(6.dp),
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = block.text,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
            )
        }

        is MarkdownBlock.Alert -> Surface(
            shape = RoundedCornerShape(8.dp),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.10f),
            modifier = modifier.fillMaxWidth()
        ) {
            Column(Modifier.padding(10.dp)) {
                Text(block.kind, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Text(block.text, style = MaterialTheme.typography.bodyMedium)
            }
        }

        is MarkdownBlock.Table -> Column(
            modifier = modifier.fillMaxWidth().horizontalScroll(rememberScrollState())
        ) {
            Row {
                block.headers.forEach { cell ->
                    Text(
                        text = cell,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(end = 14.dp, bottom = 4.dp)
                    )
                }
            }
            block.rows.forEach { row ->
                Row {
                    row.forEach { cell ->
                        Text(
                            text = cell,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(end = 14.dp, bottom = 2.dp)
                        )
                    }
                }
            }
        }

        is MarkdownBlock.Code -> CodeBlockView(language = block.language, code = block.code, modifier = modifier)

        is MarkdownBlock.ToolCallBlock -> ToolCallCardView(
            toolCall = block.toolCall,
            onApprove = onApproveTool,
            onReject = onRejectTool,
            onTerminate = onTerminateTool,
            onSubmitChoices = onSubmitChoices,
            onSkipChoices = onSkipChoices,
            modifier = modifier
        )
    }
}

@Composable
fun CodeBlockView(language: String, code: String, modifier: Modifier = Modifier) {
    val clipboard = LocalClipboardManager.current
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f),
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 4.dp, top = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(language.lowercase(), fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                IconButton(onClick = { clipboard.setText(AnnotatedString(code)) }, modifier = Modifier.size(28.dp)) {
                    Icon(Icons.Filled.ContentCopy, contentDescription = "Copy code", modifier = Modifier.size(15.dp))
                }
            }
            Box(Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()).padding(12.dp)) {
                SelectionContainer {
                    Text(
                        text = code,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 12.5.sp,
                        softWrap = false
                    )
                }
            }
        }
    }
}

@Composable
fun ToolCallCardView(
    toolCall: ToolCall,
    onApprove: (ToolCall) -> Unit,
    onReject: (ToolCall) -> Unit,
    onTerminate: (ToolCall) -> Unit,
    onSubmitChoices: (ToolCall, List<AskQuestionResponseItemDto>, String) -> Unit,
    onSkipChoices: (ToolCall, List<AskQuestionResponseItemDto>) -> Unit,
    modifier: Modifier = Modifier
) {
    val pending = toolCall.status == "PENDING_APPROVAL"
    val running = toolCall.status == "RUNNING"
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.42f),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(Modifier.padding(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = toolCall.name,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Monospace
                )
                Spacer(Modifier.width(8.dp))
                Text(text = toolCall.status.lowercase().replace('_', ' '), fontSize = 11.sp)
            }
            if (toolCall.command.isNotBlank()) {
                Text(
                    text = toolCall.command.take(600),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.5.sp,
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
            if (toolCall.output.isNotBlank()) {
                Text(
                    text = toolCall.output.takeLast(1200),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.5.sp,
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
            if (pending) {
                Row(Modifier.padding(top = 8.dp)) {
                    Text(
                        text = "Allow",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable { onApprove(toolCall) }.padding(end = 16.dp, top = 4.dp, bottom = 4.dp)
                    )
                    Text(
                        text = "Deny",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.clickable { onReject(toolCall) }.padding(top = 4.dp, bottom = 4.dp)
                    )
                }
            } else if (running) {
                Text(
                    text = "Stop",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(top = 8.dp).clickable { onTerminate(toolCall) }
                )
            }
            if (toolCall.toolType == ToolType.ASK_CHOICE) {
                Row(Modifier.padding(top = 8.dp)) {
                    Text(
                        text = "Skip questions",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable {
                            onSkipChoices(toolCall, emptyList())
                        }.padding(end = 16.dp)
                    )
                    Text(
                        text = "Answer",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable {
                            onSubmitChoices(toolCall, emptyList(), "")
                        }
                    )
                }
            }
        }
    }
}

/** Small pulsing mark shown while the agent works with no visible tool call yet. */
@Composable
fun AgentWorkingSpinner(color: androidx.compose.ui.graphics.Color, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.material3.CircularProgressIndicator(
            modifier = Modifier.size(15.dp),
            strokeWidth = 2.dp,
            color = color
        )
        Spacer(Modifier.width(10.dp))
        Text("SAIF AI is working…", fontSize = 12.sp)
    }
}

/** Handles `file://` links inside assistant markdown by delegating to the app. */
class FileLinkHandler(private val onOpenFile: (String) -> Unit) {
    fun handle(uri: String) {
        onOpenFile(uri)
    }
}
