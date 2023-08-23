package com.example.cms.order.service;

import com.example.cms.order.controller.response.OrderDetailResponse;
import com.example.cms.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //주문 번호 하나의 디테일
//    public List<OrderDetailResponse> findOrderDetail(){
//    }
}
