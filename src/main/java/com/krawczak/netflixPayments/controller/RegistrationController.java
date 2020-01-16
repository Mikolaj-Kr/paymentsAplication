package com.krawczak.netflixPayments.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

  @RequestMapping("/pay-registration")
  public ModelAndView getRegistration(){
    Map<String, Object> params = new HashMap<>();
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username;
    if (principal instanceof UserDetails) {
      username = ((UserDetails)principal).getUsername();
    } else {
      username = principal.toString();
    }
    params.put("site", "registration");
    params.put("username", username);
    return new ModelAndView("main-site", params);
  }

  @PostMapping("/pay-registration")
  public ResponseEntity<String> addNewUser(){
    return new ResponseEntity<>("hello", HttpStatus.OK);
  }


}
