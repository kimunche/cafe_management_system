package com.example.cms.member.repository;

import com.example.cms.member.domain.Member;

import java.util.List;

public interface MemberRepositoryCustom {

    List<Member> findMemberList();
}
