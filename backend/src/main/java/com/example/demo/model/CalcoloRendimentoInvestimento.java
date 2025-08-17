package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Calcolo_Rendimento_Investimento")
public class CalcoloRendimentoInvestimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calcolo")
    private Long idCalcolo;

    @Column(name = "importoFinale")
    private Double importoFinale;

    public Long getIdCalcolo() {
        return idCalcolo;
    }

    public void setIdCalcolo(Long idCalcolo) {
        this.idCalcolo = idCalcolo;
    }

    public Double getImportoFinale() {
        return importoFinale;
    }

    public void setImportoFinale(Double importoFinale) {
        this.importoFinale = importoFinale;
    }
}
