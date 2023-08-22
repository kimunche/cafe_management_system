package com.example.cms.orderitems.controller;


import com.example.cms.member.service.MemberService;
import com.example.cms.orderitems.controller.request.OrderItemsCreateRequest;
import com.example.cms.orderitems.controller.response.OrderItemsCreateResponse;
import com.example.cms.orderitems.service.OrderItemsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderItems")
public class OrderItemsController {
    private final OrderItemsService orderItemsService;



    public OrderItemsController(OrderItemsService orderItemsService) {
        this.orderItemsService = orderItemsService;
    }

    @PostMapping("/create")
    public OrderItemsCreateResponse orderItemsCreate(@RequestBody @Valid OrderItemsCreateRequest request){
        return orderItemsService.create(request);
    }
}
