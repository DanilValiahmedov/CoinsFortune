package com.valimade.coinsfortune.domain.usecase

import com.valimade.coinsfortune.domain.model.Coin
import com.valimade.coinsfortune.domain.model.CoinResult
import com.valimade.coinsfortune.domain.model.CoinSide
import kotlin.random.Random

class TossCoinUseCase {

    operator fun invoke(coin: Coin): CoinResult {
        val random = Random.nextFloat()

        val side = when {
            random < coin.firstSideProbability -> CoinSide.FIRST
            random < coin.firstSideProbability + coin.secondSideProbability -> CoinSide.SECOND
            else -> CoinSide.EDGE
        }

        return when (side) {
            CoinSide.FIRST -> CoinResult(
                side = side,
                name = coin.firstSideName,
                image = coin.firstSideImage,
                hints = coin.firstSideHints
            )

            CoinSide.SECOND -> CoinResult(
                side = side,
                name = coin.secondSideName,
                image = coin.secondSideImage,
                hints = coin.secondSideHints
            )

            CoinSide.EDGE -> CoinResult(
                side = side,
                name = coin.edgeName,
                image = coin.edgeImage,
                hints = coin.edgeHints
            )
        }
    }

}