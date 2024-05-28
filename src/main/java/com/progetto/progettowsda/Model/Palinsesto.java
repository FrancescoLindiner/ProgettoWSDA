package com.progetto.progettowsda.Model;

import jakarta.persistence.*;

@Table(name = "palinsesto")
@Entity
public class Palinsesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_impianto")
    private String idImpianto;
    @Column(name = "id_palinsesto")
    private String idPalinsesto;

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
