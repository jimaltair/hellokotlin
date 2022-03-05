package javacode;

import java.util.List;

/**
 * Другой интерфейс Java с коллекцией в качестве параметра
 */
public interface DataParser<T> {
    void parseData(String input, List<T> output, List<String> errors);
}
