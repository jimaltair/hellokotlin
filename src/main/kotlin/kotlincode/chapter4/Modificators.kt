package kotlincode.chapter4

/**
 * Объявление открытого класса с открытым методом
 */
open class RichButton : Clickable {     // Это открытый класс: другие могут наследовать его

    fun disable() {}        // Это закрытая функция: ее невозможно переопределить в подклассе

    open fun animate() {}       // Это открытая функция: ее можно переопределить в подклассе

    override fun click() {}     // Переопределение открытой функции также является открытым

}

/**
 * Запрет переопределения
 */
open class AnotherButton : Clickable {
    final override fun click() {}
}

/**
 * Объявление абстрактного класса
 */
abstract class Animated {       // Это абстрактный класс: нельзя создать его экземпляр
    abstract fun animate()      // Это абстрактная функция: она не имеет реализации и должна быть переопределена в подклассах
    fun animateTwice() {        // Конкретные функции в абстрактных классах по умолчанию закрыты для переопределения
        println("Make twice animation")
    }

    open fun stopAnimating() {}     // Делаем данную функцию открытой для переопределения в классах-наследниках
}

class RealAnimatedClass : Animated() {
    override fun animate() {
        println("Make some animation")
    }

    override fun stopAnimating() {
        println("Stop animating!")
    }
}

/**
 * Модификаторы доступа (управления наследованием) в классе
 *
 * Модификатор              Соответствующий член                            Комментарии
 *
 * final                   He может быть переопределен         Применяется к членам класса по умолчанию
 *
 * open                    Может быть переопределен            Должен указываться явно
 *
 * abstract                Должен быть переопределен           Используется только в абстрактных классах;
 *                                                             абстрактные методы не могут иметь реализацию
 *
 * override                Переопределяет метод суперкласса    По умолчанию переопределяющий метод открыт,
 *                                                             если только не объявлен как final
 */

/**
 * Модификаторы видимости в Kotlin
 *
 * Модификатор              Член класса              Объявление верхнего уровня
 *
 * public (по умолчанию)    Доступен повсюду            Доступен повсюду
 *
 * internal                 Доступен только в модуле    Доступно в модуле
 *
 * protected                Доступен в подклассах             ---
 *
 * private                  Доступен в классе           Доступно в файле
 */

internal open class TalkativeButton : Focusable {
    private fun yell() {
        println("Hey!")
    }

    protected open fun whisper() {
        println("Let's talk!")
    }
}

/**
 * Область видимости класса-наследника должна быть не шире родительского класса.
 * Данный класс может переопределять только методы интерфейса Focusable (они public open по умолчанию)
 * Функции родительского класса имеют по умолчанию модификатор final и для их переопределения нужно явно добавить слово
 * «open».
 */
internal class InheritorTalkativeButton : TalkativeButton() {
    override fun setFocus(b: Boolean) {
        println()
    }

    override fun showOff() {
        println()
    }
}

/**
 * Примеры ошибок - код не скомпилируется.
 * Kotlin запрещает ссылаться из публичной функции giveSpeech на тип TalkativeButton с более узкой областью видимости
 * (в данном случае internal)
 */
//fun TalkativeButton.giveSpeech() {  // Ошибка: «публичный» член класса раскрывает «внутренний» тип-приемник «TalkativeButton»
//    yell()      // Ошибка: функция «yell» недоступна; в классе «TalkativeButton» она объявлена с модификатором «private»
//    whisper()   // Ошибка: функция «whisper» недоступна; в классе «TalkativeButton» она объявлена с модификатором «protected»
//}