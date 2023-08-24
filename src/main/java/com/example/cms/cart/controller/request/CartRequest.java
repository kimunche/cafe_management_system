package com.example.cms.cart.controller.request;


import com.example.cms.cartitem.controller.request.CartItemCreateRequest;
import lombok.Data;

import java.util.List;

@Data
public class CartRequest {

    private List<CartItemCreateRequest> cartItemRequests;

    private String phone;

    public CartRequest() {
    }

    public CartRequest(List<CartItemCreateRequest> cartItemRequests, String phone) {
        this.cartItemRequests = cartItemRequests;
        this.phone = phone;
    }
}
