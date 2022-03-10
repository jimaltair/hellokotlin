package chapter7

import chapter5.p
import kotlin.reflect.KProperty

/**
 * Свойство "p" делегирует логику своих методов доступа другому объекту: в данном случае новому экземпляру класса Delegate.
 * Экземпляр создается выражением, следующим за ключевым словом by, и может быть чем угодно, удовлетворяющим требованиям
 * соглашения для делегирования свойств.
 */
class Example {
    var p: String by Delegate()     // ключевое слово "by" связывает свойство с объектом-делегатом
}

/**
 * В соответствии с соглашением класс Delegate должен иметь методы getValue и setValue (последний требуется только
 * для изменяемых свойств).
 */
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {      // логика метода чтения
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {       // логика метода записи
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

fun testPropertiesDelegation() {
    val example = Example()
    /**
     * Обращение к свойству example.p приводит к вызову delegate.getvalue(...) за кулисами
     */
    println(example.p)

    /**
     * Операция изменения значения свойства вызывает delegate.setValue(...)
     */
    example.p = "NEW"
}

/**
 * Отложенная инициализация (lazy initialization) - распространенный шаблон, позволяющий отложить создание объекта до
 * момента, когда он действительно потребуется. Это может пригодиться, когда процесс инициализации потребляет
 * значительные ресурсы или данные в объекте могут не требоваться.
 */

/**
 * Здесь используется приём на основе так называемого теневого свойства (backing property). У нас имеются свойство _emails,
 * хранящее значение, и свойство emails, открывающее доступ к нему для чтения. Мы вынуждены использовать два свойства,
 * потому что они имеют два разных типа: _emails может хранить значение null, a emails - нет.
 */
data class Email(val email: String)

fun loadEmails(person: Person1): List<Email> {
    println("Load emails for ${person.name}")
    return listOf(Email("person@mail.ru"), Email("zzzpersonxxx@mail.ru"))
}

class Person1(val name: String) {
    /**
     * Свойство «_emails», хранящее данные и которому делегируется логика работы свойства «emails»
     */
    private var _emails: List<Email>? = null
    val emails: List<Email>
        get() {
            if (_emails == null) {      // загрузка данных при первом обращении
                _emails = loadEmails(this)
            }
            return _emails!!        // если данные уже загружены, вернуть их
        }
}

fun testLazyInitializationForPerson1() {
    val person = Person1("Alice")
    println(person.emails)       // загрузка адресов при первом обращении
    println(person.emails)       // здесь уже не происходит обращение к функции loadEmail, а просто возвращается сама переменная
}

/**
 * Код станет намного проще, если использовать делегированные свойства, инкапсулирующие теневые свойства для хранения
 * значений и логику, гарантирующую инициализацию свойств только один раз. В данном случае можно использовать делегата,
 * возвращаемого функцией lazy из стандартной библиотеки.
 */
class Person2(val name: String) {
    val emails by lazy { loadEmails2(this) }
}

fun loadEmails2(person: Person2): List<Email> {
    println("Load emails for ${person.name}")
    return listOf(Email("person@mail.ru"), Email("zzzpersonxxx@mail.ru"))
}

fun testLazyInitializationForPerson2() {
    val person = Person2("Bob")
    println(person.emails)
    println(person.emails)
}

/**
 * Сохранение значений свойств в словаре.
 *
 * Кроме всего прочего, делегирование свойств широко применяется в объектах с динамически определяемым набором атрибутов.
 * Такие объекты иногда называют расширяемыми объектами (expando objects).
 */

/**
 * Определение свойства, хранящего свое значение в словаре.
 */
class Person3 {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String
        get() = _attributes["name"]!!       // извлечение атрибута из словаря вручную
}

fun testPerson3Atributes() {
    var person3 = Person3()
    val data = mapOf("name" to "Dmitry", "company" to "JetBrains")
    for ((attrName, value) in data) {
        person3.setAttribute(attrName, value)
    }
    println(person3.name)
}

/**
 * Делегированное свойство, хранящее свое значение в словаре.
 *
 * Это возможно благодаря тому, что в стандартной библиотеке определены функции-расширения getValue и setValue для
 * стандартных интерфейсов Мар и MutableMap. Имя свойства автоматически используется как ключ для доступа к значению
 * в словаре.
 */
class Person4 {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String by _attributes     // использование словаря в роли объекта-делегата
}