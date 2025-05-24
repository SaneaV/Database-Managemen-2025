package com.utm.retail_be.csv.validator;

import com.utm.retail_be.csv.dto.DiscountDTO;
import org.springframework.stereotype.Service;

@Service
public class DiscountDTOValidator implements Validator<DiscountDTO> {

    @Override
    public ValidationResult validate(DiscountDTO dto) {
        ValidationResult result = new ValidationResult();

        if (dto.getDiscId() == null || dto.getDiscId().isEmpty()) {
            result.addError("Disc_ID cannot be null or empty");
        }

        if (dto.getDenpr() == null || dto.getDenpr().isEmpty()) {
            result.addError("denpr cannot be null or empty");
        }

        if (dto.getDiscPerc() == null || dto.getDiscPerc() < 0 || dto.getDiscPerc() > 1) {
            result.addError("disc_perc must be between 0 and 1");
        }

        return result;
    }
}

