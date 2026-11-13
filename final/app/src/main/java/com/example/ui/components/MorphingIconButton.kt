/* Copyright (c) SAIF AI. All rights reserved. */

package com.example.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * An icon button whose *shape* morphs instead of switching abruptly.
 *
 * The button starts as a circle, becomes a squircle when idle and stretches into a pill while it
 * is pressed, while the icon counter-rotates slightly and the accent ring sweeps around it. Every
 * transition is interpolated, so the button never "pops" between states.
 */
@Composable
fun MorphingIconButton(
    icon: ImageVector,
    contentDescription: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 42.dp,
    iconSize: Dp = 20.dp,
    tint: Color = Color.White,
    containerColor: Color = Color(0xFF2B2A28),
    accent: Color = Color(0xFF3D6BF5),
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    // 0 = circle, 1 = squircle, 2 = pill. Interpolated continuously for a smooth morph.
    val morph by animateFloatAsState(
        targetValue = if (isPressed) 2f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessMediumLow),
        label = "morphAmount"
    )
    val pressScale by animateFloatAsState(
        targetValue = if (isPressed) 0.90f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessMedium),
        label = "morphScale"
    )
    val iconRotation by animateFloatAsState(
        targetValue = if (isPressed) -12f else 0f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessMediumLow),
        label = "morphRotation"
    )
    // A slow breathing zoom keeps the icon alive while the button rests.
    val idleBreath by rememberInfiniteTransition(label = "morphBreath").animateFloat(
        initialValue = 1f,
        targetValue = 1.035f,
        animationSpec = infiniteRepeatable(tween(2200, easing = FastOutSlowInEasing), RepeatMode.Reverse),
        label = "breath"
    )
    val container by animateColorAsState(
        targetValue = if (isPressed) accent.copy(alpha = 0.22f) else containerColor,
        animationSpec = tween(220),
        label = "morphContainer"
    )

    // The shape is rebuilt every frame from the morph value so it flows instead of snapping.
    val corner = when {
        morph < 1f -> (size.value * 0.5f * morph).dp
        else -> (size.value * (0.5f - (morph - 1f) * 0.5f * 0.86f)).dp
    }
    val shape: Shape = RoundedCornerShape(corner)

    Box(
        modifier = modifier
            .size(size)
            .scale(pressScale)
            .clip(shape)
            .background(container)
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(
                    listOf(
                        accent.copy(alpha = if (isPressed) 0.55f else 0.18f),
                        Color.Transparent
                    )
                ),
                shape = shape
            )
            .clickable(
                interactionSource = interactionSource,
                indication = androidx.compose.foundation.LocalIndication.current,
                enabled = enabled,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = if (enabled) tint else tint.copy(alpha = 0.4f),
            modifier = Modifier
                .size(iconSize)
                .rotate(iconRotation)
                .scale(idleBreath)
        )
    }
}

/**
 * A morphing icon button that shows a rotating "busy" arc while [busy] is true. Used for the
 * toolbar actions that trigger a long-running operation.
 */
@Composable
fun MorphingActionButton(
    icon: ImageVector,
    contentDescription: String?,
    onClick: () -> Unit,
    busy: Boolean = false,
    modifier: Modifier = Modifier,
    size: Dp = 42.dp,
    iconSize: Dp = 20.dp,
    tint: Color = Color.White,
    containerColor: Color = Color(0xFF2B2A28),
    accent: Color = Color(0xFF3D6BF5)
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val morph by animateFloatAsState(
        targetValue = if (isPressed) 2f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessMediumLow),
        label = "morphAmount"
    )
    val pressScale by animateFloatAsState(
        targetValue = if (isPressed) 0.90f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessMedium),
        label = "morphScale"
    )
    val spin by rememberInfiniteTransition(label = "morphSpin").animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(1100, easing = LinearEasing)),
        label = "spin"
    )

    val corner = when {
        morph < 1f -> (size.value * 0.5f * morph).dp
        else -> (size.value * (0.5f - (morph - 1f) * 0.5f * 0.86f)).dp
    }
    val shape: Shape = RoundedCornerShape(corner)

    Box(
        modifier = modifier
            .size(size)
            .scale(pressScale)
            .clip(shape)
            .background(if (busy) accent.copy(alpha = 0.20f) else containerColor)
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(
                    listOf(accent.copy(alpha = if (busy) 0.65f else 0.18f), Color.Transparent)
                ),
                shape = shape
            )
            .clickable(
                interactionSource = interactionSource,
                indication = androidx.compose.foundation.LocalIndication.current,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = if (busy) accent else tint,
            modifier = Modifier
                .size(iconSize)
                .rotate(if (busy) spin else 0f)
        )
    }
}
