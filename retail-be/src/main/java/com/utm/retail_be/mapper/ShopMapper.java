
package com.utm.retail_be.mapper;

import com.utm.retail_be.entity.Country;
import com.utm.retail_be.entity.Shop;

public class ShopMapper {
    public static Shop fromCsv(String[] row) {
        Shop s = new Shop();
        s.setShopID(Integer.parseInt(row[2]));
        s.setName(row[4]);
        s.setLatitude(Float.parseFloat(row[5]));
        s.setLongitude(Float.parseFloat(row[6]));
        s.setCity(row[8]);

        Country c = new Country();
        c.setName(row[7]);
        s.setCountry(c);
        return s;
    }
}
