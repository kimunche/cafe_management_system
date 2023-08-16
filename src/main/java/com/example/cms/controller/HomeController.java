package com.example.cms.controller;


import com.example.cms.domain.member.Member;
import com.example.cms.domain.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

  private MemberService memberService;

  public HomeController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/")
  public String customerIndex() {


    return "home/home";
  }
}
