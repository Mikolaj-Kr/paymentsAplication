package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.dto.PaymentDto;
import com.krawczak.netflixPayments.domain.entity.Payment;
import com.krawczak.netflixPayments.mapper.MapPaymentToDto;
import com.krawczak.netflixPayments.repositories.PaymentsRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  @Autowired
  PaymentsRepository paymentsRepository;

  @Autowired
  MapPaymentToDto mapPaymentToDto;

  public PaymentDto getLastPayment(LocalDate date){
    return mapPaymentToDto.paymentDto(paymentsRepository.getDistinctFirstByDateOfPaymentBefore(date));
  }
}
