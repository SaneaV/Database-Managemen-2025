package com.utm.retail_be.validator;

import com.utm.retail_be.entity.CustomerCategory;

public class CustomerCategoryValidator implements CsvValidator<CustomerCategory> {
    public void validate(CustomerCategory cc) throws Exception {
        if (cc.getCustomerCategoryID() == null) throw new Exception("Missing category ID");
        if (cc.getGender() == null || cc.getGender().isEmpty()) throw new Exception("Missing gender");
        if (cc.getAgeCategory() == null || cc.getAgeCategory().isEmpty()) throw new Exception("Missing age category");
    }
}
