package chapter4

import javax.naming.Context
import javax.print.attribute.AttributeSet
import javax.print.attribute.HashAttributeSet

/**
 * Объявляем простой класс
 */
class User(val nickname: String)

/**
 * Явный код, который делает то же самое:
 */
class User1 constructor(nickname: String) {        // основной конструктор с одним параметром
    val nickname: String

    init {                                          // блок инициализации
        this.nickname = nickname
    }
}

/**
 * В этом примере инициализирующий код можно совместить с объявлением свойства nickname, поэтому его не нужно помещать
 * в блок инициализации. В отсутствие аннотаций и модификаторов видимости основного конструктора ключевое слово
 * "constructor" также можно опустить.
 */
class User2(nickname: String) {     // основной конструктор с одним параметром
    val nickname = nickname         // Свойство инициализируется значением параметра
}

class User3(val nickname: String)   // val означает, что для параметра должно быть создано соответствующее свойство

/**
 * Используем значение по умолчанию для параметра конструктора
 */
class User4(val nickname: String, val isSubscribed: Boolean = true)

fun testUser4() {
    val alice = User4("Alice")      //используем значение параметра isSubscribed по умолчанию, равное "true"
    println(alice.isSubscribed)
    val bob = User4("Bob", false)    // значение параметров можно передавать в порядке определения
    println(bob.isSubscribed)
    val carol = User4("Carol", isSubscribed = false)    // Можно явно указывать имена некоторых аргументов констр.
    println(carol.isSubscribed)
}

/**
 * Если класс имеет суперкласс, основной конструктор также должен инициализировать свойства, унаследованные от
 * суперкласса. Сделать это можно, перечислив параметры конструктора суперкласса после имени его типа в списке
 * базовых классов:
 */
open class User5(val nickname: String) { /*...*/ }
class TwitterUser(nickname: String) : User5(nickname) { /*...*/ }

/**
 * Если вообще не объявить никакого конструктора, компилятор добавит конструктор по умолчанию, который ничего не делает:
 */
open class Button2      // Будет сгенерирован конструктор по умолчанию без аргументов

/**
 * Если вы захотите унаследовать класс Button в другом классе, не объявляя своих конструкторов, вы должны будете явно
 * вызвать конструктор суперкласса, даже если тот не имеет параметров:
 */
class RadioButton : Button2()

/**
 * Если вы хотите получить гарантии того, что никакой другой код не сможет создавать экземпляров вашего класса,
 * сделайте конструктор приватным с помощью ключевого слова private. Поскольку класс Secretive имеет только приватный
 * конструктор, код снаружи класса не сможет создать его экземпляра.
 */
class Secretive private constructor() { /*...*/ }        // Конструктор этого класса приватный

/**
 * Представьте класс View, объявленный в Java, который имеет два конструктора.
 * Этот класс не имеет основного конструктора. Вот как выглядит аналогичное объявление в Kotlin:
 */
open class View1 {
    constructor(ctx: Context) {      // вторичный конструктор
        // некоторый код
    }

    constructor(ctx: Context, attr: AttributeSet) {      // вторичный конструктор
        // некоторый код
    }
}

/**
 * Чтобы расширить этот класс, объявите те же конструкторы:
 */
class MyButton : View1 {
    constructor(ctx: Context) : super(ctx) {        // вызов конструктора суперкласса
        //...
    }

    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {      // вызов конструктора суперкласса
        //...
    }
}

/**
 * Как в Java, в Kotlin есть возможность вызвать один конструктор класса из другого с помощью ключевого слова this.
 * Вот как это работает:
 */
val MY_STYLE = HashAttributeSet()
class MyButton1 : View1 {

    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {
        //...
    }

    constructor(ctx: Context) : this(ctx, MY_STYLE) {       // делегирует выполнение другому конструктору того же класса
        //...
    }
}