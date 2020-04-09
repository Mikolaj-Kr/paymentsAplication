package com.krawczak.netflixPayments.domain.dotPayApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.krawczak.netflixPayments.domain.dotPayApi.paymentInformation.Payer;
import com.krawczak.netflixPayments.domain.dotPayApi.paymentInformation.Recipient;
import com.krawczak.netflixPayments.domain.dotPayApi.paymentInformation.Seller;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentInformation {

    @JsonProperty("href")
    String href;

    @JsonProperty("payment_url")
    String paymentUrl;

    @JsonProperty("amount")
    String amount;

    @JsonProperty("currency")
    String currency;

    @JsonProperty("description")
    String description;

    @JsonProperty("control")
    String control;

    @JsonProperty("language")
    String language;

    @JsonProperty("channel_id")
    String channelId;

    @JsonProperty("ch_lock")
    String chLock;

    @JsonProperty("onlinetransfer")
    String onlineTransfer;

    @JsonProperty("redirection_type")
    String redirectionType;

    @JsonProperty("buttontext")
    String buttonText;

    @JsonProperty("url")
    String url;

    @JsonProperty("urlc")
    String urlc;

    @JsonProperty("expiration_datetime")
    String expirationDatetime;

    @JsonProperty("auto_reject_date")
    String autoRejectDate;

    @JsonProperty("payer")
    Payer payer;

    @JsonProperty("recipient")
    Recipient recipient;

    @JsonProperty("customer")
    String customer;

    @JsonProperty("seller")
    Seller seller;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChLock() {
        return chLock;
    }

    public void setChLock(String chLock) {
        this.chLock = chLock;
    }

    public String getOnlineTransfer() {
        return onlineTransfer;
    }

    public void setOnlineTransfer(String onlineTransfer) {
        this.onlineTransfer = onlineTransfer;
    }

    public String getRedirectionType() {
        return redirectionType;
    }

    public void setRedirectionType(String redirectionType) {
        this.redirectionType = redirectionType;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlc() {
        return urlc;
    }

    public void setUrlc(String urlc) {
        this.urlc = urlc;
    }

    public String getExpirationDatetime() {
        return expirationDatetime;
    }

    public void setExpirationDatetime(String expirationDatetime) {
        this.expirationDatetime = expirationDatetime;
    }

    public String getAutoRejectDate() {
        return autoRejectDate;
    }

    public void setAutoRejectDate(String autoRejectDate) {
        this.autoRejectDate = autoRejectDate;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
