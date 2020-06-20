package io.daniel.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.daniel.model.OrderResponse;
import io.daniel.utils.ConverterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParserService {
    private static Logger logger = LoggerFactory.getLogger(ParserService.class);

    private final FileParser fileParser;

    public ParserService(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    public void process(String... fileNames) {
        fileParser.parseFiles(fileNames).forEach(parsedResult -> {
            List<OrderResponse> orderResponses = ConverterUtils.convert(parsedResult.getParsedLines(), parsedResult.getFileName());
            printResult(orderResponses);
        });
    }

    public static void printResult(List<OrderResponse> responses) {
        ObjectMapper objectMapper = new ObjectMapper();
        responses.forEach(response -> {
            try {
                System.out.println(objectMapper.writeValueAsString(response));
            } catch (JsonProcessingException e) {
                logger.error(e.getMessage(), e);
            }
        });
    }
}
