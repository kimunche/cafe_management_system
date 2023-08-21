package com.example.cms.member.controller.request;

import com.example.cms.member.domain.Member;

import com.example.cms.member.domain.MemberStatus;
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
    private MemberStatus status;
    public Member toEntity(){
        return Member.builder()
                .mobile(mobile)
                .name(name)
                .joinDate(LocalDate.now())
                .status(MemberStatus.OPEN)
                .build();
    }

    public MemberCreateRequest(String mobile, String name, LocalDate joinDate, MemberStatus status) {
        this.mobile = mobile;
        this.name = name;
        this.joinDate = joinDate;
        this.status = status;
    }
}
