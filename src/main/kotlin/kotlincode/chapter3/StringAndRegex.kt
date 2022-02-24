package kotlincode.chapter3

/**
 * Многие заблуждаются, полагая, что вызов " 12.345-6.А".split(".") вернет массив [12, 345-6, А]. Но в Java он вернет
 * пустой массив! Это происходит потому, что split ожидает получить регулярное выражение и разбивает строку на несколько
 * частей согласно этому выражению. В этом контексте точка (.) - регулярное выражение, соответствующее любому символу.
 */

/**
 * Вот как можно разделить строку с точкой или тире:
 */
fun splitStringWithRegex(string: String) {
    println(string.split("\\.|-".toRegex()))        // явная передача регулярного выражения
}

/**
 * Другая перегруженная версия split в Kotlin принимает произвольное число разделителей в виде обычных строк:
 */
fun splitStringWithDelimeters(string: String) {
    println(string.split(".", "-"))         // передача нескольких разделителей
}

/**
 * Разбиение пути файла на компоненты: каталог, имя файла и расширение с помощью функций substringBeforeLast и
 * substringAfterLast
 */
fun parsePath(path: String) {
    val directory = path.substringBeforeLast("\\")
    val fullName = path.substringAfterLast("\\")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

/**
 * Использование регулярных выражений для разбора пути к файлу.
 * В этом примере регулярное выражение записано в тройных кавычках. В такой строке не нужно экранировать символы,
 * включая обратную косую черту, поэтому литерал точки можно описать как \. вместо \\. в обычных строковых литералах.
 */
fun parsePathWithRegex(path: String) {
    val regex = """(.+)\\(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured     // мультидекларация переменных
        println("Dir: $directory, name: $fileName, ext: $extension")
    }
}

/**
 * Создадим ASCII-рисунок.
 * Тройные кавычки нужны не только для того, чтобы избавиться от необходимости экранировать символы. Такой строковый
 * литерал может содержать любые символы, включая переносы строк. Это создает простой способ встраивания в программу
 * текста, содержащего переносы строк.
 */
fun printKotlinLogo() {
    val kotlinLogo = """| //
                       .|//
                       .|/ \"""
    println(kotlinLogo.trimMargin("."))
}

/**
 * В многострочных литералах тоже можно использовать шаблоны. Знак $ не нуждается в экранировании
 */
fun printPrice() {
    val price = 99.9
    println("""Price: $$price""")
}











