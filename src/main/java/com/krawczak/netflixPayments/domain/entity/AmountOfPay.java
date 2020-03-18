package com.krawczak.netflixPayments.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "amount_of_pay")
public class AmountOfPay {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "amount_of_pay_id")
  private Long id;

  @Column(name = "amount_of_pay")
  private Long amountOfPay;

  public AmountOfPay() {
  }

  public AmountOfPay(Long id, Long amountOfPay) {
    this.id = id;
    this.amountOfPay = amountOfPay;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getAmountOfPay() {
    return amountOfPay;
  }

  public void setAmountOfPay(Long amountOfPay) {
    this.amountOfPay = amountOfPay;
  }
}

