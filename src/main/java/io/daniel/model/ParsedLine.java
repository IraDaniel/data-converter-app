package io.daniel.model;

public class ParsedLine {
    private static final String OK = "OK";
    private final Order order;
    private final String result;
    private final int line;
    private final boolean success;

    private ParsedLine(Order order, String result, int line, boolean success) {
        this.order = order;
        this.result = result;
        this.line = line;
        this.success = success;
    }

    public static ParsedLine success(Order order, int line){
        return new ParsedLine(order, OK, line, true);
    }

    public static ParsedLine fail(String details, int line){
        return new ParsedLine(null, details, line, false);
    }

    public Order getOrder() {
        return order;
    }

    public String getResult() {
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getLine() {
        return line;
    }
}
