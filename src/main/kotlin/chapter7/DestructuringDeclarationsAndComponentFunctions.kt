package chapter7

/**
 * Мультидекларация (destructuring declaration)
 */
fun testDestructuringDeclaration() {
    val point = Point(10, 20)
    val (x, y) = point      // Объявляются переменные х и у и инициализируются компонентами объекта point
    println("Point coordinates: x = $x, y = $y")
}

/**
 * Скрытая от ваших глаз работа мультидеклараций также основана на принципе соглашений. Для инициализации каждой
 * переменной в мультидекларации вызывается функция с именем componentN, где N - номер позиции переменной в объявлении.
 * Иными словами, предыдущий пример транслируется в код:
 *
 *  val (a, b) = p   --->   val a = p.component1()
 *                   \
 *                    -->   val b = p.component2()
 *
 * Для класса данных компилятор сгенерирует функции componentN для каждого свойства, объявленного в основном конструкторе.
 * Следующий пример демонстрирует, как можно объявить такие функции вручную в других классах, не являющихся классами данных:
 */
class Point1(val x: Int, val y: Int) {
    operator fun component1() = x
    operator fun component2() = y
}

/**
 * Использование мультидекларации для возврата из функции нескольких значений.
 * Стандартная библиотека позволяет использовать этот синтаксис для извлечения первых пяти элементов из контейнера.
 */
data class NameComponents(val name: String, val extension: String)

fun splitFilename(fullName: String): NameComponents {
    val (name, extension) = fullName.split('.', limit = 2)
    return NameComponents(name, extension)
}

/**
 * Ещё более простой способ возврата нескольких значений из функций дают классы Pair и Triple из стандартной библиотеки.
 * В этом случае код получается менее выразительным, потому что эти классы не позволяют узнать смысл возвращаемого объекта,
 * зато более лаконичным, потому что отпадает необходимость объявлять свой класс данных.
 */
fun splitFilename1(fullName: String): Pair<String, String> {
    val (name, extension) = fullName.split('.', limit = 2)
    return Pair(name, extension)
}

fun testSplitFilename() {
    val (name, extension) = splitFilename("TEST.txt")
    val (name1, extension1) = splitFilename1("TEST.txt")
    println("1st variant /// Name: $name, extension: $extension")
    println("2nd variant /// Name: $name1, extension: $extension1")
}

/**
 * Использование мультидекларации для обхода элементов словаря
 */
fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {         // Мультидекларация в объявлении цикла
        println("$key = $value")
    }
}

fun testPrintEntries(){
    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
}