package com.ntuc.income.service;

import com.ntuc.income.entity.Item;
import com.ntuc.income.entity.Order;
import com.ntuc.income.repository.ItemRepository;
import com.ntuc.income.repository.OrderRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Order getOrder(Long orderNumber){
        return orderRepository.findByOrderNumber(orderNumber);
    }

    @Transactional
    public Order placeOrder(List<Long> itemIds) {
        List<Item> items = itemRepository.findAllById(itemIds);
        double totalAmount = items.stream().map(Item::getPrice).reduce((value1, value2) -> value1 + value2).get();
        Long orderNumber = System.currentTimeMillis();
        return orderRepository.save(new Order(orderNumber, items, totalAmount));
    }
}
