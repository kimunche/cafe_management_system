package com.example.cms.cart.controller.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
public class CartResponse {

    private Integer totalCount;
    private Integer totalPrice;

    @Builder
    public CartResponse(Integer totalCount, Integer totalPrice) {
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
    }
}
