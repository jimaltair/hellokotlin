package chapter2

class Functions {
    // функция с телом-блоком
    fun max1(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    // функция с телом-выражением
    fun max2(a: Int, b: Int) = if (a > b) a else b
}