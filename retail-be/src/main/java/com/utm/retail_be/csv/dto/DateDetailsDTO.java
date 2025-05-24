package com.utm.retail_be.csv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DateDetailsDTO {
    private int id;
    private LocalDate dataBonData;
    private int sarbatoare;
    private int ziua;

}
