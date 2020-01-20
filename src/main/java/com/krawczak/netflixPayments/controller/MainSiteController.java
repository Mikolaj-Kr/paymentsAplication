package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainSiteController {

  @Autowired
  UserService userService;

  @RequestMapping("/pay-main")
  public ModelAndView getMain() {
    return getModelAndView("main");
  }

  private ModelAndView getModelAndView(String page) {
    GetModelAndView getModelAndView = new GetModelAndView();
    return getModelAndView.getModelAndView(page);
  }
}
