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
    @Column(length = 11)
    private String mobile;

    private String name;
    private Integer membershipPoint;
    private LocalDate joinDate;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;
    @Builder
    public Member(Long id, String mobile, String name, Integer membershipPoint, LocalDate joinDate, MemberStatus status) {
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

    public void update(String name, String mobile){
        this.name = name;
        this.mobile = mobile;
    }
}
