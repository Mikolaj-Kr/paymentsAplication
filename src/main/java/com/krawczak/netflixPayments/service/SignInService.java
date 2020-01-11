package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInService {

  @Autowired
  UserService userService;

  public boolean signInCheckout (String login, String password){
    UserDto userDto = userService.findUserByLogin(login);
    return userDto != null;
  }

}
