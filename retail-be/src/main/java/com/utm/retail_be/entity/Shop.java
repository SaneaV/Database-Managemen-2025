package com.utm.retail_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Shop {
    @Id
    @Column(name = "shop_id")
    @GenericGenerator(name="assigned", strategy="assigned")
    @GeneratedValue(generator="assigned")
    private Integer shopID;

    @Column(nullable = false, length = 1000)
    private String name;

    @Column(nullable = false, length = 1000)
    private String city;

    @Column(nullable = false)
    private Float longitude;

    @Column(nullable = false)
    private Float latitude;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "address_id")
    private Integer addressID;
}
