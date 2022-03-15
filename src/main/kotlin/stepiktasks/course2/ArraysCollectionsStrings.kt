package stepiktasks.course2

import java.util.*
import kotlin.collections.ArrayList

/**
 * Необходимо разработать программу для поиска среднего и медианного значений списка действительных чисел со знаком,
 * подаваемого на вход программы. Медианным значением считается такое число выборки, что ровно половина из элементов
 * выборки больше него, а другая половина меньше него. Если в выборке чётное число элементов, медиана вычисляется как
 * полусумма двух центральных элементов в упорядоченной выборке.
 *
 * Вход: список с n элементами.
 *
 * Выход: два значения (среднее, медиана)
 *
 * Sample Input 1:
 * 1.0 2.0 3.0 4.0
 *
 * Sample Output 1:
 * 2.5 2.5
 *
 * Sample Input 2:
 * 1.5 2.5 3.5 5.5
 *
 * Sample Output 2:
 * 3.25 3.0
 */
//fun main(args: Array<String>) {
//    val input = readLine()!!
//        .split(" ")
//        .map { it.toDouble() }
//        .sorted()
//
//    val average = input.average()
//
//    val size = input.size
//    val median = when {
//        size % 2 == 0 -> (input[size / 2 - 1] + input[size / 2]) / 2
//        else -> input[size / 2]
//    }
//    println("$average $median")
//}

/**
 * Вам надо написать функцию для удаления повторных регистраций от пользователей с одинаковыми именами.
 */
fun deleteCopies(inputList: List<String>): List<String> {
    return inputList.distinct()
}

/**
 * На вход функции подаётся список фамилий учеников (могут быть на русском, английском языках). Программа должна
 * возвращать список, каждый элемент которого содержит фамилии учеников, начинающиеся с одной и той же буквы.
 *
 * Sample Input:
 * Smith Jones Bambury Patel Brown Singh Williams Taylor Wilson Davies Evans Scott
 *
 * Sample Output:
 * Bambury Brown
 * Davies
 * Evans
 * Jones
 * Patel
 * Scott Singh Smith
 * Taylor
 * Williams Wilson
 */
//fun main(args: Array<String>){
//    val inputList = readLine()!!.split(" ")
//    val sortedLists = sortLists(inputList)
//    for (list in sortedLists){
//        for (string in list) {
//            print("$string ")
//        }
//        println()
//    }
//}

fun sortLists(inputList: List<String>): MutableList<MutableList<String>> {
    return inputList
        .groupBy { it.first() }
        .values
        .map { it.toMutableList().apply { sort() } }
        .toMutableList().apply { sortBy { it.first().first() } }
}

/**
 * На вход программа получается документ, представленный строкой, а также строку для поиска. На выход программа выдаёт
 * все вхождения строки для поиска в документ (индексы начального символа вхождения по возрастанию). Заметим, что
 * предполагается, что вхождения не могут пресекаться (т.е. в случае поиска строки "абракадабра" в документе
 * "абракадабрабракадабра" будет обозначено только одно вхождение, первое слева).
 *
 * Sample Input:
 * абракадабрабракадабра абракадабра
 *
 * Sample Output:
 * 0
 */
fun main(args: Array<String>) {
    val input = readLine()
    val text = input!!.split(" ").get(0)
    val substring = input.split(" ").get(1)
    println(findSubstrings(text, substring))
}

fun findSubstrings(text: String, substring: String): MutableList<Int> {
    val result = ArrayList<Int>(0)
    // TODO: находит только первое вхождение, а нужно все
    if (text.contains(substring)) {
        result.add(text.indexOf(substring))
    }
    return result
}