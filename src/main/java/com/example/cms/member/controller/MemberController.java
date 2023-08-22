package com.example.cms.member.controller;


import com.example.cms.member.controller.request.MemberCreateRequest;
import com.example.cms.member.controller.request.MemberUpdateRequest;
import com.example.cms.member.controller.response.MemberCreateResponse;
import com.example.cms.member.controller.response.MemberResponse;
import com.example.cms.member.controller.response.MemberUpdateResponse;

import com.example.cms.member.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Member", description = "회원 API")
@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @Operation(summary = "회원 생성", description = "회원에 대한 생성을 진행합니다.")
    @PostMapping("/create")
    public MemberCreateResponse createMember(@RequestBody @Valid MemberCreateRequest request){
        return memberService.save(request);
    }

    @GetMapping("/{phone}")
    public MemberResponse findMembership(@PathVariable String phone){
        return memberService.findMembership(phone);
    }

    @PatchMapping("/{previousPhone}/update")
    public MemberUpdateResponse updateMember(@PathVariable String previousPhone, @RequestBody @Valid MemberUpdateRequest request){
        return memberService.memberUpdate(previousPhone,request.getMobile(), request.getName());
    }
}
