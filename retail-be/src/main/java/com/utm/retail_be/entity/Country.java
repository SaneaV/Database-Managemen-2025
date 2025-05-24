package com.utm.retail_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Country {
    @Id
    @Column(name = "country_id")
    private Short countryID;

    @Column(nullable = false, length = 500)
    private String name;

    @Column(nullable = false, name = "is_eu")
    private Boolean isEU = false;
}
