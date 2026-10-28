package com.valimade.coinsfortune

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import kotlinx.coroutines.launch
import kotlinx.coroutines.coroutineScope
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinScreen()
        }
    }
}

private val ScreenGray = Color(0xFF808080)

/**
 * Главный экран.
 * Серый фон, монета строго по центру.
 */
@Composable
private fun CoinScreen() {

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenGray),
        contentAlignment = Alignment.Center
    ) {
        val coinDiameter = calculateCoinDiameter(
            width = maxWidth,
            height = maxHeight
        )

        Coin(
            diameter = coinDiameter
        )
    }
}

/**
 * Расчёт диаметра:
 * половина меньшей стороны доступной области.
 */
private fun calculateCoinDiameter(
    width: Dp,
    height: Dp
): Dp {
    return minOf(width, height) / 2f
}

/**
 * Монета и управление её вращением.
 */
@Composable
private fun Coin(
    diameter: Dp
) {
    val scope = rememberCoroutineScope()
    val density = LocalDensity.current.density

    // Текущий угол вращения вокруг вертикальной оси.
    val rotationYAnimation = remember {
        Animatable(0f)
    }

    var isFlipping by remember {
        mutableStateOf(false)
    }

    // 0° и 360° — лицевая сторона.
    // 180° — обратная сторона.
    val normalizedAngle =
        ((rotationYAnimation.value % 360f) + 360f) % 360f

    val isBackVisible = normalizedAngle > 90f &&
            normalizedAngle < 270f

    /**
     * Запускает один бросок.
     */
    fun flipCoin() {
        if (isFlipping) return

        scope.launch {
            isFlipping = true

            try {
                // Сначала выбираем результат броска.
                val resultIsBack = determineCoinSide()

                // Какая сторона видна перед броском.
                val currentIsBack = isBackVisible

                // От 3 до 5 полных оборотов плюс финальный поворот.
                val fullRotations = Random.nextInt(3, 6)

                val finalRotation = if (resultIsBack == currentIsBack) {
                    0f
                } else {
                    180f
                }

                val rotationDegrees = fullRotations * 360f + finalRotation

                // Случайное направление вращения.
                val direction = if (Random.nextBoolean()) {
                    1f
                } else {
                    -1f
                }

                val targetRotation =
                    rotationYAnimation.value + direction * rotationDegrees

                coroutineScope {
                    // Вращение вокруг вертикальной оси.
                    launch {
                        rotationYAnimation.animateTo(
                            targetValue = targetRotation,
                            animationSpec = tween(
                                durationMillis = 1100,
                                easing = FastOutSlowInEasing
                            )
                        )
                    }

                }
            } finally {
                isFlipping = false
            }
        }
    }

    val imageRes = if (isBackVisible) {
        R.drawable.coin_yes
    } else {
        R.drawable.coin_no
    }

    Image(
        painter = painterResource(imageRes),
        contentDescription = "Монета судьбы",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(diameter)
            .graphicsLayer {
                rotationY = rotationYAnimation.value
                cameraDistance = 12f * density
                scaleX = if (isBackVisible) -1f else 1f
            }
            .clickable(
                enabled = !isFlipping,
                onClick = { flipCoin() }
            )
    )
}

/**
 * Определяет результат броска:
 * false — лицевая сторона;
 * true — обратная сторона.
 */
private fun determineCoinSide(): Boolean {
    return Random.nextBoolean()
}
