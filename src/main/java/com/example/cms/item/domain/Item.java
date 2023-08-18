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

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private Integer cost;


    @Builder
    public Item(Integer itemId, String name, Integer cost) {
        this.itemId = itemId;
        this.name = name;
        this.cost = cost;
    }
}
