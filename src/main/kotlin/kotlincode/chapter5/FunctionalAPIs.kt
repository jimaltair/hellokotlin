package kotlincode.chapter5

fun filterAndMap() {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })
    println(list.map { it * it })
    val people = listOf(Person("Alice", 29), Person("Bob", 31), Person("Dmitry", 34))
    println(people.filter { it.age > 30 })
    println(people.map { it.name })
    println(people.map { Person::name })
    println(people.filter { it.age > 30 }.map { it.name })
    println(people.filter { it.age == people.maxByOrNull(Person::age)?.age })

    val maxAge = people.maxByOrNull(Person::age)?.age
    println(people.filter { it.age == maxAge })

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.uppercase() })
}

fun allAnyCountFind() {
    val canBeInClub27 = { person: Person -> person.age <= 27 }
    val people = listOf(Person("Alice", 27), Person("Bob", 31))
    println(people.all(canBeInClub27))
    println(people.any(canBeInClub27))

    val list = listOf(1, 2, 3)
    println(!list.all { it == 3 })
    println(list.any { it == 3 })

    println(people.count(canBeInClub27))
    println(people.find(canBeInClub27))
    println(people.firstOrNull(canBeInClub27))
}

fun groubBy() {
    val people = listOf(Person("Alice", 31), Person("Bob", 29), Person("Carol", 31))
    println(people.groupBy { it.age })

    val list = listOf("а", "ab", "b")
    println(list.groupBy(String::first))
}

class Book(val title: String, val authors: List<String>)

/**
 * Функция flatMap сначала преобразует (или отображает - map) каждый элемент в коллекцию, согласно функции, переданной
 * в аргументе, а затем собирает (или уплощает - flattens) несколько списков в один.
 */
fun flatMapAndFlatten() {
    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })

    val books = listOf(
        Book("Thursday Next", listOf("Jasper Fforde")),
        Book("Mort", listOf("Terry Pratchett")),
        Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman"))
    )
    println(books.flatMap { it.authors }.toSet())       // Множество всех авторов книг в коллекции «books»

    val lists = listOf(listOf("abc", "def"), listOf("Jasper Fforde"), listOf("Terry Pratchett", "Terry Pratchett", "Neil Gaiman"))
    println(lists.flatten())

}
/**
 * Вспомните о функции flatMap, когда нужно будет объединить коллекцию коллекций элементов. Но если потребуется просто
 * плоская коллекция, без преобразований, используйте функцию flatten: listOfLists.flatten.
 */