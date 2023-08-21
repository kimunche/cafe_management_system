package com.example.cms.member.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberRequest {

    private String name;

    @NotBlank
    private String phone;

    public MemberRequest(String phone) {
        this.phone = phone;
    }
}
