package com.valimade.coinsfortune.data.store

import com.valimade.coinsfortune.R
import com.valimade.coinsfortune.domain.model.Coin
import com.valimade.coinsfortune.ui.model.CoinPattern

object CoinsStore {

    val generalHints = listOf(
        "Так решила судьба",
        "Монета сделала свой выбор",
        "Вселенная подала знак",
        "Ответ получен",
        "Таков знак свыше",
        "Больше не нужно гадать",
        "Такова воля случая",
        "Теперь ты знаешь",
        "Случай сделал свой ход",
        "Знак получен",
        "Судьба расставила всё по местам",
        "Сегодня всё решилось",
        "Монета вынесла свой вердикт",
        "Вселенная дала ответ",
        "Пусть этот знак станет подсказкой",
        "Ответ найден",
        "Момент истины настал",
        "Таков итог этого броска",
        "Судьба сделала свой выбор",
        "Один бросок — один ответ",
        "Похоже, это не случайность",
        "Прими этот знак",
        "Пусть этот ответ станет началом",
        "Значит, так тому и быть",
        "Знаки говорят сами за себя",
        "Вселенная услышала твой вопрос",
        "Ответ оказался ближе, чем ты думал",
        "Иногда достаточно одного знака",
        "Монета сказала своё слово",
        "Судьба не заставила себя ждать",
        "Вот и прояснилась ситуация",
        "Один вопрос — один ответ",
        "Пусть случай рассудит",
        "Кажется, всё встало на свои места",
        "Пришло время принять ответ",
        "Значит, таков сегодняшний знак",
        "Случай поставил точку",
        "Ответ уже перед тобой"
    )

    val edgeHints = listOf(
        "Всё в твоих руках",
        "Судьба оставляет выбор за тобой",
        "На этот раз решать тебе",
        "Даже судьба не знает ответа",
        "Сложный вопрос для судьбы",
        "Похоже, одного броска недостаточно",
        "Сегодня случай не готов вмешиваться",
        "Иногда отсутствие ответа — тоже ответ",
        "Судьба взяла паузу",
        "Монета решила остаться нейтральной",
        "Похоже, ты задал слишком сложный вопрос",
        "Попробуй прислушаться к себе",
        "Решение ещё не созрело",
        "Возможно, стоит попробовать ещё раз",
        "Монета оставила последнее слово за тобой"
    )

    val positive = listOf(
        "Звёзды на твоей стороне",
        "Всё складывается как нельзя лучше",
        "Сегодня твой день",
        "Мир сегодня благосклонен к тебе",
        "Впереди что-то хорошее",
        "Сегодня звёзды благосклонны",
        "Сегодня всё на твоей стороне",
        "Лови момент!"
    )

    val negative = listOf(
        "Не всё складывается так, как хотелось бы",
        "Сейчас не лучшее время",
        "Похоже, придётся подождать",
        "Сегодня звёзды не на твоей стороне",
        "Не стоит торопить события",
        "Не каждый знак бывает благоприятным"
    )

    val coins = listOf(
        Coin(
            name = "Монета выбора",
            background = CoinPattern.QUESTION,
            firstSideName = "ДА",
            firstSideImage = R.drawable.coin_yes,
            firstSideProbability = 48f,
            firstSideHints = generalHints + listOf("Судьба говорит — да!"),
            secondSideName = "НЕТ",
            secondSideImage = R.drawable.coin_no,
            secondSideProbability = 48f,
            secondSideHints = generalHints + listOf("Сегодня ответ — нет"),
            edgeName = "РЕБРО",
            edgeImage = R.drawable.coin_edge,
            edgeProbability = 4f,
            edgeHints = edgeHints + listOf("Ни да, ни нет")
        ),

        Coin(
            name = "Монета истины",
            background = CoinPattern.SCALES,
            firstSideName = "ПРАВДА",
            firstSideImage = R.drawable.coin_true,
            firstSideProbability = 48f,
            firstSideHints = generalHints + listOf(
                "Правда всегда находит дорогу",
                "Истина раскрыта",
            ),
            secondSideName = "ЛОЖЬ",
            secondSideImage = R.drawable.coin_false,
            secondSideProbability = 48f,
            secondSideHints = generalHints + listOf(
                "Не всё является тем, чем кажется",
                "Не спеши верить всему услышанному",
                "За красивыми словами может скрываться обман",
                "Истина раскрыта",
            ),
            edgeName = "РЕБРО",
            edgeImage = R.drawable.coin_edge,
            edgeProbability = 4f,
            edgeHints = edgeHints + listOf(
                "Истина где-то посередине",
                "Не всё можно разделить на чёрное и белое"
            )
        ),

        Coin(
            name = "Монета случая",
            background = CoinPattern.HORSESHOE,
            firstSideName = "УДАЧА",
            firstSideImage = R.drawable.coin_luck,
            firstSideProbability = 56f,
            firstSideHints = generalHints + positive + listOf(
                "Сегодня тебе сопутствует удача!",
                "Удача на твоей стороне!",
                "Удача выбрала тебя",
            ),
            secondSideName = "ПРОВАЛ",
            secondSideImage = R.drawable.coin_fail,
            secondSideProbability = 40f,
            secondSideHints = generalHints + negative + listOf(
                "Сегодня удача отвернулась",
                "Неудача — тоже часть пути",
                "Сегодня не твой день",
            ),

            edgeName = "РЕБРО",
            edgeImage = R.drawable.coin_edge,
            edgeProbability = 4f,
            edgeHints = edgeHints + listOf(
                "Удачу можно создать самому",
                "Сегодня без победителей и проигравших",
                "Случай оказался нейтральным",
            )
        ),

        Coin(
            name = "Монета чувств",
            background = CoinPattern.HEART,
            firstSideName = "ЛЮБОВЬ",
            firstSideImage = R.drawable.coin_love,
            firstSideProbability = 54f,
            firstSideHints = generalHints + positive + listOf(
                "Следуй за своим сердцем",
                "Любовь найдёт дорогу",
                "Чувства не обманывают"
            ),
            secondSideName = "НЕНАВИСТЬ",
            secondSideImage = R.drawable.coin_hate,
            secondSideProbability = 42f,
            secondSideHints = generalHints + negative + listOf(
                "Не позволяй эмоциям управлять тобой",
                "Не каждое чувство стоит принимать всерьёз"
            ),

            edgeName = "РЕБРО",
            edgeImage = R.drawable.coin_edge,
            edgeProbability = 4f,
            edgeHints = edgeHints + listOf(
                "Между любовью и ненавистью тонкая грань",
                "Сердце ещё не определилось"
            )
        ),

        Coin(
            name = "Монета баланса",
            background = CoinPattern.YIN_YANG,
            firstSideName = "СЕРДЦЕ",
            firstSideImage = R.drawable.coin_heart,
            firstSideProbability = 50f,
            firstSideHints = generalHints + listOf(
                "Прислушайся к сердцу",
                "Иногда чувства важнее расчётов",
                "Выбирай то, что делает тебя счастливым"
            ),
            secondSideName = "РАЗУМ",
            secondSideImage = R.drawable.coin_mind,
            secondSideProbability = 46f,
            secondSideHints = generalHints + listOf(
                "Не теряй голову",
                "Взвесь все за и против",
                "Разум подскажет верный путь"
            ),
            edgeName = "РЕБРО",
            edgeImage = R.drawable.coin_edge,
            edgeProbability = 4f,
            edgeHints = edgeHints + listOf(
                "Найди баланс между сердцем и разумом",
                "Не торопись с выбором",
                "Истина между двумя решениями"
            )
        ),

        Coin(
            name = "Монета пути",
            background = CoinPattern.STOP,
            firstSideName = "ИДИ",
            firstSideImage = R.drawable.coin_go,
            firstSideProbability = 52f,
            firstSideHints = generalHints + listOf(
                "Не бойся сделать первый шаг",
                "Дорогу осилит идущий",
                "Время действовать!",
                "Не упусти подходящий момент"
            ),
            secondSideName = "СТОЙ",
            secondSideImage = R.drawable.coin_stop,
            secondSideProbability = 44f,
            secondSideHints = generalHints + listOf(
                "Остановись и подумай",
                "Иногда пауза — лучший выбор",
                "Не торопи события"
            ),

            edgeName = "РЕБРО",
            edgeImage = R.drawable.coin_edge,
            edgeProbability = 4f,
            edgeHints = edgeHints + listOf(
                "Выбери собственный путь",
                "Перекрёсток требует решения",
                "Судьба ждёт твоего шага"
            )
        ),

        Coin(
            name = "Монета времени",
            background = CoinPattern.SPIRAL,
            firstSideName = "СЕЙЧАС",
            firstSideImage = R.drawable.coin_now,
            firstSideProbability = 52f,
            firstSideHints = generalHints + listOf(
                "Не упусти подходящий момент",
                "Лучшего момента не будет",
                "Не откладывай на завтра",
                "Действуй прямо сейчас!"
            ),
            secondSideName = "ПОТОМ",
            secondSideImage = R.drawable.coin_after,
            secondSideProbability = 44f,
            secondSideHints = generalHints + listOf(
                "Всему своё время",
                "Возможно, спешить не стоит",
                "Не торопись, время ещё есть",
                "Завтра будет новый день"
            ),
            edgeName = "РЕБРО",
            edgeImage = R.drawable.coin_edge,
            edgeProbability = 4f,
            edgeHints = edgeHints + listOf(
                "Время покажет",
                "Будущее ещё не определено",
            )
        ),

        Coin(
            name = "Монета решения",
            background = CoinPattern.LOCK,
            firstSideName = "ПРИНЯТЬ",
            firstSideImage = R.drawable.coin_accept,
            firstSideProbability = 54f,
            firstSideHints = generalHints + listOf(
                "Прими этот шанс",
                "Иногда нужно сказать «да»",
                "Не упускай возможность"
            ),
            secondSideName = "ОТКАЗАТЬСЯ",
            secondSideImage = R.drawable.coin_refuse,
            secondSideProbability = 42f,
            secondSideHints = generalHints + listOf(
                "Не бойся сказать «нет»",
                "Отказ — тоже решение",
                "Не бери на себя лишнего"
            ),
            edgeName = "РЕБРО",
            edgeImage = R.drawable.coin_edge,
            edgeProbability = 4f,
            edgeHints = edgeHints + listOf(
                "Ни согласия, ни отказа",
                "Взвесь все последствия",
                "Решение пока не принято"
            )
        )
    )
}
