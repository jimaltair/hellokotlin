package javacode;

import chapter2.*;
import chapter3.MethodsAdditionToOutsideClassesKt;
import chapter3.PropertiesAdditionToOutsideClassesKt;
import chapter3.StringFunctions;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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

        var strings = List.of("a", "ab", "ccc", "abc", "zzz", "cd", "efk", "a");
        Collection<String> result = StepicTask_3_12.doSomethingStrangeWithCollection(strings);
        System.out.println(result.toString());
    }
}
