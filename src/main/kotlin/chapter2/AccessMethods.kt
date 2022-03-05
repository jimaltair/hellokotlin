package chapter2

import kotlin.random.Random

// как написать собственную реализацию метода доступа к свойству
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {                         // <- Объявление метода чтения для свойства
            return height == width
        }

}

fun createRandomRectangle(): Rectangle {
    return Rectangle(Random.nextInt(0, 100), Random.nextInt(0, 100))
}
