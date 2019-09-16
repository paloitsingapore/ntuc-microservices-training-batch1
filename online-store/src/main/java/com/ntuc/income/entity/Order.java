package com.ntuc.income.entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = AUTO)
  private Long orderId;
  private Long orderNumber;
  private double totalAmount;

  @ManyToMany
  @JoinTable(
      name = "order_item",
      joinColumns = {@JoinColumn(name = "order_id")},
      inverseJoinColumns = {@JoinColumn(name = "item_id")}
  )
  private List<Item> items;

  public Order() {

  }

  public Order(Long orderNumber, List<Item> items, double totalAmount) {
    this.orderNumber = orderNumber;
    this.items = items;
    this.totalAmount = totalAmount;
  }

  public Long getOrderId() {
    return orderId;
  }

  public Long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }
}
