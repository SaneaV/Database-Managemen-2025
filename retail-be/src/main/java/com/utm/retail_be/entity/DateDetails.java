package com.utm.retail_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class DateDetails {
    @Id
    @Column(name = "date_details_id")
    @GenericGenerator(name="assigned", strategy="assigned")
    @GeneratedValue(generator="assigned")
    private Integer dateDetailsID;

    @Column(name = "data_bon_date")
    private LocalDate dataBonDate;

    @Column(nullable = false)
    private Boolean isHoliday;

    @Column(nullable = false)
    private Short weekDay;
}
