package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.entity.Authorities;
import com.krawczak.netflixPayments.domain.entity.Users;
import com.krawczak.netflixPayments.repositories.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesService {

  private final AuthoritiesRepository authoritiesRepository;

  @Autowired
  public AuthoritiesService(AuthoritiesRepository authoritiesRepository) {
    this.authoritiesRepository = authoritiesRepository;
  }

  public void deleteAuthorities(Users users){
    authoritiesRepository.delete(authoritiesRepository.findAuthoritiesByUsers(users));
  }

  public void saveAuthorities(Authorities authorities) {
    authoritiesRepository.save(authorities);
  }

}
