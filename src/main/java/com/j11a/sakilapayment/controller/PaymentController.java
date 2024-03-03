package com.j11a.sakilapayment.controller;

import com.j11a.sakilapayment.model.Payment;
import com.j11a.sakilapayment.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {

    private PaymentService paymentService;

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable final Integer paymentId) {
        return paymentService.getPaymentById(paymentId);
    }
}
