package kotlincode.chapter4

import kotlincode.chapter2.Person
import java.io.File

/**
 * Ключевое слово "object" используется в языке Kotlin в разных случаях, которые объединены общей идеей:
 * это ключевое слово одновременно объявляет класс и создает его экземпляр (другими словами, объект).
 */

/**
 * Реализация паттерна "Singleton": в Java вы определяете класс с приватным конструктором и статическим полем,
 * содержащим единственный существующий экземпляр этого класса.
 * Kotlin обеспечивает поддержку такого решения на уровне языка, предлагая синтаксис объявления объекта.
 * Объявление объекта сочетает в себе объявление класса и единственного экземпляра этого класса.
 */
object Payroll {
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary() {
        for (person in allEmployees) {
            /* some code */
        }
    }
}
/**
 * По аналогии с классом объявление объекта может содержать определения свойств, методов, блоков инициализации и т. д.
 * Единственное, что не допускается - конструкторы, основные или вторичные.
 */

/**
 * Реализация интерфейса Comparator с помощью объявления объекта
 */
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

/**
 * Реализация интерфейса Comparator как вложенного объекта
 */
data class Person2(val name: String) {
    object NameComparator : Comparator<Person2> {
        override fun compare(person1: Person2, person2: Person2) =
            person1.name.compareTo(person2.name)
    }
}