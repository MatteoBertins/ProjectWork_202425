package com.example.demo.dto;

public class ContoDepositoCalcolatoDTO {


    private Double importoDaVincolare;
    private Long durata;
    private Double interessiMaturati;
    private Double totaleScadenza;
    private Double tasso;


    public void setDurata(Long durata) {
        this.durata = durata;
    }

    public Long getDurata() {
        return durata;
    }

    public Double getTasso() {
        return tasso;
    }

    public void setTasso(Double tasso) {
        this.tasso = tasso;
    }

    public Double getInteressiMaturati() {
        return interessiMaturati;
    }

    public void setInteressiMaturati(Double interessiMaturati) {
        this.interessiMaturati = interessiMaturati;
    }

    public Double getTotaleScadenza() {
        return totaleScadenza;
    }

    public void setTotaleScadenza(Double totaleScadenza) {
        this.totaleScadenza = totaleScadenza;
    }

    public Double getImportoDaVincolare() {
        return importoDaVincolare;
    }

    public void setImportoDaVincolare(Double importoDaVincolare) {
        this.importoDaVincolare = importoDaVincolare;
    }

}
