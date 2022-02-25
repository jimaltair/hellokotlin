package kotlincode.chapter4

/**
 * Интерфейсы в Kotlin могут включать объявления абстрактных свойств
 */
interface User6 {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User6        // свойство основного конструктора

class SubscribingUser(val email: String) : User6 {
    override val nickname: String
        get() = email.substringBefore('@')      // собственный метод чтения
}

class FacebookUser(val accountld: Int) : User6 {
    override val nickname = getFacebookName(accountld)      // инициализация свойства

    fun getFacebookName(accountld: Int): String {
        return "facebook$accountld"
    }
}

/**
 * Кроме абстрактных свойств, интерфейс может содержать свойства с методами чтения и записи — при условии, что они не
 * обращаются к полю в памяти (такое поле потребовало бы хранения состояния в интерфейсе, что невозможно).
 *
 * В данном примере интерфейс определяет абстрактное свойство email, а также свойство nickname с методом доступа.
 * Первое свойство должно быть переопределено в подклассах, а второе может быть унаследовано.
 */
interface User7 {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')      // Свойство не имеет поля для хранения значения: результат вычисляется
                                                        // при каждой попытке доступа
}

class User7Implementation : User7 {
    override val email: String = ""      // переопределение свойства родительского интерфейса значением по умолчанию
}