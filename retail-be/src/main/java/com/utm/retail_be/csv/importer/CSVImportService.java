package com.utm.retail_be.csv.importer;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.utm.retail_be.csv.dto.*;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVImportService {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("M/d/yyyy");

    public <T> List<T> importCSV(String filePath, Class<T> clazz) throws IOException {
        List<T> dataList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            reader.readNext(); // Пропускаем заголовки
            while ((line = reader.readNext()) != null) {
                T object = mapLineToObject(line, clazz);
                if (object != null) {
                    dataList.add(object);
                }
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }

    private <T> T mapLineToObject(String[] line, Class<T> clazz) {
        if (clazz == DiscountDTO.class) {
            return (T) new DiscountDTO(line[0], line[1], Double.parseDouble(line[2]));
        } else if (clazz == DateDetailsDTO.class) {
            return (T) new DateDetailsDTO(Integer.parseInt(line[0]), LocalDate.parse(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
        } else if (clazz == ShopDTO.class) {
            return (T) new ShopDTO(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                    Integer.parseInt(line[3]), line[4], Double.parseDouble(line[5]), Double.parseDouble(line[6]), line[7], line[8]);
        } else if (clazz == ProductCategoryDTO.class) {
            return (T) new ProductCategoryDTO(Integer.parseInt(line[0]), line[1], line[2], line[3]);
        } else if (clazz == SalesDTO.class) {
            return (T) new SalesDTO(
                    LocalDate.parse(line[0], DATE_FORMATTER), // DATA_BON_DATA
                    Integer.parseInt(line[1]), // DATA_BON_ORA
                    line[2],                   // NUME_GEST
                    Double.parseDouble(line[3]), // VALOARE_B
                    Integer.parseInt(line[4]), // ID_BON
                    Double.parseDouble(line[5]), // CANTITATE
                    Double.parseDouble(line[6]), // PUV_TVA
                    Double.parseDouble(line[7]), // VAL_DISC
                    line[8],                     // DENPR
                    line[9],                     // UM
                    Double.parseDouble(line[10]), // VALOARE_I
                    line[11],                    // GEN
                    line[12],                    // VIRSTA
                    line[13],                    // CANAL
                    Double.parseDouble(line[14])  // DISC_PERC
            );
        }
        return null;
    }
}
