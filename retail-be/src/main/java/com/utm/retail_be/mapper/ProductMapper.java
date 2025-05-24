
package com.utm.retail_be.mapper;

import com.utm.retail_be.entity.Product;
import com.utm.retail_be.entity.ProductCategory;

import java.util.UUID;

public class ProductMapper {
    public static Product fromCsv(String[] row) {
        Product p = new Product();
        p.setProductName(row[1]);
        p.setUnit("buc");
        p.setUnitPrice(0f);

        ProductCategory pc = new ProductCategory();
        pc.setName(row[2]);
        p.setProductCategory(pc);
        return p;
    }
}
