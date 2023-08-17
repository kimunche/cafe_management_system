package com.example.cms.item.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @ApiOperation(value = "test", notes = "testtsst")
    @GetMapping
    public String test(){
        return "";
    }
}
