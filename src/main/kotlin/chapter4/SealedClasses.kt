package chapter4

/**
 * Реализация выражения как интерфейса
 */
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

/**
 * При вычислении выражения с использованием конструкции when компилятор Kotlin вынуждает добавить ветку,
 * выполняемую по умолчанию. В этом примере невозможно вернуть что-либо осмысленное, поэтому генерируется исключение.
 */
fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknown expression")        // необходимо также проверять ветку else
    }

/**
 * Выражения в виде запечатанных (sealed) классов. Достаточно добавить модификатор sealed в объявление суперкласса, и
 * он ограничит возможность создания подклассов. Прямые подклассы запечатанных классов и интерфейсов должны быть
 * объявлены в одном пакете. Никакие другие подклассы не могут появиться после компиляции модуля с запечатанным классом.
 */
sealed class Expression
class Number(val value: Int) : Expression()
class Summing (val left: Expression, val right: Expression) : Expression()

/**
 * При обработке всех подклассов запечатанного класса в выражении "when" нет необходимости в ветке по умолчанию.
 */
fun evaluate(e: Expression): Int =
    when (e) {
        is Number -> e.value
        is Summing -> evaluate(e.left) + evaluate(e.right)
    }

/**
 * Обратите внимание: модификатор sealed означает, что класс по умолчанию открыт, добавлять модификатор open не требуется.
 */
