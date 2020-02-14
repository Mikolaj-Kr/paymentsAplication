package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.service.GetModelAndView;
import java.util.Map;
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
    return new  ModelAndView("main-site", getModelAndViewParams("login"));
  }

  private Map<String, Object> getModelAndViewParams(String page) {
    return getModelAndView.getModelAndViewParams(page);
  }
      }
