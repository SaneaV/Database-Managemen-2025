package com.utm.retail_be.validator;

import com.utm.retail_be.entity.Supplier;

public class SupplierValidator implements CsvValidator<Supplier> {
    public void validate(Supplier s) throws Exception {
        if (s.getSupplierID() == null) throw new Exception("Missing supplier ID");
        if (s.getName() == null || s.getName().isEmpty()) throw new Exception("Missing supplier name");
    }
}
