package chapter7

/**
 * Как известно, к элементам словарей в Kotlin можно обращаться так же, как к элементам массивов в Java, с применением
 * квадратных скобок:
 */
fun testMapElementInvocation() {
    val map = mutableMapOf(1 to "one", 2 to "two", 3 to "three")

    /**
     * Операция чтения элемента с использованием оператора индекса транслируется в вызов метода-оператора get
     */
    val value = map[1]      // получаем элемент по ключу
    println(value)

    /**
     * Тот же оператор можно использовать для изменения значений по ключам в изменяемом словаре:
     */
    println(map)
    /**
     * Операция записи элемента с использованием оператора индекса транслируется в вызов метода-оператора set
     */
    map[1] = "zzzzz"  // присваиваем ключу новое значение
    println(map)
}

/**
 * Реализация соглашения get для класса Point
 */
operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

fun testPointGetMethod() {
    val point = Point(10, 20)
    println(point[0])
    println(point[1])
    println(point[2])
}

/**
 * Операция доступа с применением квадратных скобок транслируется в вызов функции get
 *
 *  x[a, b]  --->   x.get(a, b)
 */

/**
 * Реализация соглашения set
 *
 *  x[a, b] = c  --->   x.set(a, b, c)
 */
data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {     // Определение функции-оператора с именем «set»
    when (index) {
        0 -> x = value      // Изменить координату, соответствующую заданному индексу
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

fun testPointSetMethod(){
    val point = MutablePoint(10, 20)
    println(point)
    point[0] = 42
    println(point)
}