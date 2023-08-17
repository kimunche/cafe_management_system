package com.example.cms.domain.member.service;

import com.example.cms.controller.member.form.MemberCreateForm;
import com.example.cms.domain.member.Member;
import com.example.cms.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional(readOnly = true)
    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Member> findById(Long id){
        return memberRepository.findById(id);
    }

    @Transactional
    public Member create(MemberCreateForm memberCreateForm){
        Member newMember = memberCreateForm.toEntity();
        return memberRepository.save(newMember);
    }

    @Transactional
    public void edit(Long id, String name, String email, Integer age,String phone){
        Member member = memberRepository.findById(id).get();
        member.edit(name,email,age,phone);
    }

    @Transactional
    public void delete(Member member){
        memberRepository.delete(member);
    }
}
