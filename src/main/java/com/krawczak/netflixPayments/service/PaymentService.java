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

  public Map<String, String> getPayments() {
    List<PaymentDto> paymentsList  = getAllPayment();
    LocalDate dateNow = LocalDate.now();
    Map <String, String> payments = new HashMap<>();
    if (paymentsList == null){
      int currentMonth = dateNow.getMonth().getValue();
      String currentMonthString = getMonth.getMonth(currentMonth);
      String lastMonthString = getMonth.getMonth(currentMonth-1);
      String penultimateMonthString = getMonth.getMonth(currentMonth-2);

      payments.put(currentMonthString, "nieopłacony");
      payments.put(lastMonthString, "nieopłacony");
      payments.put(penultimateMonthString, "nieopłacony");
      }


    return payments;
  }

  public List<PaymentDto> getAllPayment(){
    List <Payment> payments = paymentsRepository.findAll();
    List <PaymentDto> paymentsDto = new ArrayList<>();

    payments.forEach(payment -> paymentsDto.add(mapPaymentToDto.paymentDto(payment)));

    return paymentsDto;
  }
}
