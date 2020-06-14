package com.krawczak.netflixPayments.domain.dotPayApi.myAccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Config {
    @JsonProperty("urlc")
    String urlc;

    @JsonProperty("block_external_urlc")
    Boolean blockExternalUrlc;

    @JsonProperty("pin")
    String pin;

    public String getUrlc() {
        return urlc;
    }

    public void setUrlc(String urlc) {
        this.urlc = urlc;
    }

    public Boolean getBlockExternalUrlc() {
        return blockExternalUrlc;
    }

    public void setBlockExternalUrlc(Boolean blockExternalUrlc) {
        this.blockExternalUrlc = blockExternalUrlc;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
