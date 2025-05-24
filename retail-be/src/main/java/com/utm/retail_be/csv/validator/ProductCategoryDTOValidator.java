package com.utm.retail_be.csv.validator;

import com.utm.retail_be.csv.dto.ProductCategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryDTOValidator implements Validator<ProductCategoryDTO> {

    @Override
    public ValidationResult validate(ProductCategoryDTO dto) {
        ValidationResult result = new ValidationResult();

        if (dto.getId() <= 0) {
            result.addError("ID must be positive");
        }

        if (dto.getDenumireProdus() == null || dto.getDenumireProdus().isEmpty()) {
            result.addError("Denumire Produs cannot be null or empty");
        }

        if (dto.getCategorie() == null || dto.getCategorie().isEmpty()) {
            result.addError("Categorie cannot be null or empty");
        }

        if (dto.getCanalProdus() == null || dto.getCanalProdus().isEmpty()) {
            result.addError("Canal Produs cannot be null or empty");
        }

        return result;
    }
}
