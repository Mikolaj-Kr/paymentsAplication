package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordService {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public int changeUserPassword(String username, String oldPassword, String password, String password2){
        if(passwordEncoder.matches(oldPassword, userService.findUserByUsername(username).getPassword()) && password.equals(password2)){
            Users users = userService.findUserByUsername(username);
            users.setPassword(passwordEncoder.encode(password));
            userService.saveUser(users);
            return 1;
        } else if(password.equals(password2)){
            return 2;
        } else {
            return 3;
        }
    }
}
