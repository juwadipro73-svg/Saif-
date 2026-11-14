package com.example.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Shared motion for SAIF AI's buttons and cards.
 *
 * - [MorphIconButton]: a round button whose shape melts into a soft square while it is pressed (or [active]),
 *   with a springy squeeze, a small tilt, and an icon that morphs into the next icon (scale + fade) when the
 *   icon changes, e.g. microphone to send arrow.
 * - [AuroraFrame]: a slowly travelling light along the edge of a card.
 */
@Composable
fun MorphIconButton(
    icon: ImageVector,
    contentDescription: String?,
    onClick: () -> Unit,
    tint: Color,
    modifier: Modifier = Modifier,
    size: Dp = 34.dp,
    iconSize: Dp = 18.dp,
    background: Color = Color.Transparent,
    activeBackground: Color = tint.copy(alpha = 0.16f),
    outline: Color = Color.Transparent,
    activeOutline: Color = outline,
    active: Boolean = false,
    enabled: Boolean = true
) {
    val source = remember { MutableInteractionSource() }
    val pressed by source.collectIsPressedAsState()
    val morph = pressed || active
    val corner by animateIntAsState(
        targetValue = if (morph) 30 else 50,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMediumLow),
        label = "morphCorner"
    )
    val squeeze by animateFloatAsState(
        targetValue = if (pressed) 0.86f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMedium),
        label = "morphSqueeze"
    )
    val tilt by animateFloatAsState(
        targetValue = if (pressed) -14f else 0f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMediumLow),
        label = "morphTilt"
    )
    val fill by animateColorAsState(
        targetValue = if (morph) activeBackground else background,
        animationSpec = tween(200),
        label = "morphFill"
    )
    val line by animateColorAsState(
        targetValue = if (morph) activeOutline else outline,
        animationSpec = tween(200),
        label = "morphLine"
    )
    Box(
        modifier = modifier
            .size(size)
            .graphicsLayer { scaleX = squeeze; scaleY = squeeze }
            .clip(RoundedCornerShape(percent = corner))
            .background(fill)
            .border(1.dp, line, RoundedCornerShape(percent = corner))
            .clickable(interactionSource = source, indication = null, enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        AnimatedContent(
            targetState = icon,
            transitionSpec = {
                (fadeIn(tween(180)) + scaleIn(initialScale = 0.5f, animationSpec = tween(220))) togetherWith
                    (fadeOut(tween(100)) + scaleOut(targetScale = 0.5f, animationSpec = tween(120)))
            },
            label = "iconMorph"
        ) { current ->
            Icon(
                imageVector = current,
                contentDescription = contentDescription,
                tint = tint,
                modifier = Modifier.size(iconSize).graphicsLayer { rotationZ = tilt }
            )
        }
    }
}

/** Draws a slowly rotating band of light around [content]; [content] must have an opaque background. */
@Composable
fun AuroraFrame(
    shape: Shape,
    colors: List<Color>,
    modifier: Modifier = Modifier,
    borderWidth: Dp = 1.2.dp,
    periodMillis: Int = 5200,
    content: @Composable () -> Unit
) {
    val transition = rememberInfiniteTransition(label = "aurora")
    val angle by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(animation = tween(periodMillis, easing = LinearEasing), repeatMode = RepeatMode.Restart),
        label = "auroraAngle"
    )
    Box(
        modifier = modifier
            .clip(shape)
            .drawBehind {
                val radius = kotlin.math.hypot(size.width, size.height) / 2f
                val c = Offset(size.width / 2f, size.height / 2f)
                withTransform({ rotate(degrees = angle, pivot = c) }) {
                    drawCircle(brush = Brush.sweepGradient(colors, c), radius = radius, center = c)
                }
            }
            .padding(borderWidth)
    ) {
        content()
    }
}

/** Gentle up-and-down float for idle cards. [phase] offsets neighbours so they do not move together. */
@Composable
fun rememberIdleFloat(phase: Int, amplitudeDp: Float = 2.5f): Float {
    val transition = rememberInfiniteTransition(label = "idleFloat")
    val value by transition.animateFloat(
        initialValue = -amplitudeDp,
        targetValue = amplitudeDp,
        animationSpec = infiniteRepeatable(
            animation = tween(2600 + phase * 330, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "idleFloatValue"
    )
    return value
}
