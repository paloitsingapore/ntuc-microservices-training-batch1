package com.ntuc.income.api;

import com.ntuc.income.entity.Item;
import com.ntuc.income.repository.ItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.Collectors.toList;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/items/search/name/{name}")
    public List<ItemDto> searchItemsByName(@PathVariable String name) {
        List<Item> items = itemRepository.findByName(name);
        return createDto(items);
    }

    @GetMapping("/items/search/brand/{brandName}")
    public List<ItemDto> searchItemsByBrandName(@PathVariable String brandName) {
        List<Item> items = itemRepository.findByBrandName(brandName);
        return createDto(items);
    }

    private List<ItemDto> createDto(List<Item> items) {

        return items
                .stream()
                .map(item -> new ItemDto(
                        item.getItemId(),
                        item.getName(),
                        item.getPrice(),
                        item.getBrandName()))
                .collect(toList());
    }
}
