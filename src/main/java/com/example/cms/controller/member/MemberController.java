package com.example.cms.controller.member;

import com.example.cms.controller.CustomerController;
import com.example.cms.controller.JsonParseController;
import com.example.cms.controller.member.response.MemberResponse;
import com.example.cms.domain.member.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<MemberResponse> findAll(){
        return memberService.findAll();
    }
}
