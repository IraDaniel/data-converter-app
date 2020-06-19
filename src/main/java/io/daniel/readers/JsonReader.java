package io.daniel;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JsonReader implements OrderReader{

    public List<OrderRequest> readOrders(String fileName) {
        try {
            OrderRequest[] request = new ObjectMapper().readValue(new File(fileName), OrderRequest[].class);
            return Arrays.asList(request);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
