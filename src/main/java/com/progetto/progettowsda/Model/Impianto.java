package com.progetto.progettowsda.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Impianti")
public class Impianto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idImpianto")
    private String idImpianto;
    private String descrizione;
    private float latitudine;
    private float longitudine;
    private boolean stato;

    public String getIdImpianto() {
        return idImpianto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public float getLatitudine() {
        return latitudine;
    }

    public float getLongitudine() {
        return longitudine;
    }

    public boolean isStato() {
        return stato;
    }

    public void setIdImpianto(String idImpianto) {
        this.idImpianto = idImpianto;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setLatitudine(float latidudine) {
        this.latitudine = latidudine;
    }

    public void setLongitudine(float longidudine) {
        this.longitudine = longidudine;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }
}
