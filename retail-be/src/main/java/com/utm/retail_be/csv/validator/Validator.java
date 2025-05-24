package com.utm.retail_be.csv.validator;
public interface Validator<T> {
    ValidationResult validate(T object);
}

