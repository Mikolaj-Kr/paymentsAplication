package com.krawczak.netflixPayments.repositories;

import com.krawczak.netflixPayments.domain.entity.Payment;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepository extends JpaRepository<Payment, Long> {

  Payment getDistinctFirstByDateOfPaymentBefore(LocalDate localDate);
}
