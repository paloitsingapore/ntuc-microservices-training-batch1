package com.ntuc.income.order.api;

import com.ntuc.income.order.entity.Order;
import com.ntuc.income.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @Autowired
  private OrderService orderService;

  @PostMapping("/orders")
  public Long placeOrder(@RequestBody PlaceOrderRequestDto orderRequest) {
    return orderService.placeOrder(orderRequest.getItems()).getOrderNumber();
  }
}
