package com.krawczak.netflixPayments.mapper;
import com.krawczak.netflixPayments.domain.dto.PaymentDto;
import com.krawczak.netflixPayments.domain.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapPaymentToDto {

  @Autowired
  MapUserToDto mapUserToDto;

  public PaymentDto paymentDto (Payment payment){
    PaymentDto paymentDto = new PaymentDto();
    paymentDto.setId(payment.getId());
    paymentDto.setAmountOfPayment(payment.getAmountOfPayment());
    paymentDto.setDateOfPayment(payment.getDateOfPayment());
    paymentDto.setUserDto(mapUserToDto.userToDto(payment.getUsers()));
    return paymentDto;
  }

}
