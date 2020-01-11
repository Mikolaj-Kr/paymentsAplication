package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.dto.UserDto;
import com.krawczak.netflixPayments.entity.User;
import com.krawczak.netflixPayments.mapper.MapUserToDto;
import com.krawczak.netflixPayments.service.SignInService;
import com.krawczak.netflixPayments.service.UserService;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignInController {

  @Autowired
  SignInService signInService;


  @RequestMapping("/pay")
  public ModelAndView getLogin() {
    Map<String, Object> params = new HashMap<>();
    return new ModelAndView("sign-in", params);
  }

  @PostMapping("/pay")
  public ResponseEntity<String> signIn(@RequestParam(value = "login") String login,
      @RequestParam(value = "password", required = false) String password, HttpServletResponse response, HttpServletRequest request)
      throws IOException {
    if(signInService.signInCheckout(login,password)){

    }



    return new ResponseEntity<>(login, HttpStatus.OK);
  }


}
