package com.ntuc.income.order.repository;

import com.ntuc.income.order.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
