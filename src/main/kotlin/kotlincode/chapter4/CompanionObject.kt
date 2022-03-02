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

/**
 * Реализация интерфейса в объекте-компаньоне
 */
interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class Person4(val name: String) {
    companion object : JSONFactory<Person4> {           // объект-компаньон, реализующий интерфейс
        override fun fromJSON(jsonText: String): Person4 = Person4("Dmitry")
    }
}

/**
 * Далее, если у вас есть функция, использующая абстрактную фабрику для загрузки сущностей, передайте ей объект Person.
 */
fun <T> loadFromJSON(factory: JSONFactory<T>) {
    // some code
}

/* почему-то не работает как в книге на стр.134
fun testCompanionTransmission(){
    loadFromJSON(Person4("Dmitry"))     // передача объекта-компаньона в функцию
}*/

/**
 * Определение функции-расширения для объекта-компаньона
 */
// модуль реализации бизнес-логики
class Person5(val firstName: String, val lastName: String) {
    companion object {              // определение пустого объекта-компаньона

    }
}

// модуль реализации взаимодействий между клиентом и сервером
fun Person5.Companion.fromJSON(json: String): Person5 {          // объявление функции-расширения
    return Person5("Dmitry", "Botchkin")
}

fun testCompanionExtension() {
    val person = Person5.fromJSON("some json")
    println("Name: ${person.firstName}, last name: ${person.lastName}")
}

