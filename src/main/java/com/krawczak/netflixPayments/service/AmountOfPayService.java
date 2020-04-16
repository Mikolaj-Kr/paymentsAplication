package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.entity.AmountOfPay;
import com.krawczak.netflixPayments.repositories.AmountOfPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmountOfPayService {

    @Autowired
    AmountOfPayRepository amountOfPayRepository;

    public void setAmountOfPay(Long amount){
        AmountOfPay amountOfPay = new AmountOfPay(1L, amount);
        amountOfPayRepository.save(amountOfPay);
    }

    public Long getAmountOfPay(){
        AmountOfPay amountOfPay = amountOfPayRepository.findAmountOfPayById(1L);
        if (amountOfPay==null){
            setAmountOfPay(10L);
        }
        return amountOfPayRepository.findAmountOfPayById(1L).getAmountOfPay();
    }
}
