package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.dto.UserDto;
import com.krawczak.netflixPayments.domain.entity.Users;
import com.krawczak.netflixPayments.mapper.MapUserToDto;
import com.krawczak.netflixPayments.repositories.AuthoritiesRepository;
import com.krawczak.netflixPayments.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;
  private MapUserToDto mapUserToDto;
  private BCryptPasswordEncoder bCryptPasswordEncoder;



  public UserDto findUserByUsername(String username){
    return mapUserToDto.userToDto(userRepository.findByUsername(username)) ;
  }

  public void saveUser(Users users){
    userRepository.save(users);
  }




}
