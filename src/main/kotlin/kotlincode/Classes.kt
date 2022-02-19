package kotlincode

class Person1(val name: String)

//аналогично на Java
/*
public class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
 */

class Person(
    val name: String, // Неизменяемое свойство: для него будут созданы поле и простой метод чтени
    var isMarried: Boolean // Изменяемое свойство: поле, методы чтения и записи
)