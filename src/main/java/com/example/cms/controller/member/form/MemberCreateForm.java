package com.example.cms.controller.member.form;

import com.example.cms.domain.member.Member;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberCreateForm {
    private String name;
    private Integer age;
    private String email;
    private String phone;

    @Builder
    public MemberCreateForm(String name, Integer age, String email, String phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .age(age)
                .email(email)
                .phone(phone)
                .build();
    }
}
