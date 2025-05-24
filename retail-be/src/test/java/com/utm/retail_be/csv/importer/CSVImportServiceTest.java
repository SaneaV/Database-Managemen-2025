package com.utm.retail_be.csv.importer;

import com.opencsv.exceptions.CsvValidationException;
import com.utm.retail_be.csv.dto.*;
import com.utm.retail_be.csv.validator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class CSVImportServiceTest {
    private ImportService importService;
    private CSVImportService csvImportService;

    @BeforeEach
    void setUp() {
        // 1. Создаем сервисы
        csvImportService = new CSVImportService();
        DiscountDTOValidator discountDTOValidator = new DiscountDTOValidator();
        ErrorHandlingService errorHandlingService = new ErrorHandlingService();
        DateDetailsDTOValidator dateDetailsDTOValidator = new DateDetailsDTOValidator();
        ProductCategoryDTOValidator productCategoryDTOValidator = new ProductCategoryDTOValidator();
        ShopDTOValidator shopDTOValidator = new ShopDTOValidator();
        SalesDTOValidator salesDTOValidator = new SalesDTOValidator();
        importService = new ImportService(csvImportService, discountDTOValidator, dateDetailsDTOValidator, shopDTOValidator, productCategoryDTOValidator, salesDTOValidator, errorHandlingService);
    }

    @Test
    public void testImportAndValidateDiscountCSV() throws IOException {
        // 2. Указываем путь к тестовому файлу
        String filePath = "src/test/resources/Discount_Prods.csv";

        // 3. Запускаем импорт и валидацию
        importService.importAndValidate(filePath, DiscountDTO.class);

        // 4. Проверка правильности данных после исправления
        List<DiscountDTO> discountList = csvImportService.importCSV(filePath, DiscountDTO.class);

        // 5. Проверка, что ошибки были исправлены
//        assertAll("Validating fixed data",
//                () -> assertEquals(1.0, discountList.get(2).getDiscPerc(), "Error in discount percentage correction"),
//                () -> assertNotNull(discountList.get(3).getDenpr(), "Product name should not be null after fixing"),
//                () -> assertNotNull(discountList.get(4).getDenpr(), "Product name should not be null after fixing")
//        );
    }

    @Test
    public void testImportAndValidateDateDetailsCSV() throws IOException {
        String filePath = "src/test/resources/DateDetails.csv";
        importService.importAndValidate(filePath, DateDetailsDTO.class);
        var parsedData = csvImportService.importCSV(filePath, DateDetailsDTO.class);
    }

    @Test
    public void testImportAndValidateProductCategoryCSV() throws IOException {
        String filePath = "src/test/resources/Products Categories.csv";
        importService.importAndValidate(filePath, ProductCategoryDTO.class);
        var parsedData = csvImportService.importCSV(filePath, ProductCategoryDTO.class);
    }

    @Test
    public void testImportAndValidateShopsCSV() throws IOException {
        String filePath = "src/test/resources/Geolocation_shops.csv";
        importService.importAndValidate(filePath, ShopDTO.class);
        var parsedData = csvImportService.importCSV(filePath, ShopDTO.class);
    }

    @Test
    public void testImportAndValidateSalesCSV() throws IOException {
        String filePath = "src/test/resources/Sales_05_2020_new.csv";
        importService.importAndValidate(filePath, SalesDTO.class);
        var parsedData = csvImportService.importCSV(filePath, SalesDTO.class);
    }
}
