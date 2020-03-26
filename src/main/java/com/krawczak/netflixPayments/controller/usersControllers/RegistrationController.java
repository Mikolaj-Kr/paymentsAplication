package com.krawczak.netflixPayments.controller.usersControllers;

import com.krawczak.netflixPayments.configuration.PasswordEncoder;
import com.krawczak.netflixPayments.domain.entity.Authorities;
import com.krawczak.netflixPayments.domain.entity.Payment;
import com.krawczak.netflixPayments.domain.entity.Users;
import com.krawczak.netflixPayments.email.MailService;
import com.krawczak.netflixPayments.service.AuthoritiesService;
import com.krawczak.netflixPayments.service.GetModelAndView;
import com.krawczak.netflixPayments.service.PaymentService;
import com.krawczak.netflixPayments.service.UserService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Random;
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

  @Autowired
  GetModelAndView getModelAndView;

  @Autowired
  PaymentService paymentService;

  @Autowired
  MailService mailService;

  Logger logger = LoggerFactory.getLogger(this.getClass());


  @RequestMapping("/pay-registration")
  public ModelAndView getRegistration() {
    return new ModelAndView("main-site", getModelAndView("registration"));
  }

  @PostMapping("/pay-registration")
  public ResponseEntity<String> addNewUser(
      @RequestParam(value = "name") String name,
      @RequestParam(value = "surname") String surname,
      @RequestParam(value = "username") String username,
      @RequestParam(value = "password") String password,
      @RequestParam(value = "password2") String password2,
      HttpServletResponse response) throws IOException {
    if (!password.equals(password2)) {
      response.sendRedirect("/pay-registration-wrong-password");
      logger.info("Registration of user:" + name + " failed. passwords is not valid");
      return new ResponseEntity<>(name, HttpStatus.OK);
    } else if (userService.findUserByUsername(username) != null) {
      response.sendRedirect("pay-registration-wrong-username");
      logger.info("Registration failed, username: " + username + " already taken");
      return new ResponseEntity<>(name, HttpStatus.OK);
    }

    Random random = new Random();

    Users users = new Users();
    Authorities authorities = new Authorities();
    Payment payment = new Payment();
    Payment paymentBefore = new Payment();
    Payment nextPayment = new Payment();
    users.setName(name);
    users.setSurname(surname);
    users.setPassword(passwordEncoder.bCryptPasswordEncoder().encode(password));
    users.setUsername(username);
    users.setEnabled(0);
    users.setChangePasswordCode(passwordEncoder.bCryptPasswordEncoder().encode(String.valueOf(random.nextLong())));
    authorities.setUsers(users);
    authorities.setAuthority("User");
    payment.setAmountOfPayment(0L);
    payment.setDateOfPayment(LocalDate.now());
    payment.setStatus("unpaid");
    payment.setUsers(users);
    paymentBefore.setAmountOfPayment(0L);
    paymentBefore.setDateOfPayment(LocalDate.now().plusMonths(1L));
    paymentBefore.setStatus("unpaid");
    paymentBefore.setUsers(users);
    nextPayment.setAmountOfPayment(0L);
    nextPayment.setDateOfPayment(LocalDate.now().minusMonths(1L));
    nextPayment.setStatus("unpaid");
    nextPayment.setUsers(users);

    userService.saveUser(users);
    authoritiesService.saveAuthorities(authorities);
    paymentService.savePayment(nextPayment);
    paymentService.savePayment(payment);
    paymentService.savePayment(paymentBefore);



    logger.info("User " + username + "Added to DB");

    mailService.sendEmail(username, "Witaj " + username +" Wejdź w link aby aktywować konto    https://paymentmk.herokuapp.com/pay-registration-confirm?username=" + username, "Potwierdzenie rejestracji w serwisie płatności");

    response.sendRedirect("/pay-registration-success");

    return new ResponseEntity<>(name, HttpStatus.OK);
  }

  @GetMapping("/pay-registration-success")
  public ModelAndView registrationSuccess() {
    return new ModelAndView("main-site", getModelAndView("registrationSuccess"));
  }

  @GetMapping("/pay-registration-confirm")
  public ModelAndView registrationConfirm(HttpServletRequest request){
    Map<String, Object> params = getModelAndView.getModelAndViewParams("registrationConfirm");
    String username = request.getParameter("username");
    userService.confirmAccount(username);
    logger.info("Account " + username + " activated");
    return new ModelAndView("main-site", params );
  }

  @GetMapping("/pay-registration-wrong-password")
  public ModelAndView registrationWrongPassword() {
    return new ModelAndView("main-site", getModelAndView("registrationPasswordNotEquals"));
  }

  @GetMapping("/pay-registration-wrong-username")
  public ModelAndView registrationWrongUsername() {
    return new ModelAndView("main-site", getModelAndView("registrationUsernameAlreadyTaken"));
  }

  private Map<String, Object> getModelAndView(String page) {
    return getModelAndView.getModelAndViewParams(page);
  }
}
