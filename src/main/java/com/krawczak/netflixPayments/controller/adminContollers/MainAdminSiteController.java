package com.krawczak.netflixPayments.controller.adminContollers;

import com.krawczak.netflixPayments.service.GetModelAndView;

import java.util.HashMap;
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
   Map<String, Object> params = getParams("main-admin");

     return new ModelAndView("main-site", params);
  }

  private Map<String, Object> getParams(String page){
    return getModelAndView.getModelAndViewParams(page);
  }


}
