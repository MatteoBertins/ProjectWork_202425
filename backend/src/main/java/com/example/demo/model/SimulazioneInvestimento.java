package com.example.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "Simulazione_Investimento")
public class SimulazioneInvestimento {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_simulazione_investimento")
    private Long idSimulazioneInvestimento;

    @Column(name = "nome")
    private String nome;

    @Column(name = "importo")
    private Double importo;

    @Column(name = "durata")
    private Long durata;

    @Column(name = "rendimento_atteso")
    private Long rendimentoAtteso;

    @Column(name = "tipo_piano")
    private Long tipoPiano;

    @Column(name = "id_calcolo")
    private Long idCalcolo;

    @Column(name = "id_simulazione")
    private Long idSimulazione;


    public SimulazioneInvestimento() {

    }

    public SimulazioneInvestimento(Long idSimulazioneInvestimento, String nome, Double importo, Long durata, Long rendimentoAtteso, Long tipoPiano, Long idCalcolo, Long idSimulazione) {
        this.idSimulazioneInvestimento = idSimulazioneInvestimento;
        this.nome = nome;
        this.importo = importo;
        this.durata = durata;
        this.rendimentoAtteso = rendimentoAtteso;
        this.tipoPiano = tipoPiano;
        this.idCalcolo = idCalcolo;
        this.idSimulazione = idSimulazione;
    }

    public Long getIdSimulazioneInvestimento() {
        return idSimulazioneInvestimento;
    }

    public void setIdSimulazioneInvestimento(Long idSimulazioneInvestimento) {
        this.idSimulazioneInvestimento = idSimulazioneInvestimento;
    }

    public Long getIdCalcolo() {
        return idCalcolo;
    }

    public void setIdCalcolo(Long idCalcolo) {
        this.idCalcolo = idCalcolo;
    }

    public Long getIdSimulazione() {
        return idSimulazione;
    }

    public void setIdSimulazione(Long idSimulazione) {
        this.idSimulazione = idSimulazione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Long getRendimentoAtteso() {
        return rendimentoAtteso;
    }

    public void setRendimentoAtteso(Long rendimentoAtteso) {
        this.rendimentoAtteso = rendimentoAtteso;
    }

    public Long getTipoPiano() {
        return tipoPiano;
    }

    public void setTipoPiano(Long tipoPiano) {
        this.tipoPiano = tipoPiano;
    }
}
