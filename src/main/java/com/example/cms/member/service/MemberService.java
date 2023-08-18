package com.example.cms.member.service;


import com.example.cms.member.controller.request.MemberCreateRequest;
import com.example.cms.member.controller.response.MemberResponse;
import com.example.cms.member.domain.Member;
import com.example.cms.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Transactional
    public String save(MemberCreateRequest memberCreateRequest){
        Member saveMember = memberRepository.save(memberCreateRequest.toEntity());
        saveMember.firstPoint();
        return saveMember.getMobile();
    }

    public MemberResponse findMembership(String mobile){
        Member byMobile = memberRepository.findByMobile(mobile);
        return new MemberResponse(byMobile.getMobile());
    }
}
