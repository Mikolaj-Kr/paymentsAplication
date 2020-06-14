package com.krawczak.netflixPayments.repositories;

import com.krawczak.netflixPayments.domain.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {

    Credentials findCredentialsById(String id);
}
