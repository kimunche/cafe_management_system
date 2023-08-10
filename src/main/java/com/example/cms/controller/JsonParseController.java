package com.example.cms.controller;

import com.example.cms.domain.member.Member;
import com.example.cms.domain.member.service.JsonParseService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/")
public class JsonParseController {

    private JsonParseService jsonParseService;

    public JsonParseController(JsonParseService jsonParseService) {
        this.jsonParseService = jsonParseService;
    }

    @GetMapping("")
    public List<?> JsonParse() throws IOException, ParseException {

        return jsonParseService.getJsonData();
    }
}
