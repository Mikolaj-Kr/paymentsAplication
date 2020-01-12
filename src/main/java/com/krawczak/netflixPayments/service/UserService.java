package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.entity.Role;
import com.krawczak.netflixPayments.domain.entity.User;
import com.krawczak.netflixPayments.domain.dto.UserDto;
import com.krawczak.netflixPayments.mapper.MapUserToDto;
import com.krawczak.netflixPayments.repositories.RoleRepository;
import com.krawczak.netflixPayments.repositories.UserRepository;
import java.util.Arrays;
import java.util.HashSet;
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

  public UserDto findUserByEmail(String email){
    return mapUserToDto.userToDto(userRepository.findByEmail(email)) ;
  }

  public void saveUser(User user){
    user.setPassword(user.getPassword());
    user.setActive(1);
    Role userRole = roleRepository.findByRoleType("ADMIN");
    user.setRole(user.getRole());
    userRepository.save(user);
  }



}
