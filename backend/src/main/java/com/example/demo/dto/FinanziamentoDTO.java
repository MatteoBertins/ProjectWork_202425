package com.example.demo.dto;

public class FinanziamentoDTO {

    private String motivazione;
    private Double importo;
    private Long durata;
    private String tipoTasso;
    private String finalita;
    private Double valoreCasa;
    private Double importoRichiesto;
    private Long etaRichiedente;
    private String includiAssicurazione;

    public FinanziamentoDTO() {
    }

    public FinanziamentoDTO(String finalita, Double valoreCasa, Double importoRichiesto, Long durata, Long etaRichiedente, String tipoTasso, String includiAssicurazione) {
        this.finalita = finalita;
        this.valoreCasa = valoreCasa;
        this.importoRichiesto = importoRichiesto;
        this.durata = durata;
        this.etaRichiedente = etaRichiedente;
        this.tipoTasso = tipoTasso;
        this.includiAssicurazione = includiAssicurazione;
    }

    public FinanziamentoDTO(String motivazione, Double importo, Long durata, String tipoTasso, String includiAssicurazione) {
        this.motivazione = motivazione;
        this.importo = importo;
        this.durata = durata;
        this.tipoTasso = tipoTasso;
        this.includiAssicurazione = includiAssicurazione;
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

    public Long getEtaRichiedente() {
        return etaRichiedente;
    }

    public void setEtaRichiedente(Long etaRichiedente) {
        this.etaRichiedente = etaRichiedente;
    }

    public String getIncludiAssicurazione() {
        return includiAssicurazione;
    }

    public void setIncludiAssicurazione(String includiAssicurazione) {
        this.includiAssicurazione = includiAssicurazione;
    }
}
