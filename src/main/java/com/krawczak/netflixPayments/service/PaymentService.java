package com.krawczak.netflixPayments.service;

import com.krawczak.netflixPayments.domain.dto.PaymentDto;
import com.krawczak.netflixPayments.domain.entity.Payment;
import com.krawczak.netflixPayments.domain.entity.Users;
import com.krawczak.netflixPayments.mapper.MapPaymentToDto;
import com.krawczak.netflixPayments.mapper.MapUserToDto;
import com.krawczak.netflixPayments.repositories.PaymentsRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentsRepository paymentsRepository;

    private final MapPaymentToDto mapPaymentToDto;

    private final UserService userService;


    public PaymentService(PaymentsRepository paymentsRepository, MapPaymentToDto mapPaymentToDto, GetPolishNames getPolishNames, UserService userService, MapUserToDto mapUserToDto) {
        this.paymentsRepository = paymentsRepository;
        this.mapPaymentToDto = mapPaymentToDto;
        this.userService = userService;
    }

    public List<PaymentDto> getUserPayments(String username) {
        List<PaymentDto> paymentsList = new ArrayList<>();
        paymentsRepository.findPaymentByUsersOrderByDateOfPayment(userService.findUserByUsername(username))
                .forEach(payment -> paymentsList.add(mapPaymentToDto.paymentDto(payment)));
        Collections.reverse(paymentsList);
        return paymentsList;
    }

    public Payment getLastUserPayment(String username){
      List<PaymentDto> paymentsList = getUserPayments(username);
      Collections.reverse(paymentsList);
      return findPaymentById(paymentsList.get(paymentsList.size()-1).getId());
    }

    public PaymentDto getLastPaidUserPayment(String username){
        List<PaymentDto> paymentList = new ArrayList<>();
        paymentsRepository.findPaymentByUsersAndStatusOrderByDateOfPayment(userService.findUserByUsername(username), "paid")
                      .forEach(payment -> paymentList.add(mapPaymentToDto.paymentDto(payment)));
        return paymentList.get(paymentList.size()-1);
    }

    public Payment findPaymentById(Long id) {
        return paymentsRepository.findPaymentById(id);
    }

    public void newPayController(Long id, String username) {
        Payment payment = findPaymentById(id);
        payment.setAmountOfPayment(10L);
        payment.setStatus("inProgress");
        addNewPay(username);
        savePayment(payment);
    }

    public void changePayToPaid(Long id){
        Payment payment = findPaymentById(id);
        payment.setStatus("paid");
        savePayment(payment);
    }

    public void changePayToUnpaid(Long id){
        Payment payment = findPaymentById(id);
        payment.setStatus("unpaid");
        savePayment(payment);
    }

    public void addNewPay(String username){
      Payment payment = getLastUserPayment(username);
      Payment nextPayment = new Payment();
      nextPayment.setAmountOfPayment(10L);
      nextPayment.setStatus("unpaid");
      nextPayment.setDateOfPayment(payment.getDateOfPayment().plusMonths(1));
      nextPayment.setUsers(userService.findUserByUsername(username));
      savePayment(nextPayment);
    }

    public void deleteUserPayments(Users users){
        List<Payment> paymentList = paymentsRepository.findPaymentByUsersOrderByDateOfPayment(users);
        paymentList.forEach(payment -> paymentsRepository.delete(payment));
    }

    public void finishPayment(Long paymentId){
        deletePayment(findPaymentById(paymentId));
    }

    public void savePayment(Payment payment) {
        paymentsRepository.save(payment);
    }

    private void deletePayment(Payment payment){
        paymentsRepository.delete(payment);
    }
}

