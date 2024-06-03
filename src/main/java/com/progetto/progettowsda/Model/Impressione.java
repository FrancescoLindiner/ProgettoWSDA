package com.progetto.progettowsda.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Table(name = "Segnalazioni")
@Entity
public class Impressione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSegnalazione")
    private Integer idSegnalazione;

    @Column(name = "idImpianto")
    private String idImpianto;

    @Column(name = "idPalinsesto")
    private String idPalinsesto;

    @Column(name = "idCartellone")
    private String idCartellone;

    @Column(name = "durata")
    private Long durata;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public Integer getIdSegnalazione() {
        return idSegnalazione;
    }

    public void setIdSegnalazione(Integer idSegnalazione) {
        this.idSegnalazione = idSegnalazione;
    }

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

    public String getIdCartellone() {
        return idCartellone;
    }

    public void setIdCartellone(String idCartellone) {
        this.idCartellone = idCartellone;
    }

    public Long getDurata() {
        return durata;
    }

    public void setDurata(Long durata) {
        this.durata = durata;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Impressione{" +
                "idSegnalazione=" + idSegnalazione +
                ", idImpianto='" + idImpianto + '\'' +
                ", idPalinsesto='" + idPalinsesto + '\'' +
                ", idCartellone='" + idCartellone + '\'' +
                ", durata=" + durata +
                ", timestamp=" + timestamp +
                '}';
    }
}
