package stepiktasks

import java.util.Arrays
import java.util.function.BiFunction

/**
 * Реализовать сортировку пузырьком (или другим более увлекательным способом), дополнив функцию bubbleSort.
 */
fun bubbleSort(inputList: List<String>): IntArray {
    var array = inputList.map { it.toInt() }.toIntArray()

    var isSorted = false

    while (!isSorted) {
        isSorted = true
        for (i in 0 until array.size - 1) {
            if (array[i] > array[i + 1]) {
                val temp = array[i + 1]
                array[i + 1] = array[i]
                array[i] = temp
                isSorted = false
            }
        }
    }
    return array
}

fun testBubbleSort() {
    val sample1 = listOf("5", "4", "3", "2", "1", "6", "7", "8", "9", "10")
    val sample2 = listOf("5", "4", "3", "2", "1", "6", "7", "2", "8", "9", "2", "10")
    println(bubbleSort(sample1).contentToString())
    println(bubbleSort(sample2).contentToString())
}

/**
 * Вывести треугольник Паскаля до n-ой строки включительно.
 */
fun pascalTriangle(rows: Int) {
    for (line in 1..rows) {
        var c = 1
        for (i in 1..line) {
            print("$c")
            if (i != line)
                print(".")
            c = c * (line - i) / i
        }
        println()
    }
}

fun testPascalTriangle() {
    pascalTriangle(5)
}

/**
 * Дан следующий Java-код, в котором  foo()  имеет несколько перегрузок:
 */
/*
public String foo(String name, int number, boolean toUpperCase) {
    return (toUpperCase ? name.toUpperCase() : name) + number;
}
public String foo(String name, int number) {
    return foo(name, number, false);
}
public String foo(String name, boolean toUpperCase) {
    return foo(name, 42, toUpperCase);
}
public String foo(String name) {
    return foo(name, 42);
}
 */
/**
 * В Kotlin аналогичное поведение можно реализовать с помощью одной функции с аргументами по умолчанию.
 * Необходимо поменять объявление функции foo так, чтобы код ниже был успешно собран компилятором. При этом надо
 * использовать именованные аргументы и аргументы по умолчанию.
 */
fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) =
    (if (toUpperCase) name.toUpperCase() else name) + number

fun useFoo() = listOf(
    foo("a"),
    foo("b", number = 1),
    foo("c", toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)

/**
 * Написать элементарную программу кодирования строки. Каждый символ кодируется своим обозначением и количеством
 * повторений. Например, для строки «aaaaaabbbbbaccccddeeeee» результатом кодирования будет строка «a6b5a1c4d2e5».
 */
fun main(args: Array<String>) {
    val str = readLine()!!
    val sb = StringBuilder()
    var charCounter = 0
    var currentChar: Char? = null
    for ((index, char) in str.toCharArray().withIndex()) {
        if (index < str.length - 1) {
            if (currentChar == null) {
                currentChar = char
                charCounter++
            } else if (char == currentChar) {
                charCounter++
            } else {
                sb.append(currentChar).append(charCounter)
                currentChar = char
                charCounter = 1
            }
        } else {
            if (char == currentChar) {
                charCounter++
                sb.append(char).append(charCounter)
            } else {
                sb.append(char).append(1)
            }
        }
    }
    println(sb)
}
