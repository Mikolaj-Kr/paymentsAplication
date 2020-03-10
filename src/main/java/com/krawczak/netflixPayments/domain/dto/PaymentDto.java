package com.krawczak.netflixPayments.domain.dto;

import java.time.LocalDate;

public class PaymentDto {

  private Long id;
  private LocalDate dateOfPayment;
  private Long amountOfPayment;
  private boolean regulated;
  private String monthOfPayment;
  private UserDto userDto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getDateOfPayment() {
    return dateOfPayment;
  }

  public void setDateOfPayment(LocalDate dateOfPayment) {
    this.dateOfPayment = dateOfPayment;
  }

  public Long getAmountOfPayment() {
    return amountOfPayment;
  }

  public void setAmountOfPayment(Long amountOfPayment) {
    this.amountOfPayment = amountOfPayment;
  }

  public boolean getIsRegulated() {
    return regulated;
  }

  public boolean isRegulated() {
    return regulated;
  }

  public void setRegulated(boolean regulated) {
    this.regulated = regulated;
  }

  public String getMonthOfPayment() {
    return monthOfPayment;
  }

  public void setMonthOfPayment(String monthOfPayment) {
    this.monthOfPayment = monthOfPayment;
  }

  public UserDto getUserDto() {
    return userDto;
  }

  public void setUserDto(UserDto userDto) {
    this.userDto = userDto;
  }
}
