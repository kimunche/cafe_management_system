package com.example.cms.member.controller.response;

import lombok.Data;

@Data
public class MemberCreateResponse {

    public String phone;

    public MemberCreateResponse(String phone) {
        this.phone = phone;
    }
}
