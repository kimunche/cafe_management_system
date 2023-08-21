package com.example.cms.item.controller.request;

import com.example.cms.item.domain.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ItemCreateRequest {

    private String name;
    private Integer cost;

    @Builder
    public ItemCreateRequest(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }

    public Item toItem(){
        return Item.builder()
                .name(name)
                .cost(cost)
                .build();
    }
}
