package com.valimade.coinsfortune.ui.util

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.valimade.coinsfortune.ui.model.CoinPattern

@Composable
fun CoinPatternBackground(
    pattern: CoinPattern,
    modifier: Modifier = Modifier,
    symbolAlpha: Float = 0.20f,
    symbolSize: Dp = 20.dp,
    spacing: Dp = 76.dp
) {
    Canvas(modifier = modifier.fillMaxSize()) {

        drawRect(Color.Black)

        val symbolSizePx = symbolSize.toPx()
        val spacingPx = spacing.toPx()

        val color = pattern.color.copy(
            alpha = pattern.color.alpha * symbolAlpha
        )

        val strokeWidth = 1.5.dp.toPx()

        // Запас для символов за границами экрана
        val rowStart = -2
        val rowEnd = (size.height / spacingPx).toInt() + 3

        for (row in rowStart..rowEnd) {

            // Смещение текущей строки
            val rowOffset = row * spacingPx * 0.5f

            // Рассчитываем колонки именно для этой строки
            val columnStart = (
                    (-symbolSizePx - rowOffset) / spacingPx
                    ).toInt() - 2

            val columnEnd = (
                    (size.width + symbolSizePx - rowOffset) / spacingPx
                    ).toInt() + 2

            for (column in columnStart..columnEnd) {

                val center = Offset(
                    x = column * spacingPx + rowOffset,
                    y = row * spacingPx
                )

                drawCoinSymbol(
                    pattern = pattern,
                    center = center,
                    sizePx = symbolSizePx,
                    color = color,
                    strokeWidthPx = strokeWidth
                )
            }
        }
    }
}