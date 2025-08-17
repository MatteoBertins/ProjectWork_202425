package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Transazione")
public class Transazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transazione")
    private Long idTransazione;

    @Column(name = "id_conto_origine")
    private Long idContoOrigine;

    @Column(name = "importo")
    private BigDecimal importo;

    @Column(name = "data")
    private Date data;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "id_categoria")
    private Long idCategoria;

    // Getters e setters
    public Long getIdTransazione() {
        return idTransazione;
    }

    public void setIdTransazione(Long idTransazione) {
        this.idTransazione = idTransazione;
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

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}
