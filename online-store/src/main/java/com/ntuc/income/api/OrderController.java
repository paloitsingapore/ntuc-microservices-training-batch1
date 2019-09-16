package com.ntuc.income.api;

import com.ntuc.income.entity.Item;
import com.ntuc.income.entity.Order;
import com.ntuc.income.service.OrderService;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders/{orderNumber}")
    public OrderDto getOrder(@PathVariable Long orderNumber) {
        Order order = orderService.getOrder(orderNumber);
        return createOrderDto(order);
    }

    @PostMapping("/orders")
    public OrderDto placeOrder(@RequestBody PlaceOrderRequestDto orderRequest) {
        Order order = orderService.placeOrder(orderRequest.getItems());
        return createOrderDto(order);
    }

    private OrderDto createOrderDto(Order order) {
        return new OrderDto(
                order.getOrderNumber(),
                order.getItems().stream().map(Item::getName).collect(Collectors.toList()),
                order.getTotalAmount()
        );
    }
}
