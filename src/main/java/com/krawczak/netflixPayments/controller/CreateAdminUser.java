package com.krawczak.netflixPayments.controller;

import com.krawczak.netflixPayments.configuration.PasswordEncoder;
import com.krawczak.netflixPayments.domain.entity.Authorities;
import com.krawczak.netflixPayments.domain.entity.Payment;
import com.krawczak.netflixPayments.domain.entity.Users;
import com.krawczak.netflixPayments.service.AuthoritiesService;
import com.krawczak.netflixPayments.service.UserService;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateAdminUser {

  @Autowired
  UserService userService;

  @Autowired
  AuthoritiesService authoritiesService;

  @Autowired
  PasswordEncoder passwordEncoder;

  @RequestMapping("pay-add-admin")
  public ModelAndView getAdmin(){
    Users users = new Users();
    users.setEnabled(1);
    users.setName("mikolaj");
    users.setPassword(passwordEncoder
        .bCryptPasswordEncoder()
        .encode("mikolaj"));
    users.setSurname("krawczak");
    users.setUsername("mikolaj");


    Authorities authorities = new Authorities();
    authorities.setAuthority("ADMIN");
    authorities.setUsers(users);



    List<Authorities> authoritiesList = new ArrayList<>();
    authoritiesList.add(authorities);

    users.setAuthorities(authoritiesList);

    userService.saveUser(users);

    authoritiesService.saveAuthorities(authorities);

    Map<String, Object> params = new HashMap<>();
    return new ModelAndView("main-site",params);
  }


}
