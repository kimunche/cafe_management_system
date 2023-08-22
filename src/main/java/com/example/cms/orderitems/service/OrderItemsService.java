package com.example.cms.orderitems.service;


import com.example.cms.item.domain.Item;
import com.example.cms.item.repository.ItemRepository;
import com.example.cms.item.service.ItemService;
import com.example.cms.orderitems.controller.request.OrderItemsCreateRequest;
import com.example.cms.orderitems.controller.response.OrderItemsCreateResponse;
import com.example.cms.orderitems.domain.OrderItems;
import com.example.cms.orderitems.repository.OrderItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service
public class OrderItemsService {
    private final OrderItemsRepository orderItemsRepository;
    private final ItemRepository itemRepository;

    public OrderItemsService(OrderItemsRepository orderItemsRepository, ItemRepository itemRepository) {
        this.orderItemsRepository = orderItemsRepository;
        this.itemRepository = itemRepository;
    }


    /**
     * sudo
     * itemRepository 에서 아이템 검색후 -> OrderItems 에 등록하고 -> 결제
     */
    @Transactional
    public OrderItemsCreateResponse create(OrderItemsCreateRequest request){
        Item Drink = itemRepository.findByNameAndHotIce(request.getName(),request.getStatus());
        OrderItems orderItems = new OrderItems(Drink, request.getCount(), Drink.getCost());
        OrderItems save = orderItemsRepository.save(orderItems);
        return new OrderItemsCreateResponse(save.getItem().getName(),save.getItem().getCost(),save.getItem().getHotIce(), request.getCount());
    }

}
