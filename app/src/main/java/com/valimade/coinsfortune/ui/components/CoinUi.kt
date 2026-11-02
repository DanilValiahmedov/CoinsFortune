package com.valimade.coinsfortune.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun CoinUi(
    diameter: Dp,
    description: String,
    image: Int,
    rotationY: Float,
    onClick: () -> Unit
) {
    val density = LocalDensity.current.density

    Image(
        painter = painterResource(image),
        contentDescription = description,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(diameter)
            .graphicsLayer {
                this.rotationY = rotationY
                cameraDistance = 12f * density
                scaleX = if (rotationY % 360f in 90f..270f) -1f else 1f
            }
            .clickable(onClick = onClick)
    )
}
