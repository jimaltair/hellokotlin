package chapter2

class StringFormatting {
    // Выведет «Hello, Kotlin!» или «Hello, Bob!», если передать аргумент со строкой «Bob»
    fun formatString(args: Array<String>): String {
        val name = if (args.size > 0) args[0] else "Kotlin"
        return ("Hello, $name!")
    }
}