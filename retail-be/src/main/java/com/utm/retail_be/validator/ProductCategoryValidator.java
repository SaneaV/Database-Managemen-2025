package com.utm.retail_be.validator;

import com.utm.retail_be.entity.ProductCategory;

public class ProductCategoryValidator implements CsvValidator<ProductCategory> {
    public void validate(ProductCategory pc) throws Exception {
        if (pc.getProductCategoryID() == null) throw new Exception("Missing category ID");
        if (pc.getName() == null || pc.getName().isEmpty()) throw new Exception("Missing category name");
    }
}
