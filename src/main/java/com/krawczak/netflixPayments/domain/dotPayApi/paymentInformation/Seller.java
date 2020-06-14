package com.krawczak.netflixPayments.domain.dotPayApi.paymentInformation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Seller {

    @JsonProperty("p_info")
    String pInfo;

    @JsonProperty("p_email")
    String pEmail;

    @JsonProperty("p_www")
    String pWWW;

    public String getpInfo() {
        return pInfo;
    }

    public void setpInfo(String pInfo) {
        this.pInfo = pInfo;
    }

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public String getpWWW() {
        return pWWW;
    }

    public void setpWWW(String pWWW) {
        this.pWWW = pWWW;
    }
}
