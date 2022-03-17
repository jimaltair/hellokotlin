package stepiktasks.course2

import kotlin.math.roundToInt


/**
 * Необходимо разработать программу, получающую по целому число минут приблизительное значение в часах и днях.
 * 30 минут округляется до часа наверх, 24 часа это 1 день.
 *
 * Sample Input 1:
 * 60
 *
 * Sample Output 1:
 * days: 0
 * hours: 1
 *
 * Sample Input 2:
 * 90
 *
 * Sample Output 2:
 * days: 0
 * hours: 2
 *
 * Sample Input 3:
 * 1410
 *
 * Sample Output 3:
 * days: 1
 * hours: 0
 */
//fun main(args: Array<String>) {
//    val input = Integer.parseInt(readLine())
//    val myDate = convertMinutesToDays(input)
//    println("days: ${myDate.first}")
//    println("hours: ${myDate.second}")
//}

fun convertMinutesToDays(minutes: Int): Pair<Int, Int> {
    val hours = (minutes / 60.0).roundToInt()
    val days = (hours / 24.0).roundToInt()
    return Pair(days, hours % 24)
}

/**
 * Разработать программу, разбивающую целое число на цифры.
 *
 * Sample Input:
 * 123456789
 *
 * Sample Output:
 * 1 2 3 4 5 6 7 8 9
 */
//fun main(args: Array<String>) {
//    readLine()!!
//        .toCharArray()
//        .map { it.toString() }
//        .forEach { print("$it ") }
//}

/**
 * Разработать программу для перевода скорости танкера, данной в узлах (морских милях в час), в стандартные единицы
 * измерения (км/час). Международная морская миля равна ровно 1852 метрам. Точность до третьего знака после запятой.
 *
 * Sample Input:
 * 1
 *
 * Sample Output:
 * 1.852
 */
//fun main(args: Array<String>) {
//    println(Integer.parseInt(readLine()) * 1.852)
//}

/**
 * Реализовать простой калькулятор для выражений с операциями сложения, вычитания, умножения над целыми числами
 * возвращающий результат вычислений.
 *
 * Sample Input 1:
 * 2 + 2
 *
 * Sample Output 1:
 * 4
 *
 * Sample Input 2:
 * 4 + 1 * 2 - 2
 *
 * Sample Output 2:
 * 4
 *
 * Sample Input 3:
 * -1 + 1
 *
 * Sample Output 3:
 * 0
 */
//fun main(args: Array<String>) {
//}
