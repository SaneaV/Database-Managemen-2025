package com.utm.retail_be.validator;

public interface CsvValidator<T> {
    void validate(T entity) throws Exception;
}
