package kotlincode

/**
 * Проверка вхождения в диапазон с помощью in
 */
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'      // Преобразуется в а <= с && с <= z
fun isNotDigit(c: Char) = c !in '0'..'9'

/**
 * Использование проверки in в ветках when
 */
fun recognize(c: Char) =
    when (c) {
        in '0'..'9' -> "It's a digit!"
        in 'a'..'z', in 'A'..'Z' -> "It's a letter!"        // Можно совместить несколько диапазонов
        else -> "I don't know..."
    }

/**
 * Если есть класс, который поддерживает сравнение экземпляров (за счет реализации интерфейса java.lang.Comparable),
 * вы сможете создавать диапазоны из объектов этого типа, но не можете перечислить все объекты в таких диапазонах.
 * Но вы по-прежнему сможете убедиться в принадлежности объекта диапазону с помощью оператора in
 */
fun checkStringInRange(word: String) {
    println(word in "Java".."Scala")        // To же, что и 'Java' <= word && word <= 'Scala
}

/**
 * Та же проверка in будет работать с коллекциями
 */
fun checkStringInSet(word: String) {
    println(word in setOf("Java", "Scala"))
}