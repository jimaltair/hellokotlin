package chapter6

import javacode.DataParser
import javacode.FileContentProcessor
import java.io.BufferedReader
import java.io.File
import java.io.StringReader
import java.util.LinkedList

/**
 * Создание коллекции, которая может хранить значения null
 */
fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()          // создание списка значений типа Int с поддержкой null
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            result.add(number)          // добавление в список целочисленного значения (не равного null)
        } catch (e: NumberFormatException) {
            result.add(null)        // добавление в список null, поскольку текущая строка не может быть преобр. в число
        }
    }
    return result
}
/**
 * Примечание: помните, для каких объектов допускается значение null - для элементов или для самой коллекции.
 * List<Int?> - отдельные элементы списка могут хранить null
 * List<Int>? - сам список может быть представлен пустой ссылкой
 * List<Int?>? - комбинация двух предыдущих вариантов. При этом вам придется выполнять проверки на null два раза:
 * и при использовании значения переменной, и при использовании значения каждого элемента в списке.
 */

/**
 * Работа с коллекцией, которая может хранить значения null
 */
fun addValidNumbers(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for (number in numbers) {           // чтение из списка значения, которое может оказаться равным null
        if (number != null)             // проверка значения на null
            sumOfValidNumbers += number
        else
            invalidNumbers++
    }
    println("Sum of valid numbers = $sumOfValidNumbers")
    println("Count of invalid numbers = $invalidNumbers")
}

fun testAddValidNumbers() {
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)
}

/**
 * Применение функции filterNotNull к коллекции, которая может хранить значения null
 */
fun addValidNumbers1(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers = ${validNumbers.sum()}")
    println("Count of invalid numbers = ${numbers.size - validNumbers.size}")
}

fun testAddValidNumbers1() {
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    addValidNumbers1(numbers)
}

/**
 * kotlin.collections.Collection - неизменяемая коллекция
 * kotlin.collections.MutableCollection - изменяемая коллекция
 * Интерфейс MutableCollection наследует Collection и добавляет методы для изменения содержимого коллекции
 */

/**
 * Например, в следующем примере видно, что функция copyElements будет изменять целевую коллекцию, но не исходную.
 */
fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (element in source) {       // цикл по всем элементам исходной коллекции
        target.add(element)         // добавление элементов в изменяемую целевую коллекцию
    }
}

fun testCopyElements() {
    val source: Collection<Int> = arrayListOf(1, 10, 100)
    val target: MutableCollection<Int> = arrayListOf(999)
    val target1: Collection<Int> = arrayListOf(999)
//    val result1 = copyElements(source, target1)       // получим ошибку
    copyElements(source, target)
    println(target)
}
/**
 * Самое главное, что нужно помнить при работе с интерфейсами коллекций, доступных только для чтения - они необязательно
 * неизменяемые. Если вы работаете с переменной-коллекцией, интерфейс которой дает доступ только для чтения, она может
 * оказаться лишь одной из нескольких ссылок на одну и ту же коллекцию. Другие ссылки могут иметь тип изменяемого интерфейса
 */

/**
 * Реализация интерфейса FileContentProcessor в Kotlin.
 * В Kotlin-реализации этого интерфейса нужно принять во внимание следующие соображения:
 * 1. Ссылка на список может оказаться пустой, поскольку существуют двоичные файлы, которые нельзя представить в виде текста.
 * 2. Элементы в списке не могут хранить null, поскольку строки в файле никогда не имеют значения null.
 * 3. Список доступен только для чтения, поскольку представляет неизменяемое содержимое файла.
 */
class FileIndexer : FileContentProcessor {
    override fun processContents(path: File, binaryContents: ByteArray?, textContents: List<String>?) {
        // some code
    }
}

/**
 * Реализация интерфейса DataParser на языке Kotlin.
 * Здесь нужно учесть другие соображения:
 * 1. Список List<String> не может быть пустой ссылкой, поскольку вызывающий код всегда должен получать сообщения об ошибках.
 * 2. Среди элементов списка может оказаться значение null, поскольку не все элементы в выходном списке будут иметь
 *    связанные с ними сообщения об ошибках.
 * 3. Список List<String> будет изменяемым, поскольку реализация должна добавлять в него элементы.
 */
class PersonParser : DataParser<Person> {
    override fun parseData(input: String, output: MutableList<Person>, errors: MutableList<String?>) {
        // some code
    }
}

/**
 * Использование массивов
 */
fun fakeMain(args: Array<String>) {
    for (i in args.indices) {           // Использование свойства-расширения array.indices для обхода диапазона индексов
        println("Argument $i is: ${args[i]}")       // Обращение к элементу по индексу array[index]
    }
}

/**
 * Создать массив в Kotlin можно следующими способами:
 * 1. Функция arrayOf создает массив с элементами, соответствующими аргументам функции.
 * 2. Функция arrayOfNulls создает массив заданного размера, где все элементы равны null. Конечно, эту функцию можно
 *    использовать лишь для создания массивов, допускающих хранение null в элементах.
 * 3. Конструктор класса Array принимает размер массива и лямбда-выражение,
 *    после чего инициализирует каждый элемент с помощью этого лямбда-выражения. Так можно инициализировать массив,
 *    который не поддерживает значения null в элементах, не передавая всех элементов непосредственно.
 */

/**
 * Создание массива строк.
 * Лямбда-выражение принимает индекс элемента массива и возвращает значение, которое будет помещено в массив с
 * этим индексом. Здесь значение вычисляется путем сложения индекса с кодом символа "а" и преобразованием результата в
 * строку.
 */
val letters = Array<String>(33) { i -> ('а' + i).toString() }

/**
 * Одна из самых распространенных причин создания массивов в Kotlin - необходимость вызова метода Java, принимающего
 * массив, или функции Kotlin с параметром типа vararg. Чаще всего в таких случаях данные уже хранятся в коллекции,
 * и вам просто нужно преобразовать их в массив. Сделать это можно с помощью метода toTypedArray.
 */
val strings = listOf("a", "b", "с")
fun testArrayCreation() {
    /**
     * Для передачи массива в метод, ожидающий vararg, применяется оператор развертывания (*)
     */
    println("%s/%s/%s".format(*strings.toTypedArray()))
}

/**
 * Создать массив примитивного типа можно следующими способами:
 * 1. Конструктор типа принимает параметр size и возвращает массив, инициализированный значениями по умолчанию для
 *    данного типа (обычно нулями).
 * 2. Фабричная функция (intArrayOf - для массива IntArray и аналогичные для остальных типов) принимает переменное
 *    число аргументов и создает массив из этих аргументов.
 * 3. Другой конструктор принимает значение размера и лямбда-выражение для инициализации каждого элемента.
 */
val fiveZeros = IntArray(5)
val fiveZerosToo = intArrayOf(0, 0, 0, 0, 0)
val squares = IntArray(5) { i -> (i + 1) * (i + 1) }

/**
 * Применение функции forEachIndexed к массиву
 */
fun fakeMain1(args: Array<String>) {
    args.forEachIndexed { index, element -> println("Argument $index is: $element") }
}