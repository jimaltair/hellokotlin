package kotlincode.chapter6

/**
 * Случай, если мы не предполагаем что функция может быть вызвана со значением null
 */
fun strLen(s: String) = s.length

/**
 * Чтобы разрешить вызов этой функции с любыми аргументами, в том числе и null, мы должны указать это явно,
 * добавив вопросительный знак после имени типа.
 * Type? = Type или null
 */
fun strLenSafe(s: String?) = s?.length

/**
 * Нельзя присвоить значение null переменной, которая не поддерживает этот тип
 */
val x: String? = null
//val y: String = null      // ошибка компиляции

/**
 * Работа со значением null с помощью проверки if
 */
fun strLenSafe1(s: String?): Int =
    if (s != null) s.length else 0      // после добавления проверки на null код начал компилироваться

/**
 * Оператор безопасного вызова:«?.»
 * Если значение, метод которого вы пытаетесь вызвать, не является null, то вызов будет выполнен обычным образом.
 * Если значение равно null, вызов игнорируется, и в качестве результата возвращается null.
 */
fun printAllCaps(s: String?) {
    val allCaps: String? = s?.uppercase()       // переменная allCaps может хранить null
    println(allCaps)
}

/**
 * Применение оператора безопасного вызова для доступа к свойствам, способным принимать значение null
 */
class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee) = employee.manager?.name

/**
 * Объединение нескольких операторов безопасного вызова
 */
class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
class Company(val name: String, val address: Address?)
class Person(val name: String, val company: Company?)

fun Person.countryName(): String? {
    val country = company?.address?.country
    return if (country != null) country else "Unkown"
}

/**
 * Оператор «Элвис»: «?:»
 * Оператор принимает два значения и возвращает первое, если оно не равно null, а в противном случае - второе.
 *
 * foo ?: bar ---> foo != null ---> вернуть foo
 *            \
 *             --> foo == null ---> вернуть bar
 */
fun foo(string: String?) {
    val result: String = string ?: ""      // если "string" хранит null, вернуть пустую строку
}

/**
 * Применение оператора «Элвис» для работы с null
 */
fun strLenSafe2(s: String?) = s?.length ?: 0
fun Person.countryName1() = company?.address?.country ?: "Unknown"

/**
 * Использование оператора throw с оператором «Элвис».
 * Особенно удобным оператор «Элвис» делает то обстоятельство, что такие операции, как return и throw,
 * действуют как выражения и, следовательно, могут находиться справа от оператора.
 */
fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("No address")   // при отсутствии адреса вызовется исключение
    with(address){                          // переменная "address" хранит непустое значение
        println(streetAddress)
        println("$zipCode, $city, $country")
    }
}