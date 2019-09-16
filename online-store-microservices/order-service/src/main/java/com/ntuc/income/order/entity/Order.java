package com.ntuc.income.order.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "orders")

public class Order {

  @Id
  @GeneratedValue(strategy = AUTO)
  private Long orderId;
  private Long orderNumber;
  private double totalAmount;
  @OneToMany(mappedBy = "order", cascade = ALL)
  private List<OrderItem> orderItems;

  Order() { }
  public Order(Long orderNumber, double totalAmount,
      List<OrderItem> orderItems) {
    this.orderNumber = orderNumber;
    this.totalAmount = totalAmount;
    this.orderItems = orderItems;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
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

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }
}
