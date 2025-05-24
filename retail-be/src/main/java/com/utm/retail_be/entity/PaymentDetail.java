package com.utm.retail_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
public class PaymentDetail {
    @Id
    @Column(name = "payment_detail_id")
    private UUID paymentDetailID;

    @Column(nullable = false)
    private Float quantity;

    private Double discountValue;
    private Double finalValue;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
