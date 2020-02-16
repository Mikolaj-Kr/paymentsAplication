package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.dto.PaymentDto;
import com.krawczak.netflixPayments.domain.entity.Payment;
import com.krawczak.netflixPayments.mapper.MapPaymentToDto;
import com.krawczak.netflixPayments.repositories.PaymentsRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  @Autowired
  PaymentsRepository paymentsRepository;

  @Autowired
  MapPaymentToDto mapPaymentToDto;

  @Autowired
  GetMonth getMonth;

  public List<PaymentDto> getPayments() {
    LocalDate dateNow = LocalDate.now();
    PaymentDto lastPayment  = mapPaymentToDto.paymentDto(paymentsRepository.getDistinctFirstByDateOfPaymentBefore(dateNow));
    List<PaymentDto> paymentsList = new ArrayList<>();

    Map <String, String> payments = new HashMap<>();
    if (lastPayment == null){
      PaymentDto paymentDto = new PaymentDto();
      paymentDto.setAmountOfPayment(0L);
      int currentMonth = dateNow.getMonth().getValue();
      String currentMonthString = getMonth.getMonth(currentMonth);
      payments.put(currentMonthString, "nieopłacony");
      } else {
    }

    return paymentsList;
  }

  public List<PaymentDto> getAllPayment(){
    List <Payment> payments = paymentsRepository.findAll();
    List <PaymentDto> paymentsDto = new ArrayList<>();

    payments.forEach(payment -> paymentsDto.add(mapPaymentToDto.paymentDto(payment)));

    return paymentsDto;
  }
}
