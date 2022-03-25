package metrics

import org.http4k.client.JavaHttpClient
import org.http4k.core.*
import kotlin.random.Random

/**
 * Тестовый клиент - делает запросы по указанному URI с определённой задержкой. Ответ можно вывести в консоль
 * или обработать иным образом по своему желанию.
 */
private const val CALLING_URI = "https://pokeapi.co/api/v2/pokemon"
private const val DEFAULT_TIME_GENERATOR_UPPER_BOUND = 1000L
private const val DEFAULT_DOWNLOADED_POKEMONS_UPPER_BOUND = 100

fun main() {
    testClientEngine()
}

private fun testClientEngine() {
    //    val http = Debug().then(JavaHttpClient())       // с выводом полученного ответа в консоль
    val client = JavaHttpClient()       // а здесь ничего не делаем
    while (true) {
        val request = Request(Method.GET, CALLING_URI)
            .query("limit", getRandomCountOfPokemons().toString())
        val response: Response = client(request)
        val body: String = response.bodyString()
        val status: String = response.status.toString()
        println(status)
        // имитируем перерывы между запросами по сети
        Thread.sleep(getRandomTime())
    }
}

/**
 * Позволяет выводить ответ в консоль
 */
fun Debug() = Filter { next ->
    { request ->
        next(request).also { response -> println(response) }
    }
}

fun getRandomTime(): Long {
    return Random.nextLong(DEFAULT_TIME_GENERATOR_UPPER_BOUND)
}

fun getRandomCountOfPokemons(): Int {
    return Random.nextInt(DEFAULT_DOWNLOADED_POKEMONS_UPPER_BOUND)
}