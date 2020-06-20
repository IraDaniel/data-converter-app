package io.daniel;

import io.daniel.service.ParserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    private ParserService parserService;

    public SpringBootConsoleApplication(ParserService parserService) {
        this.parserService = parserService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        parserService.process(args);
    }
}
