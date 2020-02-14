package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.service.GetModelAndView;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainAdminSiteController {

  @Autowired
  GetModelAndView getModelAndView;

  @RequestMapping("/pay-main-admin")
  public ModelAndView getMainAdminSite() {
    Map<String, Object> params = getParams("main-site-admin");
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username;
    if (principal instanceof UserDetails) {
      username = ((UserDetails) principal).getUsername();
    } else {
      username = principal.toString();
    }
    params.put("username", username);
    return new ModelAndView("main-site-admin", params);
  }

  private Map<String, Object> getParams(String page){
    return getModelAndView.getModelAndViewParams(page);
  }


}
