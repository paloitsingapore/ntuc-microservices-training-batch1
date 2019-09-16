package com.ntuc.income.order.service;

import com.ntuc.income.order.entity.Order;
import com.ntuc.income.order.entity.OrderItem;
import com.ntuc.income.order.repository.OrderRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import static java.util.stream.Collectors.toList;

@Service
public class OrderService {

  @Autowired
  private ItemServiceClient itemServiceClient;

  @Autowired
  private OrderRepository orderRepository;

  @Transactional
  public Order placeOrder(List<Long> itemIds) {
    List<ItemDto> itemDtoList = itemServiceClient.searchItems(itemIds);
    double totalAmount = itemDtoList.stream().map(ItemDto::getPrice).reduce((value1, value2) -> value1 + value2).get();
    List<OrderItem> orderItems = itemDtoList.stream().map(this::getOrderItem).collect(toList());
    Long orderNumber = System.currentTimeMillis();
    Order order = new Order(orderNumber, totalAmount, orderItems);
    orderItems.forEach(orderItem -> orderItem.setOrder(order));
    return orderRepository.save(order);
  }

  private OrderItem getOrderItem(ItemDto itemDto) {
    return new OrderItem(
        itemDto.getName(),
        itemDto.getBrandName(),
        itemDto.getPrice()
    );
  }

  @FeignClient(name = "item-service")
  private interface ItemServiceClient {

    @PostMapping(value = "/items/search")
    List<ItemDto> searchItems(List<Long> itemIds);
  }
}
