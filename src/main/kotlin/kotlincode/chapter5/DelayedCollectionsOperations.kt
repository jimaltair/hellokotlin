package kotlincode.chapter5

fun delayedOperations() {
    val people = listOf(Person("Alice", 27), Person("Bob", 31))

    /**
     * Справочник по стандартной библиотеке Kotlin говорит, что filter и map возвращают список. Это значит,
     * что данная цепочка вызовов создаст два списка: один - для хранения результатов функции filter и другой -
     * для результатов функции map.
     * Если в исходном списке пара элементов, можно делать так:
     */
    val first = people
        .map { it.name }
        .filter { it.startsWith("A") }
    println(first)

    /**
     * Но в случае со списком из миллиона элементов это может существенно снизить эффективность операции.
     * Для повышения эффективности нужно реализовать операцию с применением последовательностей вместо коллекций:
     */
    val second = people.asSequence()
        .map { it.name }
        .filter { it.startsWith("A") }
        .toList()
    println(second)
}