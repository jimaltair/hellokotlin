package javacode;

import kotlincode.chapter2.*;
import kotlincode.chapter3.StringFunctions;


import java.util.List;

// TODO: разобраться почему не запускается
public class Main {
    // этот код не зависит от того, на каком языке определен класс Person - Java или Kotlin
    public static void main(String[] args) {
        Person person = new Person("Bob", true);
        System.out.println(person);

        Rectangle rectangle = new Rectangle(41, 43);
        System.out.println(rectangle.isSquare());

        List<Integer> numbers = List.of(1, 10, 100);
        /**
         * такой вызов функции возможен благодаря аннотации @JvmOverloads над соответствующей функцией
         */
        StringFunctions.joinToString(numbers);
    }
}
