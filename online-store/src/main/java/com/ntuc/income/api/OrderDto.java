package com.ntuc.income.api;

import java.util.List;

public class OrderDto {
    private Long orderNumber;
    private List<String> items;
    private double totalPrice;

    public OrderDto(Long orderNumber, List<String> items, double totalPrice) {
        this.orderNumber = orderNumber;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
