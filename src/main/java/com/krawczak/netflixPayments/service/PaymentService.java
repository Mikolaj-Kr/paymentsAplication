package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.dto.PaymentDto;
import com.krawczak.netflixPayments.domain.entity.Payment;
import com.krawczak.netflixPayments.mapper.MapPaymentToDto;
import com.krawczak.netflixPayments.mapper.MapUserToDto;
import com.krawczak.netflixPayments.repositories.PaymentsRepository;
import com.krawczak.netflixPayments.repositories.UserRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  Logger logger = LoggerFactory.getLogger(this.getClass());

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
        Collections.reverse(paymentsList);
    return paymentsList;
  }

  public Payment getPaymentByUserAndDate(String username, LocalDate dateOfPayment){
    return paymentsRepository.findPaymentByUsersAndDateOfPayment(userRepository.findUsersByUsername(username), dateOfPayment);
  }

  public List<PaymentDto> getAllPayment(){
    List <Payment> payments = paymentsRepository.findAll();
    List <PaymentDto> paymentsDto = new ArrayList<>();
    payments.forEach(payment -> paymentsDto.add(mapPaymentToDto.paymentDto(payment)));
    return paymentsDto;
  }

  public Payment findPaymentById(Long id){
    return paymentsRepository.findPaymentById(id);
  }

  public void newPayController(Long id){
    Payment payment = findPaymentById(id);
    payment.setAmountOfPayment(10L);
    savePayment(payment);
  }

  public void savePayment(Payment payment){paymentsRepository.save(payment);
  };



  }

