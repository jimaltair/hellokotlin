package chapter7

/**
 * По аналогии с арифметическими операторами Kotlin дает возможность использовать операторы сравнения (==, !=,>,< и другие)
 * с любыми объектами, а не только с простыми типами. Вместо вызова equals или compareTo, как в Java, вы можете
 * использовать непосредственные операторы сравнения, которые выглядят короче и понятнее.
 */

/**
 * Проверка на равенство == транслируется в вызов equals и проверку на равенство null
 *
 *  a == b   --->   a?.equals(b) ?: (b == null)
 */
fun testPointEquals() {
    println(Point(10, 20) == Point(10, 20))
    println(Point(10, 20) != Point(5, 5))
    println(null == Point(1, 2))
}

/**
 * Оператор строгого равенства, или идентичности (===) часто используется для проверки параметра текущему объекту.
 * Оператор идентичности действует в точности как оператор == в Java: он сравнивает ссылки своих аргументов
 * (или значения, если аргументы - это значения простого типа). Использование этого оператора - распространенная
 * оптимизация реализаций equals. Обратите внимание, что оператор === недоступен для перегрузки.
 */

/**
 * Сравнение двух объектов транслируется в сравнение с нулем результата, возвращаемого методом compareTo
 *
 *  a >= b  --->   a.compareTo(b) >= 0
 */

/**
 * Реализация метода compareTo
 */
class Person(val firstName: String, val lastName: String) : Comparable<Person> {
    // Вызывает заданные функции в указанном порядке и сравнивает возвращаемые ими результаты
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }
}

fun testPersonCompare(){
    val p1 = Person("Alice", "Smith")
    val p2 = Person("Bob", "Johnson")
    println(p1 < p2)

    /**
     * Все Java-классы, реализующие интерфейс Comparable, можно сравнивать в коде на Kotlin с использованием краткого
     * синтаксиса операторов:
     */
    println("abc" < "bac")
}