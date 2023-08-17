package com.example.cms.domain.member;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable=false, updatable=false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "phone")
    private String phone;

    @Builder
    public Member(Long id, String name, Integer age, String email, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public void edit(String name, String email, Integer age, String phone){
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }
}
