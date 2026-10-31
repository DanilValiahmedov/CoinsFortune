package com.valimade.coinsfortune.ui.util

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import com.valimade.coinsfortune.ui.model.CoinPattern

fun DrawScope.drawCoinSymbol(
    pattern: CoinPattern,
    center: Offset,
    sizePx: Float,
    color: Color,
    strokeWidthPx: Float
) {
    val scale = sizePx / 100f

    withTransform({
        translate(
            left = center.x - sizePx / 2f,
            top = center.y - sizePx / 2f
        )
        scale(
            scaleX = scale,
            scaleY = scale,
            pivot = Offset.Zero
        )
    }) {
        val stroke = Stroke(
            width = strokeWidthPx / scale,
            cap = StrokeCap.Round,
            join = StrokeJoin.Round
        )

        when (pattern) {
            CoinPattern.QUESTION ->
                drawQuestion(color, stroke)

            CoinPattern.SCALES ->
                drawScales(color, stroke)

            CoinPattern.HORSESHOE ->
                drawHorseshoe(color, stroke)

            CoinPattern.HEART ->
                drawHeart(color, stroke)

            CoinPattern.YIN_YANG ->
                drawYinYang(color, stroke)

            CoinPattern.STOP ->
                drawStop(color, stroke)

            CoinPattern.SPIRAL ->
                drawSpiral(color, stroke)

            CoinPattern.LOCK ->
                drawLock(color, stroke)
        }
    }
}

private fun DrawScope.drawQuestion(
    color: Color,
    stroke: Stroke
) {
    val path = Path().apply {
        moveTo(29f, 34f)
        cubicTo(29f, 15f, 43f, 9f, 55f, 12f)
        cubicTo(73f, 15f, 79f, 31f, 68f, 46f)
        cubicTo(62f, 54f, 50f, 58f, 50f, 70f)
    }

    drawPath(path, color, style = stroke)
    drawCircle(color, radius = 3.5f, center = Offset(50f, 86f))
}

private fun DrawScope.drawScales(
    color: Color,
    stroke: Stroke
) {
    // Центральная стойка
    drawLine(color, Offset(50f, 15f), Offset(50f, 83f), stroke.width, stroke.cap)

    // Перекладина
    drawLine(color, Offset(20f, 28f), Offset(80f, 28f), stroke.width, stroke.cap)

    // Верхушка
    drawCircle(
        color,
        radius = 4f,
        center = Offset(50f, 18f),
        style = stroke
    )

    // Левая подвеска
    drawLine(color, Offset(28f, 28f), Offset(20f, 58f), stroke.width)
    drawLine(color, Offset(28f, 28f), Offset(36f, 58f), stroke.width)

    // Правая подвеска
    drawLine(color, Offset(72f, 28f), Offset(64f, 58f), stroke.width)
    drawLine(color, Offset(72f, 28f), Offset(80f, 58f), stroke.width)

    // Чаши
    val leftBowl = Path().apply {
        moveTo(15f, 58f)
        quadraticTo(28f, 78f, 41f, 58f)
    }

    val rightBowl = Path().apply {
        moveTo(59f, 58f)
        quadraticTo(72f, 78f, 85f, 58f)
    }

    drawPath(leftBowl, color, style = stroke)
    drawPath(rightBowl, color, style = stroke)

    // Основание
    drawLine(color, Offset(50f, 83f), Offset(32f, 89f), stroke.width)
    drawLine(color, Offset(50f, 83f), Offset(68f, 89f), stroke.width)
    drawLine(color, Offset(27f, 91f), Offset(73f, 91f), stroke.width)
}

private fun DrawScope.drawHorseshoe(
    color: Color,
    stroke: Stroke
) {
    withTransform({
        rotate(
            degrees = 180f,
            pivot = Offset(50f, 50f)
        )
    }) {
        val path = Path().apply {
            moveTo(27f, 16f)

            cubicTo(
                12f, 30f,
                20f, 67f,
                36f, 81f
            )

            cubicTo(
                43f, 88f,
                57f, 88f,
                64f, 81f
            )

            cubicTo(
                80f, 67f,
                88f, 30f,
                73f, 16f
            )
        }

        drawPath(path, color, style = stroke)

        val holes = listOf(
            Offset(26f, 31f),
            Offset(28f, 48f),
            Offset(35f, 66f),
            Offset(74f, 31f),
            Offset(72f, 48f),
            Offset(65f, 66f)
        )

        holes.forEach {
            drawCircle(
                color = color,
                radius = 2.5f,
                center = it,
                style = stroke
            )
        }
    }
}

private fun DrawScope.drawHeart(
    color: Color,
    stroke: Stroke
) {
    val path = Path().apply {
        moveTo(50f, 83f)
        cubicTo(41f, 74f, 12f, 51f, 12f, 32f)
        cubicTo(12f, 8f, 42f, 5f, 50f, 29f)
        cubicTo(58f, 5f, 88f, 8f, 88f, 32f)
        cubicTo(88f, 51f, 59f, 74f, 50f, 83f)
    }

    drawPath(path, color, style = stroke)
}

private fun DrawScope.drawYinYang(
    color: Color,
    stroke: Stroke
) {
    // Внешняя окружность
    drawCircle(
        color = color,
        radius = 43f,
        center = Offset(50f, 50f),
        style = stroke
    )

    // S-образная граница
    val path = Path().apply {
        moveTo(50f, 7f)

        cubicTo(
            100f, 7f,
            100f, 50f,
            50f, 50f
        )

        cubicTo(
            0f, 50f,
            0f, 93f,
            50f, 93f
        )
    }

    drawPath(path, color, style = stroke)

    // Верхняя точка
    drawCircle(
        color = color,
        radius = 5f,
        center = Offset(50f, 28.5f),
        style = stroke
    )

    // Нижняя точка
    drawCircle(
        color = color,
        radius = 5f,
        center = Offset(50f, 71.5f),
        style = stroke
    )
}

private fun DrawScope.drawStop(
    color: Color,
    stroke: Stroke
) {
    val path = Path().apply {
        moveTo(35f, 10f)
        lineTo(65f, 10f)
        lineTo(90f, 35f)
        lineTo(90f, 65f)
        lineTo(65f, 90f)
        lineTo(35f, 90f)
        lineTo(10f, 65f)
        lineTo(10f, 35f)
        close()
    }

    drawPath(path, color, style = stroke)
}

private fun DrawScope.drawSpiral(
    color: Color,
    stroke: Stroke
) {
    val path = Path()
    val centerX = 50f
    val centerY = 50f

    val turns = 2.5f
    val maxAngle = turns * 2f * PI.toFloat()

    val points = 180

    for (i in 0..points) {
        val progress = i.toFloat() / points
        val angle = progress * maxAngle
        val radius = 3f + progress * 39f

        val x = centerX + cos(angle) * radius
        val y = centerY + sin(angle) * radius

        if (i == 0) {
            path.moveTo(x, y)
        } else {
            path.lineTo(x, y)
        }
    }

    drawPath(path, color, style = stroke)
}

private fun DrawScope.drawLock(
    color: Color,
    stroke: Stroke
) {
    // Дужка
    val shackle = Path().apply {
        moveTo(30f, 45f)
        lineTo(30f, 32f)
        cubicTo(30f, 5f, 70f, 5f, 70f, 32f)
        lineTo(70f, 45f)
    }

    drawPath(shackle, color, style = stroke)

    // Корпус замка
    drawRoundRect(
        color = color,
        topLeft = Offset(17f, 42f),
        size = Size(66f, 48f),
        cornerRadius = androidx.compose.ui.geometry.CornerRadius(7f),
        style = stroke
    )

    // Замочная скважина
    drawCircle(
        color = color,
        radius = 4f,
        center = Offset(50f, 58f)
    )

    drawLine(
        color = color,
        start = Offset(50f, 61f),
        end = Offset(50f, 73f),
        strokeWidth = stroke.width,
        cap = stroke.cap
    )
}