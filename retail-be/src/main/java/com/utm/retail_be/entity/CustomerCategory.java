package com.utm.retail_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class CustomerCategory {
    @Id
    @Column(name = "customer_category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerCategoryID;

    @Column(length = 1)
    private String gender;

    @Column(nullable = false, length = 8)
    private String ageCategory;
}
