package com.example.cms.item.controller.response;

import com.example.cms.item.domain.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ItemResponse {
    private String itemName;
    private Integer cost;

    @Builder
    public ItemResponse(String itemName, Integer cost) {
        this.itemName = itemName;
        this.cost = cost;
    }

    public static ItemResponse of(Item item){
        return ItemResponse.builder()
                .itemName(item.getItemName())
                .cost(item.getCost())
                .build();
    }
}
