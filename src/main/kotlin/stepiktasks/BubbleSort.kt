package stepiktasks


fun bubbleSort(inputList: List<String>): IntArray {
    var array = inputList.map { it.toInt() }.toIntArray()

    var isSorted = false

    while (!isSorted) {
        isSorted = true
        for (i in 0 until array.size - 1) {
            if (array[i] > array[i + 1]) {
                val temp = array[i + 1]
                array[i + 1] = array[i]
                array[i] = temp
                isSorted = false
            }
        }
    }
    return array
}

fun testBubbleSort(){
    val sample1 = listOf("5", "4", "3", "2", "1", "6", "7", "8", "9", "10")
    val sample2 = listOf("5", "4", "3", "2", "1", "6", "7", "2", "8", "9", "2", "10")
    println(bubbleSort(sample1).contentToString())
    println(bubbleSort(sample2).contentToString())
}