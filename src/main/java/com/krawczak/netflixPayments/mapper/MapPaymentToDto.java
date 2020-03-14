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
      paymentDto.setRegulated(true);
    } else {
      paymentDto.setRegulated(false);
    }
    paymentDto.setMonthOfPayment(getMonth.getMonth(payment.getDateOfPayment().getMonth().getValue()));
    paymentDto.setUsersDto(mapUserToDto.userToDto(payment.getUsers()));
    return paymentDto;
  }
}
