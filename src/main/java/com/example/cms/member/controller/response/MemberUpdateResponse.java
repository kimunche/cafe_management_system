package com.example.cms.member.controller.response;

import lombok.Data;

@Data
public class MemberUpdateResponse {

    private String mobile;
    private String name;

    public MemberUpdateResponse(String mobile, String name) {
        this.mobile = mobile;
        this.name = name;
    }
}
