package com.example.cms.domain.member.service;

import com.example.cms.domain.member.Member;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Service
public class JsonParseService {

    public List<?> getJsonData() throws IOException, ParseException {
        ClassPathResource resource = new ClassPathResource("static/customer_table.json");
        Reader reader = new FileReader(resource.getFile());

        JSONParser parser = new JSONParser();

        Object ob = parser.parse(reader);
        JSONArray arr = new JSONArray();
        arr.add(ob);

        List<Member> list = arr.stream().toList();
        System.out.println(list);
        return list;
    }

}
