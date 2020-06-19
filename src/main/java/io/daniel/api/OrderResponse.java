package io.daniel.api;

public class OrderResponse {
    //{“id”:1, ”amount”:100, ”comment”:”оплата заказа”, ”filename”:”orders.csv”, ”line”:1, ”result”:”OK” }
    private final long id;
    private final long amount;
    private final String comment;
    private final String filename;
    private final int line;
    private String result;

    public OrderResponse(long id, long amount, String comment, String filename, int line) {
        this.id = id;
        this.amount = amount;
        this.comment = comment;
        this.filename = filename;
        this.line = line;
    }

    public long getId() {
        return id;
    }

    public long getAmount() {
        return amount;
    }

    public String getComment() {
        return comment;
    }

    public String getFilename() {
        return filename;
    }

    public int getLine() {
        return line;
    }

    public String getResult() {
        return result;
    }
}
