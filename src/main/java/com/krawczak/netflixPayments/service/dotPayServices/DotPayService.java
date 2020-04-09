package com.krawczak.netflixPayments.service.dotPayServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.krawczak.netflixPayments.domain.dotPayApi.MyAccount;
import com.krawczak.netflixPayments.domain.dotPayApi.PaymentInformation;
import com.krawczak.netflixPayments.domain.dotPayApi.paymentInformation.Payer;
import com.krawczak.netflixPayments.mapper.apiMapper.DotPayApiMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DotPayService {

    @Autowired
    DotPayApiMapper dotPayApiMapper;

    @Autowired
    CreateJson createJson;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public MyAccount getAccountInfoFromDotPay() throws JsonProcessingException, UnirestException {
        return dotPayApiMapper.parseMyAccount();
    }

    public String createPaymentLink(String description, String control, Payer payer) throws JsonProcessingException, UnirestException {
        return dotPayApiMapper.parsePayment("13", description, control, payer).getPaymentUrl();
    }



}
