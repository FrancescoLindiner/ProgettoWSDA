package com.progetto.progettowsda.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Palinsesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idImpianto;
    private String idPalinsesto;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Palinsesto> palinsesti;

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
}
