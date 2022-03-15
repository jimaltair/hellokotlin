package stepiktasks

import chapter3.joinToString
import java.math.BigInteger

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
            if (i != line) print(".")
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
    foo("a"), foo("b", number = 1), foo("c", toUpperCase = true), foo(name = "d", number = 2, toUpperCase = true)
)

/**
 * Написать элементарную программу кодирования строки. Каждый символ кодируется своим обозначением и количеством
 * повторений. Например, для строки «aaaaaabbbbbaccccddeeeee» результатом кодирования будет строка «a6b5a1c4d2e5».
 */
//fun main(args: Array<String>) {
//    val str = readLine()!!
//    encodeStringJavaStyle(str)
//    encodeStringKotlinStyle(str)
//}

fun encodeStringJavaStyle(str: String) {
    val sb = StringBuilder()
    var charCounter = 0
    var currentChar: Char? = null
    for ((index, char) in str.toCharArray().withIndex()) {
        if (index == 0) {
            currentChar = char
            charCounter++
        }
        if (index in 1 until str.length - 1) {
            if (char == currentChar) {
                charCounter++
            } else {
                sb.append(currentChar).append(charCounter)
                currentChar = char
                charCounter = 1
            }
        }
        if (index == str.length - 1) {
            if (char == currentChar) {
                charCounter++
                sb.append(char).append(charCounter)
            } else {
                sb.append(currentChar).append(charCounter)
                sb.append(char).append(1)
            }
        }
    }
    println(sb.toString())
}

fun encodeStringKotlinStyle(str: String) {
    var charCounter = 0
    var currentChar = str.first()
    for (char in str) {
        if (char != currentChar) {
            print("$currentChar$charCounter")
            charCounter = 0
        }
        currentChar = char
        charCounter++
    }
    print("$currentChar$charCounter")
}

/**
 * Интеллектуальная среда разработки IntelliJ IDEA умеет конвертировать Java-код в Kotlin-код.
 * Ваша задача состоит в том, чтобы конвертировать функцию toJSON в Kotlin-код:
 */
/*
public class JavaCode {
    public String toJSON(Collection<Integer> collection) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            sb.append(element);
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
 */
class JavaCode {
    fun toJSON(collection: Collection<Int?>): String {
        val sb = StringBuilder()
        sb.append("[")
        val iterator = collection.iterator()
        while (iterator.hasNext()) {
            val element = iterator.next()
            sb.append(element)
            if (iterator.hasNext()) {
                sb.append(", ")
            }
        }
        sb.append("]")
        collection.joinToString()
        return sb.toString()
    }
}

/**
 * Даны 111 беззнаковых целых, каждое из которых состоит из 47 цифр (см. пример ниже).
 * Необходимо вывести первые 9 цифр их суммы. В данной задаче не предполагает использование коллекций.
 *
 * Input:
 * 13273269708705650734211312160963364392368945816
 * 64361863847308796002886528604013323768035602644
 * 60587804274606460837016609279605443939335348830
 * ...
 * 39921573434927647476246337094832271637540776910
 *
 * Output: 599603249
 */
//fun main(args: Array<String>) {
//    var sum = BigInteger.ZERO
//    while (true) {
//        val str = readLine()
//        if (str == "" || str == null)
//            break
//        sum += str.toBigInteger()
//    }
//    println(sum.toString().take(9))
//}

/**
 * Реализовать функцию для перевода числа, заданного в двоичной системе счисления в шестнадцатеричную.
 *
 * Input:
 * 101010111100
 *
 * Output:
 * ABC
 */
//fun main(args: Array<String>) {
//    val intNum = Integer.parseInt(readLine(), 2)
//    val hexNum = Integer.toHexString(intNum)
//    println(hexNum.uppercase())
//}
