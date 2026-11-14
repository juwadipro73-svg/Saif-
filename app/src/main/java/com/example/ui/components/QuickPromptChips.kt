package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.material.icons.outlined.AutoFixHigh
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.animation.core.*
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import com.example.ui.theme.SaifTheme

@Composable
fun QuickPromptChips(
    currentMode: String,
    onSelectPrompt: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val accent = Color(0xFF7C5CE0)
    val isLightMode = com.example.ui.theme.SaifTheme.colors.isLight

    // Staggered entrance: hero first, then each suggestion card slides up in turn.
    var entered by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { entered = true }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        val infiniteTransition = rememberInfiniteTransition(label = "hero")
        val breathe by infiniteTransition.animateFloat(
            initialValue = 0.985f,
            targetValue = 1.015f,
            animationSpec = infiniteRepeatable(
                animation = tween(3200, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "hero_breathe"
        )
        // The mark keeps morphing between a rounded square and a circle; a thin orbit ring turns around it.
        val markCorner by infiniteTransition.animateFloat(
            initialValue = 22f,
            targetValue = 34f,
            animationSpec = infiniteRepeatable(
                animation = tween(2600, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "hero_mark_corner"
        )
        val orbit by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(animation = tween(9000, easing = LinearEasing), repeatMode = RepeatMode.Restart),
            label = "hero_orbit"
        )
        val markShape = RoundedCornerShape(markCorner.dp)
        val glowAlpha by infiniteTransition.animateFloat(
            initialValue = 0.10f,
            targetValue = 0.24f,
            animationSpec = infiniteRepeatable(
                animation = tween(3200, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "hero_glow"
        )

        AnimatedVisibility(
            visible = entered,
            enter = fadeIn(tween(450)) + slideInVertically(tween(450, easing = FastOutSlowInEasing)) { it / 6 }
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Hero mark: soft single-colour halo, gentle breathing only
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.scale(breathe)
                ) {
                    Box(
                        modifier = Modifier
                            .size(128.dp)
                            .background(
                                brush = androidx.compose.ui.graphics.Brush.radialGradient(
                                    colors = listOf(accent.copy(alpha = glowAlpha), Color.Transparent)
                                )
                            )
                    )
                    androidx.compose.foundation.Canvas(
                        modifier = Modifier
                            .size(100.dp)
                            .graphicsLayer { rotationZ = orbit }
                    ) {
                        drawArc(
                            brush = androidx.compose.ui.graphics.Brush.sweepGradient(
                                listOf(Color.Transparent, accent.copy(alpha = 0.15f), accent, Color(0xFF38BDF8), Color.Transparent)
                            ),
                            startAngle = 0f,
                            sweepAngle = 250f,
                            useCenter = false,
                            style = androidx.compose.ui.graphics.drawscope.Stroke(width = 2.dp.toPx(), cap = androidx.compose.ui.graphics.StrokeCap.Round)
                        )
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(68.dp)
                            .clip(markShape)
                            .background(if (isLightMode) Color(0xFFF5F4EE) else Color(0xFF2B2A28))
                            .border(
                                1.dp,
                                if (isLightMode) Color(0xFFE5E2D6) else Color(0xFF3A3835),
                                markShape
                            )
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.AutoAwesome,
                            contentDescription = "SAIF AI",
                            tint = accent,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = run {
                        val hour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY)
                        when (hour) {
                            in 5..11 -> "Good morning"
                            in 12..16 -> "Good afternoon"
                            in 17..21 -> "Good evening"
                            else -> "Burning the midnight oil?"
                        }
                    },
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.6.sp,
                    color = accent,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "How can I help you today?",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = (-0.3).sp,
                    color = SaifTheme.colors.textPrimary,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Chat, create images, analyze photos, write code\nor start a voice conversation.",
                    fontSize = 14.sp,
                    color = SaifTheme.colors.textSecondary,
                    textAlign = TextAlign.Center,
                    lineHeight = 21.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                // Which APK is this? (set by CI: "build #N (commit)")
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = com.example.gemini.BuildConfig.BUILD_STAMP,
                    fontSize = 11.sp,
                    color = SaifTheme.colors.textSecondary.copy(alpha = 0.5f),
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        val cards = listOf(
            Triple(Icons.Outlined.AutoFixHigh, "Create an image" to "A futuristic city at night", "Generate an image of a futuristic city at night"),
            Triple(Icons.Outlined.ChatBubbleOutline, "Plan something" to "A 3-day Tokyo itinerary", "Help me plan a 3-day Tokyo itinerary"),
            Triple(Icons.Default.Code, "Explain code" to "Walk me through React hooks", "Walk me through React hooks"),
            Triple(Icons.Outlined.Lightbulb, "Chat in Hinglish" to "Switch to Hindi written in English letters", "Let's chat in Hinglish"),
            Triple(Icons.Outlined.Apps, "Build an app" to "A simple calendar for my phone", "Build me a simple Android calendar app")
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            cards.forEachIndexed { index, (icon, text, prompt) ->
                AnimatedVisibility(
                    visible = entered,
                    enter = fadeIn(tween(380, delayMillis = 120 + index * 70)) +
                        slideInVertically(tween(380, delayMillis = 120 + index * 70, easing = FastOutSlowInEasing)) { it / 3 }
                ) {
                    PromptCard(
                        icon = icon,
                        title = text.first,
                        subtitle = text.second,
                        iconTint = accent,
                        index = index,
                        onClick = { onSelectPrompt(prompt) }
                    )
                }
            }
        }
    }
}

@Composable
fun PromptCard(
    icon: ImageVector,
    title: String,
    subtitle: String,
    iconTint: Color,
    onClick: () -> Unit,
    index: Int = 0
) {
    val isLightMode = com.example.ui.theme.SaifTheme.colors.isLight
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val cardScale by animateFloatAsState(
        targetValue = if (isPressed) 0.965f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMedium),
        label = "PromptCardScale"
    )
    // The icon tile melts from a rounded square into a circle and tilts while the card is held.
    val tileCorner by animateIntAsState(
        targetValue = if (isPressed) 50 else 30,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMediumLow),
        label = "PromptTileCorner"
    )
    val tileTilt by animateFloatAsState(
        targetValue = if (isPressed) 18f else 0f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMediumLow),
        label = "PromptTileTilt"
    )
    val chevronShift by animateFloatAsState(
        targetValue = if (isPressed) 6f else 0f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMedium),
        label = "PromptChevron"
    )
    val float = rememberIdleFloat(phase = index)
    val base = if (isLightMode) Color(0xFFE5E2D6) else Color(0xFF3A3835)
    val cardShape = RoundedCornerShape(16.dp)

    AuroraFrame(
        shape = cardShape,
        colors = listOf(base, base, iconTint.copy(alpha = 0.85f), Color(0xFF38BDF8).copy(alpha = 0.8f), base, base, base),
        periodMillis = 5200 + index * 700,
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer { translationY = float.dp.toPx(); scaleX = cardScale; scaleY = cardScale }
            .clickable(interactionSource = interactionSource, indication = null, onClick = onClick)
    ) {
        Surface(
            shape = RoundedCornerShape(15.dp),
            color = if (isLightMode) Color(0xFFFFFFFF) else Color(0xFF2B2A28),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(40.dp)
                        .graphicsLayer { rotationZ = tileTilt }
                        .clip(RoundedCornerShape(percent = tileCorner))
                        .background(iconTint.copy(alpha = if (isPressed) 0.22f else 0.12f))
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = iconTint,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(14.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        color = SaifTheme.colors.textPrimary,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = subtitle,
                        color = SaifTheme.colors.textSecondary,
                        fontSize = 13.sp
                    )
                }
                Icon(
                    imageVector = Icons.Outlined.ChevronRight,
                    contentDescription = null,
                    tint = SaifTheme.colors.textSecondary.copy(alpha = 0.6f),
                    modifier = Modifier
                        .size(20.dp)
                        .graphicsLayer { translationX = chevronShift.dp.toPx() }
                )
            }
        }
    }
}
