import kotlincode.Person
import kotlincode.Rectangle
import kotlincode.createRandomRectangle

fun main(args: Array<String>) {
//    println("Hello Kotlin!")

//    println(kotlincode.Functions().max1(10, 20))
//    println(kotlincode.Functions().max2(10, 20))

//    println(kotlincode.Variables().compareAndPrintMessage(10, 20))
//    println(kotlincode.Variables().compareAndPrintMessage(20, 10))

//    println(kotlincode.StringFormatting().formatString(arrayOf("Bob")))
//    println(kotlincode.StringFormatting().formatString(arrayOf()))

//    val person = Person("Bob", true)
//    println(person.name) // Конструктор вызывается без ключевого слова «new»
//    println(person.isMarried) // Прямое обращение к свойству, но при этом вызывается метод чтения

//    val rectangle = Rectangle(41, 43)
//    println(rectangle.isSquare)

    val rectangle = createRandomRectangle()
    println("height = ${rectangle.height} width = ${rectangle.width}")

}
