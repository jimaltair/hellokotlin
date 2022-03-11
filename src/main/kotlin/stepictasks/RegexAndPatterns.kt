package stepictasks

import java.util.regex.Pattern

const val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"
fun getPattern(): String = """\d{2}[ ]$month[ ]\d{4}"""

fun someStringMatchPattern(input: String): Boolean {
    val pattern = Pattern.compile(getPattern())
    val matcher = pattern.matcher(input)
    return matcher.matches()
}

fun testRegex(){
    println(someStringMatchPattern("13 JUN 1992"))
}