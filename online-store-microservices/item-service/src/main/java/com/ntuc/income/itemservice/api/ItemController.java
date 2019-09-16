package com.ntuc.income.itemservice.api;

import com.ntuc.income.itemservice.entity.Item;
import com.ntuc.income.itemservice.repository.ItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

  @Autowired ItemRepository itemRepository;

  @PostMapping("/search")
  public List<Item> searchByItemId(@RequestBody List<Long> itemIds) {
    return itemRepository.findAllById(itemIds);
  }
}
