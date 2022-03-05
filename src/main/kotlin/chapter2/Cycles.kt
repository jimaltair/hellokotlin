package chapter2

import java.util.*

/**
 * циклы while и do-while полностью аналогичны соответствующим циклам на Java
 */

/**
 * Используем диапазон целых чисел, чтобы сыграть в Fizz-Buzz. Эта игра - хороший способ скоротать долгое путешествие
 * на машине и вспомнить забытые навыки деления. Игроки договариваются о диапазоне чисел и затем ходят по очереди,
 * начиная с единицы и заменяя число, кратное трем, словом fizz, и число, кратное пяти, словом buzz. Если число кратно
 * и трем, и пяти, оно заменяется парой слов fizz buzz.
 */

fun fizzBuzz(i: Int) =
    when {
        i % 3 == 0 -> "Fizz "
        i % 5 == 0 -> "Buzz "
        i % 15 == 0 -> "FizzBuzz "
        else -> "$i "
    }

/**
 * итерация по диапазону. диапазон закрытый, т.е. от и до включительно
 */
fun playFizzBuzz() {
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
}

/**
 * итерация по диапазону с шагом
 */
fun playImprovedFizzBuzz() {
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }
}

/**
 * итерация по полузакрытому диапазону (от и до не включая)
 */
fun playFizzBuzzHalfOpenedRange() {
    for (i in 0 until 100) {
        print(fizzBuzz(i))
    }
}

/**
 * итерация по элементам словарей
 */
fun mapIteration() {
    val binaryReps = TreeMap<Char, String>()    // Словарь TreeМар хранит ключи в порядке сортировки
    for (i in 'A'..'F') {
        val binary = Integer.toBinaryString(i.code)     // Преобразует ASCII-код в двоичное представление
        binaryReps[i] = binary       // аналогично записи binaryReps.put(i, binary)
    }
    for ((char, bin) in binaryReps) {
        println("$char = $bin")     // Обход элементов словаря; ключ и значение присваиваются двум переменным
    }
}

/**
 * итерация по элементам списка
 *
 * Синтаксит распаковки при обходе коллекции можно применить, чтобы сохранить индекс текущего элемента.
 * Это избавит вас от необходимости создавать отдельную переменную для хранения индекса и увеличивать её вручную
 */
fun listIteration(){
    val list = listOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}
