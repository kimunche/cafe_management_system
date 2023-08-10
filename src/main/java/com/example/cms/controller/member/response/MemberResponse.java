package com.example.cms.controller.member.response;

import com.example.cms.domain.member.Member;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
public class MemberResponse {
    private String name;
    private String email;

    @Builder
    public MemberResponse(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static MemberResponse of(Member member){
        return MemberResponse.builder()
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }
}
