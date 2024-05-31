package com.progetto.progettowsda.Model;

public class ImpressioneDTO {
    private String idImpianto;
    private String idPalinsesto;
    private String idCartellone;
    private Long durataTotale;
    private String query;

    public ImpressioneDTO(String idImpianto, String idPalinsesto, Long durataTotale) {
        this.idImpianto = idImpianto;
        this.idPalinsesto = idPalinsesto;
        this.durataTotale = durataTotale;
    }

    public ImpressioneDTO(String idImpianto, Long durataTotale) {
        this.idImpianto = idImpianto;
        this.durataTotale = durataTotale;
    }

    public ImpressioneDTO(String idImpianto, String idPalinsesto, String idCartellone, Long durataTotale) {
        this.idImpianto = idImpianto;
        this.idPalinsesto = idPalinsesto;
        this.idCartellone = idCartellone;
        this.durataTotale = durataTotale;
    }

    // Getters e Setters
    public String getIdImpianto() {
        return idImpianto;
    }

    public void setIdImpianto(String idImpianto) {
        this.idImpianto = idImpianto;
    }

    public String getIdPalinsesto() {
        return idPalinsesto;
    }

    public void setIdPalinsesto(String idPalinsesto) {
        this.idPalinsesto = idPalinsesto;
    }

    public Long getDurataTotale() {
        return durataTotale;
    }

    public void setDurataTotale(Long durataTotale) {
        this.durataTotale = durataTotale;
    }

    public String getIdCartellone() {
        return idCartellone;
    }

    public void setIdCartellone(String idCartellone) {
        this.idCartellone = idCartellone;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
