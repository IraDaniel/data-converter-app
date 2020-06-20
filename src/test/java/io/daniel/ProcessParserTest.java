package io.daniel;

import io.daniel.service.ParserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ProcessParserTest extends SpringBootCommonTest {

    @Autowired
    private ParserService parserService;

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfAnyFileNotFound(){
        parserService.process("file1", "file2");
    }

}
