package com.example.cms.item;

import com.example.cms.item.controller.request.ItemSearchRequest;
import com.example.cms.item.domain.ItemRedis;
import com.example.cms.item.domain.ItemStatus;
import com.example.cms.item.repository.RedisTestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ItemRedisTest {

    @Autowired
    private RedisTestRepository itemRepository;

    @Test
    void saveTest(){
        ItemRedis item1 = new ItemRedis(15L, "아이스티", 3000, ItemStatus.ICED);
        ItemRedis item2 = new ItemRedis(16L, "얼그레이티", 3000, ItemStatus.HOT);
        ItemRedis item3 = new ItemRedis(17L, "히비스커스티", 3000, ItemStatus.HOT);
        ItemRedis item4 = new ItemRedis(18L, "유자차", 3000, ItemStatus.HOT);

        System.out.println(item1);

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);

        System.out.println(itemRepository.findAll());
    }

    @Test
    void selectTest(){
        List<ItemRedis> items = itemRepository.findAll();
        System.out.println(items);
    }
}