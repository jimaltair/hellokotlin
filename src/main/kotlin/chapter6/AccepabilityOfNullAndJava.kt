package chapter6

import javacode.JavaPerson
import javacode.StringProcessor

/**
 * Код на Java может содержать информацию о допустимости значений null, выраженную с помощью аннотаций. Если эта
 * информация присутствует в коде, Kotlin воспользуется ею. То есть объявление @Nullable String в Java будет
 * представлено в Kotlin как String?, а объявление @NotNull String - как String.
 *
 *           Java                   Kotlin
 *       @Nullable   +   Type    =   Type?
 *       @NotNull    +   Type    =   Type
 */

/**
 * Когда аннотации отсутствуют, данный тип Java становится платформенным типом в Kotlin.
 * Платформенный тип - это тип, для которого Kotlin не может найти информацию о допустимости null.
 * С ним можно работать как с типом, допускающим null, или как с типом, не допускающим null
 *
 *          Java             Kotlin
 *          Type    =   Type? или Type
 *
 * Это означает, что, точно как в Java, вы несете полную ответственность за операции с этим типом.
 * Компилятор разрешит вам делать всё. Он также не станет напоминать об избыточных безопасных операциях над
 * такими значениями (как он делает обычно, встречая безопасные операции над значениями, которые не могут быть null).
 */

/**
 * Обращение к Java-классу без дополнительных проверок на null
 */
fun yellAt(person: JavaPerson) {
    println(person.name.uppercase() + "!!!")
}

fun testYellAt() {
    /**
     * получатель метода uppercase() - поле person.name - равен null, поэтому будет возбуждено исключение
     */
    yellAt(JavaPerson(null))
}

/**
 * Обращение к классу Java с проверками на null
 */
fun yellAtSafe(person: JavaPerson) {
    println((person.name ?: "Anyone").uppercase() + "!!!")
}

fun testYellAtSafe() {
    yellAtSafe(JavaPerson("Bob"))
    yellAtSafe(JavaPerson(null))
}

/**
 * Вы не можете объявить переменную платформенного типа в Kotlin - эти типы могут прийти только из кода на Java.
 * Но вы можете встретить их в сообщениях об ошибках или в IDE:
 *
 * >>> val i: Int = person.name
 * ERROR: Type mismatch: inferred type is String! but Int was expected
 *
 * С помощью нотации String! компилятор Kotlin обозначает платформенные типы, пришедшие из кода на Java.
 */

/**
 * Наследование.
 * Реализация Java-интерфейса с поддержкой и без поддержки null
 */
class StringPrinter : StringProcessor {
    override fun process(value: String) {
        println(value)
    }
}

class NullableStringPrinter : StringProcessor {
    override fun process(value: String?) {
        if (value != null)
            println(value)
    }
}