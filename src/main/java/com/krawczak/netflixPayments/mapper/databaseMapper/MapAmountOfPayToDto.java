package com.krawczak.netflixPayments.mapper.databaseMapper;

import com.krawczak.netflixPayments.domain.dto.AmountOfPayDto;
import com.krawczak.netflixPayments.domain.entity.AmountOfPay;
import org.springframework.stereotype.Service;

@Service
public class MapAmountOfPayToDto {

  public AmountOfPayDto amountOfPayToDto(AmountOfPay amountOfPay) {
    AmountOfPayDto amountOfPayDto = new AmountOfPayDto();
    amountOfPayDto.setId(amountOfPay.getId());
    amountOfPayDto.setAmountOfPayment(amountOfPay.getAmountOfPay());
    return amountOfPayDto;
  }
}
