package io.daniel.service.readers;

import io.daniel.SpringBootCommonTest;
import io.daniel.model.Order;
import io.daniel.model.ParsedLine;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.List;

@RunWith(SpringRunner.class)
public class CsvReaderTest extends SpringBootCommonTest {

    @Autowired
    private CsvReader csvReader;

    @Test
    public void shouldParseFileWithCsvList() {
        File file = new File("src/test/resources/input_correct_csv.csv");
        List<ParsedLine> lines = csvReader.readOrders(file);
        Assert.assertEquals(2, lines.size());
        Order expected = new Order(1, 100, "USD", "tt");
        Assert.assertEquals(expected, lines.get(0).getOrder());
    }

}
