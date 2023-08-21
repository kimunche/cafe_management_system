package com.example.cms.item.service;

import com.example.cms.item.controller.request.ItemCreateRequest;
import com.example.cms.item.controller.response.ItemResponse;
import com.example.cms.item.domain.Item;
import com.example.cms.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
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

    public ItemResponse findByName(String name) {
        return itemRepository.findByNameLike(name)
                .map(ItemResponse::of)
                .orElseThrow(()-> new IllegalStateException(name + " 이름의 메뉴가 없습니다."));
    }

    public void create(ItemCreateRequest itemCreateRequest){
        Item newItem = itemCreateRequest.toItem();
        //중복체크
        Boolean isExistItem = itemRepository.existsByName(newItem.getName());

        if(isExistItem){
            throw new IllegalStateException("이미 같은 이름의 메뉴가 있습니다.");
        }else {
            itemRepository.save(newItem);
        }
    }

    //TODO: 수정, 삭제

}
