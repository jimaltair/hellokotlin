package kotlincode.chapter2

import java.io.BufferedReader

fun exceptionExample(percentage: Int) {
    if (percentage !in 0..100) {
        throw IllegalArgumentException("A percentage value must be between 0 and 100: $percentage")
    }
}

fun validateAndReturnPercentage(percentage: Int) =
    if (percentage in 0..100)
        percentage
    else
        throw IllegalArgumentException("A percentage value must be between 0 and 100: $percentage")

/**
 * Как и в Java, для обработки исключений используется выражение try с разделами catch и finally.
 * Но в отличии от Java, исключения, возбуждаемые функцией, не указываются - можно обрабатывать или не обрабатывать
 * любые исключения
 */
fun readNumber1(reader: BufferedReader): Int? {   // He требуется явно указывать, какое исключение может возбудить функция
    try {
        val number = reader.readLine()
        return Integer.parseInt(number)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

/**
 * Использование try в качестве выражения
 * Ключевое слово try в языке Kotlin наряду с if и when является выражением, значение которого можно присвоить переменной.
 * В отличие от if, тело выражения всегда нужно заключать в фигурные скобки. Как и в остальных случаях, если тело
 * содержит несколько выражений, итоговым результатом станет значение последнего выражения.
 */
fun readNumber2(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())     // получит значение выражения try
    } catch (e: NumberFormatException) {
        return      // прерываем выполнение функции
    }
    println(number)
}

fun readNumber3(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())     // если исключение не возникнет, будет возвращено это значение
    } catch (e: NumberFormatException) {
        null        // если исключение возникнет, будет возвращён null
    }
    println(number)
}

