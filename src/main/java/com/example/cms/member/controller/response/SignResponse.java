package com.example.cms.member.controller.response;

import com.example.cms.member.domain.Member;
import com.example.cms.member.domain.UserRoleEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignResponse {
    private String mobile;
    private String name;
    private String token;
    private UserRoleEnum role;

    @Builder
    public SignResponse(String mobile, String name, String token, UserRoleEnum role) {
        this.mobile = mobile;
        this.name = name;
        this.token = token;
        this.role = role;
    }

    public static SignResponse of(Member member){
        return SignResponse.builder()
                .mobile(member.getMobile())
                .name(member.getName())
                .role(member.getRole())
                .build();
    }

    public void setToken(String token){
        this.token = token;
    }
}
