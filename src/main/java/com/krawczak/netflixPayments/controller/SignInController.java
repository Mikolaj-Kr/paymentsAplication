package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.service.SignInService;
import com.krawczak.netflixPayments.service.UserService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignInController {

  @Autowired
  SignInService signInService;

  @Autowired
  UserService userService;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());


  @RequestMapping("/pay")
  public ModelAndView getLogin() {
    Map<String, Object> params = new HashMap<>();
    return new ModelAndView("sign-in", params);
  }

  @PostMapping("/pay")
  public ResponseEntity<String> signIn(@RequestParam(value = "email") String email,
      @RequestParam(value = "password", required = false) String password,
      HttpServletResponse response, HttpServletRequest request)
      throws IOException {
    if (signInService.signInCheckout(email, password)) {
      logger.info(email + " sign in");
      request.getSession().setAttribute("userId", userService.findUserByEmail(email).getId());
      response.sendRedirect("/pay-main-admin");
    } else {
      logger.info(email + " try to sign in with wrong data");
    }

    return new ResponseEntity<>("złe dane logowania", HttpStatus.OK);
  }


}
