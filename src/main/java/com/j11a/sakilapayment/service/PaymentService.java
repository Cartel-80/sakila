package com.j11a.sakilapayment.service;

import com.j11a.sakilapayment.model.Payment;
import com.j11a.sakilapayment.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class PaymentService {

    private PaymentRepository paymentRepository;

    public ResponseEntity<Payment> getPaymentById(final Integer paymentId) {
        final Optional<Payment> payment = paymentRepository.findById(paymentId);

        return payment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    public ResponseEntity<List<Payment>> getPaymentsByCustomerId(final Integer customerId) {
        final List<Payment> paymentsByCustomer = paymentRepository.findAllByCustomerId(customerId);

        return parseResponse(paymentsByCustomer);
    }

    public ResponseEntity<List<Payment>> getPaymentsByStaffId(final Integer staffId) {
        final List<Payment> paymentsByStaff = paymentRepository.findAllByStaffId(staffId);

        return parseResponse(paymentsByStaff);
    }

    public ResponseEntity<List<Payment>> getPaymentsGreaterThanAmount(final Double amount) {
        final List<Payment> paymentsGreaterThanAmount = paymentRepository.findAllByAmountGreaterThan(amount);

        return parseResponse(paymentsGreaterThanAmount);
    }

    public ResponseEntity<?> getPaymentsOnPaymentDate(final String date) {
        final String datePattern = "^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
        if(!Pattern.matches(datePattern, date)) {
            return ResponseEntity
                    .badRequest()
                    .body(Collections.singletonMap("error", "Date must be in the format YYYY-MM-DD"));
        }
        final Instant startDateTime = Instant.parse(String.format("%sT00:00:00.000Z", date));
        final Instant endDateTime= Instant.parse(String.format("%sT23:59:59.999Z", date));
        final List<Payment> paymentsOnpPaymentDate = paymentRepository.findAllByPaymentDateAfterAndPaymentDateBefore(startDateTime, endDateTime);

        return parseResponse(paymentsOnpPaymentDate);
    }

    private static ResponseEntity<List<Payment>> parseResponse(List<Payment> payments) {
        if(payments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(payments);
    }


}
