package com.j11a.sakilapayment.controller;

import com.j11a.sakilapayment.model.Payment;
import com.j11a.sakilapayment.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {

    private PaymentService paymentService;

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable final Integer paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Payment>> getPaymentsByCustomer(@PathVariable final Integer customerId) {
        return  paymentService.getPaymentsByCustomerId(customerId);
    }

    @GetMapping("/staff/{staffId}")
    public ResponseEntity<List<Payment>> getPaymentsByStaff(@PathVariable final Integer staffId) {
        return paymentService.getPaymentsByStaffId(staffId);
    }

    @GetMapping("/amount/{amount}")
    public ResponseEntity<List<Payment>> getPaymentsGreaterThanAmount(@PathVariable final Double amount) {
        return paymentService.getPaymentsGreaterThanAmount(amount);
    }

    @GetMapping("/date")
    public ResponseEntity<?> getPaymentsByPaymentDate(@RequestParam final String date) {
        return paymentService.getPaymentsOnPaymentDate(date);
    }

}
