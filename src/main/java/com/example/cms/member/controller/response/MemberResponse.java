package com.example.cms.member.controller.response;

import lombok.Data;

@Data
public class MemberResponse {

    private String mobile;
    private String name;
    private Integer membershipPoint;

    public MemberResponse(String mobile, String name, Integer membershipPoint) {
        this.mobile = mobile;
        this.name = name;
        this.membershipPoint = membershipPoint;
    }

}