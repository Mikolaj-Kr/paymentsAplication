package com.krawczak.netflixPayments.mapper;

import com.krawczak.netflixPayments.dto.AmountOfPayDto;
import com.krawczak.netflixPayments.entity.AmountOfPay;
import org.springframework.stereotype.Service;

@Service
public class MapAmountOfPayToDto {

  public AmountOfPayDto amountOfPayToDto(AmountOfPay amountOfPay){
    AmountOfPayDto amountOfPayDto = new AmountOfPayDto();
    amountOfPayDto.setId(amountOfPay.getId());
    amountOfPayDto.setAmountOfPayment(amountOfPay.getAmountOfPay());
    return amountOfPayDto;
  }

}
