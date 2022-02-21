package kotlincode

interface Expr  // маркерный интерфейс, играет роль общего типа для различных видов выражений
class Num(val value: Int) : Expr     // простой класс объектов-значений с одним св-вом value, реализ. интерфейс Expr
class Sum(val left: Expr, val right: Expr) :
    Expr    // Аргументами операции Sum могут быть любые экземпляры Ехрг: Num или другой объект Sum

/**
 * Вычисление выражения с помощью каскада операторов if (реализация в стиле Java)
 */
fun evalJavaStyle(e: Expr): Int {
    if (e is Num) {
        val n = e as Num    // Явное приведение к типу Num здесь излишнее
        return n.value
    }
    if (e is Sum) {
        return evalJavaStyle(e.left) + evalJavaStyle(e.right)     // Переменная e уже приведена к нужному типу!
    }
    throw IllegalArgumentException("Unknown expression")
}

/**
 * Использование выражения if, возвращающего значения (реализация в стиле Kotlin)
 */
fun evalKotlinStyleIf(e: Expr): Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        evalKotlinStyleIf(e.left) + evalKotlinStyleIf(e.right)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }

/**
 * Использование when вместо каскада выражений if (реализация в стиле Kotlin)
 */
fun evalKotlinStyleWhen(e: Expr): Int =
    when (e) {
        is Num -> e.value   // Ветка «when» проверяет тип аргумента и использует автоматическое приведение типов
        is Sum -> evalKotlinStyleWhen(e.left) + evalKotlinStyleWhen(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

/**
 * Оба выражения - if и when - позволяют определять ветви в виде блоков.
 * Результатом такой ветви станет результат последнего выражения в блоке.
 */
fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value              // это последнее выражение в блоке, функция вернет его значение, если е имеет тип Num
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right        // функция вернёт это выражение если e имеет тип Sum
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }
/**
 * Правило «последнее выражение в блоке является результатом» действует всегда, когда используется блок и ожидается результат.
 * Это правило не выполняется для обычных функций. Функция может обладать телом-выражением, которое не может быть блоком,
 * или телом-блоком с оператором return внутри.
 */

