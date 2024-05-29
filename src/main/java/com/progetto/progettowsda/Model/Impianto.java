package com.progetto.progettowsda.Model;

import jakarta.persistence.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private String palinsesto_path;

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

    public void setPalinsesto_path(String palinsesto_path) {
        // Estrai il numero dalla stringa palinsesto_path
        String numero = palinsesto_path.substring(1); // Prendi tutto tranne il primo carattere "P"

        // Costruisci il percorso XML con il numero estratto
        String percorso_xml = "../../file_xml/palinsesto" + numero + ".xml";

        // Imposta il percorso XML
        this.palinsesto_path = percorso_xml;
    }


    public String getPalinsesto_path() {
        // Per estrarre l'id del palinsesto
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(palinsesto_path);

        if (matcher.find()) {
            String numero = matcher.group();
            String risultato = "P" + numero;

            System.out.println(risultato);
            return risultato;
        } else {
            throw new IllegalStateException("No match found for palinsesto_path");
        }
    }

}
