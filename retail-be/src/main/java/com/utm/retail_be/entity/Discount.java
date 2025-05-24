package com.utm.retail_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Discount {
    @Id
    @Column(name = "discount_id")
    private Short discountID;

    @Column(nullable = false, length = 1000)
    private String name;

    @Column(nullable = false, precision = 4)
    private Double amount;
}
