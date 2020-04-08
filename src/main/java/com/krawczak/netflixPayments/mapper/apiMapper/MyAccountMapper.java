package com.krawczak.netflixPayments.mapper.apiMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krawczak.netflixPayments.domain.dotPayApi.MyAccount;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyAccountMapper {

    private ObjectMapper objectMapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MyAccount parseMyAccount() throws UnirestException, JsonProcessingException {
        HttpResponse<String> response = Unirest.get("https://ssl.dotpay.pl/test_seller/api/v1/accounts").basicAuth("mikolak25@gmail.com", "Mikolaj2511").asString();
logger.info(response.getBody());
        return objectMapper.readValue(response.getBody(), MyAccount.class);
    }
}