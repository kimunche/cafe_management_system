package com.example.cms.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/customer")
public class CustomerController {
  @GetMapping
  public ModelAndView customerIndex() {
    ModelAndView mav = new ModelAndView("customer");
    return mav;
  }
}
