package com.ntuc.income.demo.api;

import com.ntuc.income.demo.entity.User;
import com.ntuc.income.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/users")
  public Long createUser(@RequestBody User user){
    return userRepository.save(user).getUserId();
  }
}
