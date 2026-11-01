package com.valimade.coinsfortune.domain.model

import com.valimade.coinsfortune.ui.model.CoinPattern

data class Coin(
    val name: String,
    val background: CoinPattern,

    val firstSideName: String,
    val firstSideImage: Int,
    val firstSideProbability: Float,
    val firstSideHints: List<String>,

    val secondSideName: String,
    val secondSideImage: Int,
    val secondSideProbability: Float,
    val secondSideHints: List<String>,

    val edgeName: String,
    val edgeImage: Int,
    val edgeProbability: Float,
    val edgeHints: List<String>
)