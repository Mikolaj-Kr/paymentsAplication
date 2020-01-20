package com.krawczak.netflixPayments.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;

public class GetModelAndView {

  public ModelAndView getModelAndView(String page) {
    Map<String, Object> params = new HashMap<>();
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username;
    if (principal instanceof UserDetails) {
      username = ((UserDetails) principal).getUsername();
    } else {
      username = principal.toString();
    }
    params.put("site", page);
    params.put("username", username);
    return new ModelAndView("main-site", params);
  }
}
