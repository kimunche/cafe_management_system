package com.example.cms.item.controller;

import com.example.cms.item.controller.request.ItemCreateRequest;
import com.example.cms.item.controller.response.ItemResponse;
import com.example.cms.item.service.ItemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Items", description = "상품 API")
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(summary = "상품 목록 조회", description = "상품 목록 전부 조회합니다.")
    @GetMapping
    public List<ItemResponse> findAll(){
        return itemService.findAll();
    }

    @Operation(summary = "상품 이름으로 조회", description = "상품 이름으로 like 조회합니다.")
    @GetMapping
    public ItemResponse findByName(@PathVariable("item") String name){
        return itemService.findByName(name);
    }

    @Operation(summary = "신규 상품 추가", description = "신규 상품을 추가합니다. 같은 이름의 메뉴를 중복체크합니다.")
    @PostMapping
    public void create(@RequestBody ItemCreateRequest itemCreateRequest){
        itemService.create(itemCreateRequest);
    }
}
