package com.utm.retail_be.validator;

import com.utm.retail_be.entity.DateDetails;

public class DateDetailsValidator implements CsvValidator<DateDetails> {
    public void validate(DateDetails d) throws Exception {
        if (d.getDateDetailsID() == null) throw new Exception("Missing date ID");
        if (d.getIsHoliday() == null) throw new Exception("Missing isHoliday");
        if (d.getWeekDay() == null) throw new Exception("Missing weekDay");
    }
}
