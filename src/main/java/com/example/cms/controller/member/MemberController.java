package com.example.cms.controller.member;

import com.example.cms.domain.member.Member;
import com.example.cms.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/member")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/list")
    public String MemberList(Model model){
        List<Member> members = memberService.findAll();
        model.addAttribute("members",members);
        return "member/memberList";
    }

    @GetMapping("/info/{id}")
    public String info(Model model, @PathVariable Long id){
        Optional<Member> member = memberService.findById(id);
        model.addAttribute("member",member);
        return "member/memberInfo";
    }

    @GetMapping("/edit")
    public String edit(Model model){

        return "member/memberEdit";
    }

    @PostMapping()
    public String MemberEdit(){

        return "redirect:/member/info";
    }

}
