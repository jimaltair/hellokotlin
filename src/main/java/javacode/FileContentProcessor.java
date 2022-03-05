package javacode;

import java.io.File;
import java.util.List;

/**
 * Интерфейс Java с коллекцией в качестве параметра
 */
public interface FileContentProcessor {
    void processContents(File path, byte[] binaryContents, List<String> textContents);
}
