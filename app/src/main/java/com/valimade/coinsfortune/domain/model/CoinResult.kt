package com.valimade.coinsfortune.domain.model

data class CoinResult(
    val side: CoinSide,
    val name: String,
    val image: Int,
    val hints: List<String>
)