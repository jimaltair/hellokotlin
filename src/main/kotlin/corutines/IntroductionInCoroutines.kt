package corutines

import kotlinx.coroutines.*

/**
 * Функция main должна явно вернуть Unit, чтобы мы могли её запустить без ошибки. Есть три варианта:
 * 1. Типизировать функцию coroutineScope типом Unit.
 * 2. Явным образом возвратить в конце тип Unit
 * 3. Выполнить ещё какой-то код, к примеру, вывести строку в консоль
 */
var result: Double? = null

suspend fun main() {
//    firstExample()
//    secondExample()
    thirdExample()
}


suspend fun firstExample() {
    coroutineScope {
        launch { result = doWork1() }
        launch { doWork2() }
//        delay(4000L)   // без этой паузы result = null, с ней - переменная result проинициализируется функцией doWork1()
        println(result)
    }
}

suspend fun secondExample() {
    coroutineScope {
        val job = async { result = doWork1() }
        async { doWork2() }
        job.await()         // выполнение кода приостановится на данной строке, пока не будет выполнен job
        println(result)
    }
}

suspend fun thirdExample(){
    coroutineScope {
        val job = async { result = doWork1() }.invokeOnCompletion { println(result) }   // после завершения напечатает result
        async { doWork2() }
    }
}

/**
 * Функция без использования корутин
 */
suspend fun withoutCoroutines() {
    for (i in 0..5) {
        delay(400L)
        println(i)
    }
    println("Hello, my master!")
}

suspend fun doWork1(): Double {
    val x = 10.0 / 20.0
    for (i in 0..5) {
        println(i)
        delay(400L)
    }
    println("doWork1() is ended")
    return x
}

suspend fun doWork2() {
    for (i in 1000..1005) {
        println(i)
        delay(400L)
    }
    println("doWork2() is ended")
}

