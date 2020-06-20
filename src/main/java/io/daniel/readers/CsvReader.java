package io.daniel.readers;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import io.daniel.model.AvailableType;
import io.daniel.model.Order;
import io.daniel.model.ParsedLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CsvReader implements OrderReader {

    private static Logger logger = LoggerFactory.getLogger(CsvReader.class);

    private final CsvMapper mapper;

    public CsvReader() {
        mapper = new CsvMapper();
    }

    @Override
    public List<ParsedLine> readOrders(File file) {
        try {
            MappingIterator<Order> readValues = mapper.readerWithTypedSchemaFor(Order.class).readValues(file);
            List<ParsedLine> parsedResult = new ArrayList<>();
            AtomicInteger lineNumber = new AtomicInteger(0);
            while (readValues.hasNext()) {
                try {
                    Order order = readValues.next();
                    parsedResult.add(ParsedLine.success(order, lineNumber.incrementAndGet()));
                } catch (Exception e) {
                    parsedResult.add(ParsedLine.fail(e.getMessage(), lineNumber.incrementAndGet()));
                    logger.error(e.getMessage(), e);
                }
            }
           return parsedResult;
        } catch (Exception e) {
            logger.error("Error occurred while loading object list from file " + file.getName(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public AvailableType getFileType() {
        return AvailableType.CSV;
    }
}
