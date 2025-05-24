
package com.utm.retail_be.validator;

import com.utm.retail_be.entity.Country;

public class CountryValidator implements CsvValidator<Country> {
    public void validate(Country c) throws Exception {
        if (c.getCountryID() == null) throw new Exception("Missing country ID");
        if (c.getName() == null || c.getName().isEmpty()) throw new Exception("Missing country name");
    }
}
