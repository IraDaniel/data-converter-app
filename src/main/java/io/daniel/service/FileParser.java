package io.daniel.service;

import io.daniel.model.AvailableType;
import io.daniel.model.FileParsedResult;
import io.daniel.model.ParsedLine;
import io.daniel.service.readers.OrderReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.daniel.utils.FileUtils.*;

@Component
public class FileParser {
    private static Logger logger = LoggerFactory.getLogger(FileParser.class);

    private final Map<AvailableType, OrderReader> orderReaderByFileType;

    public FileParser(List<OrderReader> orderReaders) {
        orderReaderByFileType = orderReaders.stream()
                .collect(Collectors.toMap(OrderReader::getFileType, Function.identity()));
    }

    public Stream<FileParsedResult> parseFiles(String[] fileNames) {
        return Stream.of(fileNames)
                .parallel()
                .map(fileName -> {
                    List<ParsedLine> parsedLines = parseFile(fileName);
                    return new FileParsedResult(fileName, parsedLines);
                });
    }

    private List<ParsedLine> parseFile(String fileName) {
        if (fileName == null) {
            return Collections.emptyList();
        }
        File file = getFile(fileName);
        if (isAvailableType(file)) {
            AvailableType type = getFileType(file);
            return orderReaderByFileType.get(type).readOrders(file);
        } else {
            logger.info("File {} cannot be parsed.", fileName);
        }
        return Collections.emptyList();
    }
}
