package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "SIMULAZIONE_Finanziamento_Prestiti")
public class FinanziamentoPrestiti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_finanziamento_prestiti")
    private Long idFinanziamentoPrestito;

    @Column(name = "motivazione")
    private String motivazione;

    @Column(name = "importo")
    private Double importo;

    @Column(name = "durata")
    private Long durata;

    @Column(name = "tasso")
    private Double tasso;

    @Column(name = "tipoTasso")
    private String tipoTasso;

    @Column(name = "id_tipo")
    private Long idTipo;

    @Column(name = "id_simulazione")
    private Long idSimulazione;



    @Column(name = "includi_assicurazione")
    private String includiAssicurazione;


    @Column(name = "rata_mensile")
    private Double rataMensile;
    @Column(name = "totale_interessi")
    private Double totInteressi;
    @Column(name = "costo_totale")
    private Double costoTotale;

    public Double getRataMensile() {
        return rataMensile;
    }

    public void setRataMensile(Double rataMensile) {
        this.rataMensile = rataMensile;
    }

    public Double getTotInteressi() {
        return totInteressi;
    }

    public void setTotInteressi(Double totInteressi) {
        this.totInteressi = totInteressi;
    }

    public Double getCostoTotale() {
        return costoTotale;
    }

    public void setCostoTotale(Double costoTotale) {
        this.costoTotale = costoTotale;
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

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public Long getIdFinanziamentoPrestito() {
        return idFinanziamentoPrestito;
    }

    public void setIdFinanziamentoPrestito(Long idFinanziamentoPrestito) {
        this.idFinanziamentoPrestito = idFinanziamentoPrestito;
    }

    public String getMotivazione() {
        return motivazione;
    }

    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
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

    public String getTipoTasso() {
        return tipoTasso;
    }

    public void setTipoTasso(String tipoTasso) {
        this.tipoTasso = tipoTasso;
    }

    public String getIncludiAssicurazione() {
        return includiAssicurazione;
    }

    public void setIncludiAssicurazione(String includiAssicurazione) {
        this.includiAssicurazione = includiAssicurazione;
    }
}
