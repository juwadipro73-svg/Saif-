/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.saif.ui.agents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.saif.data.remote.dto.AskQuestionResponseItemDto
import com.example.saif.domain.model.AgentKind
import com.example.saif.domain.model.ChatMessage
import com.example.saif.domain.model.ToolCall
import com.example.saif.domain.model.ToolType

/** A tool call the owner has to allow or deny before it runs. */
data class AgentApprovalItem(
    val toolCall: ToolCall,
    val messageId: String,
    val title: String,
    val detail: String,
    val onApprove: (String?) -> Unit,
    val onReject: (String?) -> Unit
)

/**
 * Builds the approval rows shown above the composer.
 * Only calls that are actually waiting for a decision are returned.
 */
fun agyApprovalItems(
    approvals: List<com.example.saif.ui.chat.PendingToolApproval>,
    onApprove: (ToolCall, String, String?) -> Unit,
    onReject: (ToolCall, String, String?) -> Unit
): List<AgentApprovalItem> = approvals
    .filter { it.toolCall.status == "PENDING_APPROVAL" }
    .map { approval ->
        AgentApprovalItem(
            toolCall = approval.toolCall,
            messageId = approval.messageId,
            title = approval.toolCall.name.ifBlank { approval.toolCall.toolType.name.lowercase() },
            detail = approval.toolCall.command.ifBlank { approval.toolCall.output }.take(400),
            onApprove = { scope -> onApprove(approval.toolCall, approval.messageId, scope) },
            onReject = { reason -> onReject(approval.toolCall, approval.messageId, reason) }
        )
    }

/** A question the agent asked; answered from the composer area. */
data class AgentQuestion(
    val toolCall: ToolCall,
    val messageId: String,
    val prompt: String,
    val options: List<String>
)

/** Finds a tool call of type ASK_CHOICE that is still waiting for the owner's answer. */
fun findPendingQuestion(agentKind: AgentKind, messages: List<ChatMessage>): AgentQuestion? {
    if (agentKind != AgentKind.AGY && agentKind != AgentKind.CUSTOM) return null
    val message = messages.lastOrNull { msg ->
        msg.toolCalls.any { it.toolType == ToolType.ASK_CHOICE && it.status == "PENDING_APPROVAL" }
    } ?: return null
    val toolCall = message.toolCalls.first { it.toolType == ToolType.ASK_CHOICE && it.status == "PENDING_APPROVAL" }
    val options = toolCall.output.lines()
        .map { it.trim() }
        .filter { it.startsWith("- ") || it.matches(Regex("^\\d+[.)].*")) }
        .map { it.removePrefix("- ").replace(Regex("^\\d+[.)]\\s*"), "") }
    return AgentQuestion(
        toolCall = toolCall,
        messageId = message.id,
        prompt = toolCall.command.ifBlank { "SAIF AI needs an answer to continue." },
        options = options
    )
}

@Composable
fun AgentApprovalPanel(
    items: List<AgentApprovalItem>,
    onAllowAll: () -> Unit,
    onDenyAll: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (items.isEmpty()) return
    Surface(
        modifier = modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp),
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.4f))
    ) {
        Column(Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Filled.Security,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = if (items.size == 1) "SAIF AI wants to run a tool" else "SAIF AI wants to run ${items.size} tools",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp
                )
            }
            items.take(3).forEach { item ->
                Column(Modifier.padding(top = 8.dp)) {
                    Text(item.title, fontSize = 12.5.sp, fontFamily = FontFamily.Monospace)
                    if (item.detail.isNotBlank()) {
                        Text(item.detail, fontSize = 11.5.sp, fontFamily = FontFamily.Monospace)
                    }
                    Row(Modifier.padding(top = 6.dp)) {
                        TextButton(onClick = { item.onApprove("SESSION") }) { Text("Allow") }
                        TextButton(onClick = { item.onReject(null) }) { Text("Deny") }
                    }
                }
            }
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                TextButton(onClick = onDenyAll) { Text("Deny all") }
                Spacer(Modifier.width(6.dp))
                Button(onClick = onAllowAll, colors = ButtonDefaults.buttonColors()) { Text("Allow all") }
            }
        }
    }
}

@Composable
fun AgentQuestionPanel(
    question: AgentQuestion,
    onSubmit: (List<AskQuestionResponseItemDto>, String) -> Unit,
    onSkip: (List<AskQuestionResponseItemDto>) -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    var answer by remember(question.toolCall.id) { mutableStateOf("") }
    Surface(
        modifier = modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp),
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.35f))
    ) {
        Column(Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Filled.QuestionAnswer,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text("SAIF AI needs an answer", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
            }
            Text(question.prompt, fontSize = 12.5.sp, modifier = Modifier.padding(top = 6.dp))
            if (question.options.isNotEmpty()) {
                question.options.take(6).forEach { option ->
                    TextButton(onClick = {
                        onSubmit(listOf(AskQuestionResponseItemDto(question = question.prompt, answer = option)), option)
                    }) { Text(option, fontSize = 12.sp) }
                }
            }
            OutlinedTextField(
                value = answer,
                onValueChange = { answer = it },
                label = { Text("Your answer") },
                singleLine = false,
                minLines = 1,
                modifier = Modifier.fillMaxWidth().padding(top = 6.dp)
            )
            Row(Modifier.fillMaxWidth().padding(top = 6.dp), horizontalArrangement = Arrangement.End) {
                TextButton(onClick = onCancel) { Text("Cancel") }
                Spacer(Modifier.width(6.dp))
                TextButton(onClick = {
                    onSkip(listOf(AskQuestionResponseItemDto(question = question.prompt, answer = "")))
                }) { Text("Skip") }
                Spacer(Modifier.width(6.dp))
                Button(
                    onClick = {
                        onSubmit(
                            listOf(AskQuestionResponseItemDto(question = question.prompt, answer = answer)),
                            answer
                        )
                    },
                    enabled = answer.isNotBlank()
                ) { Text("Send") }
            }
        }
    }
}
