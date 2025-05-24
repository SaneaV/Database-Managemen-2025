
package com.utm.retail_be.mapper;

import com.utm.retail_be.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class SalesMapper {
  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

  public static Payment fromCsvRow(String[] row, Map<LocalDate, DateDetails> dateDetailsByDate) throws Exception {
    Payment p = new Payment();
    LocalDate parsed = LocalDate.parse(row[0], formatter);
    p.setCreateDate(parsed);

    Shop shop = new Shop();
    shop.setName(row[2]);
    p.setShop(shop);

    CustomerCategory cc = new CustomerCategory();
    cc.setGender(row[11]);
    cc.setAgeCategory(row[12]);
    p.setCustomerCategory(cc);

    DateDetails dd = dateDetailsByDate.get(parsed);
    if (dd == null) {
      throw new Exception("No DateDetails found for date " + row[0]);
    }
    p.setDateDetails(dd);
    p.setTotalAmount(new BigDecimal(row[3]));
    return p;
  }

  public static PaymentDetail fromCsvRow(String[] row) {
    PaymentDetail pd = new PaymentDetail();
    pd.setQuantity(Float.parseFloat(row[5]));
    pd.setDiscountValue(Double.parseDouble(row[7]));
    pd.setFinalValue(Double.parseDouble(row[10]));

    Product prod = new Product();
    prod.setProductName(row[8]);
    pd.setProduct(prod);

    Discount d = new Discount();
    d.setAmount(Double.parseDouble(row[14]));
    pd.setDiscount(d);

    return pd;
  }
}
