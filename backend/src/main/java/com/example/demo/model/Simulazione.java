package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Simulazione")
public class Simulazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_simulazione")
    private Long idSimulazione;

    @Column(name = "id_utente")
    private Long idUtente;

    @Column(name = "id_tipo")
    private Long idTipo;

    @Column(name = "data_creazione")
    private Date dataCreazione;


    public Long getIdSimulazione() {
        return idSimulazione;
    }

    public void setIdSimulazione(Long idSimulazione) {
        this.idSimulazione = idSimulazione;
    }

    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }
}
