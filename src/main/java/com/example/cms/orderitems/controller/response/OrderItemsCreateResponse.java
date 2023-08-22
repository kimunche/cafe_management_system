package com.example.cms.orderitems.controller.response;


import com.example.cms.item.domain.ItemStatus;
import lombok.Data;

@Data
public class OrderItemsCreateResponse {

    private String name;
    private Integer price;
    private ItemStatus status;
    private Integer count;

    public OrderItemsCreateResponse(String name, Integer price, ItemStatus status, Integer count) {
        this.name = name;
        this.price = price;
        this.status = status;
        this.count = count;
    }
}
