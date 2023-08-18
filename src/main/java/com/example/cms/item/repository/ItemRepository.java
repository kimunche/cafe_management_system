package com.example.cms.item.repository;

import com.example.cms.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item save(Item item);

    List<Item> findAll();
    Optional<Item> findByItemId(int itemId);

    void deleteByItemId(int itemId);
}
