package com.example.cms.member.controller.request;

import com.example.cms.member.domain.Member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;


@Data
public class MemberCreateRequest {

    @NotEmpty
    private String mobile;

    @NotBlank
    private String name;
    private LocalDate joinDate;
    private Boolean status;
    public Member toEntity(){
        return Member.builder()
                .mobile(mobile)
                .name(name)
                .joinDate(LocalDate.now())
                .status(Boolean.TRUE)
                .build();
    }

}
