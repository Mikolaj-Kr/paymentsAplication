package com.krawczak.netflixPayments.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {

  @RequestMapping("/pay-main")
  public ModelAndView getMainSite(HttpServletRequest request, HttpServletResponse response){
    Map<String, Object> params = new HashMap<>();

    return new ModelAndView("main-site", params);
  }

}
