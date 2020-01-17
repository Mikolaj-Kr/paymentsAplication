package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.service.GetModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

  @RequestMapping("/login")
  public ModelAndView getLoginPage(){
    return getModelAndView("login");
  }

  private ModelAndView getModelAndView (String page){
    GetModelAndView getModelAndView = new GetModelAndView();
    return getModelAndView.getModelAndView(page);
  }

}
