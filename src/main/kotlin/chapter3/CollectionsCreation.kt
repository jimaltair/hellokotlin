package chapter3

class KotlinCollections {
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    fun lastIndexInList() = list.last()
    fun maxElementInSet() = set.maxOrNull()
}
