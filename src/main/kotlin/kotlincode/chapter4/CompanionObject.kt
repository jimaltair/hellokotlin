package kotlincode.chapter4

import kotlincode.chapter2.Person

/**
 * Классы в Kotlin не могут иметь статических членов; ключевое слово static, имеющееся в Java, не является частью языка
 * Kotlin. В качестве замены Kotlin используются функции уровня пакета и объявления объектов. Но такие функции не имеют
 * доступа к приватным членам класса. Поэтому, чтобы написать функцию, которую можно вызывать без экземпляра класса,
 * но с доступом к внутреннему устройству класса, вы можете сделать её членом объявления объекта внутри класса.
 */
class A {
    private fun privateFunction() {
        println("private function called")
    }

    companion object {
        fun testCompanionObject() {
            println("companion object called")
            A().privateFunction()
        }
    }
}

fun topLevelFunction() {
//    A().privateFunction()        - нет доступа к приватной функции
}

/**
 * Определение класса с несколькими вторичными конструкторами
 */
class User9 {
    val nickname: String

    constructor(email: String) {                            // вторичный конструктор
        nickname = email.substringBefore("@")
    }

    constructor(facebookAccountId: Int) {                   // вторичный конструктор
        nickname = getFacebookName(facebookAccountId)
    }

    fun getFacebookName(accountId: Int): String {
        return "facebook$accountId"
    }
}

/**
 * Альтернативный способ реализации той же логики, который может быть полезен по многим причинам, — использовать
 * фабричные методы для создания экземпляров класса. Экземпляр User создается вызовом фабричного метода, а не с
 * помощью различных конструкторов.
 */
class User10 private constructor(val nickname: String) {        // Основной конструктор объявлен приватным

    companion object {                                          // Объявление объекта-компаньона

        fun newSubscribingUser(email: String) = User10(email.substringBefore("@"))

        // фабричный метод создаёт нового пользователя на основе идентификатора в Facebook
        fun newFacebookUser(accountId: Int) = User10(getFacebookName(accountId))

        fun getFacebookName(accountId: Int): String {
            return "facebook$accountId"
        }
    }

}
/**
 * Примечание: объекты-компаньоны не могут расширяться в подклассах
 */

/**
 * Объявление именованного объекта-компаньона
 */
class Person3(val name: String) {
    companion object Loader {
        fun fromJSON(jsonText: String): Person3 = Person3("Dmitry")
    }
}

/**
 * Для вызова метода fromJSON можно использовать оба подхода
 */
fun testNamedCompanionObject() {
    var person = Person3.Loader.fromJSON("{name: 'Dmitry'}")
    println(person.name)
    person = Person3.fromJSON("{name: 'Dmitry'}")
    println(person.name)
}
/**
 * Примечание: если имя объекта-компаньона не указано, по умолчанию выбирается имя Companion.
 */