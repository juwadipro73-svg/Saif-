/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.SaifTheme

/**
 * The animated character cards shown on the empty chat screen.
 *
 * Each card renders a little procedurally-drawn "agent" that moves on its own: a glowing core,
 * an orbiting satellite and a scanning arc. Nothing is downloaded - the artwork is drawn with the
 * Compose canvas so the APK stays small and the animation is perfectly smooth.
 */
@Composable
fun AnimatedCharacterCards(
    modifier: Modifier = Modifier,
    onCardClick: ((String) -> Unit)? = null
) {
    val cards = remember { SaifCharacterCatalog.cards }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        cards.forEachIndexed { index, card ->
            SaifCharacterCard(
                card = card,
                index = index,
                onClick = onCardClick?.let { callback -> { callback(card.id) } }
            )
        }
    }
}

@Composable
private fun SaifCharacterCard(
    card: SaifCharacterCardModel,
    index: Int,
    onClick: (() -> Unit)?
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.972f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessMediumLow),
        label = "charScale"
    )

    // Each card wakes up slightly after the previous one so the grid feels alive.
    val entrance = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(90L * index)
        entrance.animateTo(1f, tween(520, easing = FastOutSlowInEasing))
    }

    val accent = Color(card.accent)
    val accentSoft = Color(card.accentSoft)

    val infinite = rememberInfiniteTransition(label = "char_${card.id}")
    val orbit by infinite.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(card.orbitMillis, easing = LinearEasing), RepeatMode.Restart),
        label = "orbit"
    )
    val pulse by infinite.animateFloat(
        initialValue = 0.92f,
        targetValue = 1.08f,
        animationSpec = infiniteRepeatable(tween(1500 + index * 180, easing = FastOutSlowInEasing), RepeatMode.Reverse),
        label = "pulse"
    )
    val sweep by infinite.animateFloat(
        initialValue = -0.4f,
        targetValue = 1.4f,
        animationSpec = infiniteRepeatable(tween(2100 + index * 260, easing = FastOutSlowInEasing), RepeatMode.Restart),
        label = "sweep"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .scale(scale)
            .alpha(entrance.value)
            .clip(RoundedCornerShape(18.dp))
            .background(
                Brush.horizontalGradient(
                    listOf(
                        SaifTheme.colors.surfaceCard.copy(alpha = 0.92f),
                        accentSoft.copy(alpha = 0.10f)
                    )
                )
            )
            .border(
                width = 1.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        accent.copy(alpha = 0.45f),
                        Color.Transparent
                    )
                ),
                shape = RoundedCornerShape(18.dp)
            )
            .then(if (onClick != null) Modifier.clickable(
                interactionSource = interactionSource,
                indication = androidx.compose.foundation.LocalIndication.current,
                onClick = onClick
            ) else Modifier)
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Animated procedural avatar
        Box(
            modifier = Modifier.size(46.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val c = center
                val r = size.minDimension / 2f

                // Soft halo
                drawCircle(
                    brush = Brush.radialGradient(
                        listOf(accent.copy(alpha = 0.34f * pulse), Color.Transparent),
                        center = c,
                        radius = r
                    ),
                    radius = r,
                    center = c
                )

                // Orbiting satellite
                val satAngle = Math.toRadians(orbit.toDouble())
                val satRadius = r * 0.78f
                val satCenter = Offset(
                    c.x + kotlin.math.cos(satAngle).toFloat() * satRadius,
                    c.y + kotlin.math.sin(satAngle).toFloat() * satRadius
                )
                drawCircle(accent.copy(alpha = 0.55f), radius = 2.6.dp.toPx(), center = satCenter)

                // Core body
                drawCircle(
                    brush = Brush.linearGradient(
                        listOf(accent, Color(accent.red, accent.green, accent.blue, 0.55f))
                    ),
                    radius = r * 0.52f,
                    center = c
                )

                // Scanning arc
                rotate(degrees = orbit * 1.6f, pivot = c) {
                    drawArc(
                        brush = Brush.sweepGradient(listOf(Color.Transparent, Color.White.copy(alpha = 0.85f), Color.Transparent)),
                        startAngle = 0f,
                        sweepAngle = 110f,
                        useCenter = false,
                        topLeft = Offset(c.x - r * 0.66f, c.y - r * 0.66f),
                        size = Size(r * 1.32f, r * 1.32f),
                        style = Stroke(width = 2.dp.toPx(), cap = StrokeCap.Round)
                    )
                }

                // Eyes - the "face" that makes the card read as a character.
                val eyeY = c.y - r * 0.06f
                val eyeDx = r * 0.17f
                val eyeR = maxOf(1.5f, r * 0.075f)
                drawCircle(Color.White.copy(alpha = 0.95f), radius = eyeR, center = Offset(c.x - eyeDx, eyeY))
                drawCircle(Color.White.copy(alpha = 0.95f), radius = eyeR, center = Offset(c.x + eyeDx, eyeY))
            }
        }

        Spacer(Modifier.width(13.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = card.title,
                color = SaifTheme.colors.textPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = card.subtitle,
                color = SaifTheme.colors.textSecondary,
                fontSize = 11.5.sp,
                lineHeight = 15.sp,
                maxLines = 2
            )
        }

        Spacer(Modifier.width(8.dp))

        // Trailing energy bar that fills continuously.
        Box(
            modifier = Modifier
                .width(3.dp)
                .height(28.dp)
                .clip(RoundedCornerShape(2.dp))
                .background(accent.copy(alpha = 0.14f))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight((sweep).coerceIn(0f, 1f))
                    .clip(RoundedCornerShape(2.dp))
                    .background(
                        Brush.verticalGradient(listOf(accent, accent.copy(alpha = 0.35f)))
                    )
            )
        }
    }
}

/** One character card model. */
data class SaifCharacterCardModel(
    val id: String,
    val title: String,
    val subtitle: String,
    val accent: Long,
    val accentSoft: Long,
    val orbitMillis: Int
)

/**
 * The characters SAIF AI ships with. Each one is a distinct developer persona, so the empty
 * screen doubles as a quick way to start the right kind of task.
 */
object SaifCharacterCatalog {
    val cards: List<SaifCharacterCardModel> = listOf(
        SaifCharacterCardModel(
            id = "builder",
            title = "Builder",
            subtitle = "Ships a full Android app end to end and hands you the APK.",
            accent = 0xFF3D6BF5,
            accentSoft = 0xFF8B5CF6,
            orbitMillis = 2600
        ),
        SaifCharacterCardModel(
            id = "reviewer",
            title = "Reviewer",
            subtitle = "Reads your diff, hunts the bugs and explains every fix.",
            accent = 0xFF10B981,
            accentSoft = 0xFF34D399,
            orbitMillis = 3200
        ),
        SaifCharacterCardModel(
            id = "terminal",
            title = "Terminal",
            subtitle = "Drives the shell, installs packages and runs your test suite.",
            accent = 0xFFF59E0B,
            accentSoft = 0xFFFBBF24,
            orbitMillis = 2200
        ),
        SaifCharacterCardModel(
            id = "researcher",
            title = "Researcher",
            subtitle = "Searches the web, reads the docs and writes the plan.",
            accent = 0xFFEC4899,
            accentSoft = 0xFFF472B6,
            orbitMillis = 3800
        )
    )
}
