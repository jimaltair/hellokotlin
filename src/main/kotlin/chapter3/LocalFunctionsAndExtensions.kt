package chapter3

/**
 * Функция с повторяющимся кодом
 */
class User(val id: Int, val name: String, val address: String)

/**
 * здесь происходит дублирование полей
 */
fun saveUserJavaStyle(user: User) {
    if (user.name.isEmpty()) {      // дублируется проверка полей
        throw IllegalArgumentException("Can't save user with id=${user.id}: empty Name")
    }
    if (user.address.isEmpty()) {      // дублируется проверка полей
        throw IllegalArgumentException("Can't save user with id=${user.id}: empty Address")
    }
    // сохраняем информацию о пользователе в базе данных
}

/**
 * Извлечение локальной функции для предотвращения дублирования.
 */
fun saveUserBeforeRefactoring(user: User) {
    fun validate(
        user: User,        // объявление локальной функции для проверки произовльного поля
        value: String,
        fieldName: String
    ) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user with id=${user.id}: empty $fieldName")
        }
    }
    validate(user, user.name, "Name")       // вызов функции для проверки конкретных полей
    validate(user, user.address, "Address")

    // сохраняем информацию о пользователе в базе данных
}

/**
 * Локальные функции имеют доступ ко всем параметрам и переменным охватывающей функции
 */
fun saveUserAfterRefactoring(user: User) {
    fun validate(value: String, fieldName: String) {    // теперь не нужно дублировать параметр user в функции saveUser
        if (value.isEmpty()) {      // можно напрямую обращаться к параметром внешней функции
            throw IllegalArgumentException("Can't save user with id=${user.id}: empty $fieldName")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")

    // сохраняем информацию о пользователе в базе данных
}

/**
 * Перемещение логики в функцию-расширение
 */
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {      // к свойствам класса User можно обращаться напрямую
            throw IllegalArgumentException("Can't save user with id=${id}: empty $fieldName")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()       // вызов функции расширения
    // сохраняем информацию о пользователе в базе данных
}