package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssetDTO {


    private String nome;
    private Double importo;
    private Long durata;
    private Long rendimentoAtteso;
    private Long tipoPiano;
    private Long idCalcolo;
    private String piano;
    private Double importoFinale;

    public AssetDTO(String nome, Double importo, Long durata, Long rendimentoAtteso, String piano, Double importoFinale,Long idCalcolo) {
        this.nome = nome;
        this.importo = importo;
        this.durata = durata;
        this.rendimentoAtteso = rendimentoAtteso;
        this.piano = piano;
        this.importoFinale = importoFinale;
        this.idCalcolo = idCalcolo;
    }
}
