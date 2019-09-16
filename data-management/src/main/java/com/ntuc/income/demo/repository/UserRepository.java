package com.ntuc.income.demo.repository;

import com.ntuc.income.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
