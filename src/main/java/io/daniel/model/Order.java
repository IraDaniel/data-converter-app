package io.daniel.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonPropertyOrder({ "orderId", "amount", "currency", "comment" })
public class Order {

    private long orderId;
    private long amount;
    private String currency;
    private String comment;

    private Order() {
    }

    public Order(long orderId, long amount, String currency, String comment) {
        this.orderId = orderId;
        this.amount = amount;
        this.currency = currency;
        this.comment = comment;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId &&
                amount == order.amount &&
                Objects.equals(currency, order.currency) &&
                Objects.equals(comment, order.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, amount, currency, comment);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
