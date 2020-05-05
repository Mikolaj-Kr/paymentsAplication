package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.dto.UsersDto;
import com.krawczak.netflixPayments.domain.entity.Users;
import com.krawczak.netflixPayments.mapper.MapUserToDto;
import com.krawczak.netflixPayments.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;

  private final MapUserToDto mapUserToDto;

  private final AuthoritiesService authoritiesService;

  private final PaymentService paymentService;

  public UserService(UserRepository userRepository, MapUserToDto mapUserToDto, AuthoritiesService authoritiesService, PaymentService paymentService) {
    this.userRepository = userRepository;
    this.mapUserToDto = mapUserToDto;
    this.authoritiesService = authoritiesService;
    this.paymentService = paymentService;
  }

  public Users findUserByUsername(String username) {
    return userRepository.findUsersByUsername(username);
  }

  public List<UsersDto> findAllUsers() {
    List<UsersDto> usersDtoList = new ArrayList<>();
    userRepository.findAll().forEach(users -> usersDtoList.add(mapUserToDto.userToDto(users)));
    return usersDtoList;
  }

  public void confirmAccount(String username) {
  Users user = findUserByUsername(username);
  user.setEnabled(1);
  saveUser(user);
  }

  public void saveUser(Users users) {
    userRepository.save(users);
  }

  public void deleteUser(String username) {
    authoritiesService.deleteAuthorities(findUserByUsername(username));
    paymentService.deleteUserPayments(findUserByUsername(username));
    userRepository.delete(findUserByUsername(username));
  }
}
