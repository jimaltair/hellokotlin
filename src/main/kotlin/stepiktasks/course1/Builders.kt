package stepiktasks

import java.util.*

/**
 * You can declare isEven and isOdd as values, that can be called as extension functions. Complete the declarations below.
 */
fun task(): List<Boolean> {
    val isEven: Int.() -> Boolean = { this % 2 == 0 }
    val isOdd: Int.() -> Boolean = { this % 2 != 0 }

    return listOf(42.isOdd(), 239.isOdd(), 294823098.isEven())
}

/**
 * Add and implement the function 'buildMap' with one parameter (of type extension function) creating a new HashMap,
 * building it and returning it as a result. The usage of this function is shown below.
 */
fun usage(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}

fun <K, V> buildMap(build: HashMap<K, V>.() -> Unit): HashMap<K, V> {
    val hashMap = HashMap<K, V>()
    hashMap.build()
    return hashMap
}

fun <K, V> buildMap(build: MutableMap<K, V>.() -> Unit): Map<K, V> = HashMap<K, V>().apply { build() }

/**
 * The previous examples can be rewritten using the library function apply (see examples below).
 * Write your own implementation of this function named 'myApply'.
 */
fun <T> T.myApply(f: T.() -> Unit): T {
    f()
    return this
}

fun createString(): String {
    return StringBuilder().myApply {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }.toString()
}

fun createMap(): Map<Int, String> {
    return hashMapOf<Int, String>().myApply {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
