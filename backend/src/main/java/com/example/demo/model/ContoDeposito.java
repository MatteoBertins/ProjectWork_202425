package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Calcolo_Conto_Deposito")
public class ContoDeposito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conto_deposito")
    private Long idContoDeposito;

    @Column(name = "importo_vincolato")
    private Double importoVincolato;


    @Column(name = "data_inizio")
    private Date dataInizio;



    @Column(name = "data_fine")
    private Date dataFine;


    @Column(name = "id_conto_origine")
    private Long idContoOrigine;


    public Long getIdContoDeposito() {
        return idContoDeposito;
    }

    public void setIdContoDeposito(Long idContoDeposito) {
        this.idContoDeposito = idContoDeposito;
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

    public Long getIdContoOrigine() {
        return idContoOrigine;
    }

    public void setIdContoOrigine(Long idContoOrigine) {
        this.idContoOrigine = idContoOrigine;
    }
}
