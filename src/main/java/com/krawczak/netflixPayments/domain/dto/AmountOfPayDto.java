package com.krawczak.netflixPayments.domain.dto;

public class AmountOfPayDto {

    private Long id;
    private Long amountOfPayment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmountOfPayment() {
        return amountOfPayment;
    }

    public void setAmountOfPayment(Long amountOfPayment) {
        this.amountOfPayment = amountOfPayment;
    }
}
