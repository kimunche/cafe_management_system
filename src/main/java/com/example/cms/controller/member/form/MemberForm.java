package com.example.cms.controller.member.form;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberForm {
    private String name;
    private Integer age;
    private String email;
    private String phone;

    @Builder
    public MemberForm(String name, Integer age, String email, String phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }
}
