package io.daniel.utils;

import io.daniel.model.Order;
import io.daniel.model.ParsedLine;
import io.daniel.model.OrderResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ConverterUtils {

    public static List<OrderResponse> convert(List<ParsedLine> parsedLines, String fileName) {
        return parsedLines.stream()
                .map(parsedLine -> toOrderResponse(fileName, parsedLine))
                .collect(Collectors.toList());
    }

    private static OrderResponse toOrderResponse(String fileName, ParsedLine parsedLine) {
        Order request = parsedLine.getOrder();
        if (parsedLine.isSuccess()) {
            return new OrderResponse(request.getOrderId(), request.getAmount(),
                    request.getComment(), fileName, parsedLine.getLine(), parsedLine.getResult());
        } else {
            return new OrderResponse(null, null, null, fileName,
                    parsedLine.getLine(), parsedLine.getResult());
        }
    }

    private ConverterUtils() {
    }
}
