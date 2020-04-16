package com.krawczak.netflixPayments.mapper.apiMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krawczak.netflixPayments.domain.dotPayApi.MyAccount;
import com.krawczak.netflixPayments.domain.dotPayApi.PaymentInformation;
import com.krawczak.netflixPayments.domain.dotPayApi.paymentInformation.Payer;
import com.krawczak.netflixPayments.service.dotPayServices.CreateJson;
import com.krawczak.netflixPayments.service.dotPayServices.GetDotPayCredentials;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DotPayApiMapper {

    @Autowired
    CreateJson createJson;

    @Autowired
    GetDotPayCredentials getDotPayCredentials;

    private ObjectMapper objectMapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MyAccount parseMyAccount() throws UnirestException, JsonProcessingException {
        HttpResponse<String> response = Unirest.get("https://ssl.dotpay.pl/test_seller/api/v1/accounts")
                .basicAuth(getDotPayCredentials.findCredentialsById("dot").getUsername(), getDotPayCredentials.findCredentialsById("dot").getPassword())
                .asString();
        return objectMapper.readValue(response.getBody(), MyAccount.class);
    }

    public PaymentInformation parsePayment(String amount, String description, String control, Payer payer) throws UnirestException, JsonProcessingException {
        HttpResponse<String> response = Unirest.post("https://ssl.dotpay.pl/test_seller/api/v1/accounts/776768/payment_links/")
                .basicAuth(getDotPayCredentials.findCredentialsById("dot").getUsername(), getDotPayCredentials.findCredentialsById("dot").getPassword())
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .header("Host", "ssl.dotpay.pl")
                .body(createJson.jsonForCreatingPaymentLink(amount, description, control, payer).toString())
                .asString();
        return objectMapper.readValue(response.getBody(), PaymentInformation.class);
    }
}