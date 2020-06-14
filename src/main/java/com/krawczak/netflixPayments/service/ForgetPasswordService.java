package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.configuration.PasswordEncoder;
import com.krawczak.netflixPayments.domain.entity.Users;
import com.krawczak.netflixPayments.email.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ForgetPasswordService {

    private final MailService mailService;

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public ForgetPasswordService(MailService mailService, UserService userService, PasswordEncoder passwordEncoder) {
        this.mailService = mailService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public void forgetPassword(String username) {
        Random random = new Random();
        String randomLong = String.valueOf(random.nextLong());
        Users users = userService.findUserByUsername(username);
        users.setChangePasswordCode(passwordEncoder.bCryptPasswordEncoder().encode((randomLong)));
        userService.saveUser(users);
        mailService.sendEmail(username, "Aby odzyskać hasło do swojego konta, użyj linku.  https://paymentmk.herokuapp.com/pay-forget-change-password?code=" + randomLong + "&username=" + username, "Odzyskiwanie hasła");
    }

    public String changePassword(String password, String password2, String username, String code) {
        Users users = userService.findUserByUsername(username);
        Random random = new Random();

        if (passwordEncoder.bCryptPasswordEncoder().matches(code, userService.findUserByUsername(username).getChangePasswordCode())) {
            if (password.equals(password2)) {
                users.setPassword(passwordEncoder.bCryptPasswordEncoder().encode(password));
                users.setChangePasswordCode(passwordEncoder.bCryptPasswordEncoder().encode(String.valueOf(random.nextLong())));
                userService.saveUser(users);
                return "ok";
            } else {
                return "password not equals";
            }
        } else {
            return "wrongParameters";
        }
    }
}
