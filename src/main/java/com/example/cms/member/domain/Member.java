package com.example.cms.member.domain;

import com.example.cms.utils.entity.BaseDateTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity @Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseDateTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    @Column(length = 11)
    private String mobile;

    private String name;

    @Column(name = "membership_point")
    private Integer membershipPoint;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private MemberStatus status;

    //첫 회원 가입 포인트
    Integer firstJoinPoint = 10000;

    @Builder
    public Member(Long id, String mobile, String name, Integer membershipPoint,  MemberStatus status) {
        this.id = id;
        this.mobile = mobile;
        this.name = name;
        this.membershipPoint = membershipPoint;
        this.status = status;
    }

    public void firstPoint(){
        this.membershipPoint = firstJoinPoint;
    }

    public void update(String name, String mobile){
        this.name = name;
        this.mobile = mobile;
    }

    public void updatePoint(Integer membershipPoint){
        this.membershipPoint = membershipPoint;
    }
}
