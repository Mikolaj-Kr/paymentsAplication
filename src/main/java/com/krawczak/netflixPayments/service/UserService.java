package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.entity.Users;
import com.krawczak.netflixPayments.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public Users findUserByUsername(String username) {
    return userRepository.findUsersByUsername(username);
  }

  public void saveUser(Users users) {
    userRepository.save(users);
  }
}
