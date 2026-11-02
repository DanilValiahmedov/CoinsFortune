package com.valimade.coinsfortune.ui.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.valimade.coinsfortune.R
import com.valimade.coinsfortune.domain.model.CoinSide
import com.valimade.coinsfortune.ui.components.CoinUi
import com.valimade.coinsfortune.ui.util.animateCoinFlip
import com.valimade.coinsfortune.ui.util.calculateCoinDiameter
import com.valimade.coinsfortune.ui.util.calculateTargetRotation
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val scope = rememberCoroutineScope()

    val rotation = remember {
        Animatable(0f)
    }

    var isFlipping by remember {
        mutableStateOf(false)
    }

    var result by remember {
        mutableStateOf<CoinSide?>(null)
    }

    val normalizedAngle = ((rotation.value % 360f) + 360f) % 360f

    // Во время вращения показываем соответствующую сторону.
    // После остановки показываем окончательный результат.
    val image = when {
        result == CoinSide.EDGE && !isFlipping ->
            R.drawable.coin_edge

        normalizedAngle in 80f..100f ||
                normalizedAngle in 260f..280f ->
            R.drawable.coin_edge

        normalizedAngle in 90f..270f ->
            R.drawable.coin_no

        else ->
            R.drawable.coin_yes
    }


    val diameter = calculateCoinDiameter()

    fun flipCoin() {
        if (isFlipping) return

        scope.launch {
            isFlipping = true
            result = null

            try {
                val coinResult = CoinSide.entries.random()

                val targetRotation = calculateTargetRotation(
                    currentRotation = rotation.value,
                    result = coinResult
                )

                animateCoinFlip(
                    rotation = rotation,
                    targetRotation = targetRotation
                )

                result = coinResult

            } finally {
                isFlipping = false
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CoinUi(
            diameter = diameter,
            description = "Монета судьбы",
            image = image,
            rotationY = rotation.value,
            onClick = { flipCoin() }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = when (result) {
                CoinSide.FIRST -> "Первая сторона"
                CoinSide.SECOND -> "Вторая сторона"
                CoinSide.EDGE -> "Ребро"
                null -> "Нажми на монету"
            },
            color = Color.White,
            fontSize = 20.sp
        )
    }
}