package io.daniel.readers;

import javax.activation.MimeType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public static void read(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("File %s not found", fileName));
        }

    }
}
