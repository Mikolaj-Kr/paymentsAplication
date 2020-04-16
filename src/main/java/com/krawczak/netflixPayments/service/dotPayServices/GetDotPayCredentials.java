package com.krawczak.netflixPayments.service.dotPayServices;

import com.krawczak.netflixPayments.domain.entity.Credentials;
import com.krawczak.netflixPayments.repositories.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetDotPayCredentials {

    @Autowired
    CredentialsRepository credentialsRepository;

    public Credentials findCredentialsById(String id){
        return credentialsRepository.findCredentialsById(id);
    }

}
