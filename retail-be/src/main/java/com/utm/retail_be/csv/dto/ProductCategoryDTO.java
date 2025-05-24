package com.utm.retail_be.csv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProductCategoryDTO {
    private Short id;
    private String denumireProdus;
    private String categorie;
    private String canalProdus;

    @Override
    public String toString() {
        return "ProductCategoryDTO{" +
                "id=" + id +
                ", denumireProdus='" + denumireProdus + '\'' +
                ", categorie='" + categorie + '\'' +
                ", canalProdus='" + canalProdus + '\'' +
                '}';
    }
}
