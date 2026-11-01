package com.valimade.coinsfortune.domain.model

import androidx.annotation.DrawableRes

data class Coin(
    val name: String,

    val firstSideName: String,
    @DrawableRes val firstSideImage: Int,
    val firstSideProbability: Float,
    val firstSideHints: List<String>,

    val secondSideName: String,
    @DrawableRes val secondSideImage: Int,
    val secondSideProbability: Float,
    val secondSideHints: List<String>,

    val edgeName: String,
    @DrawableRes val edgeImage: Int,
    val edgeProbability: Float,
    val edgeHints: List<String>
)