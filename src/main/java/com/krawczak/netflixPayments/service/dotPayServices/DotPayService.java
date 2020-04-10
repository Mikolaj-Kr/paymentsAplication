package com.krawczak.netflixPayments.service.dotPayServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.krawczak.netflixPayments.configuration.PasswordEncoder;
import com.krawczak.netflixPayments.domain.dotPayApi.MyAccount;
import com.krawczak.netflixPayments.domain.dotPayApi.PaymentInformation;
import com.krawczak.netflixPayments.domain.dotPayApi.paymentInformation.Payer;
import com.krawczak.netflixPayments.mapper.apiMapper.DotPayApiMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Service
public class DotPayService {

    @Autowired
    DotPayApiMapper dotPayApiMapper;

    @Autowired
    CreateJson createJson;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CreateShaHash createShaHash;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    public MyAccount getAccountInfoFromDotPay() throws JsonProcessingException, UnirestException {
        return dotPayApiMapper.parseMyAccount();
    }

    public String createPaymentLink(String description, String control, Payer payer) throws JsonProcessingException, UnirestException, NoSuchAlgorithmException {
        return dotPayApiMapper.parsePayment("13", description, control, payer).getPaymentUrl() + "&chk=" + createShaHash.creatChk("13", description, control, payer);
    }


}
