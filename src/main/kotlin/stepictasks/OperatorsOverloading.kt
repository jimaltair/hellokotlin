package stepictasks

import stepictasks.TimeInterval.*
import java.time.LocalDate
import java.util.*


data class MyDate1(val year: Int, val month: Int, val dayOfMonth: Int)

/**
 * В данном классе перегружаем оператор "*" с помощью operator fun a.times(b)
 */
enum class TimeInterval {

    DAY {
        override var times = 1
    },
    WEEK {
        override var times = 1
    },
    YEAR {
        override var times = 1
    };

    abstract var times: Int
    operator fun times(i: Int): TimeInterval{
        times = i
        return this
    }
}

/**
 * В данном классе перегружаем оператор "+" с помощью operator fun a.plus(b)
 */
operator fun MyDate1.plus(timeInterval: TimeInterval) = this.addTimeIntervals(timeInterval, timeInterval.times)

/**
 * Утилитная функция, позволяющая прибавлять временные интервалы к нашему классу даты
 */
fun MyDate1.addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate1 {
    val calendar = Calendar.getInstance()
    calendar.set(year, month, dayOfMonth)
    when (timeInterval) {
        DAY -> calendar.add(Calendar.DAY_OF_MONTH, number)
        WEEK -> calendar.add(Calendar.WEEK_OF_MONTH, number)
        YEAR -> calendar.add(Calendar.YEAR, number)
    }
    return MyDate1(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
}

fun task1(today: MyDate1): MyDate1 {
    return today + YEAR + WEEK
}

fun task2(today: MyDate1): MyDate1 {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}

fun testOperatorOverloading() {
    val date = LocalDate.now()
    val testDate = MyDate1(date.year, date.monthValue, date.dayOfMonth)
    println(task1(testDate))
    println(task2(testDate))
}