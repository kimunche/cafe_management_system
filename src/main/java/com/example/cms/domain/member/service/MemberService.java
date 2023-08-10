package com.example.cms.domain.member.service;

import com.example.cms.controller.member.response.MemberResponse;
import com.example.cms.domain.member.Member;
import com.example.cms.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional(readOnly = true)
    public List<MemberResponse> findAll(){
        return memberRepository.findAll().stream().map(MemberResponse::of)
                .collect(Collectors.toList());
    }
}
