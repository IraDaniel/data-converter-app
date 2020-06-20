package io.daniel.model;

import java.util.List;

public class FileParsedResult {

    private final String fileName;
    private final List<ParsedLine> parsedLines;

    public FileParsedResult(String fileName, List<ParsedLine> parsedLines) {
        this.fileName = fileName;
        this.parsedLines = parsedLines;
    }

    public String getFileName() {
        return fileName;
    }

    public List<ParsedLine> getParsedLines() {
        return parsedLines;
    }
}
