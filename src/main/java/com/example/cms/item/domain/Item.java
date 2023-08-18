package com.example.cms.item.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "cost")
    private Integer cost;


    @Builder
    public Item(Integer itemId, String itemName, Integer cost) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.cost = cost;
    }
}
