
package com.utm.retail_be.mapper;

import com.utm.retail_be.entity.Discount;

public class DiscountMapper {
    public static Discount fromCsv(String[] row) {
        Discount d = new Discount();
        d.setDiscountID(Integer.parseInt(row[0]));
        d.setName(row[1]);
        d.setAmount(Double.parseDouble(row[2]));
        return d;
    }
}
