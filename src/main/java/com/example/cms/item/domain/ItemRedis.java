package com.example.cms.item.domain;

import com.example.cms.utils.entity.BaseDateTimeEntity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash("Item")
public class ItemRedis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String name;

    private Integer cost;

    private ItemStatus hotIce;

    @Builder
    public ItemRedis(Long id, String name, Integer cost, ItemStatus hotIce) {
        this.itemId = id;
        this.name = name;
        this.cost = cost;
        this.hotIce = hotIce;
    }

    public void update(Long id, String name, Integer cost, ItemStatus hotIce) {
        this.itemId = id;
        this.name = name;
        this.cost = cost;
        this.hotIce = hotIce;
    }
}
