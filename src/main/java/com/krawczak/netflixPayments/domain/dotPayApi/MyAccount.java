package com.krawczak.netflixPayments.domain.dotPayApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.krawczak.netflixPayments.domain.dotPayApi.myAccount.Result;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyAccount {

    @JsonProperty("count")
    int count;

    @JsonProperty("results")
    List<Result> results;


}
