package io.daniel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderResponse {
    @JsonProperty("id")
    private final Long id;
    @JsonProperty("amount")
    private final Long amount;
    @JsonProperty("comment")
    private final String comment;
    @JsonProperty("fileName")
    private final String fileName;
    @JsonProperty("line")
    private final Integer line;
    @JsonProperty("result")
    private String result;

    public OrderResponse(Long id, Long amount, String comment, String fileName, Integer line, String result) {
        this.id = id;
        this.amount = amount;
        this.comment = comment;
        this.fileName = fileName;
        this.line = line;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public Long getAmount() {
        return amount;
    }

    public String getComment() {
        return comment;
    }

    public String getFileName() {
        return fileName;
    }

    public Integer getLine() {
        return line;
    }

    public String getResult() {
        return result;
    }
}
