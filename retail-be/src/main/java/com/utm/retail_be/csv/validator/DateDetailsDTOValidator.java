package com.utm.retail_be.csv.validator;
import com.utm.retail_be.csv.dto.DateDetailsDTO;
import org.springframework.stereotype.Component;

@Component
public class DateDetailsDTOValidator implements Validator<DateDetailsDTO> {

    @Override
    public ValidationResult validate(DateDetailsDTO dto) {
        ValidationResult result = new ValidationResult();

        if (dto.getDataBonData() == null) {
            result.addError("data_bon_data cannot be null");
        }

        if (dto.getSarbatoare() < 0 || dto.getSarbatoare() > 1) {
            result.addError("Sarbatoare must be either 0 or 1");
        }

        if (dto.getZiua() <= 0) {
            result.addError("Ziua must be a positive integer");
        }

        return result;
    }
}

