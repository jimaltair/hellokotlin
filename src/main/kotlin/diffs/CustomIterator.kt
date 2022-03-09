package diffs

import java.time.Instant
import java.time.LocalDate
import java.util.*
import kotlin.NoSuchElementException

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
 * Перегружаем оператор ".." с помощью operator fun a.rangeTo(b)
 */
operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

/**
 * Имплементируем интерфейс Iterable для того чтобы можно было итерироваться по диапазону MyDate
 */
class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var current: MyDate = start

            override fun hasNext(): Boolean = current <= end

            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                var result = current

                val calendar = Calendar.getInstance()
                calendar.set(current.year, current.month, current.dayOfMonth)
                calendar.add(Calendar.DAY_OF_MONTH, 1)

                current = MyDate(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH))
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

fun testCustomForLoop() {
    iterateOverDateRange(MyDate(2022, 1, 1), MyDate(2022, 2, 15), ::println)
}