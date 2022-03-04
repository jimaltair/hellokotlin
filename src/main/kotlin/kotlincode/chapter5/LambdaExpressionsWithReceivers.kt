package kotlincode.chapter5

import javax.naming.Context

/**
 * В Kotlin есть уникальная особенность, недоступная в Java: возможность вызова методов другого объекта в теле
 * лямбда-выражений без дополнительных квалификаторов. Такие конструкции называются "лямбда-выражениями с получателями".
 */

/**
 * Генерация алфавита
 */
fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

/**
 * Использование функции with для генерации алфавита
 */
fun alphabet1(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {                // определяется получатель, методы которого буду вызываться
        for (letter in 'A'..'Z') {
            this.append(letter)                 // вызов метода получателя с помощью ссылки "this"
        }
        append("\nNow I know the alphabet!")    // вызов метода без ссылки "this"
        this.toString()                         // возврат значения из лямбда-выражения
    }
}
/**
 * Структура with выглядит как особая конструкция, но это лишь функция, которая принимает два аргумента - в данном
 * случае объект stringBuilder и лямбда-выражение. Здесь используется соглашение о передаче лямбда-выражения за
 * круглыми скобками, поэтому весь вызов выглядит как встроенная конструкция языка. То же самое можно было бы
 * записать как with(stringBuilder, {...}), но такой код труднее читать.
 */

/**
 * Применение функции with и тела-выражения для генерации алфавита
 */
fun alphabet2() = with(StringBuilder()) {
    for (letter in 'A'..'Z') append(letter)
    append("\nNow I know the alphabet!")
    toString()
}
/**
 * Теперь эта функция возвращает только выражение, поэтому она была переписана с использованием синтаксиса
 * тела-выражения. Мы создали новый экземпляр StringBuilder и напрямую передали его в аргументе, а теперь
 * используем его без явной ссылки this внутри лямбда-выражения.
 */

/**
 * Использование функции "apply" для генерации алфавита.
 * Функция "apply" работает почти так же, как "with" - разница лишь в том, что "apply" всегда возвращает объект,
 * переданный в аргументе (другими словами, объект-получатель).
 */
fun alphabet3() = StringBuilder().apply {
    for (letter in 'A'..'Z') append(letter)
    append("\nNow I know the alphabet!")
}.toString()

/**
 * Применение функции apply для инициализации экземпляра TextView
 */
/*
fun createViewWithCustomAttributes(context: Context) =
    TextView(context).apply {
        text = "Sample Text"
        textSize = 20.0
        setPadding(10, 0, 0, 0)
    }
*/
/**
 * Один из многих случаев, где это может пригодиться - создание экземпляра, у которого нужно сразу инициализировать
 * некоторые свойства. В Java это обычно выполняется с помощью отдельного объекта Builder, а в Kotlin можно использовать
 * функцию apply с любым объектом без какой-либо специальной поддержки со стороны библиотеки, где этот объект определен.
 */

/**
 * Использование функции buildString для генерации алфавита.
 * Например, функцию append можно упростить с помощью стандартной библиотечной функции buildString, которая позаботится
 * о создании экземпляра StringBuilder и вызовет метод toString. Она ожидает получить лямбда-выражение с получателем,
 * а получателем всегда будет экземпляр StringBuilder.
 */
fun alphabet4() = buildString {
    for(letter in 'A'..'Z') append(letter)
    append("\nNow I know the alphabet!")
}
