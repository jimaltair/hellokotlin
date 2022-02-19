package javacode;

import kotlincode.Person;
import kotlincode.Rectangle;

//TODO: разобраться почему не запускается
public class Main {
    // этот код не зависит от того, на каком языке определен класс Person - Java или Kotlin
    public static void main(String[] args) {
        Person person = new Person("Bob", true);
        System.out.println(person);

        Rectangle rectangle = new Rectangle(41, 43);
        System.out.println(rectangle.isSquare());
    }
}
