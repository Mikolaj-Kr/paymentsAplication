package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.configuration.ModelAndViewConfig;
import com.krawczak.netflixPayments.service.UserService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainSiteController {

  @Autowired
  UserService userService;

  @RequestMapping("/pay-main")
  public ModelAndView getMain(){
    return getModelAndView("main");
  }

  private ModelAndView getModelAndView(String page){
    ModelAndViewConfig modelAndViewConfig = new ModelAndViewConfig();
    return modelAndViewConfig.getModelAndView(page);
  }
}
