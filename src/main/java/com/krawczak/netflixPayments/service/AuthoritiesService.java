package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.entity.Authorities;
import com.krawczak.netflixPayments.domain.entity.Users;
import com.krawczak.netflixPayments.repositories.AuthoritiesRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesService {

  @Autowired
  AuthoritiesRepository authoritiesRepository;

  public void deleteAuthorities(Users users){
    authoritiesRepository.delete(authoritiesRepository.findAuthoritiesByUsers(users));
  }

  public void saveAuthorities(Authorities authorities) {
    authoritiesRepository.save(authorities);
  }

}
