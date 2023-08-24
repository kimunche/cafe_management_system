package com.example.cms.cartitem.controller.response;


import com.example.cms.item.domain.ItemStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartItemCreateResponse {

    private String name;
    private Integer price;
    private ItemStatus status;
    @Min(value = 1)
    @NotNull
    private Integer count;

    public CartItemCreateResponse(String name, Integer price, ItemStatus status, Integer count) {
        this.name = name;
        this.price = price;
        this.status = status;
        this.count = count;
    }
}
