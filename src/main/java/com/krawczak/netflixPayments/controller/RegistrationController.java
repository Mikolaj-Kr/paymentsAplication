package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.configuration.PasswordEncoder;
import com.krawczak.netflixPayments.domain.entity.Authorities;
import com.krawczak.netflixPayments.domain.entity.Users;
import com.krawczak.netflixPayments.service.AuthoritiesService;
import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.UserService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  UserService userService;

  @Autowired
  AuthoritiesService authoritiesService;

  Logger logger = LoggerFactory.getLogger(this.getClass());


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
      @RequestParam(value = "password2", required = true) String password2,
      @RequestParam(value = "email", required = true) String email,
      HttpServletResponse response, HttpServletRequest request) throws IOException {
    if (!password.equals(password2)) {
      response.sendRedirect("/pay-registration-wrong-password");
      logger.info("Registration of user:" + name + " failed. passwords is not valid");
      return new ResponseEntity<>(name, HttpStatus.OK);
    }
    if (userService.findUserByUsername(username) != null) {
      response.sendRedirect("pay-registration-wrong-username");
      logger.info("Registration failed, username: " + username + " already taken");
      return new ResponseEntity<>(name, HttpStatus.OK);
    }

    Users users = new Users();
    Authorities authorities = new Authorities();
    users.setName(name);
    users.setSurname(surname);
    users.setPassword(passwordEncoder.bCryptPasswordEncoder().encode(password));
    users.setUsername(username);
    users.setPayments(null);
    users.setEnabled(1);
    users.setEmail(email);
    authorities.setUsers(users);
    authorities.setAuthority("User");

    userService.saveUser(users);
    authoritiesService.saveAuthorities(authorities);

    logger.info("User " + username + "Added to DB");

    response.sendRedirect("/pay-registration-success");

    return new ResponseEntity<>(name, HttpStatus.OK);
  }

  @GetMapping("/pay-registration-success")
  public ModelAndView registrationSuccess() {
    return getModelAndView("registrationSuccess");
  }

  @GetMapping("/pay-registration-wrong-password")
  public ModelAndView registrationWrongPassword() {
    return getModelAndView("registrationPasswordNotEquals");
  }

  @GetMapping("/pay-registration-wrong-username")
  public ModelAndView registrationWrongUsername() {
    return getModelAndView("registrationUsernameAlreadyTaken");
  }

  private ModelAndView getModelAndView(String page) {
    GetModelAndView getModelAndView = new GetModelAndView();
    return getModelAndView.getModelAndView(page);
  }
}
