package com.example.cms.api.member;

import com.example.cms.api.member.response.MemberResponse;
import com.example.cms.domain.member.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberApiController {

    private MemberService memberService;

    public MemberApiController(MemberService memberService) {
        this.memberService = memberService;
    }

//    @GetMapping
//    public List<MemberResponse> findAll(){
//        return memberService.findAll();
//    }
}
