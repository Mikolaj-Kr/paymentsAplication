package com.krawczak.netflixPayments.service;

import java.util.HashMap;
import java.util.Map;

import com.krawczak.netflixPayments.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class GetModelAndView {

  private final UserRepository userRepository;

  @Autowired
  public GetModelAndView(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Map<String, Object> getModelAndViewParams(String page) {
    Map<String, Object> params = new HashMap<>();
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username;
    if (principal instanceof UserDetails) {
      username = ((UserDetails) principal).getUsername();
    } else {
      username = principal.toString();
    }
    params.put("site", page);
    params.put("username", username);
    params.put("user", userRepository.findUsersByUsername(username));
    return params;
  }

}
