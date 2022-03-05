package javacode;

/**
 * Java-класс без аннотаций, определяющих допустимость null
 */
public class JavaPerson {

    private final String name;

    public JavaPerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
