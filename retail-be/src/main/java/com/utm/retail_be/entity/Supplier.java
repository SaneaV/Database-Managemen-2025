package com.utm.retail_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Supplier {
    @Id
    @Column(name = "supplier_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierID;

    @Column(nullable = false, length = 255)
    private String name;
}
