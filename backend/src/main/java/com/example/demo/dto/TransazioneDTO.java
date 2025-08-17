package com.example.demo.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


public class TransazioneDTO {


    private Long idContoOrigine;
    private BigDecimal importo;
    private Date data;
    private String descrizione;
    private Long tipologiaTransazione;

    public TransazioneDTO(Long idContoOrigine, BigDecimal importo, Date data, String descrizione, Long tipologiaTransazione) {
        this.idContoOrigine = idContoOrigine;
        this.importo = importo;
        this.data = data;
        this.descrizione = descrizione;
        this.tipologiaTransazione = tipologiaTransazione;
    }

    public TransazioneDTO() {
    }

    public Long getIdContoOrigine() {
        return idContoOrigine;
    }

    public void setIdContoOrigine(Long idContoOrigine) {
        this.idContoOrigine = idContoOrigine;
    }

    public BigDecimal getImporto() {
        return importo;
    }

    public void setImporto(BigDecimal importo) {
        this.importo = importo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Long getTipologiaTransazione() {
        return tipologiaTransazione;
    }

    public void setTipologiaTransazione(Long tipologiaTransazione) {
        this.tipologiaTransazione = tipologiaTransazione;
    }
}
