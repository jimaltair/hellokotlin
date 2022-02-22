/**
 * Чтобы изменить имя класса с Kotlin-функциями верхнего уровня, нужно добавить в файл аннотацию @JvmName.
 * Поместите её в начало файла перед именем пакета. По этому имени можно будет вызывать функцию из Java-кода, как буд-то
 * это название статического класса, в котором располагается данная функция.
 */
@file: JvmName("StringFunctions")

package kotlincode

/**
 * так можно объявить константу (слово const нужно для корректного доступа из Java-кода
 */
const val UNIX_LINE_SEPARATOR = "\n"

/**
 * Собственная реализация функции toString для коллекции.
 * Аннотация @JvmOverloads подсказывает компилятору Kotlin создавать перегрузки данной функции, для того чтобы заменять
 * значения параметров по умолчанию (для вызова функции из Java-кода)
 */
@JvmOverloads
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",       // параметры со значениями по умолчанию, в Java такое отсутствует
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0)
            result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

/**
 * Как и функции, свойства можно объявлять на верхнем уровне файла, не привязываясь к какому-либо классу
 *
 */
var counter = 0
fun performOperation(times: Int) {
    for (i in 0 until times){
        counter++
    }
    println("Operation was performed $counter times")
}