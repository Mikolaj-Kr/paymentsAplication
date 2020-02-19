package com.krawczak.netflixPayments.mapper;

import com.krawczak.netflixPayments.domain.dto.PaymentDto;
import com.krawczak.netflixPayments.domain.entity.Payment;
import com.krawczak.netflixPayments.service.GetMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapPaymentToDto {

  @Autowired
  MapUserToDto mapUserToDto;

  @Autowired
  GetMonth getMonth;

  public PaymentDto paymentDto(Payment payment) {
    PaymentDto paymentDto = new PaymentDto();
    paymentDto.setId(payment.getId());
    paymentDto.setAmountOfPayment(payment.getAmountOfPayment());
    paymentDto.setDateOfPayment(payment.getDateOfPayment());
    if(payment.getAmountOfPayment()>0){
      paymentDto.setIsRegulated("Opłacone");
    } else {
      paymentDto.setIsRegulated("Nieopłacone");
    }
    paymentDto.setMonthOfPayment(getMonth.getMonth(payment.getDateOfPayment().getMonth().getValue()));
    paymentDto.setUserDto(mapUserToDto.userToDto(payment.getUsers()));
    return paymentDto;
  }
}
