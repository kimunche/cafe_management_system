package com.example.cms.item.repository;

import com.example.cms.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAll();
    Optional<Item> findByNameLike(String name);

    boolean existsByName(String name);

    void deleteByItemId(String name);
}
