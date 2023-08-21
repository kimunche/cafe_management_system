package com.example.cms.member.controller.response;

import lombok.Data;

@Data
public class MemberCreateResponse {

    public String name;
    public String phone;


    public MemberCreateResponse(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }


}
