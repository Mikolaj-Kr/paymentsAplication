package com.krawczak.netflixPayments.mapper;

import com.krawczak.netflixPayments.dto.PaymentDto;
import com.krawczak.netflixPayments.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapPaymentToDto {

  @Autowired
  MapUserToDto mapUserToDto;

  public PaymentDto paymentToDto(Payment payment){
    PaymentDto paymentDto = new PaymentDto();
    paymentDto.setId(payment.getId());
    paymentDto.setAmountOfPayment(payment.getAmountOfPayment());
    paymentDto.setDateOfPayment(payment.getDateOfPayment());
    paymentDto.setUserDto(mapUserToDto.userToDto(payment.getUser()));
    return paymentDto;
  }

}
