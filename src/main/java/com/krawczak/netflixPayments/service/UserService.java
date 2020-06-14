package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.dto.UsersDto;
import com.krawczak.netflixPayments.domain.entity.Users;
import com.krawczak.netflixPayments.mapper.MapUserToDto;
import com.krawczak.netflixPayments.repositories.AuthoritiesRepository;
import com.krawczak.netflixPayments.repositories.PaymentsRepository;
import com.krawczak.netflixPayments.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final MapUserToDto mapUserToDto;

    private final AuthoritiesRepository authoritiesRepository;

    private final PaymentsRepository paymentsRepository;

    @Autowired
    public UserService(UserRepository userRepository, MapUserToDto mapUserToDto, AuthoritiesRepository authoritiesRepository, PaymentsRepository paymentsRepository) {
        this.userRepository = userRepository;
        this.mapUserToDto = mapUserToDto;
        this.authoritiesRepository = authoritiesRepository;
        this.paymentsRepository = paymentsRepository;
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
        authoritiesRepository.delete(authoritiesRepository.findAuthoritiesByUsers(findUserByUsername(username)));
        paymentsRepository.findPaymentByUsersOrderByDateOfPayment(findUserByUsername(username)).forEach(paymentsRepository::delete);
        userRepository.delete(findUserByUsername(username));
    }
}
