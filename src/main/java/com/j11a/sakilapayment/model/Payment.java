package com.j11a.sakilapayment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer paymentId;

    private Integer customerId;

    private Integer staffId;

    private Double amount;

    private Instant paymentDate;

    private Instant lastUpdate;
}
