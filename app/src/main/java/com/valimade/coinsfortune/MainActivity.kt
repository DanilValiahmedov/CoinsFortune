package com.valimade.coinsfortune

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.valimade.coinsfortune.ui.model.CoinPattern
import com.valimade.coinsfortune.ui.util.CoinPatternBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinPatternBackground(
                pattern = CoinPattern.LOCK,
                symbolAlpha = 0.20f,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
