package com.krawczak.netflixPayments.domain.dto;

import java.time.LocalDate;

public class PaymentDto {

    private Long id;
    private LocalDate dateOfPayment;
    private Long amountOfPayment;
    private String status;
    private String monthOfPayment;
    private UsersDto usersDto;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMonthOfPayment() {
        return monthOfPayment;
    }

    public void setMonthOfPayment(String monthOfPayment) {
        this.monthOfPayment = monthOfPayment;
    }

    public UsersDto getUsersDto() {
        return usersDto;
    }

    public void setUsersDto(UsersDto usersDto) {
        this.usersDto = usersDto;
    }
}
