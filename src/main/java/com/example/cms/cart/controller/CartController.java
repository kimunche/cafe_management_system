package com.example.cms.cart.controller;

import com.example.cms.cart.controller.response.CartResponse;
import com.example.cms.cartitem.service.CartItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {


    private final CartItemService cartItemService;

    public CartController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }
    @PostMapping
    public CartResponse addCartItem(){

        return new CartResponse();
    }
}
