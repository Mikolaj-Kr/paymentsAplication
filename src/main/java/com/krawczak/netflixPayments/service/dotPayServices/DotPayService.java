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
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class DotPayService {

    private final DotPayApiParser dotPayApiParser;

    private final CreateShaHash createShaHash;

    private final UserService userService;

    private final PaymentService paymentService;

    private final AmountOfPayService amountOfPayService;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public DotPayService(DotPayApiParser dotPayApiParser, CreateJson createJson, PasswordEncoder passwordEncoder, CreateShaHash createShaHash, UserService userService, PaymentService paymentService, AmountOfPayService amountOfPayService) {
        this.dotPayApiParser = dotPayApiParser;
        this.createShaHash = createShaHash;
        this.userService = userService;
        this.paymentService = paymentService;
        this.amountOfPayService = amountOfPayService;
    }

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

    public void changePaymentStatus(String paymentId, String status) {
        Payment payment = paymentService.findPaymentById(Long.valueOf(paymentId));
        if ((payment.getStatus().equals("unpaid") || payment.getStatus().equals("inProgress"))) {
            if (status.equals("completed")) {
                payment.setStatus("paid");
            } else {
                payment.setStatus("unpaid");
            }
            paymentService.savePayment(payment);
        }
    }


}
