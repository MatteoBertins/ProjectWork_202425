package com.example.demo.dto;

import java.util.Date;

public class ContoDepositoVincolatoDTO {


    private Double importoVincolato;
    private Date dataInizio;
    private Date dataFine;
    private Long mesi;

    public Long getMesi() {
        return mesi;
    }

    public void setMesi(Long mesi) {
        this.mesi = mesi;
    }

    public Double getImportoVincolato() {
        return importoVincolato;
    }

    public void setImportoVincolato(Double importoVincolato) {
        this.importoVincolato = importoVincolato;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }
}
