package com.example.cms.cart.controller;

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
        System.out.println("request.getPhone() = " + request.getPhone());
        List<CartItemCreateRequest> cartItemRequests = request.getCartItemRequests();
        for (CartItemCreateRequest cartItemRequest : cartItemRequests) {
            System.out.println("cartItemRequest = " + cartItemRequest);
        }
        CartResponse cartResponse = cartService.CreateCart(request.getPhone(), request);
        return cartResponse;
    }
}
