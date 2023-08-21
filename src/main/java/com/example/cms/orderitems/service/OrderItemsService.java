package com.example.cms.orderitems.service;


import com.example.cms.orderitems.controller.request.OrderItemsCreateRequest;
import com.example.cms.orderitems.controller.response.OrderItemsCreateResponse;
import com.example.cms.orderitems.repository.OrderItemsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderItemsService {
    private final OrderItemsRepository orderItemsRepository;

    public OrderItemsService(OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
    }

//    @Transactional
//    public OrderItemsCreateResponse create(OrderItemsCreateRequest request){
//
//        return new OrderItemsCreateResponse();
//    }

}
