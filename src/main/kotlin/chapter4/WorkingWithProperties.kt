package chapter4

/**
 * Доступ к полю из метода записи
 */
class User8(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""Address was changed for $name: "$field" -> "$value".""".trimIndent())   // Чтение значения из поля
            field = value       // Изменение значения поля
        }
}
/**
 * field - специальный идентификатор, который используется для доступа к значению поля в его методе записи
 */

/**
 * По умолчанию методы доступа имеют ту же видимость, что и свойство. Но вы можете изменить её, добавив модификатор
 * видимости перед ключевыми словами get и set.
 */
class LengthCounter {
    var counter: Int = 0
        private set                     // Значение этого свойства нельзя изменить вне класса

    fun addWord(word: String) {
        counter += word.length
    }
}