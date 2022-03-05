package chapter4

import java.io.Serializable

interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

/**
 * Реализация интерфейса View в Kotlin с помощью вложенного класса.
 * В Kotlin вложенный класс без модификаторов — это полный аналог статического вложенного класса в Java.
 * Чтобы превратить его во внутренний класс со ссылкой на внешний класс, нужно добавить модификатор inner.
 */
class Button1 : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {/*...*/
    }

    class ButtonState : State {/*...*/ }        // Это аналог статического вложенного класса в Java
}

/**
 * Соответствие между внутренними и вложенными классами в Java и Kotlin
 *
 * Класс А, объявленный внутри другого класса В                 В Java              В Kotlin
 *
 * Вложенный класс (не содержит ссылки на внешний класс)    static class A          class A
 * Внутренний класс (содержит ссылку на внешний класс)      class A                 inner class A
 */

/**
 * Чтобы получить доступ к классу Outer из класса Inner, нужно написать this@Outer.
 */
class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}