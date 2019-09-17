package com.ntuc.income.order.api;

import com.ntuc.income.order.service.OrderProducer;
import com.ntuc.income.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @Autowired
  private OrderService orderService;

  @Autowired OrderProducer  orderProducer;

  @PostMapping("/orders")
  public Long placeOrder(@RequestBody PlaceOrderRequestDto orderRequest) {
    return orderService.placeOrder(orderRequest.getItems()).getOrderNumber();
  }

  @GetMapping("/ship/{item}")
  public ResponseEntity shipOrder(@PathVariable String item){
    orderProducer.sendOrder(item);
    return ResponseEntity.accepted().build();
  }
}
