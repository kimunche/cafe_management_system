package com.example.cms.member;


import com.example.cms.member.controller.request.MemberCreateRequest;
import com.example.cms.member.domain.MemberStatus;
import com.example.cms.member.service.MemberService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;
    @PostConstruct
    public void init() {
        initService.dbInit1();

    }
    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final MemberService memberService;
        public void dbInit1(){
            for(int i = 0; i<5; i++){
                MemberCreateRequest memberCreateRequest = new MemberCreateRequest("1234" + i,"kim" +i ,LocalDate.now(),MemberStatus.OPEN);
                memberService.save(memberCreateRequest);
            }

        }
    }
}
