package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "SIMULAZIONE_FINANZIAMENTO_MUTUI")
public class FinanziamentoMutui {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Finanziamento_mutui")
    private Long idFinanziamentoMutui;


    @Column(name = "finalita")
    private String finalita;

    @Column(name = "valore_casa")
    private Double valoreCasa;

    @Column(name = "importo_richiesto")
    private Double importoRichiesto;

    @Column(name = "durata")
    private Long durata;

    @Column(name = "eta_richiedente")
    private Long etaRichiedente;

    @Column(name = "tipo_tasso")
    private String tipoTasso;

    @Column(name = "tasso")
    private Double tasso;

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



    public FinanziamentoMutui() {
    }

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

    public Long getIdSimulazione() {
        return idSimulazione;
    }

    public void setIdSimulazione(Long idSimulazione) {
        this.idSimulazione = idSimulazione;
    }

    public FinanziamentoMutui(String finalita, Double valoreCasa, Double importoRichiesto, Long durata, Long etaRichiedente, String tipoTasso, String includiAssicurazione) {
        this.finalita = finalita;
        this.valoreCasa = valoreCasa;
        this.importoRichiesto = importoRichiesto;
        this.durata = durata;
        this.etaRichiedente = etaRichiedente;
        this.tipoTasso = tipoTasso;
        this.includiAssicurazione = includiAssicurazione;
    }

    public Long getIdFinanziamentoMutui() {
        return idFinanziamentoMutui;
    }

    public Double getTasso() {
        return tasso;
    }

    public void setTasso(Double tasso) {
        this.tasso = tasso;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public void setIdFinanziamentoMutui(Long idFinanziamentoMutui) {
        this.idFinanziamentoMutui = idFinanziamentoMutui;
    }

    public String getFinalita() {
        return finalita;
    }

    public void setFinalita(String finalita) {
        this.finalita = finalita;
    }

    public Double getValoreCasa() {
        return valoreCasa;
    }

    public void setValoreCasa(Double valoreCasa) {
        this.valoreCasa = valoreCasa;
    }

    public Double getImportoRichiesto() {
        return importoRichiesto;
    }

    public void setImportoRichiesto(Double importoRichiesto) {
        this.importoRichiesto = importoRichiesto;
    }

    public Long getDurata() {
        return durata;
    }

    public void setDurata(Long durata) {
        this.durata = durata;
    }

    public Long getEtaRichiedente() {
        return etaRichiedente;
    }

    public void setEtaRichiedente(Long etaRichiedente) {
        this.etaRichiedente = etaRichiedente;
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
