/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.saif.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agyext.AntigravityCustomApiDialog
import com.example.agyext.AntigravityCustomApiManager
import com.example.saif.ui.chat.SaifSharedChatViewModel

/**
 * The engine settings the chat screen opens.
 *
 * It only shows things SAIF AI actually owns: the AI provider the owner configured with their
 * own key, the workspace/terminal entry point, saved skills and slash commands.
 */
@Composable
fun EmbeddedEngineSettings(
    viewModel: SaifSharedChatViewModel,
    isLightMode: Boolean,
    initialSection: String?,
    onOpenTerminal: () -> Unit,
    autoApprove: Boolean,
    onAutoApproveChange: (Boolean) -> Unit,
    onDismiss: () -> Unit
) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val providerState by AntigravityCustomApiManager.stateFlow.collectAsState()
    val connection by viewModel.systemConnectionState.collectAsState()
    var showProviderDialog by remember { mutableStateOf(false) }
    val sections = remember { SettingsSection.entries }
    var section by remember { mutableStateOf(initialSection ?: SettingsSection.GENERAL.name) }
    val accent = Color(0xFF3D6BF5)
    val surface = if (isLightMode) Color(0xFFFFFFFF) else Color(0xFF1E1E20)
    val textPrimary = if (isLightMode) Color(0xFF151515) else Color(0xFFF2F1EC)
    val textSecondary = if (isLightMode) Color(0xFF5A5A5A) else Color(0xFFA8A59B)

    if (showProviderDialog) {
        AntigravityCustomApiDialog(onDismiss = { showProviderDialog = false })
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = surface,
        shape = RoundedCornerShape(22.dp),
        title = { Text("SAIF AI engine", color = textPrimary, fontWeight = FontWeight.Bold, fontSize = 18.sp) },
        text = {
            Column(
                Modifier
                    .heightIn(max = 460.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                sections.forEach { item ->
                    val selected = item.name == section
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (selected) accent.copy(alpha = 0.12f) else Color.Transparent,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { section = item.name }
                    ) {
                        Text(
                            item.title,
                            color = if (selected) accent else textPrimary,
                            fontSize = 14.sp,
                            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 9.dp)
                        )
                    }
                }

                Box(Modifier.fillMaxWidth().padding(top = 6.dp).background(if (isLightMode) Color(0xFFF3F3F1) else Color(0xFF26262A), RoundedCornerShape(12.dp))) {
                    Column(Modifier.padding(12.dp)) {
                        when (section) {
                            SettingsSection.GENERAL.name -> Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text("AI provider", color = textPrimary, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                Text(connection.label, color = textSecondary, fontSize = 12.5.sp)
                                Text(
                                    providerState.activeProfile?.let { "${it.name} · ${it.selectedModel}" }
                                        ?: "No provider configured yet",
                                    color = textSecondary,
                                    fontSize = 12.5.sp
                                )
                                Button(
                                    onClick = { showProviderDialog = true },
                                    colors = ButtonDefaults.buttonColors(containerColor = accent)
                                ) { Text("Configure provider") }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text("Run tools without asking", color = textPrimary, fontSize = 13.5.sp)
                                    Spacer(Modifier.width(10.dp))
                                    Switch(checked = autoApprove, onCheckedChange = onAutoApproveChange)
                                }
                                Text(
                                    "When off, SAIF AI asks before it runs a command or writes a file.",
                                    color = textSecondary,
                                    fontSize = 12.sp
                                )
                            }

                            SettingsSection.WORKSPACE.name -> Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text("Workspace shell", color = textPrimary, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                Text(
                                    "Terminal, code editor and file manager run against the local workspace directory.",
                                    color = textSecondary,
                                    fontSize = 12.5.sp
                                )
                                Button(
                                    onClick = { onOpenTerminal(); onDismiss() },
                                    colors = ButtonDefaults.buttonColors(containerColor = accent)
                                ) { Text("Open terminal") }
                            }

                            SettingsSection.AI_SKILLS.name -> Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text("Saved skills", color = textPrimary, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                val skills = com.example.saif.data.remote.SavedAiSkills.visibleSkills()
                                if (skills.isEmpty()) {
                                    Text("No skills saved yet. Import one from the skills sheet.", color = textSecondary, fontSize = 12.5.sp)
                                } else {
                                    skills.take(8).forEach { skill ->
                                        Text("/${skill.name} · ${skill.description.take(60)}", color = textSecondary, fontSize = 12.sp)
                                    }
                                }
                            }

                            SettingsSection.SLASH_COMMANDS.name -> Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Text("Slash commands", color = textPrimary, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                com.example.saif.data.remote.SlashCommandsCache.getCachedSync().orEmpty().forEach { cmd ->
                                    Text("${cmd.command}  ${cmd.description}", color = textSecondary, fontSize = 12.sp)
                                }
                            }

                            SettingsSection.VOICE.name -> Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text("Voice", color = textPrimary, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                Text(
                                    "Speech-to-text uses the provider you configured (or the device recogniser when none is set).",
                                    color = textSecondary,
                                    fontSize = 12.5.sp
                                )
                            }

                            SettingsSection.WEBVIEW_EXTENSIONS.name -> Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text("Web extensions", color = textPrimary, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                Text(
                                    "Extensions are bundled inside SAIF AI. Nothing is downloaded from a remote store.",
                                    color = textSecondary,
                                    fontSize = 12.5.sp
                                )
                            }

                            SettingsSection.MCP.name -> Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text("Model Context Protocol", color = textPrimary, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                Text(
                                    "The local bridge exposes SAIF AI's own tools to the workspace over loopback only.",
                                    color = textSecondary,
                                    fontSize = 12.5.sp
                                )
                            }

                            SettingsSection.ABOUT.name -> Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text("About & Credits", color = textPrimary, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                Text(
                                    com.saifai.brand.SaifCredits.HEADLINE,
                                    color = textPrimary,
                                    fontWeight = FontWeight.Black,
                                    fontSize = 20.sp,
                                    letterSpacing = 2.sp
                                )
                                Text(
                                    com.saifai.brand.SaifCredits.HEADLINE_SUB,
                                    color = textSecondary,
                                    fontSize = 11.sp
                                )
                                Text(
                                    com.saifai.brand.SaifCredits.thirdPartyOneLine,
                                    color = textSecondary.copy(alpha = 0.85f),
                                    fontSize = 9.5.sp,
                                    lineHeight = 14.sp
                                )
                            }

                            else -> Column {
                                Text("Appearance", color = textPrimary, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                Text(
                                    "SAIF AI follows the system light/dark mode. The accent colour is fixed at #3D6BF5.",
                                    color = textSecondary,
                                    fontSize = 12.5.sp
                                )
                            }
                        }
                    }
                }
                Text(
                    "Workspace folder: ${context.filesDir.absolutePath}",
                    color = textSecondary,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Done", color = accent) }
        }
    )
}
