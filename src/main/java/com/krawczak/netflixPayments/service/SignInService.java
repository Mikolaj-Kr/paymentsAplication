package com.krawczak.netflixPayments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInService {

  @Autowired
  UserService userService;

  public boolean signInCheckout (String email, String password){
    return userService.findUserByEmail(email) != null;
  }

}
