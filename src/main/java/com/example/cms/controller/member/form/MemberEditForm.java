package com.example.cms.controller.member.form;

import lombok.Data;

@Data
public class MemberEditForm {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String phone;

    public MemberEditForm(Long id, String name, Integer age, String email, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }
}
