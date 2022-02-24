package javacode;

import kotlincode.chapter2.*;
import kotlincode.chapter3.MethodsAdditionToOutsideClassesKt;
import kotlincode.chapter3.PropertiesAdditionToOutsideClassesKt;
import kotlincode.chapter3.StringFunctions;


import java.util.List;

// TODO: разобраться почему не запускается
public class Main {
    public static void main(String[] args) {
        /**
         * Этот код не зависит от того, на каком языке определен класс Person - Java или Kotlin
         */
        Person person = new Person("Bob", true);
        System.out.println(person);

        Rectangle rectangle = new Rectangle(41, 43);
        System.out.println(rectangle.isSquare());

        List<Integer> numbers = List.of(1, 10, 100);
        /**
         * Такой вызов функции возможен благодаря аннотации @JvmOverloads над соответствующей функцией
         */
        StringFunctions.joinToString(numbers);

        /**
         * Вызываем функцию-расширение из Kotlin-кода как обычный статический метод по названию файла
         */
        MethodsAdditionToOutsideClassesKt.lastChar("some string");
        /**
         * чтобы обратиться к свойству-расширению из Java, нужно явно вызывать его метод чтения:
         */
        PropertiesAdditionToOutsideClassesKt.getLastChar("Java");
    }
}
