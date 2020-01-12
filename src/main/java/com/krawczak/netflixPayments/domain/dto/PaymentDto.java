package com.krawczak.netflixPayments.domain.dto;

import java.util.Date;

public class PaymentDto {

  private Long id;
  private Date dateOfPayment;
  private Long amountOfPayment;
  private UserDto userDto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDateOfPayment() {
    return dateOfPayment;
  }

  public void setDateOfPayment(Date dateOfPayment) {
    this.dateOfPayment = dateOfPayment;
  }

  public Long getAmountOfPayment() {
    return amountOfPayment;
  }

  public void setAmountOfPayment(Long amountOfPayment) {
    this.amountOfPayment = amountOfPayment;
  }

  public UserDto getUserDto() {
    return userDto;
  }

  public void setUserDto(UserDto userDto) {
    this.userDto = userDto;
  }
}
