package com.krawczak.netflixPayments.service.dotPayServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.krawczak.netflixPayments.configuration.PasswordEncoder;
import com.krawczak.netflixPayments.domain.dotPayApi.MyAccount;
import com.krawczak.netflixPayments.domain.dotPayApi.paymentInformation.Payer;
import com.krawczak.netflixPayments.domain.entity.Payment;
import com.krawczak.netflixPayments.domain.entity.Users;
import com.krawczak.netflixPayments.parser.DotPayApiParser;
import com.krawczak.netflixPayments.service.AmountOfPayService;
import com.krawczak.netflixPayments.service.PaymentService;
import com.krawczak.netflixPayments.service.UserService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class DotPayService {

    @Autowired
    DotPayApiParser dotPayApiParser;

    @Autowired
    CreateJson createJson;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CreateShaHash createShaHash;

    @Autowired
    UserService userService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    AmountOfPayService amountOfPayService;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    public MyAccount getAccountInfoFromDotPay() throws JsonProcessingException, UnirestException {
        return dotPayApiParser.parseMyAccount();
    }

    public String createPaymentLink(String username, String paymentId) throws JsonProcessingException, UnirestException, NoSuchAlgorithmException {
        Users users = userService.findUserByUsername(username);
        Payer payer = new Payer();
        Payment payment = paymentService.findPaymentById(Long.valueOf(paymentId));
        String description = username + "Payment for the month number: " + payment.getDateOfPayment().getMonth().getValue();
        payer.setEmail(users.getUsername());
        payer.setFirstName(users.getName());
        payer.setLastName(users.getSurname());

        String urlWithoutChk = dotPayApiParser.parsePayment(amountOfPayService.getAmountOfPay().toString(), description, paymentId, payer).getPaymentUrl();

        String[] urlArray = urlWithoutChk.split("=");
        String pid = urlArray[1];
        return urlWithoutChk + "&chk=" + createShaHash.creatChk(pid);
    }


}
