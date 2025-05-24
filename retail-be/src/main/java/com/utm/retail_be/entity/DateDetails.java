package com.utm.retail_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
public class DateDetails {
    @Id
    @Column(name = "date_details_id")
    private Integer dateDetailsID;

    @Column(nullable = false)
    private Boolean isHoliday;

    @Column(nullable = false)
    private Short weekDay;
}
