package com.utm.retail_be.validator;

import com.utm.retail_be.entity.Product;

public class ProductValidator implements CsvValidator<Product> {
    public void validate(Product p) throws Exception {
        if (p.getProductID() == null) throw new Exception("Missing product ID");
        if (p.getProductName() == null || p.getProductName().isEmpty()) throw new Exception("Missing product name");
        if (p.getUnit() == null || p.getUnit().isEmpty()) throw new Exception("Missing unit");
        if (p.getUnitPrice() == null) throw new Exception("Missing unit price");
        if (p.getProductCategory() == null) throw new Exception("Missing product category");
    }
}
