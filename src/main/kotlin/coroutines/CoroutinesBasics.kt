package coroutines

import kotlinx.coroutines.*
import java.time.Instant
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime


suspend fun main() {
//    launchManyCoroutines()
//    doWorld()
    sequentialCoroutineExecution()
    parallelCoroutineExecution()
}

suspend fun launchManyCoroutines() = runBlocking {
    repeat(100_000) { // launch a lot of coroutines
        launch {
            delay(5000L)
            print(".")
        }
    }
}

// Concurrently executes both sections
suspend fun doWorld() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}

// код в корутинах по умолчанию является последовательным
suspend fun sequentialCoroutineExecution() = coroutineScope {
    val time = measureTimeMillis {
        val one = doSomethingOne()
        val two = doSomethingTwo()
    }
    println("Выполнено за $time ms")
}

// если необходимо, мы можем запустить параллельное выполнение корутин
suspend fun parallelCoroutineExecution() = coroutineScope {
    val time = measureTimeMillis {
        val one = async { doSomethingOne() }
        val two = async { doSomethingTwo() }
        joinAll(one, two)
    }
    println("Выполнено за $time ms")
}

suspend fun doSomethingOne() {
    println("Функция №1 начала свою работу...")
    delay(1000)
    println("Функция №1 отработала")
}

suspend fun doSomethingTwo() {
    println("Функция №2 начала свою работу...")
    delay(2000)
    println("Функция №2 отработала")
}

