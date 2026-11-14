package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.icon.TimeAwareIcon
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.sin

/** Sky colours (top, bottom) of the start-up screen: the same eight moods as the launcher icon, kept dark. */
private val SplashSky = listOf(
    Color(0xFF3B1F4F) to Color(0xFF110B22), // dawn
    Color(0xFF1B2F5C) to Color(0xFF0E0B26), // morning
    Color(0xFF16275E) to Color(0xFF0B0A24), // noon
    Color(0xFF4A2A52) to Color(0xFF120B22), // afternoon
    Color(0xFF55224A) to Color(0xFF0F0A22), // sunset
    Color(0xFF241A5E) to Color(0xFF0A0820), // evening
    Color(0xFF14123D) to Color(0xFF060614), // night
    Color(0xFF0D0C2A) to Color(0xFF040410)  // late night
)

private const val BRAND = "SAIF AI"

@Composable
fun SaifAnimatedSplashOverlay(
    visible: Boolean,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = visible,
        exit = fadeOut(animationSpec = tween(520, easing = FastOutSlowInEasing)) +
            scaleOut(targetScale = 1.14f, animationSpec = tween(520, easing = FastOutSlowInEasing)),
        modifier = modifier.fillMaxSize()
    ) {
        val sky = remember { SplashSky[TimeAwareIcon.currentPhase().coerceIn(0, SplashSky.lastIndex)] }
        val logoScale = remember { Animatable(0.4f) }
        val logoAlpha = remember { Animatable(0f) }
        val badgeCorner = remember { Animatable(50f) }     // starts as a circle, settles into a rounded square
        val shock = remember { Animatable(0f) }            // one shockwave ring when the logo lands
        val letters = remember { List(BRAND.length) { Animatable(0f) } }
        val tagAlpha = remember { Animatable(0f) }
        val barProgress = remember { Animatable(0.04f) }

        LaunchedEffect(Unit) {
            launch { logoAlpha.animateTo(1f, tween(300, easing = FastOutSlowInEasing)) }
            launch {
                logoScale.animateTo(1f, spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessLow))
            }
            launch {
                delay(250)
                badgeCorner.animateTo(30f, tween(900, easing = FastOutSlowInEasing))
            }
            launch {
                delay(380)
                shock.animateTo(1f, tween(1100, easing = FastOutSlowInEasing))
            }
            launch {
                delay(420)
                letters.forEachIndexed { i, a ->
                    launch {
                        delay(i * 75L)
                        a.animateTo(1f, spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMediumLow))
                    }
                }
            }
            launch {
                delay(900)
                tagAlpha.animateTo(1f, tween(500, easing = FastOutSlowInEasing))
            }
            launch { barProgress.animateTo(1f, tween(1900, easing = FastOutSlowInEasing)) }
        }

        val infinite = rememberInfiniteTransition(label = "saif_splash_infinite")
        val orbitAngle by infinite.animateFloat(
            initialValue = 0f, targetValue = 360f,
            animationSpec = infiniteRepeatable(tween(2600, easing = LinearEasing), RepeatMode.Restart),
            label = "orbit_angle"
        )
        val pulseGlow by infinite.animateFloat(
            initialValue = 0.85f, targetValue = 1.15f,
            animationSpec = infiniteRepeatable(tween(1100, easing = FastOutSlowInEasing), RepeatMode.Reverse),
            label = "pulse_glow"
        )
        val shimmerSweep by infinite.animateFloat(
            initialValue = -1f, targetValue = 2f,
            animationSpec = infiniteRepeatable(tween(1400, easing = FastOutSlowInEasing), RepeatMode.Restart),
            label = "shimmer_sweep"
        )
        val clock by infinite.animateFloat(
            initialValue = 0f, targetValue = 1f,
            animationSpec = infiniteRepeatable(tween(6000, easing = LinearEasing), RepeatMode.Restart),
            label = "clock"
        )
        // Fixed star field: same every launch, so the screen feels designed rather than random.
        val stars = remember {
            val r = java.util.Random(7L)
            List(42) { Triple(r.nextFloat(), r.nextFloat(), r.nextFloat()) }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(listOf(sky.first, sky.second))),
            contentAlignment = Alignment.Center
        ) {
            // Twinkling stars drift slowly upward; the ambient glow breathes behind the logo.
            Canvas(modifier = Modifier.fillMaxSize()) {
                stars.forEachIndexed { i, (x, y, depth) ->
                    val twinkle = 0.35f + 0.65f * (0.5f + 0.5f * sin((clock * 2f * PI + i * 1.7).toFloat()))
                    val drift = ((y - clock * (0.02f + depth * 0.05f)) % 1f + 1f) % 1f
                    drawCircle(
                        color = Color.White.copy(alpha = 0.55f * twinkle * (0.4f + depth * 0.6f)),
                        radius = (0.8f + depth * 1.6f).dp.toPx(),
                        center = Offset(x * size.width, drift * size.height)
                    )
                }
                val center = Offset(size.width / 2f, size.height * 0.43f)
                val radius = size.minDimension * 0.62f * pulseGlow
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(Color(0xFF7C5CE0).copy(alpha = 0.34f), Color(0xFF4F46E5).copy(alpha = 0.12f), Color.Transparent),
                        center = center, radius = radius
                    ),
                    radius = radius, center = center
                )
                // Shockwave ring
                val p = shock.value
                if (p > 0f && p < 1f) {
                    drawCircle(
                        color = Color(0xFFA78BFA).copy(alpha = (1f - p) * 0.55f),
                        radius = size.minDimension * (0.10f + 0.55f * p),
                        center = center,
                        style = Stroke(width = (3f * (1f - p) + 0.6f).dp.toPx())
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(152.dp)
                        .graphicsLayer {
                            scaleX = logoScale.value; scaleY = logoScale.value; alpha = logoAlpha.value
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val stroke = 2.6.dp.toPx()
                        val outer = 8.dp.toPx()
                        val inner = 20.dp.toPx()
                        val third = 32.dp.toPx()
                        withTransform({ rotate(degrees = orbitAngle, pivot = center) }) {
                            drawArc(
                                brush = Brush.sweepGradient(listOf(Color.Transparent, Color(0xFF9B82EC).copy(alpha = 0.25f), Color(0xFF8B5CF6), Color(0xFF38BDF8), Color.Transparent)),
                                startAngle = 0f, sweepAngle = 250f, useCenter = false,
                                topLeft = Offset(outer, outer), size = Size(size.width - outer * 2, size.height - outer * 2),
                                style = Stroke(width = stroke, cap = StrokeCap.Round)
                            )
                        }
                        withTransform({ rotate(degrees = -orbitAngle * 1.35f, pivot = center) }) {
                            drawArc(
                                brush = Brush.sweepGradient(listOf(Color.Transparent, Color(0xFFA78BFA), Color(0xFFE879F9), Color.Transparent)),
                                startAngle = 60f, sweepAngle = 190f, useCenter = false,
                                topLeft = Offset(inner, inner), size = Size(size.width - inner * 2, size.height - inner * 2),
                                style = Stroke(width = 1.8.dp.toPx(), cap = StrokeCap.Round)
                            )
                        }
                        withTransform({ rotate(degrees = orbitAngle * 0.7f + 120f, pivot = center) }) {
                            drawArc(
                                color = Color(0xFF38BDF8).copy(alpha = 0.55f),
                                startAngle = 0f, sweepAngle = 70f, useCenter = false,
                                topLeft = Offset(third, third), size = Size(size.width - third * 2, size.height - third * 2),
                                style = Stroke(width = 1.4.dp.toPx(), cap = StrokeCap.Round)
                            )
                        }
                    }

                    val badgeShape = RoundedCornerShape(percent = badgeCorner.value.toInt().coerceIn(0, 50))
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(badgeShape)
                            .background(Brush.linearGradient(listOf(Color(0xFF8B5CF6), Color(0xFF5B3CC4), Color(0xFF312E81))))
                            .border(
                                width = 1.5.dp,
                                brush = Brush.linearGradient(listOf(Color.White.copy(alpha = 0.55f), Color(0xFF9B82EC).copy(alpha = 0.2f))),
                                shape = badgeShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            val startX = size.width * shimmerSweep
                            drawLine(
                                brush = Brush.linearGradient(
                                    colors = listOf(Color.Transparent, Color.White.copy(alpha = 0.26f), Color.Transparent),
                                    start = Offset(startX - 40f, 0f), end = Offset(startX + 40f, size.height)
                                ),
                                start = Offset(startX - 30f, 0f), end = Offset(startX + 30f, size.height),
                                strokeWidth = 36f
                            )
                        }
                        Text(text = "S", color = Color.White, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold)
                    }
                }

                Spacer(Modifier.height(22.dp))

                // The name arrives letter by letter.
                Row(horizontalArrangement = Arrangement.Center) {
                    BRAND.forEachIndexed { i, ch ->
                        val a = letters[i].value
                        Text(
                            text = ch.toString(),
                            color = Color.White,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = 3.sp,
                            modifier = Modifier.graphicsLayer {
                                alpha = a.coerceIn(0f, 1f)
                                translationY = (1f - a) * 34.dp.toPx()
                                scaleX = 0.7f + 0.3f * a
                                scaleY = 0.7f + 0.3f * a
                            }
                        )
                    }
                }
                Spacer(Modifier.height(6.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.graphicsLayer { alpha = tagAlpha.value }
                ) {
                    Text(
                        text = "INTELLIGENT AUTONOMOUS WORKSPACE",
                        color = Color(0xFFB8A9F5),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 1.8.sp
                    )
                    Spacer(Modifier.height(28.dp))
                    Box(
                        modifier = Modifier
                            .width(168.dp)
                            .height(4.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.10f))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(barProgress.value.coerceIn(0.04f, 1f))
                                .clip(CircleShape)
                                .background(Brush.horizontalGradient(listOf(Color(0xFF7C5CE0), Color(0xFFA78BFA), Color(0xFF38BDF8))))
                        )
                    }
                }
            }
        }
    }
}
