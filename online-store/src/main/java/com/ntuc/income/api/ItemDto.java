package com.ntuc.income.api;

public class ItemDto {

    private Long itemId;
    private String name;
    private double price;
    private String brandName;

    public ItemDto(Long itemId, String name, double price, String brandName) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.brandName = brandName;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
