package com.utm.retail_be.validator;

import com.utm.retail_be.entity.Payment;

public class PaymentValidator implements CsvValidator<Payment> {
    public void validate(Payment p) throws Exception {
        if (p.getPaymentID() == null) throw new Exception("Missing payment ID");
        if (p.getCreateDate() == null) throw new Exception("Missing create date");
        if (p.getShop() == null) throw new Exception("Missing shop reference");
        if (p.getDateDetails() == null) throw new Exception("Missing date details");
        if (p.getCustomerCategory() == null) throw new Exception("Missing customer category");
    }
}
