package com.example.cms.member.repository;

import com.example.cms.member.domain.Member;
import com.example.cms.member.domain.QMember;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;


public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public List<Member> findMemberList(){

        List<Tuple> fetch = queryFactory.select().from(QMember.member).fetch();


        return null;
    }

}
