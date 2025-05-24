package com.utm.retail_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
public class Payment {
    @Id
    @Column(name = "payment_id")
    private UUID paymentID;

    private Double totalAmount;

    @Column(nullable = false)
    private Timestamp createDate;

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
