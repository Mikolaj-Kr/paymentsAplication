package com.krawczak.netflixPayments.repositories;

import com.krawczak.netflixPayments.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findUsersByUsername(String username);
}
