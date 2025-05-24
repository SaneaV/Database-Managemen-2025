package com.utm.retail_be.csv.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class ShopDTO {
    private int id;
    private int addressId;
    private int shopId;
    private int countryId;
    private String numeGest;
    private double lat;
    private double lon;
    private String tara;
    private String oras;

    public ShopDTO(int id, int addressId, int shopId, int countryId, String numeGest, double lat, double lon, String tara, String oras) {
        this.id = id;
        this.addressId = addressId;
        this.shopId = shopId;
        this.countryId = countryId;
        this.numeGest = numeGest;
        this.lat = lat;
        this.lon = lon;
        this.tara = tara;
        this.oras = oras;
    }

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

