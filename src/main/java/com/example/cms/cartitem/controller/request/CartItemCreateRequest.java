package com.example.cms.cartitem.controller.request;

import com.example.cms.item.domain.ItemStatus;

import lombok.Data;

import java.util.List;


@Data
public class CartItemCreateRequest {


    private String name;
    private Integer count;
    private ItemStatus status;

    private List<CartItemCreateRequest> cartItemCreateRequests;

    public CartItemCreateRequest() {
    }

    public CartItemCreateRequest(String name, Integer count, ItemStatus status) {
        this.name = name;
        this.count = count;
        this.status = status;
    }
}
