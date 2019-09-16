package com.ntuc.income.repository;

import com.ntuc.income.entity.Item;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findByName(String name);

    List<Item> findByBrandName(String brandName);

    @Query("SELECT item from Item item WHERE id in (:ids)")
    List<Item> findAllById(@Param("ids") List<Long> ids);
}
