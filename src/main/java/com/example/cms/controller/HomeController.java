package com.example.cms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

  @GetMapping("/")
  public String customerIndex() {


    return "home/home";
  }
}
