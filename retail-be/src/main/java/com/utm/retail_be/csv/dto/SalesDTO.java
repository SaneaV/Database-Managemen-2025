package com.utm.retail_be.csv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class SalesDTO {
    private LocalDate dataBonData;
    private int dataBonOra;
    private String numeGest;
    private double valoareB;
    private int idBon;
    private double cantitate;
    private double puvTva;
    private double valDisc;
    private String denpr;
    private String um;
    private double valoareI;
    private String gen;
    private String varsta;
    private String canal;
    private double discPerc;

    @Override
    public String toString() {
        return "SalesDTO{" +
                "dataBonData=" + dataBonData +
                ", dataBonOra=" + dataBonOra +
                ", numeGest='" + numeGest + '\'' +
                ", valoareB=" + valoareB +
                ", idBon=" + idBon +
                ", cantitate=" + cantitate +
                ", puvTva=" + puvTva +
                ", valDisc=" + valDisc +
                ", denpr='" + denpr + '\'' +
                ", um='" + um + '\'' +
                ", valoareI=" + valoareI +
                ", gen='" + gen + '\'' +
                ", varsta='" + varsta + '\'' +
                ", canal='" + canal + '\'' +
                ", discPerc=" + discPerc +
                '}';
    }
}
