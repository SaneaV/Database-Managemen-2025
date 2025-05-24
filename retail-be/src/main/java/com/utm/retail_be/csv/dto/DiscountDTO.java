package com.utm.retail_be.csv.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class DiscountDTO {
    private String discId;
    private String denpr;
    private Double discPerc;

    public DiscountDTO(String discId, String denpr, Double discPerc) {
        this.discId = discId;
        this.denpr = denpr;
        this.discPerc = discPerc;
    }

}

