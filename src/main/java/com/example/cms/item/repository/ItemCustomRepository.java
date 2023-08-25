package com.example.cms.item.repository;

import com.example.cms.item.domain.Item;

import java.util.List;

public interface ItemCustomRepository {
    List<Item> searchItems(Item item);
}
