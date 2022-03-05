package chapter5

import java.awt.Button

/**
 * Использование параметров функции в лямбда-выражении
 */
fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    // Принимает в качестве аргумента лямбда-выражение, определяющее, что делать с каждым элементом
    messages.forEach {
        println("$prefix $it")
    }
}

/**
 * Изменение локальных переменных внутри лямбда-выражения.
 * Kotlin, в отличие от Java, позволяет обращаться к обычным, не финальным переменным (без модификатора final)
 * и даже изменять их внутри лямбда-выражения.
 */
fun printProblemCounts(responses: Collection<String>) {
    var clientsErrors = 0               // объявление переменных, к которым будет обращаться лямбда-выражение
    var serverErrors = 0
    responses.forEach {
        if (it.startsWith("4"))
            clientsErrors++             // изменение переменной внутри лямбда-выражения
        else if (it.startsWith("5"))
            serverErrors++
    }
    println("Client errors: $clientsErrors, server errors: $serverErrors")
}

/**
 * Важно отметить, что если лямбда-выражение используется в качестве обработчика событий или просто выполняется асинхронно,
 * модификация локальных переменных произойдет только при выполнении лямбда-выражения. Например, следующий код
 * демонстрирует неправильный способ подсчета нажатий кнопки:
 */
/*
fun tryToCountButtonClicks(button: Button): Int {
    var clicks = 0
    button.onClick { clicks++ }
    return clicks                   // Эта функция всегда вернёт 0!
}
*/
/**
 * Для правильной работы количество нажатий необходимо сохранять не в локальную переменную, а в месте,
 * доступном за пределами функции - например, в свойстве класса.
 */
var counter = 0
val inc = { counter++ }