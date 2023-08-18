package com.example.cms.member.controller;


import com.example.cms.member.controller.request.MemberCreateRequest;
import com.example.cms.member.controller.response.MemberCreateResponse;
import com.example.cms.member.controller.response.MemberResponse;
import com.example.cms.member.domain.Member;
import com.example.cms.member.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @PostMapping("/create")
    public MemberCreateResponse createMember(@RequestBody @Valid MemberCreateRequest request){
        return new MemberCreateResponse(memberService.save(request));
    }

}
