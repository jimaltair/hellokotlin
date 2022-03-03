package kotlincode.chapter5

import java.io.File

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

    listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
        .toList()

    val people1 = listOf(Person("Alice", 29), Person("Bob", 31),
        Person("Charles", 31), Person("Dan", 21))

    /**
     * Применение функции filter первой помогает уменьшить число необходимых преобразований. Если map выполнится первой,
     * будет преобразован каждый элемент. Если же сначала применить filter, неподходящие элементы отфильтруются раньше
     * и не будут преобразованы.
     */
    println(
        people1.asSequence()
        .filter { it.name.length < 4 }
        .map { it.name }
        .toList()
    )
}

/**
 * Создание и использование последовательности натуральных чисел
 */
fun sequenceCreation(){
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())         // Все отложенные операции выполнятся при обращении к «sum»
}

/**
 * Создание и применение последовательности родительских каталогов
 */
fun File.isInsideHiddenDirectory() =
    generateSequence(this) { it.parentFile }.any { it.isHidden }

val file = File("/Users/svtk/.HiddenOir/a.txt")
fun testIsInsideHiddenDirectory(){
    println(file.isInsideHiddenDirectory())
}