package com.ntuc.income.itemservice;

import com.ntuc.income.itemservice.entity.Item;
import com.ntuc.income.itemservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ItemServiceApplication { //implements ApplicationRunner {

  @Autowired ItemRepository itemRepository;

  public static void main(String[] args) {
    SpringApplication.run(ItemServiceApplication.class, args);
  }


  @GetMapping("/greet")
  public String greet() {
    return "hello";
  }
















  //
  //@Override public void run(ApplicationArguments args) throws Exception {
  //
  //  itemRepository.save(new Item("iphone-8", 499, "Apple"));
  //  itemRepository.save(new Item("iphone-10", 699, "Apple"));
  //  itemRepository.save(new Item("iphone-11-max-pro", 999, "Apple"));
  //  itemRepository.save(new Item("s10", 799, "Samsung"));
  //  itemRepository.save(new Item("s10-note", 999, "Samsung"));
  //
  //}
}
