package com.example.cms.cart.controller;

import com.example.cms.cart.controller.request.CartDeleteRequest;
import com.example.cms.cart.controller.request.CartRequest;
import com.example.cms.cart.controller.response.CartResponse;
import com.example.cms.cart.service.CartService;
import com.example.cms.cartitem.controller.request.CartItemCreateRequest;
import com.example.cms.cartitem.service.CartItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {


    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/create")
    public CartResponse CreateCart(@RequestBody CartRequest request){
        return cartService.CreateCart(request);
    }

    /**
     * 카트 불러와서 삭제 과정 논의 어떤 기준으로 불러와서 진행을 할까?
     * 1. 카트 아이디와 회원 아이디?
     */
    @PostMapping("/deleteItem")
    public void deleteCartItem(@RequestBody CartDeleteRequest cartDeleteRequest){


    }


}
