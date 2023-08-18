package com.example.cms.item.controller;

import com.example.cms.item.controller.response.ItemResponse;
import com.example.cms.item.service.ItemService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(summary = "상품 목록 조회", description = "상품 목록 전부 조회함")
    @GetMapping
    public List<ItemResponse> findAll(){
        return itemService.findAll();
    }
}
