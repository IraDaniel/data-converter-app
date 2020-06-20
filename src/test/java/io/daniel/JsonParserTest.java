package io.daniel;

import io.daniel.model.Order;
import io.daniel.model.ParsedLine;
import io.daniel.readers.JsonReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class JsonParserTest {

    @Test
    public void shouldParseFileWithJsonList(){
        JsonReader jsonReader = new JsonReader();
        File file = new File("input.json");
        List<ParsedLine> lines = jsonReader.readOrders(file);
        Assert.assertEquals( 2, lines.size());
        Order expected = new Order(1, 100, "USD", "оплата заказа");
        Assert.assertEquals(expected, lines.get(0).getOrder());
    }
}
