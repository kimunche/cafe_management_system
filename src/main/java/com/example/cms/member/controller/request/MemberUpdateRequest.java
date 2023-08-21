package com.example.cms.member.controller.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberUpdateRequest {

    @NotBlank
    private String mobile;

    @NotBlank
    private String name;
}
