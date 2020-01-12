package com.krawczak.netflixPayments.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainSiteController {

  @RequestMapping("/pay-main")
  public ModelAndView getMain(){
    Map<String, Object> params = new HashMap<>();
    return new  ModelAndView("main-site", params);
  }
}
