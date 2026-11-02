package com.valimade.coinsfortune.ui.util

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.valimade.coinsfortune.domain.model.CoinSide
import kotlin.random.Random

const val MAX_DIAMETER = 320

@Composable
fun calculateCoinDiameter(): Dp {
    val configuration = LocalConfiguration.current

    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    return (minOf(screenWidth, screenHeight) * 0.5f)
        .coerceAtMost(MAX_DIAMETER.dp)
}

fun calculateTargetRotation(
    currentRotation: Float,
    result: CoinSide
): Float {
    val normalizedCurrent = ((currentRotation % 360f) + 360f) % 360f

    val targetAngle = when (result) {
        CoinSide.FIRST -> 0f
        CoinSide.SECOND -> 180f
        CoinSide.EDGE -> if (Random.nextBoolean()) 90f else 270f
    }

    val direction = if (Random.nextBoolean()) 1f else -1f
    val fullRotations = Random.nextInt(3, 6)

    val remainingRotation = if (direction > 0) {
        (targetAngle - normalizedCurrent + 360f) % 360f
    } else {
        -((normalizedCurrent - targetAngle + 360f) % 360f)
    }

    return currentRotation +
            direction * fullRotations * 360f +
            remainingRotation
}

suspend fun animateCoinFlip(
    rotation: Animatable<Float, AnimationVector1D>,
    targetRotation: Float
) {
    rotation.animateTo(
        targetValue = targetRotation,
        animationSpec = tween(
            durationMillis = 1100,
            easing = FastOutSlowInEasing
        )
    )
}