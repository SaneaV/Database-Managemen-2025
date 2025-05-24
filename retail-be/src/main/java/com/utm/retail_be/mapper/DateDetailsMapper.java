package com.utm.retail_be.mapper;

import com.utm.retail_be.entity.DateDetails;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateDetailsMapper {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static DateDetails fromCsv(String[] row) throws Exception {
        DateDetails d = new DateDetails();
        d.setDateDetailsID(Integer.parseInt(row[0]));
        d.setDataBonDate(LocalDate.parse(row[1], formatter));
        d.setIsHoliday("TRUE".equalsIgnoreCase(row[2]));
        d.setWeekDay(Short.parseShort(row[3]));
        return d;
    }
}
