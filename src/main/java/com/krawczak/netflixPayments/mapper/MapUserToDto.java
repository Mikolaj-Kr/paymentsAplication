package com.krawczak.netflixPayments.mapper;

import com.krawczak.netflixPayments.dto.UserDto;
import com.krawczak.netflixPayments.entity.User;
import org.springframework.stereotype.Service;

@Service
public class MapUserToDto {



  public UserDto userToDto(User user){
    UserDto userDto = new UserDto();

    userDto.setId(user.getId());
    userDto.setLogin(user.getLogin());
    userDto.setName(user.getName());
    userDto.setSurname(user.getSurname());
    userDto.setPassword(user.getPassword());

    return userDto;
  }

}
