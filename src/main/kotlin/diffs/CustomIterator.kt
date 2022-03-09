package diffs

import java.time.LocalDate

/**
 * Свой класс даты, повторяющий java.time.LocalDate
 */
data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        when {
            year > other.year -> return 1
            year < other.year -> return -1

            month > other.month -> return 1
            month < other.month -> return -1

            dayOfMonth > other.dayOfMonth -> return 1
            dayOfMonth < other.dayOfMonth -> return -1
        }
        return 0
    }
}

/**
 * метод, позволяющий использовать оператор ".." для указания диапазона
 */
operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

/**
 * имплементируем интерфейс Iterable для того чтобы можно было итерироваться по диапазону MyDate
 */
class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var current: MyDate = start

            override fun hasNext(): Boolean = current <= end

            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                var result = current
                current = MyDate(current.year, current.month, current.dayOfMonth + 1)
                return result
            }

        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}

fun testCustomForLoop(){
    iterateOverDateRange(MyDate(2022, 1,1), MyDate(2022, 1, 31), ::println)
}