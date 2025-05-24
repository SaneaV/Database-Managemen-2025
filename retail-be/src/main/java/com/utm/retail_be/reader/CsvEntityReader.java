package com.utm.retail_be.reader;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.utm.retail_be.validator.CsvValidator;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvEntityReader<T> {
    public List<T> readAndValidate(InputStream inputStream, Class<T> clazz, CsvValidator<T> validator) throws Exception {
        try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1)) {
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                .withType(clazz)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

            List<T> beans = csvToBean.parse();
            List<T> notCorrectedBeans = new ArrayList<>();
            for (T bean : beans) {
                try {
                    validator.validate(bean);
                }
                catch (Exception e) {
                    notCorrectedBeans.add(bean);
                }
            }

            beans.removeAll(notCorrectedBeans);
            return beans;
        }
    }
}

