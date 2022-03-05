package chapter3

/**
 * Функция-расширение. Может вызываться как член класса, но определена за его пределами
 * В отличие от методов, объявленных в классе, функции-расширения не имеют доступа к закрытым или защищенным членам класса.
 */
fun String.lastChar(): Char = this.get(this.length - 1)     // this можно опустить

/**
 * Теперь joinToString можно вызывать как обычный член класса Collection<T>
 */
fun <T> Collection<T>.joinToString(     // объявление функции-расширения для типа Collection<T>
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {    // «this» ссылается на обьект-приемник: коллекцию элементов типа T
        if (index > 0)
            result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

/**
 * В качестве типа-применика можно указывать не просто класс, а более конкретный тип, к примеру Collection<String>.
 * В таком случае если вызвать эту функцию для списка объектов другого типа, код не скомпилируется
 */
fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)

/**
 * Функции-расширения не переопределяются: Kotlin определяет их статически.
 * Для вызова метода showOff переменной типа View компилятор выберет соответствующее расширение, руководствуясь типом,
 * указанным в объявлении переменной, даже если фактическое значение имеет тип Button.
 */
open class View {
    open fun click() = println("View clicked")
}
fun View.showOff() = println("I'm a view")


class Button: View() {                                  // класс Button наследует View
    override fun click() = println("Button clicked")
}
fun Button.showOff() = println("I'm a button")

/**
 * Примечание. Если класс имеет метод с той же сигнатурой, как у функции-расширения, приоритет всегда будет отдаваться
 * методу. Имейте это в виду, расширяя API классов: если вы добавите в класс метод с такой же сигнатурой, как у
 * функции-расширения, которую определил клиент вашего класса, то после перекомпиляции код клиента изменит свою семантику
 * и начнет ссылаться на новый метод класса.
 */
