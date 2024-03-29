package com.ntuc.income.itemservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "item")
public class Item {

  @Id
  @GeneratedValue(strategy = AUTO)
  private Long itemId;
  private String name;
  private double price;
  private String brandName;

  Item() {}

  public Item(String name, double price, String brandName) {
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

  @Override public String toString() {
    return "Item{" +
        "itemId=" + itemId +
        ", name='" + name + '\'' +
        ", price=" + price +
        ", brandName='" + brandName + '\'' +
        '}';
  }
}
