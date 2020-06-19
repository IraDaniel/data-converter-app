package io.daniel;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class CsvReader implements OrderReader {

    public List<OrderRequest> readOrders(String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new File(fileName);
            MappingIterator<OrderRequest> readValues =
                    mapper.reader(OrderRequest.class).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            System.out.println("Error occurred while loading object list from file " + fileName);
            return Collections.emptyList();
        }
    }

}
