package chapter2

import chapter2.Color.*

// простой класс перечислений
enum class Colors1 {
    RED, YELLOW, ORANGE, GREEN, BLUE, INDIGO, VIOLET
}

// класс перечислений со свойствами
enum class Color(
    val r: Int, val g: Int, val b: Int      // Значения свойств определяются для каждой константы
) {
    RED(255, 0, 0),    // Объявление свойств констант перечислени
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);      // Точка с запятой здесь обязательна, если далее идёт какой-либо метод

    fun rgb() = (r * 256 + g) * 256 + b     // Определение метода класса перечисления
}

fun getMnemonic(color: Color) =
    when (color) {
        RED -> "каждый"
        ORANGE -> "охотник"
        YELLOW -> "желает"
        GREEN -> "знать"
        BLUE -> "где"
        INDIGO -> "сидит"
        VIOLET -> "фазан"
    }

fun getWarmth(color: Color) =
    when (color) {
        RED, ORANGE, YELLOW -> "тёплый"
        BLUE, INDIGO, VIOLET -> "холодный"
        GREEN -> "нейтральный"
    }

/* Использование различных объектов в ветках when
 В отличие от switch в Java, который требует использовать константы (константы перечисления, строки или
 числовые литералы) в определениях вариантов, оператор when позволяет использовать любые объекты*/
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(BLUE, YELLOW) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("грязный цвет")
    }

/* Выражение when без аргументов
 Достигается лучшая производительность по сравнению с предыдущей функцией, т.к. мы отказываемся от создания нескольких
 множеств Set. Стоит применять в том случае, если данная функция вызывается очень часто (избегаем лишнего мусора)*/
fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE    // условием выбора может стать любое логич. выраж.
        (c1 == BLUE && c2 == YELLOW) || (c1 == YELLOW && c2 == BLUE) -> GREEN
        (c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO
        else -> throw Exception("грязный цвет")
    }
