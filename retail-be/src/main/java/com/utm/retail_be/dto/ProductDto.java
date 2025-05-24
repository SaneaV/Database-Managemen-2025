package com.utm.retail_be.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDto {
    private Integer productId;
    private String productName;
    private String productCategory;
}
