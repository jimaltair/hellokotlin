package kotlincode.chapter4

/**
 * Пример, сколько кода понадобится декоратору, чтобы реализовать простой интерфейс Collection - даже притом,
 * что он не изменяет поведения исходного класса.
 */
class DelegatingCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>()

    override val size: Int get() = innerList.size

    override fun contains(element: T) = innerList.contains(element)

    override fun containsAll(elements: Collection<T>) = innerList.containsAll(elements)

    override fun isEmpty() = innerList.isEmpty()

    override fun iterator() = innerList.listIterator()
}

/**
 * При использовании Kotlin писать столько кода не нужно, потому что он предоставляет полноценную поддержку
 * делегирования на уровне языка. Всякий раз, реализуя интерфейс, вы можете делегировать реализацию другому объекту,
 * добавив ключевое слово "by". Вот как выглядит предыдущий пример с использованием этой особенности:
 */
class DelegatingCollection1<T>(innerList: Collection<T> = ArrayList()) : Collection<T> by innerList
/**
 * Все реализации методов в классе исчезли. Компилятор сам сгенерирует их, и фактическая реализация будет похожа на ту,
 * что вы видели в примере с DelegatingCollection. Поскольку такой код содержит мало интересного, нет смысла писать его
 * вручную, если компилятор может делать всё то же самое автоматически.
 */

/**
 * Давайте посмотрим, как применить эту технику для реализации коллекции, которая подсчитывает количество попыток
 * добавления элементов в неё.
 */
class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet()) : MutableCollection<T> by innerSet {
    var objectsAdded = 0
    override fun add(element: T): Boolean {     // собственная реализация вместо делегирования
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {     // собственная реализация вместо делегирования
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}