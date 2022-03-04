package kotlincode.chapter6

/**
 * Вызов функции-расширения с получателем, тип которого поддерживает null
 */
fun String?.isNullOrBlank(): Boolean =      // Расширение для типа String с поддержкой null
    this == null || this.isBlank()      // Во втором обращении к «this» применяется автоматическое приведение типов

fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank())           // не требуется использовать оператор безопасного вызова
        println("Please fill in the required fields")

    val person: Person6? =Person6("Bob", "bob@gmail.com")
//    person.let { sendEmailTo(it.email) }    // небезопасный вызов, потому что "it" может оказаться равным null
    person?.let { sendEmailTo(it.email) }
}

fun testVerifyUserInput() {
    verifyUserInput(" ")
    /**
     * Если вызвать isNulLOrBlank c null в качестве получателя, зто не приведет к исключению
     */
    verifyUserInput(null)
}