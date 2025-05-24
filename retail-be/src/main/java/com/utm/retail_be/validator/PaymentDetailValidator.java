package com.utm.retail_be.validator;

import com.utm.retail_be.entity.PaymentDetail;

public class PaymentDetailValidator implements CsvValidator<PaymentDetail> {
    public void validate(PaymentDetail pd) throws Exception {
        if (pd.getPaymentDetailID() == null) throw new Exception("Missing payment detail ID");
        if (pd.getQuantity() == null) throw new Exception("Missing quantity");
        if (pd.getPayment() == null) throw new Exception("Missing payment");
        if (pd.getProduct() == null) throw new Exception("Missing product");
    }
}
