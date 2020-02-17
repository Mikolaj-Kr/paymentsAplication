package com.krawczak.netflixPayments.domain.dto;

public class PaymentsForUsersDto {
  String month;
  boolean payment;

  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public boolean isPayment() {
    return payment;
  }

  public void setPayment(boolean payment) {
    this.payment = payment;
  }
}
