package com.example.demo.dto;

public class FinanziamentoCalcolatoDTO {


    private Double rataMensile;
    private Double totInteressi;
    private Double costoTotale;


    public Double getRataMensile() {
        return rataMensile;
    }

    public void setRataMensile(Double rataMensile) {
        this.rataMensile = rataMensile;
    }

    public Double getTotInteressi() {
        return totInteressi;
    }

    public void setTotInteressi(Double totInteressi) {
        this.totInteressi = totInteressi;
    }

    public Double getCostoTotale() {
        return costoTotale;
    }

    public void setCostoTotale(Double costoTotale) {
        this.costoTotale = costoTotale;
    }
}
