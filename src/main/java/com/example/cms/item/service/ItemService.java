package com.example.cms.item.service;

import com.example.cms.item.controller.response.ItemResponse;
import com.example.cms.item.domain.Item;
import com.example.cms.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemResponse> findAll(){
        return itemRepository.findAll().stream()
                .map(ItemResponse::of)
                .collect(Collectors.toList());
    }

    //TODO: create+중복체크, id로 검색, 수정, 삭제

}
