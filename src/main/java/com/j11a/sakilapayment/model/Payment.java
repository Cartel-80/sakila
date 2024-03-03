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
    private Integer payment_id;

    private Integer customer_id;

    private Integer staff_id;

    private Double amount;

    private Instant payment_date;

    private Instant last_update;
}
