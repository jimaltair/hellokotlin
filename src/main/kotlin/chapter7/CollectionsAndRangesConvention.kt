package chapter7

import java.time.LocalDate

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
 *
 */
data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {     // Определение функции-оператора с именем «set»
    when (index) {
        0 -> x = value      // Изменить координату, соответствующую заданному индексу
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

fun testPointSetMethod() {
    val point = MutablePoint(10, 20)
    println(point)
    point[0] = 42
    println(point)
}

/**
 * Еще один оператор, поддерживаемый коллекциями - оператор in. Он используется для проверки вхождения объекта
 * в коллекцию. Соответствующая функция называется contains. Реализуем её, чтобы дать возможность использовать
 * оператор in для проверки вхождения точки в границы прямоугольника.
 *
 * Оператор in транслируется в вызов функции contains
 *
 *  a in c   --->   c.contains(a)
 */
data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x &&     // Создает диапазон и проверяет принадлежность ему координаты «х»
            p.y in upperLeft.y until lowerRight.y   // Использует функцию «until» для создания открытого диапазона
}

fun testRectangleContains() {
    val rectangle = Rectangle(Point(10, 20), Point(50, 50))
    println(Point(20, 30) in rectangle)
    println(Point(5, 5) in rectangle)
}

/**
 * Соглашение rangeTo.
 * Для создания диапазона используется синтаксис ..: например, 1..10 перечисляет все числа от 1 до 10.
 *
 * Оператор .. представляет собой краткую форму вызова функции rangeTo
 *
 *  start..end   --->   start.rangeTo(end)
 */

fun testStandartRangeTo() {
    val now = LocalDate.now()
    val vacation = now..now.plusDays(14)        // создаём диапазон 14 дней начиная от текущей даты
    println(now.plusWeeks(1) in vacation)      // проверяем принадлежность конкретной даты этому диапазону

    /**
     * Оператор rangeTo имеет более низкий приоритет, чем арифметические операторы, поэтому мы рекомендуем пользоваться
     * круглыми скобками, чтобы избежать путаницы:
     */
    val n = 9
    println(0..(n + 1))

    /**
     * Заключите диапазон в круглые скобки, чтобы получить возможность вызвать его метод
     */
    (0..10).forEach(::print)
}

/**
 * Соглашение «iterator» для цикла «for»
 *
 * Вы можете определять метод iterator в своих классах. Например, следующий метод позволяет выполнять итерации по датам.
 */
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object :
        Iterator<LocalDate> {     // Этот объект реализует интерфейс Iterator для поддержки итераций по элементам LocalDate

        var current = start

        // Обратите внимание, что дня дат используется соглашение compareTo
        override fun hasNext() = current <= endInclusive


        override fun next() = current.apply {       // Возвращает текущую дату как результат перед ее изменением
            current = plusDays(1)        // увеличивает текущую дату на 1 день
        }
    }

fun testDateIterator() {
    val newYear = LocalDate.of(2021, 12, 31)
    val daysOff = newYear..newYear.plusDays(9)
    /**
     * Выполняет итерации no daysOff, когда доступна соответствующая функция iterator
     */
    for (dayOff in daysOff) {
        println(dayOff)
    }
}
