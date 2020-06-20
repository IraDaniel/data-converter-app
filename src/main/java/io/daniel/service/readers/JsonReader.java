package io.daniel.service.readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.daniel.model.AvailableType;
import io.daniel.model.Order;
import io.daniel.model.ParsedLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class JsonReader implements OrderReader {

    private static Logger logger = LoggerFactory.getLogger(JsonReader.class);

    private final ObjectMapper objectMapper;

    public JsonReader() {
        objectMapper = new ObjectMapper();
    }

    public List<ParsedLine> readOrders(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            AtomicInteger lineNumber = new AtomicInteger(0);
            return reader.lines()
                    .map(line -> parseLine(line, lineNumber.incrementAndGet()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    private ParsedLine parseLine(String line, int lineNumber) {
        try {
            Order order = objectMapper.readValue(line, Order.class);
            return ParsedLine.success(order, lineNumber);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ParsedLine.fail(e.getLocalizedMessage(), lineNumber);
        }
    }

    @Override
    public AvailableType getFileType() {
        return AvailableType.JSON;
    }
}
