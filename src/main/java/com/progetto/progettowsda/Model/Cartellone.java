package com.progetto.progettowsda.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cartellone")
public class Cartellone {
    @Id
    @Column(name = "id_cartellone")
    private String id_cartellone;
    private String nome_cartellone;

    public String getId_cartellone() {
        return id_cartellone;
    }

    public String getNome_cartellone() {
        return nome_cartellone;
    }

    public void setId_cartellone(String id_cartellone) {
        this.id_cartellone = id_cartellone;
    }

    public void setNome_cartellone(String nome_cartellone) {
        this.nome_cartellone = nome_cartellone;
    }
}
