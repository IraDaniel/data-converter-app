package io.daniel.utils;

import io.daniel.model.AvailableType;
import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileUtils {

    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    private static final Tika MIME_TYPE_DETECTOR = new Tika();
    public static final Set<String> AVAILABLE_TYPES = new HashSet<>();

    static {
        AVAILABLE_TYPES.add("application/json");
        AVAILABLE_TYPES.add("text/csv");
    }

    public static File getFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("File %s not found", fileName));
        }
        return file;
    }

    public static boolean isAvailableType(File file) {
        try {
            String detectedMimeType = MIME_TYPE_DETECTOR.detect(file);
            return AVAILABLE_TYPES.contains(detectedMimeType);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    public static AvailableType getFileType(File file) {
        try {
            String detectedMimeType = MIME_TYPE_DETECTOR.detect(file);
            return AvailableType.fromMimeType(detectedMimeType);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
           return null;
        }
    }

    private FileUtils() {
    }
}
