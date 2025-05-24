package com.utm.retail_be.csv.validator;

import com.utm.retail_be.csv.dto.ShopDTO;
import org.springframework.stereotype.Component;

@Component
public class ShopDTOValidator implements Validator<ShopDTO> {

    @Override
    public ValidationResult validate(ShopDTO dto) {
        ValidationResult result = new ValidationResult();

        if (dto.getId() <= 0) {
            result.addError("ID must be positive");
        }

        if (dto.getAddressId() <= 0) {
            result.addError("AddressID must be positive");
        }

        if (dto.getShopId() <= 0) {
            result.addError("ShopID must be positive");
        }

        if (dto.getCountryId() <= 0) {
            result.addError("CountryID must be positive");
        }

        if (dto.getNumeGest() == null || dto.getNumeGest().isEmpty()) {
            result.addError("nume_gest cannot be null or empty");
        }

        if (dto.getLat() == 0 || dto.getLon() == 0) {
            result.addError("Lat and Lon must be valid coordinates");
        }

        if (dto.getTara() == null || dto.getTara().isEmpty()) {
            result.addError("Tara cannot be null or empty");
        }

        if (dto.getOras() == null || dto.getOras().isEmpty()) {
            result.addError("Oras cannot be null or empty");
        }

        return result;
    }
}

