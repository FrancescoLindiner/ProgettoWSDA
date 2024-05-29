package com.progetto.progettowsda.Repository;

import com.progetto.progettowsda.Model.Impressione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImpressioniRepository extends JpaRepository<Impressione, String> {

    @Query("SELECT s.idImpianto, s.idCartellone, SUM(s.durata) AS durata_totale " +
            "FROM Impressione s " +
            "GROUP BY s.idImpianto, s.idCartellone, s.durata")
    List<Object []> getDurataTotalePerImpiantoPalinsestoCartellone();
}