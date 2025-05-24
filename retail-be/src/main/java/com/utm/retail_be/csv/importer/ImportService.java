package com.utm.retail_be.csv.importer;

import com.utm.retail_be.csv.dto.*;
import com.utm.retail_be.csv.validator.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImportService {

    private final CSVImportService csvImportService;
    private final DiscountDTOValidator discountDTOValidator;
    private final DateDetailsDTOValidator dateDetailsDTOValidator;
    private final ShopDTOValidator shopDTOValidator;
    private final ProductCategoryDTOValidator productCategoryDTOValidator;
    private final SalesDTOValidator salesDTOValidator;
    private final ErrorHandlingService errorHandlingService;

    public List<?> importAndValidate(String filePath, Class<?> clazz) throws IOException {
        // Получаем список объектов из CSV
        List<?> dataList = csvImportService.importCSV(filePath, clazz);

        // Валидация для DiscountDTO
        if (clazz == DiscountDTO.class) {
            for (Object obj : dataList) {
                DiscountDTO dto = (DiscountDTO) obj;
                ValidationResult result = discountDTOValidator.validate(dto);
                if (result.hasErrors()) {
                    System.out.println("Errors found for DiscountDTO: " + result.getErrors());
                    dto = (DiscountDTO) errorHandlingService.fixErrors(dto);
                    System.out.println("Fixed DiscountDTO: " + dto);
                } else {
                    System.out.println("Valid DiscountDTO: " + dto);
                }
            }
        }
        // Валидация для DateDetailsDTO
        else if (clazz == DateDetailsDTO.class) {
            for (Object obj : dataList) {
                DateDetailsDTO dto = (DateDetailsDTO) obj;
                ValidationResult result = dateDetailsDTOValidator.validate(dto);
                if (result.hasErrors()) {
                    System.out.println("Errors found for DateDetailsDTO: " + result.getErrors());
                    dto = (DateDetailsDTO) errorHandlingService.fixErrors(dto);
                    System.out.println("Fixed DateDetailsDTO: " + dto);
                } else {
                    System.out.println("Valid DateDetailsDTO: " + dto);
                }
            }
        }
        // Валидация для ShopDTO
        else if (clazz == ShopDTO.class) {
            for (Object obj : dataList) {
                ShopDTO dto = (ShopDTO) obj;
                ValidationResult result = shopDTOValidator.validate(dto);
                if (result.hasErrors()) {
                    System.out.println("Errors found for ShopDTO: " + result.getErrors());
                    dto = (ShopDTO) errorHandlingService.fixErrors(dto);
                    System.out.println("Fixed ShopDTO: " + dto);
                } else {
                    System.out.println("Valid ShopDTO: " + dto);
                }
            }
        }
        // Валидация для ProductCategoryDTO
        else if (clazz == ProductCategoryDTO.class) {
            for (Object obj : dataList) {
                ProductCategoryDTO dto = (ProductCategoryDTO) obj;
                ValidationResult result = productCategoryDTOValidator.validate(dto);
                if (result.hasErrors()) {
                    System.out.println("Errors found for ProductCategoryDTO: " + result.getErrors());
                    dto = (ProductCategoryDTO) errorHandlingService.fixErrors(dto);
                    System.out.println("Fixed ProductCategoryDTO: " + dto);
                } else {
                    System.out.println("Valid ProductCategoryDTO: " + dto);
                }
            }
        }

        else if (clazz == SalesDTO.class) {
            for (Object obj : dataList) {
                SalesDTO dto = (SalesDTO) obj;
                ValidationResult result = salesDTOValidator.validate(dto);
                if (result.hasErrors()) {
                    System.out.println("Errors found for SalesDTO: " + result.getErrors());
                    dto = (SalesDTO) errorHandlingService.fixErrors(dto);
                    System.out.println("Fixed SalesDTO: " + dto);
                } else {
                    System.out.println("Valid SalesDTO: " + dto);
                }
            }
        }

        return dataList;
    }
}
