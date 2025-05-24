package com.utm.retail_be.validator;

import com.utm.retail_be.entity.Discount;

public class DiscountValidator implements CsvValidator<Discount> {
    public void validate(Discount d) throws Exception {
        if (d.getDiscountID() == null) throw new Exception("Missing discount ID");
        if (d.getName() == null || d.getName().isEmpty()) throw new Exception("Missing discount name");
        if (d.getAmount() == null) throw new Exception("Missing discount amount");
    }
}
