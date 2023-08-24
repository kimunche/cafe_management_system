package com.example.cms.cart.controller.response;

import lombok.Data;

import java.util.List;

@Data
public class CartResponse {

    private Integer totalCount;
//    private Integer totalPrice;

    public CartResponse(Integer totalCount) {
        this.totalCount = totalCount;
//        this.totalPrice = totalPrice;
    }
}
