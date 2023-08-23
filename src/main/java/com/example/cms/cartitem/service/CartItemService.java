package com.example.cms.cartitem.service;


import com.example.cms.item.domain.Item;
import com.example.cms.item.repository.ItemRepository;
import com.example.cms.cartitem.controller.request.CartItemCreateRequest;
import com.example.cms.cartitem.controller.request.CartItemRequest;
import com.example.cms.cartitem.controller.response.CartItemCreateResponse;
import com.example.cms.cartitem.controller.response.CartItemResponse;
import com.example.cms.cartitem.domain.CartItem;
import com.example.cms.cartitem.repository.CartItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service
public class CartItemService {
    private final CartItemRepository orderItemsRepository;
    private final ItemRepository itemRepository;

    public CartItemService(CartItemRepository orderItemsRepository, ItemRepository itemRepository) {
        this.orderItemsRepository = orderItemsRepository;
        this.itemRepository = itemRepository;
    }


    /**
     * pseudo code
     * itemRepository 에서 아이템 검색후 -> CartItem 에 등록하고 -> 결제
     */
    @Transactional
    public CartItemCreateResponse create(CartItemCreateRequest request){



        return null;
    }

    /**
     * TODO
     * 삭제 조회에 대하여 생각해봐야함
     */
    @Transactional
    public CartItemResponse delete(CartItemRequest request){

        return new CartItemResponse();
    }
    @Transactional(readOnly = true)
    public CartItemResponse findMyOrderItems(){

        return new CartItemResponse();
    }

}
