package com.example.cms.item.controller.request;

import com.example.cms.item.domain.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ItemCreateRequest {

    private Integer itemId;
    private String itemName;
    private Integer cost;

    @Builder
    public ItemCreateRequest(Integer itemId, String itemName, Integer cost) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.cost = cost;
    }

    public Item toItem(){
        return Item.builder()
                .itemId(itemId)
                .itemName(itemName)
                .cost(cost)
                .build();
    }
}
