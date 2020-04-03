package com.krawczak.netflixPayments.controller.adminContollers;

import com.krawczak.netflixPayments.configuration.PasswordEncoder;
import com.krawczak.netflixPayments.domain.entity.Authorities;
import com.krawczak.netflixPayments.domain.entity.Authority;
import com.krawczak.netflixPayments.domain.entity.Payment;
import com.krawczak.netflixPayments.domain.entity.Users;
import com.krawczak.netflixPayments.repositories.AuthorityRepository;
import com.krawczak.netflixPayments.service.*;

import java.time.LocalDate;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletResponse;

@Controller
public class CreateAdminUser {

    @Autowired
    UserService userService;

    @Autowired
    AuthoritiesService authoritiesService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    PaymentService paymentService;

    @Autowired
    GetModelAndView getModelAndView;

    @Autowired
    AuthorityService authorityService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/pay-add-admin")
    public ModelAndView getAdmin() {
      Random random = new Random();
        Map<String, Object> params = getModelAndView.getModelAndViewParams("main");
        Users users = new Users();
        Authorities authorities = new Authorities();
        Authorities authorities2 = new Authorities();
        Authority authority = new Authority();
        Authority authority2 = new Authority();
        Payment payment = new Payment();
        Payment paymentBefore = new Payment();
        Payment nextPayment = new Payment();
        users.setName("Mikołaj");
        users.setSurname("Krawczak");
        users.setPassword(passwordEncoder.bCryptPasswordEncoder().encode("Mikolaj2511"));
        users.setUsername("mikolak25@gmail.com");
        users.setEnabled(1);
        users.setChangePasswordCode(passwordEncoder.bCryptPasswordEncoder().encode(String.valueOf(random.nextLong())));
        authorities.setUsers(users);
        authorities2.setUsers(users);
        authority.setAuthority("ADMIN");
        authority2.setAuthority("USER");
        authorities.setAuthority(authority);
        authorities2.setAuthority(authority2);
        payment.setAmountOfPayment(0L);
        payment.setDateOfPayment(LocalDate.now());
        payment.setUsers(users);
        paymentBefore.setAmountOfPayment(0L);
        paymentBefore.setDateOfPayment(LocalDate.now().plusMonths(1L));
        paymentBefore.setUsers(users);
        nextPayment.setAmountOfPayment(0L);
        nextPayment.setDateOfPayment(LocalDate.now().minusMonths(1L));
        nextPayment.setUsers(users);

        userService.saveUser(users);
        authorityService.saveAuthority(authority);
        authorityService.saveAuthority(authority2);
        authoritiesService.saveAuthorities(authorities);
        authoritiesService.saveAuthorities(authorities2);
        paymentService.savePayment(paymentBefore);
        paymentService.savePayment(payment);
        paymentService.savePayment(nextPayment);

        logger.info("Admin added to DB");

        return new ModelAndView("main-site", params);
    }
}
