package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.entity.Authority;
import com.krawczak.netflixPayments.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

    @Autowired
    AuthorityRepository authorityRepository;

    public void saveAuthority(Authority authority){
        authorityRepository.save(authority);
    }
}
