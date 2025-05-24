package com.utm.retail_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Payment {
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentID;

    private BigDecimal totalAmount;

    @Column(nullable = false)
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "date_details_id")
    private DateDetails dateDetails;

    @ManyToOne
    @JoinColumn(name = "customer_category_id")
    private CustomerCategory customerCategory;
}
