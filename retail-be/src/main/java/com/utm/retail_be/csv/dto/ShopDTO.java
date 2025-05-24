package com.utm.retail_be.csv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class ShopDTO {
    private int id;
    private int addressId;
    private int shopId;
    private int countryId;
    private String numeGest;
    private Float lat;
    private Float lon;
    private String tara;
    private String oras;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopDTO shopDTO = (ShopDTO) o;
        return id == shopDTO.id && addressId == shopDTO.addressId && shopId == shopDTO.shopId && countryId == shopDTO.countryId && Double.compare(shopDTO.lat, lat) == 0 && Double.compare(shopDTO.lon, lon) == 0 && Objects.equals(numeGest, shopDTO.numeGest) && Objects.equals(tara, shopDTO.tara) && Objects.equals(oras, shopDTO.oras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addressId, shopId, countryId, numeGest, lat, lon, tara, oras);
    }
}

