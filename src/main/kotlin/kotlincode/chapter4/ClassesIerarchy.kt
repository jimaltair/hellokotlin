package kotlincode.chapter4

/**
 * обяъвление простого интерфейса
 */
interface Clickable {
    fun click()                                     // обычное объявление метода
    fun showOff() = println("I'm clickable!")       // метод с реализацией по умолчанию
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")
}

class Button : Clickable, Focusable {
    override fun click() {
        println("I was clicked")
    }

    /**
     * Вы должны явно реализовать метод, если наследуется несколько его реализаций.
     * Ключевое слово «super» с именем супертипа в угловых скобках определяет родителя, чей метод будет вызван.
     */
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}