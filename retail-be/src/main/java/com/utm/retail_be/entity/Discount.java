package com.utm.retail_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Discount {
    @Id
    @Column(name = "discount_id")
    @GenericGenerator(name="assigned", strategy="assigned")
    @GeneratedValue(generator="assigned")
    private Integer discountID;

    @Column(nullable = false, length = 1000)
    private String name;

    @Column(nullable = false, precision = 4)
    private Double amount;
}
