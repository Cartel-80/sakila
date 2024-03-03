package com.j11a.sakilapayment.service;

import com.j11a.sakilapayment.model.Payment;
import com.j11a.sakilapayment.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentService {

    private PaymentRepository paymentRepository;

    public ResponseEntity<Payment> getPaymentById(Integer paymentId) {
        Optional<Payment> payment = paymentRepository.findById(paymentId);

        return payment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
