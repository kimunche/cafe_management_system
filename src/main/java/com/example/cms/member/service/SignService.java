package com.example.cms.member.service;

import com.example.cms.member.controller.request.SignRequest;
import com.example.cms.member.controller.response.SignResponse;
import com.example.cms.member.domain.Member;
import com.example.cms.member.domain.UserRoleEnum;
import com.example.cms.member.exception.MemberAlreadyExistException;
import com.example.cms.member.exception.MemberNotFoundException;
import com.example.cms.member.repository.MemberRepository;
import com.example.security.JwtProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SignService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public SignService(MemberRepository memberRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    @Transactional
    public SignResponse login(SignRequest request) {
        Member member = memberRepository.findByMobile(request.getMobile())
                .orElseThrow(() -> new MemberNotFoundException("잘못된 번호입니다."));

        if(passwordEncoder.matches(request.getPassword(), member.getPassword())){
            throw new IllegalStateException("잘못된 비밀번호 입니다.");
        }

        SignResponse result = SignResponse.of(member);

        List<String> roles = new ArrayList<>();
        roles.add(member.getRole().name());
        result.setToken(jwtProvider.createToken(member.getMobile(),roles));

        return result;
    }


    @Transactional
    public SignResponse join(SignRequest request) {
        try {
            if (memberRepository.existsByMobile(request.getMobile())) {
                throw new MemberAlreadyExistException("이미 가입된 번호입니다.");
                }

            String password = passwordEncoder.encode(request.getPassword());
            Member member = request.toEntity(password, UserRoleEnum.USER);

            memberRepository.save(member);
        }catch (Exception e){
            throw new IllegalStateException("가입에 실패하였습니다.");
        }

        Member joinMember = memberRepository.findByMobile(request.getMobile())
                .orElseThrow(()-> new MemberNotFoundException("no member"));

        return SignResponse.of(joinMember);
    }
}
