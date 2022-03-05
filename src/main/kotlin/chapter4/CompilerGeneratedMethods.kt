package chapter4

/**
 * Первоначальное определение класса Client
 */
class Client123(val name: String, val postalCode: Int)

/**
 * Переопределяем equals и hashCode
 */
class Client(val name: String, val postalCode: Int) {
    // «Any» - это аналог java Java.lang.Object: суперкласс всех классов в Kotlin. Знак
    // вопроса в «Аny?» означает, что аргумент «other» может иметь значение null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Client     // Убедиться, что «other» имеет тип Client

        if (name != other.name) return false
        if (postalCode != other.postalCode) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + postalCode
        return result
    }
}

/**
 * Реализация метода toString() в классе Client
 */
class Client1(val name: String, val postalCode: Int) {
    override fun toString(): String {
        return "Client1(name=$name, postalCode=$postalCode)"
    }
}

/**
 * В Kotlin оператор == проверяет равенство объектов, а не ссылок. Он компилируется в вызов метода «equals».
 */
fun compareClientsByReferences(client1: Client, client2: Client) =
    client1 == client2

/**
 * Для сравнения ссылок можно использовать оператор ===, который работает точно как оператор == в Java,
 * выполняя сравнение указателей.
 */
fun compareClientsByValue(client1: Client, client2: Client) =
    client1 === client2

/**
 * Класс Client как класс данных: автоматическое переопределение функций equals, toString и hashCode.
 * Также существует встроенный метод copy.
 * Обратите внимание, что свойства, не объявленные в основном конструкторе, не принимают участия в проверках
 * равенства и вычислении хэш-кода.
 */
data class Client2(val name: String, val postalCode: Int)

