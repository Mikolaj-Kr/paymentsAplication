package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.service.GetModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

  @Autowired
  GetModelAndView getModelAndView;

  @RequestMapping("/login")
  public ModelAndView getLoginPage() {
    return getModelAndView("login");
  }

  private ModelAndView getModelAndView(String page) {
    return getModelAndView.getModelAndView(page);
  }
}
