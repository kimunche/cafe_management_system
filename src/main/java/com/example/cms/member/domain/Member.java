package com.example.cms.member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity @Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    @Column(length = 11)
    private String mobile;

    private String name;

    @Column(name = "membership_point")
    private Integer membershipPoint;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private MemberStatus status;

    //첫 회원 가입 포인트
    Integer firstJoinPoint = 10000;

    @Builder
    public Member(Long id, String mobile, String name, Integer membershipPoint, LocalDateTime createDate, MemberStatus status) {
        this.id = id;
        this.mobile = mobile;
        this.name = name;
        this.membershipPoint = membershipPoint;
        this.createDate = createDate;
        this.status = status;
    }

    public void firstPoint(){
        this.membershipPoint = firstJoinPoint;
    }

    public void update(String name, String mobile){
        this.name = name;
        this.mobile = mobile;
    }
}
