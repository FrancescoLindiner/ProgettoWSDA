package com.progetto.progettowsda.Model;

import jakarta.persistence.*;

@Table(name = "Palinsesto")
@Entity
public class Palinsesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_palinsesto")
    private String idPalinsesto;

    @Column(name = "path_palinsesto")
    private String path_palinsesto;

    public String getIdPalinsesto() {
        return idPalinsesto;
    }

    public void setIdPalinsesto(String idPalinsesto) {
        this.idPalinsesto = idPalinsesto;
    }

    public String getPath_palinsesto() {
        return path_palinsesto;
    }

    public void setPath_palinsesto(String path_palinsesto) {
        this.path_palinsesto = path_palinsesto;
    }
}
