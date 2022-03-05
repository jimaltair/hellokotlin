package chapter6

import chapter4.Person2
import chapter4.Person3
import chapter4.Person4
import chapter4.Person5
import kotlin.random.Random

/**
 * Функция let облегчает работу с выражениями, допускающими значение null. Вместе с оператором безопасного вызова она
 * позволяет вычислить выражение, проверить результат на null и сохранить его в переменной - и все это в одном коротком
 * выражении.
 */

/**
 * Эта функция написана на Kotlin и требует параметра, который не равен null:
 */
fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun testSendEmail() {
    val email: String? = "abc"
    /**
     * Вы не сможете передать в эту функцию значение типа с поддержкой null:
     */
//    sendEmailTo(email)        // компилятор ругается
    /**
     * Вы должны явно проверить, что значение не равно null:
     */
    if (email != null) sendEmailTo(email)
}

/**
 * Но можно пойти другим путем: применить функцию let, объединив её с оператором безопасного вызова. Функция let просто
 * превращает объект вызова в параметр лямбда-выражения. Объединяя её с синтаксисом безопасного вызова, вы фактически
 * преобразуете объект из типа с поддержкой null в тип без поддержки null
 *
 *  foo?.let { ...it... }  ---> foo != null ---> it внутри лямбда-выражения - не null
 *                         \
 *                          --> foo == null ---> ничего не произойдёт
 *
 * Безопасный вызов функции let выполнит лямбда-выражение, только если выражение не равно null
 */

fun testSendEmail1() {
    val email: String? = "abc"

    /**
     * Функция let будет вызвана, только если значение адреса электронной почты не равно null, поэтому его можно
     * использовать как аргумент лямбда-выражения, не равный null:
     */
    email?.let { email -> sendEmailTo(email) }
    email?.let { sendEmailTo(it) }              // так ещё короче
}

/**
 * Обратите внимание, что нотация let особенно удобна, когда нужно использовать значение большого выражения,
 * не равного null. В этом случае вам не придется создавать отдельную переменную.
 */
class Person6(val name: String, val email: String)

fun testLetKeyword() {
    fun getTheBestPersonInTheWorld(): Person6? {
        return if (Random(10).nextInt() == 10)
            Person6("Best person", "bestperson@mail.ru")
        else null
    }

    /**
     * Сравните следующий фрагмент с явной проверкой:
     */
    val person: Person6? = getTheBestPersonInTheWorld()
    if (person != null) sendEmailTo(person.email)

    /**
     * С аналогичной реализацией без дополнительной переменной:
     */
    getTheBestPersonInTheWorld()?.let { sendEmailTo(it.email) }

}



