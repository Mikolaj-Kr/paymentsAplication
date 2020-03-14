package com.krawczak.netflixPayments.mapper;

import com.krawczak.netflixPayments.domain.dto.UsersDto;
import com.krawczak.netflixPayments.domain.entity.Users;
import org.springframework.stereotype.Service;

@Service
public class MapUserToDto {


  public UsersDto userToDto(Users users) {
    UsersDto usersDto = new UsersDto();

    usersDto.setUsername(users.getUsername());
    usersDto.setName(users.getName());
    usersDto.setSurname(users.getSurname());

    return usersDto;
  }
}
