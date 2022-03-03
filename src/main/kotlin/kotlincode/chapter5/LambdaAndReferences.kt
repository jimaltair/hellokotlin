package kotlincode.chapter5

data class Person(val name: String, val age: Int)

/**
 * Поиск в коллекции вручную
 */
fun findTheOldest(people: List<Person>) {
    var maxAge = 0                              // Хранит максимальный возраст
    var theOldest: Person? = null               // Хранит самого старого человека
    for (person in people) {
        if (person.age > maxAge) {          // Если следующий старше предыдущего, максимальный возраст изменится
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

/**
 * Вызов лямбда-выражения, хранящегося в переменно
 */
fun testLambda() {
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))
    run { println(42) }             // При желании лямбда-выражение можно вызывать напрямую
}

/**
 * Сокращение лямбда-выражения
 */
fun shortenTheLambda() {
    val people = listOf(Person("Bob", 31), Person("Alice", 29))

    /**
     * Вызов лямбды без синтаксических сокращений
     */
    people.maxByOrNull({ person: Person -> person.age })

    /**
     * Синтаксис языка Kotlin позволяет вынести лямбда-выражение за круглые скобки, если оно является последним
     * аргументом вызываемой функции. В этом примере лямбда-выражение - единственный аргумент, поэтому его можно
     * поместить после круглых скобок:
     */
    people.maxByOrNull() { person: Person -> person.age }

    /**
     * Когда лямбда-выражение является единственным аргументом функции, также можно избавиться от пустых круглых скобок:
     */
    people.maxByOrNull { person: Person -> person.age }
}

/**
 * Передача лямбда-выражения в именованном аргументе
 */
fun anotherLambda() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    val names = people.joinToString(separator = " ", transform = Person::name)
    println(names)

    /**
     * А вот как можно переписать этот вызов, поместив лямбда-выражение за скобками:
     */
    val names1 = people.joinToString(" ") { person -> person.name }
    println(names1)

    /**
     * Если лямбда-выражение хранится в переменной, то компилятор не имеет контекста, из которого можно вывести тип
     * параметра. Поэтому его следует указать явно:
     */
    val getAge = { person: Person -> person.age }
//    val getAge = Person::age
    println(people.maxByOrNull(getAge))

    /**
     * Иногда лямбда-выражения могут содержать несколько выражений. В таком случае их результат - последнее выражение:
     */
    val sum = { x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x + y
    }
    println(sum(1, 2))
}