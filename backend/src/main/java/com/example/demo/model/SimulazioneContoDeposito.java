package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "SIMULAZIONE_CONTO_DEPOSITO")
public class SimulazioneContoDeposito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_simulazione_conto_deposito")
    private Long idSimulazioneContoDeposito;

    @Column(name = "importo")
    private Double importo;


    @Column(name = "durata")
    private Long durata;


    @Column(name = "tasso")
    private Double tasso;

    @Column(name = "id_simulazione")
    private Long idSimulazione;

    public Long getIdSimulazioneContoDeposito() {
        return idSimulazioneContoDeposito;
    }

    public void setIdSimulazioneContoDeposito(Long idSimulazioneContoDeposito) {
        this.idSimulazioneContoDeposito = idSimulazioneContoDeposito;
    }

    public Double getImporto() {
        return importo;
    }

    public void setImporto(Double importo) {
        this.importo = importo;
    }

    public Long getDurata() {
        return durata;
    }

    public void setDurata(Long durata) {
        this.durata = durata;
    }


    public Double getTasso() {
        return tasso;
    }

    public void setTasso(Double tasso) {
        this.tasso = tasso;
    }

    public Long getIdSimulazione() {
        return idSimulazione;
    }

    public void setIdSimulazione(Long idSimulazione) {
        this.idSimulazione = idSimulazione;
    }
}
