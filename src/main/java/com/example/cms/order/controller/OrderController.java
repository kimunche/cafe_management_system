package com.example.cms.order.controller;

import com.example.cms.order.controller.request.OrderCreateRequest;
import com.example.cms.order.controller.response.OrderCreateResponse;
import com.example.cms.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //TODO: 주문내역조회, 결제, 취소

    @PostMapping
    public OrderCreateResponse create(OrderCreateRequest request){
        return orderService.createOrder(request);
    }
}
