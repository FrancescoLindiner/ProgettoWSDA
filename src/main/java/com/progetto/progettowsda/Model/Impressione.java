package com.progetto.progettowsda.Model;

import jakarta.persistence.*;

@Table(name = "Segnalazioni")
@Entity
public class Impressione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPalinsesto")
    private String idPalinsesto;
    @Column(name = "idImpianto")
    private String idImpianto;
    @Column(name = "idCartellone")
    private String idCartellone;
    private Long durata;

    public String getIdPalinsesto() {
        return idPalinsesto;
    }

    public void setIdPalinsesto(String idPalinsesto) {
        this.idPalinsesto = idPalinsesto;
    }

    public String getIdImpianto() {
        return idImpianto;
    }

    public void setIdImpianto(String idImpianto) {
        this.idImpianto = idImpianto;
    }

    public Long getDurata() {
        return durata;
    }

    public void setDurata(Long durata) {
        this.durata = durata;
    }

    public String getIdCartellone() {
        return idCartellone;
    }
}
