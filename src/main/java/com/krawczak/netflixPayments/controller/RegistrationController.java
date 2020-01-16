package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.configuration.ModelAndViewConfig;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

  @RequestMapping("/pay-registration")
  public ModelAndView getRegistration() {
    return getModelAndView("registration");
  }

  @PostMapping("/pay-registration")
  public ResponseEntity<String> addNewUser(
      @RequestParam(value = "name", required = true) String name,
      @RequestParam(value = "surname", required = true) String surname,
      @RequestParam(value = "username", required = true) String username,
      @RequestParam(value = "password", required = true) String password,
      HttpServletResponse response, HttpServletRequest request) throws IOException {

    response.sendRedirect("/pay-registration-success");

    return new ResponseEntity<>(name, HttpStatus.OK);
  }

  @GetMapping("/pay-registration-success")
  public ModelAndView registrationSuccess() {
    return getModelAndView("registrationSuccess");
  }

  private ModelAndView getModelAndView(String page) {
    ModelAndViewConfig modelAndViewConfig = new ModelAndViewConfig();
    return modelAndViewConfig.getModelAndView(page);
  }

}
