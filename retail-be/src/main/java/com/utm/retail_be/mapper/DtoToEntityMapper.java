package com.utm.retail_be.mapper;

import com.utm.retail_be.csv.dto.*;
import com.utm.retail_be.entity.DateDetails;
import com.utm.retail_be.entity.Discount;
import com.utm.retail_be.entity.ProductCategory;
import com.utm.retail_be.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DtoToEntityMapper {
    public List<DateDetails> mapToEntityFromDetails(List<DateDetailsDTO> dtoList) {
        return dtoList.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    public DateDetails mapToEntity(DateDetailsDTO dto) {
        var entity = new DateDetails();

        entity.setDateDetailsID(dto.getId());
        entity.setWeekDay(dto.getZiua());
        entity.setIsHoliday(dto.getSarbatoare() == 1);
        // TODO: add other fields

        return entity;
    }

    public List<Discount> mapToEntityFromDiscount(List<DiscountDTO> dtoList) {
        return dtoList.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    public Discount mapToEntity(DiscountDTO dto) {
        var entity = new Discount();

        entity.setDiscountID(Short.parseShort(dto.getDiscId()));
        entity.setName(dto.getDenpr());
        entity.setAmount(dto.getDiscPerc());

        return entity;
    }

    public List<ProductCategory> mapToEntityFromProductCategory(List<ProductCategoryDTO> dtoList) {
        return dtoList.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    public ProductCategory mapToEntity(ProductCategoryDTO dto) {
        var entity = new ProductCategory();

        entity.setProductCategoryID(dto.getId());
        entity.setName(dto.getCategorie());
        // TODO: add other fields

        return entity;
    }

    public List<Shop> mapToEntityFromShop(List<ShopDTO> dtoList) {
        return dtoList.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    public Shop mapToEntity(ShopDTO dto) {
        var entity = new Shop();

        entity.setShopID(dto.getId());
        entity.setAddressID(dto.getAddressId());
        entity.setCity(dto.getOras());
        entity.setName(dto.getNumeGest());
        entity.setLatitude(dto.getLat());
        entity.setLongitude(dto.getLon());
        // TODO: add other fields

        return entity;
    }

    // TODO: add Sales mapper
}
