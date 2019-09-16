package com.ntuc.income.order.repository;

import com.ntuc.income.order.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
