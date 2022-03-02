package kotlincode.chapter4

import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

/**
 * Ключевое слово object можно использовать не только для объявления именованных объектов-одиночек, но и для создания
 * анонимных объектов. Анонимные объекты заменяют анонимные внутренние классы в Java.
 */

/**
 * Реализация обработчика событий с помощью анонимного объекта
 */
/*
window.addMouseListener(
    object : MouseAdapter() {                           // Объявление анонимного объекта, наследующего MouseAdapter
        override fun mouseClicked(e: MouseEvent) {      // Переопределение методов MouseAdapter
            // ...
        }

    override fun mouseEntered(e: MouseEvent) {          // Переопределение методов MouseAdapter
        // ...
        }
    }
)*/

/**
 * Объект-выражение объявляет класс и создает экземпляр этого класса, но не присваивает имени ни классу, ни экземпляру.
 * Как правило, в этом нет необходимости, поскольку объект используется в качестве параметра вызова функции.
 * Если объекту потребуется дать имя, его можно сохранить в переменной:
 */
val listener = object : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent) {/*...*/}
    override fun mouseEntered(e: MouseEvent) {/*...*/}
}
/**
 * В отличие от анонимных внутренних классов Java, которые могут наследовать только один класс или реализовать только
 * один интерфейс, анонимный объект Kotlin может реализовывать несколько интерфейсов или вовсе ни одного.
 *
 * Примечание: В отличие от объявления объекта, анонимные объекты - не «одиночки». При каждом выполнении
 * объекта-выражения создается новый экземпляр объекта.
 */

/**
 * Доступ к локальным переменным из анонимного объекта
 */
fun countClicks(window: Window){
    var clickCount = 0                  // Объявление локальной переменной

    window.addMouseListener(object : MouseAdapter(){
        override fun mouseClicked(e: MouseEvent) {
            clickCount++                // Изменение значения переменной
        }
    })
}
