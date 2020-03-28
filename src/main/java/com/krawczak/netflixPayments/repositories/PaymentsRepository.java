package com.krawczak.netflixPayments.repositories;

import com.krawczak.netflixPayments.domain.entity.Payment;
import com.krawczak.netflixPayments.domain.entity.Users;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PaymentsRepository extends JpaRepository<Payment, Long> {

  List<Payment> findAll();

  List<Payment> findPaymentByUsersOrderByDateOfPayment(Users users);

  Payment findPaymentById(Long id);

  Payment findPaymentByUsersAndDateOfPayment(Users users, LocalDate date);

  }
