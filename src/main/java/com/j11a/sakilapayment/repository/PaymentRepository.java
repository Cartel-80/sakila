package com.j11a.sakilapayment.repository;

import com.j11a.sakilapayment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findAllByCustomerId(final Integer customerId);
    List<Payment> findAllByStaffId(final Integer staffId);
    List<Payment> findAllByAmountGreaterThan(final Double amount);
    List<Payment> findAllByPaymentDateAfterAndPaymentDateBefore(final Instant startDateTime, final Instant endDateTime);
}
