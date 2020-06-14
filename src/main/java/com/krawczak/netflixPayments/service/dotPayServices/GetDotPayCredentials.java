package com.krawczak.netflixPayments.service.dotPayServices;

import com.krawczak.netflixPayments.domain.entity.Credentials;
import com.krawczak.netflixPayments.repositories.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetDotPayCredentials {

    private final CredentialsRepository credentialsRepository;

    @Autowired
    public GetDotPayCredentials(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    public Credentials findCredentialsById(String id){
        return credentialsRepository.findCredentialsById(id);
    }

}
