package chapter5

/**
 * Лямбда-выражение позволяет передать функцию напрямую.
 * Это выражение называется ссылкой на член класса (member reference) и обеспечивает короткий синтаксис создания
 * значения функции, вызывающего ровно один метод или обращающегося к свойству.
 */
val getAge = Person::age

// а это более длинный вариант
val getAge1 = { person: Person -> person.age }


fun someFun() {
    val people = listOf(Person("Bob", 31), Person("Alice", 29))
    /**
     * Ссылка на член класса - того же типа, что и лямбда-выражение, вызывающее эту функцию,
     * поэтому их можно взаимно заменять:
     */
    people.maxByOrNull(Person::age)
    /**
     * Также можно создать ссылку на функцию верхнего уровня (и не являющуюся членом класса):
     */
    fun salute() = println("Salute!")
    run(::salute)
}

/**
 * Иногда удобно использовать ссылку на функцию вместо лямбда-выражения, делегирующего свою работу функции,
 * принимающей несколько параметров:
 */
// данное лямбда-выражение делегирует работу функции sendEmail
val action = { person: Person, message: String -> sendEmail(person, message) }
// вместо вышеуказанного лямбда-выражения можно использовать ссылку на функцию
val nextAction = ::sendEmail

fun sendEmail(person: Person, message: String) = println("Sending email [$message] to $person")

/**
 * Вы можете сохранить или отложить операцию создания экземпляра класса с помощью ссылки на конструктор.
 * Чтобы сформировать ссылку на конструктор, нужно указать имя класса после двойного двоеточия:
 */
data class Person1(val name: String, val age: Int)
val createPerson = ::Person         // операция создания экземпляра Person сохраняется в переменной
val p = createPerson("Alice", 29)

/**
 * Также ссылку можно получить и на функцию-расширение:
 */
fun Person.isAdult() = age >= 21
val adultPredicate = Person::isAdult

/**
 * Связанная ссылки. Доступно, начиная с Kotlin 1.1
 */
fun testConnectedReferences(){
    val dmitry = Person("Dmitry", 34)
    val personsAgeFunction = Person::age
    println(personsAgeFunction(dmitry))

    val dmitrysAgeFunction = dmitry::age
    println(dmitrysAgeFunction())           // Связанная ссылка, доступная в Kotlin 1.1
}


