package com.example.cms.item.service;

import com.example.cms.item.controller.request.ItemCreateRequest;
import com.example.cms.item.controller.request.ItemUpdateRequest;
import com.example.cms.item.controller.response.ItemResponse;
import com.example.cms.item.domain.Item;
import com.example.cms.item.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
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

    public List<ItemResponse> findByName(String name) {
        return itemRepository.findAllByNameContaining(name)
                .stream().map(ItemResponse::of)
                .collect(Collectors.toList());
    }

    public void create(ItemCreateRequest itemCreateRequest){
        Item newItem = itemCreateRequest.toItem();
        //중복체크
        Boolean isExistItemAndStatus = itemRepository.existsByNameAndAndHotIce(newItem.getName(), newItem.getHotIce());

        Item originItem = itemRepository.findByNameAndHotIce(newItem.getName(), newItem.getHotIce());

        if(isExistItemAndStatus){
            validateDuplicate(originItem, newItem);
        }else {
            itemRepository.save(newItem);
        }
    }

    private void validateDuplicate(Item originItem, Item newItem){
        // 이름과 상태값이 같은 제품이 있을경우, 가격 비교 - 가격이 같은 경우 중복으로 인식 / 가격이 다른경우 - 변경여부 물어봄
        if(originItem != null && ( originItem.getCost().equals(newItem.getCost()))){
            throw new IllegalStateException("이미 같은 이름, 가격, hot&Ice 의 메뉴가 있습니다. " + originItem.getName() + "("+ originItem.getHotIce() +") " +originItem.getCost());

        }else if(originItem != null && ( originItem.getCost() != newItem.getCost())){
            System.out.printf("%s(%s) 메뉴의 가격은 %d 으로 책정되어 있습니다. 가격을 바꾸시겠습니까? (Y/N) : ", newItem.getName(), newItem.getHotIce(), originItem.getCost());

            Scanner s = new Scanner(System.in);
            String input = s.nextLine();

            if(input.equals("Y")){
                originItem.update(originItem.getItemId(), originItem.getName(), newItem.getCost(), originItem.getHotIce());
                itemRepository.save(originItem);
            }

            //s.close();
        }
    }

    @Transactional
    public void update(ItemUpdateRequest updateRequest){
        Item updateItem = updateRequest.toItem();

        //name, cost, h/i 가 모두 중복
        Boolean isDuplicated = itemRepository.existsByNameAndCostAndHotIce(updateItem.getName(), updateItem.getCost(), updateItem.getHotIce());
        if(isDuplicated) {
            throw new IllegalStateException("중복되는 기존 메뉴가 있습니다." + updateItem.getName() + "(" + updateItem.getHotIce() + ") " + updateItem.getCost() + "원");
        }else {
            //name , h/i 중복
            Item originItem = itemRepository.findByNameAndHotIce(updateItem.getName(), updateItem.getHotIce());

            if(originItem != null){
                //cost 만 다를경우
                if(originItem.getCost() != updateItem.getCost()){
                    updateItem.update(updateItem.getItemId(), originItem.getName(), updateItem.getCost(), originItem.getHotIce());
                    itemRepository.save(updateItem);
                }
//                throw new IllegalStateException("중복되는 기존 메뉴가 있습니다." + originItem.getName() + "(" + originItem.getHotIce() + ") " + originItem.getCost() + "원");
            }else{
                updateItem.update(updateItem.getItemId(), updateItem.getName(), updateItem.getCost(), updateItem.getHotIce());
                itemRepository.save(updateItem);
            }

        }
    }

    @Transactional
    public void delete(Long itemId){
        itemRepository.deleteByItemId(itemId);
    }

}
