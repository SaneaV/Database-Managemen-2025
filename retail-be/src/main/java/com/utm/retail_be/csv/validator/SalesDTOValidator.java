package com.utm.retail_be.csv.validator;

import com.utm.retail_be.csv.dto.SalesDTO;
import org.springframework.stereotype.Component;

@Component
public class SalesDTOValidator implements Validator<SalesDTO> {

    @Override
    public ValidationResult validate(SalesDTO dto) {
        ValidationResult result = new ValidationResult();

        // Проверка даты
        if (dto.getDataBonData() == null) {
            result.addError("DATA_BON_DATA cannot be null");
        }

        // Проверка числовых значений
        if (dto.getValoareB() <= 0) {
            result.addError("VALOARE_B must be greater than 0");
        }

        if (dto.getCantitate() <= 0) {
            result.addError("CANTITATE must be greater than 0");
        }

        if (dto.getPuvTva() < 0) {
            result.addError("PUV_TVA cannot be negative");
        }

        if (dto.getValDisc() < 0) {
            result.addError("VAL_DISC cannot be negative");
        }

        if (dto.getValoareI() <= 0) {
            result.addError("VALOARE_I must be greater than 0");
        }

        // Проверка строковых полей на пустоту
        if (dto.getNumeGest() == null || dto.getNumeGest().isEmpty()) {
            result.addError("NUME_GEST cannot be null or empty");
        }

        if (dto.getDenpr() == null || dto.getDenpr().isEmpty()) {
            result.addError("DENPR cannot be null or empty");
        }

        if (dto.getUm() == null || dto.getUm().isEmpty()) {
            result.addError("UM cannot be null or empty");
        }

        if (dto.getGen() == null || dto.getGen().isEmpty()) {
            result.addError("GEN cannot be null or empty");
        }

        if (dto.getVarsta() == null || dto.getVarsta().isEmpty()) {
            result.addError("VIRSTA cannot be null or empty");
        }

        if (dto.getCanal() == null || dto.getCanal().isEmpty()) {
            result.addError("CANAL cannot be null or empty");
        }

        // Проверка дисконта
        if (dto.getDiscPerc() < 0 || dto.getDiscPerc() > 1) {
            result.addError("DISC_PERC must be between 0 and 1");
        }

        return result;
    }
}
