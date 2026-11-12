/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Login
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.CloudOff
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.saif.data.remote.SaifAccountInfo
import com.example.saif.data.remote.SystemConnectionState
import com.example.saif.data.remote.SystemStatus
import com.example.ui.theme.SaifTheme

private val SaifPurple = Color(0xFF3D6BF5)

/**
 * The centre of an empty SAIF AI chat.
 *  - offline            -> what is wrong, nothing to sign in to
 *  - signed out         -> "Sign in to SAIF AI"
 *  - starting           -> small spinner with the step
 *  - provider missing   -> what to configure
 *  - ready              -> just the glowing SAIF AI mark
 */
@Composable
fun SaifEmptyState(
    status: SystemStatus,
    isNetworkConnected: Boolean,
    isAuthBusy: Boolean,
    onSignIn: () -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    val c = SaifTheme.colors
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 28.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when {
            !isNetworkConnected -> {
                SaifMarkCircle(icon = Icons.Outlined.CloudOff, tint = Color(0xFFEF4444))
                Spacer(Modifier.height(16.dp))
                Text(
                    "You seem to be offline",
                    color = c.textPrimary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "Connect to the internet to reach your AI provider.",
                    color = c.textSecondary,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Center
                )
            }

            status == SystemStatus.UNAUTHENTICATED -> {
                SaifMarkCircle(icon = Icons.Default.Person, tint = SaifPurple)
                Spacer(Modifier.height(16.dp))
                Text(
                    "Sign in to SAIF AI",
                    color = c.textPrimary,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "Sign in to keep your chats, workspace and saved skills.",
                    color = c.textSecondary,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(20.dp))
                Button(
                    onClick = onSignIn,
                    enabled = !isAuthBusy,
                    colors = ButtonDefaults.buttonColors(containerColor = SaifPurple, contentColor = Color.White)
                ) {
                    if (isAuthBusy) {
                        CircularProgressIndicator(modifier = Modifier.size(16.dp), strokeWidth = 2.dp, color = Color.White)
                    } else {
                        Icon(Icons.AutoMirrored.Outlined.Login, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(8.dp))
                        Text("Sign In", fontWeight = FontWeight.SemiBold)
                    }
                }
            }

            status == SystemStatus.CHECKING_AUTH ||
                status == SystemStatus.ACQUIRING_CSRF ||
                status == SystemStatus.STARTING -> {
                CircularProgressIndicator(modifier = Modifier.size(28.dp), strokeWidth = 3.dp, color = SaifPurple)
                Spacer(Modifier.height(14.dp))
                Text(
                    when (status) {
                        SystemStatus.ACQUIRING_CSRF -> "Almost ready…"
                        SystemStatus.STARTING -> "Starting SAIF AI…"
                        else -> "Checking your sign-in…"
                    },
                    color = c.textSecondary,
                    fontSize = 14.sp
                )
            }

            status == SystemStatus.ERROR || status == SystemStatus.OFFLINE -> {
                SaifMarkCircle(icon = Icons.Outlined.Tune, tint = Color(0xFFF59E0B))
                Spacer(Modifier.height(16.dp))
                Text(
                    if (status == SystemStatus.ERROR) "Add your own AI provider" else "Your AI provider is switched off",
                    color = c.textPrimary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "SAIF AI has no built-in model list. Add an API key you own (OpenRouter, OpenAI, Anthropic, Gemini or a local endpoint) and pick a model.",
                    color = c.textSecondary,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(18.dp))
                Button(
                    onClick = onRetry,
                    colors = ButtonDefaults.buttonColors(containerColor = SaifPurple, contentColor = Color.White)
                ) { Text("Open AI provider settings", fontWeight = FontWeight.SemiBold) }
            }

            else -> {
                SaifMarkCircle(icon = Icons.Outlined.Tune, tint = SaifPurple)
            }
        }
    }
}

@Composable
private fun SaifMarkCircle(icon: androidx.compose.ui.graphics.vector.ImageVector, tint: Color) {
    val transition = rememberInfiniteTransition(label = "saif_mark")
    val pulse by transition.animateFloat(
        initialValue = 0.96f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(tween(2200, easing = FastOutSlowInEasing), RepeatMode.Reverse),
        label = "saif_mark_pulse"
    )
    Box(
        modifier = Modifier
            .size(64.dp)
            .scale(pulse)
            .clip(CircleShape)
            .background(tint.copy(alpha = 0.14f)),
        contentAlignment = Alignment.Center
    ) {
        Icon(icon, contentDescription = null, tint = tint, modifier = Modifier.size(32.dp))
    }
}

/**
 * Connection / account card, opened by the status dot in the header.
 * It reports SAIF AI's own account plus the AI provider the owner configured.
 */
@Composable
fun SaifConnectionDialog(
    account: SaifAccountInfo,
    connection: SystemConnectionState,
    onManageProviders: () -> Unit,
    onSignIn: () -> Unit,
    onDismiss: () -> Unit
) {
    val c = SaifTheme.colors
    val status = connection.status
    val name = account.displayName.ifBlank { account.fullName }.ifBlank { account.email }
    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = c.surfaceCard,
        titleContentColor = c.textPrimary,
        textContentColor = c.textSecondary,
        shape = RoundedCornerShape(22.dp),
        title = { Text("SAIF AI connection", fontWeight = FontWeight.Bold, fontSize = 18.sp) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(Modifier.size(11.dp).background(status.dotColor, CircleShape))
                    Spacer(Modifier.width(10.dp))
                    Text(status.label, color = c.textPrimary, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                }
                if (account.isLoggedIn && name.isNotBlank()) {
                    Text("Signed in as $name", fontSize = 13.5.sp)
                    if (account.email.isNotBlank() && account.email != name) {
                        Text(account.email, fontSize = 12.5.sp)
                    }
                } else {
                    Text("You are not signed in yet.", fontSize = 13.5.sp)
                }
                when (connection) {
                    is SystemConnectionState.Connected -> Text(
                        "Provider: ${connection.providerName.ifBlank { "custom endpoint" }} · ${connection.modelId}",
                        fontSize = 13.sp
                    )

                    SystemConnectionState.NotConfigured -> Text(
                        "No AI provider configured yet. Add your own API key in Settings → AI provider.",
                        fontSize = 13.sp
                    )

                    SystemConnectionState.ProviderOffline -> Text(
                        "Your AI provider is switched off or missing a key. Enable it in Settings → AI provider.",
                        fontSize = 13.sp
                    )

                    else -> Text("SAIF AI is starting up.", fontSize = 13.sp)
                }
            }
        },
        confirmButton = {
            when {
                !account.isLoggedIn -> Button(
                    onClick = { onSignIn(); onDismiss() },
                    colors = ButtonDefaults.buttonColors(containerColor = SaifPurple, contentColor = Color.White)
                ) { Text("Sign In") }

                else -> Button(
                    onClick = { onManageProviders(); onDismiss() },
                    colors = ButtonDefaults.buttonColors(containerColor = SaifPurple, contentColor = Color.White)
                ) { Text("Manage AI provider") }
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Close", color = c.textSecondary) }
        }
    )
}
