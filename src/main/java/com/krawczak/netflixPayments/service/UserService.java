package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.entity.Authorities;
import com.krawczak.netflixPayments.domain.entity.User;
import com.krawczak.netflixPayments.domain.dto.UserDto;
import com.krawczak.netflixPayments.mapper.MapUserToDto;
import com.krawczak.netflixPayments.repositories.RoleRepository;
import com.krawczak.netflixPayments.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private MapUserToDto mapUserToDto;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  public UserDto findUserByUsername(String username){
    return mapUserToDto.userToDto(userRepository.findByUsername(username)) ;
  }




}
