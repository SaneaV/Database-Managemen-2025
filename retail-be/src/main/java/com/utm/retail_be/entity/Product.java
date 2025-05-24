package com.utm.retail_be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @Column(name = "product_id")
    private Integer productID;

    @Column(nullable = false, length = 255)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(nullable = false, length = 3)
    private String unit;

    @Column(nullable = false)
    private Float unitPrice;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;
}
