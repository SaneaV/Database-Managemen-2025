package com.utm.retail_be.validator;

import com.utm.retail_be.entity.Shop;

public class ShopValidator implements CsvValidator<Shop> {
    public void validate(Shop s) throws Exception {
        if (s.getShopID() == null) throw new Exception("Missing shop ID");
        if (s.getName() == null || s.getName().isEmpty()) throw new Exception("Missing shop name");
        if (s.getCity() == null || s.getCity().isEmpty()) throw new Exception("Missing city");
        if (s.getLongitude() == null) throw new Exception("Missing longitude");
        if (s.getLatitude() == null) throw new Exception("Missing latitude");
        if (s.getCountry() == null) throw new Exception("Missing country");
    }
}
