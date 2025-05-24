package com.utm.retail_be.csv.validator;

import com.utm.retail_be.csv.dto.DateDetailsDTO;
import com.utm.retail_be.csv.dto.DiscountDTO;
import org.springframework.stereotype.Service;

@Service
public class ErrorHandlingService {

    public <T> T fixErrors(T dto) {
        if (dto instanceof DiscountDTO discountDTO) {
            if (discountDTO.getDiscPerc() < 0) {
                discountDTO.setDiscPerc(0.0);
            } else if (discountDTO.getDiscPerc() > 1) {
                discountDTO.setDiscPerc(1.0);
            }
        }

        if (dto instanceof DateDetailsDTO holidayDTO) {
            if (holidayDTO.getSarbatoare() != 0 && holidayDTO.getSarbatoare() != 1) {
                holidayDTO.setSarbatoare(0);
            }
        }

        return dto;
    }
}


