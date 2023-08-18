package com.example.cms.item.controller.response;

import com.example.cms.item.domain.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ItemResponse {
    private String name;
    private Integer cost;

    @Builder
    public ItemResponse(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }

    public static ItemResponse of(Item item){
        return ItemResponse.builder()
                .name(item.getName())
                .cost(item.getCost())
                .build();
    }
}
