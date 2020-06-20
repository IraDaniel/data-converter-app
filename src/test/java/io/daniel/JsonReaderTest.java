package io.daniel;

import io.daniel.model.Order;
import io.daniel.model.ParsedLine;
import io.daniel.readers.JsonReader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.List;

@RunWith(SpringRunner.class)
public class JsonReaderTest extends SpringBootCommonTest {

    @Autowired
    private JsonReader jsonReader;

    @Test
    public void shouldParseFileWithJsonList() {
        File file = new File("src/test/resources/input_correct.json");
        List<ParsedLine> lines = jsonReader.readOrders(file);
        Assert.assertEquals(2, lines.size());
        Order expected = new Order(1, 100, "USD", "order");
        Assert.assertEquals(expected, lines.get(0).getOrder());
    }
}
