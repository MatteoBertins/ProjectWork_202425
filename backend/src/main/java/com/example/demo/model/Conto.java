package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Conto")
public class Conto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conto")
    private Long idConto;


    @Column(name = "id_utente")
    private Long idUtente;

    @Column(name = "saldo")
    private Double saldo;


    public Long getIdConto() {
        return idConto;
    }

    public void setIdConto(Long idConto) {
        this.idConto = idConto;
    }

    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
