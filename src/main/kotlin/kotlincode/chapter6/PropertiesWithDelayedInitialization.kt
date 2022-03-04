package kotlincode.chapter6

import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Применение утверждений !! для доступа к полю с поддержкой null
 */
class MyService {
    fun performAction(): String = "foo"
}

class MyTest{
    private var myService: MyService? = null    // Объявление свойства с типом, поддерживающим null, чтобы инициализировать его значением null

    @Before
    fun setUp(){
        myService = MyService()     // настоящее значение присваивается в методе setUp
    }

    @Test
    fun testAction(){       // из-за подобного объявления приходится использовать !! или ?
        Assert.assertEquals("foo", myService!!.performAction())
    }
}

/**
 * Применение свойства с «ленивой» инициализацией.
 * Поля с отложенной инициализацией больше не требуется инициализировать в конструкторе, даже если их типы поддерживают null.
 */
class MyTest1{
    private lateinit var myService: MyService    // Объявление свойства с типом, не поддерживающим null, без инициализации

    @Before
    fun setUp(){
        myService = MyService()     // инициализация в методе setUp такая же, как и раньше
    }

    @Test
    fun testAction(){       // обращение к свойству без лишних проверок на null
        Assert.assertEquals("foo", myService.performAction())
    }
}