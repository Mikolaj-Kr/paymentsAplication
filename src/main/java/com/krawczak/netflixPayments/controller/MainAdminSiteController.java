package com.krawczak.netflixPayments.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainAdminSiteController {

  @RequestMapping("/pay-main-admin")
  public ModelAndView getMainAdminSite() {
    Object principal = SecurityContextHolder.getContext().getAuthentication();
    Map<String, Object> params = new HashMap<>();
    String username = ((UserDetails)principal).getUsername();
    return new ModelAndView("main-site-admin", params);
  }

}
