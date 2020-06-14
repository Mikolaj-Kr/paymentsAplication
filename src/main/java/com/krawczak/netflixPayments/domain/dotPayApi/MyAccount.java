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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
