package com.example.cms.controller.member;

import com.example.cms.controller.member.form.MemberCreateForm;
import com.example.cms.controller.member.form.MemberEditForm;
import com.example.cms.domain.member.Member;
import com.example.cms.domain.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

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
        Member member = memberService.findById(id).get();
        model.addAttribute("member",member);
        return "member/memberInfo";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id){
        Member member = memberService.findById(id).get();
        model.addAttribute("member",member);
        return "member/memberEdit";
    }

    @PostMapping("/edit/{id}")
    public String MemberEdit(@PathVariable Long id, @ModelAttribute("member") MemberEditForm form,
                             RedirectAttributes redirectAttributes){
        memberService.edit(id,form.getName(),form.getEmail(),form.getAge(),form.getPhone());
        redirectAttributes.addAttribute("id",id);
        return "redirect:/member/info/{id}";
    }

    @GetMapping("/create")
    public String createMember(Model model){
        model.addAttribute("memberCreate", new MemberCreateForm());
        return "member/memberCreate";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("memberCreate") MemberCreateForm memberCreateForm,
                         RedirectAttributes redirectAttributes){
        Member member = memberService.create(memberCreateForm);
        Long id = memberService.findById(member.getId()).get().getId();
        redirectAttributes.addAttribute("id",id);
        return "redirect:/member/info/{id}";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){

        Member member = memberService.findById(id).get();
        memberService.delete(member);

        return "redirect:/member/list";
    }

}
