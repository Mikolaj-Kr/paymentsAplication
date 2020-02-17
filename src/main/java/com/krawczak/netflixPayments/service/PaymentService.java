package com.krawczak.netflixPayments.service;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.krawczak.netflixPayments.domain.dto.PaymentDto;
import com.krawczak.netflixPayments.domain.dto.PaymentsForUsersDto;
import com.krawczak.netflixPayments.domain.dto.UserDto;
import com.krawczak.netflixPayments.domain.entity.Payment;
import com.krawczak.netflixPayments.mapper.MapPaymentToDto;
import com.krawczak.netflixPayments.mapper.MapUserToDto;
import com.krawczak.netflixPayments.repositories.PaymentsRepository;
import com.krawczak.netflixPayments.repositories.UserRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  @Autowired
  PaymentsRepository paymentsRepository;

  @Autowired
  MapPaymentToDto mapPaymentToDto;

  @Autowired
  GetMonth getMonth;

  @Autowired
  UserRepository userRepository;

  @Autowired
  MapUserToDto mapUserToDto;

  public List<PaymentDto> getUserPayments(String username) {
    List<PaymentDto> paymentsList = new ArrayList<>();
        paymentsRepository.findPaymentByUsers(userRepository.findUsersByUsername(username))
        .forEach(payment -> paymentsList.add(mapPaymentToDto.paymentDto(payment)));
    return paymentsList;
  }

  public List<PaymentDto> getAllPayment(){
    List <Payment> payments = paymentsRepository.findAll();
    List <PaymentDto> paymentsDto = new ArrayList<>();

    payments.forEach(payment -> paymentsDto.add(mapPaymentToDto.paymentDto(payment)));

    return paymentsDto;
  }

  public List<PaymentsForUsersDto> getPaymentsForUsers(String username) {
    List<PaymentDto> userPayments = getUserPayments(username);
    List<PaymentsForUsersDto> paymentsList = new ArrayList<>();
    LocalDate date = LocalDate.now();
    PaymentsForUsersDto paymentsForUsersDto = new PaymentsForUsersDto();
    int numberOfMonths = 1;
      return paymentsList;
    }
  }

