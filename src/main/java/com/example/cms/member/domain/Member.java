package com.example.cms.member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String mobile;
    private String name;
    private Integer membershipPoint;
    private LocalDate joinDate;
    private Boolean status;

    @Builder
    public Member(Long id, String mobile, String name, Integer membershipPoint, LocalDate joinDate, Boolean status) {
        this.id = id;
        this.mobile = mobile;
        this.name = name;
        this.membershipPoint = membershipPoint;
        this.joinDate = joinDate;
        this.status = status;
    }

    public void firstPoint(){
        this.membershipPoint = 10000;
    }

}
