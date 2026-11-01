package com.valimade.coinsfortune.ui.model

import androidx.compose.ui.graphics.Color

enum class CoinPattern(val color: Color) {
    QUESTION(Color(0xFF4CAF50)), // Монета выбора — Знак вопроса — Зелёный
    SCALES(Color(0xFFFFC107)), //  Монета истины — Весы правосудия — Золотистый
    HORSESHOE(Color(0xFFBFC5CC)), // Монета случая — Подкова — Серебристый
    HEART(Color(0xFFE879B9)), // Монета чувств — Сердце — Розовый
    YIN_YANG(Color(0xFFFFFFFF)), // Монета баланса — Инь-ян — Белый
    STOP(Color(0xFFE53935)), // Монета пути — Восьмиуголник — Красный
    SPIRAL(Color(0xFF4285F4)), // Монета времени — Спираль — Синий
    LOCK(Color(0xFFFF9800)), // Монета решения — Замок — Оранжевый
}
