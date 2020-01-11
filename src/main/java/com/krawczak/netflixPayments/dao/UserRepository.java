package com.krawczak.netflixPayments.dao;

import com.krawczak.netflixPayments.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

  User findByEmail(String email);


}
