package com.krawczak.netflixPayments.mapper;

import com.krawczak.netflixPayments.domain.dto.UserDto;
import com.krawczak.netflixPayments.domain.entity.Users;
import org.springframework.stereotype.Service;

@Service
public class MapUserToDto {


  public UserDto userToDto(Users users) {
    UserDto userDto = new UserDto();

    userDto.setUsername(users.getUsername());
    userDto.setName(users.getName());
    userDto.setSurname(users.getSurname());

    return userDto;
  }
}
