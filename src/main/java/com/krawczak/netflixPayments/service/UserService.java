package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.dao.UserRepository;
import com.krawczak.netflixPayments.dto.UserDto;
import com.krawczak.netflixPayments.mapper.MapUserToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private MapUserToDto mapUserToDto;

  public UserDto findUserByEmail(String email){
    return mapUserToDto.userToDto(userRepository.findByEmail(email));
  }

}
