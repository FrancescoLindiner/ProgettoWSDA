package com.progetto.progettowsda.Repository;

import com.progetto.progettowsda.Model.Impressione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ImpressioniRepository extends JpaRepository<Impressione, Integer> {
    @Query("SELECT s.idImpianto, s.idCartellone, s.idPalinsesto, SUM(s.durata) AS durata_totale " +
            "FROM Impressione s " +
            "WHERE (s.idImpianto = :idImpianto) " +
            "AND  (s.idPalinsesto = :idPalinsesto) " +
            "AND  (s.idCartellone = :idCartellone) " +
            "AND (s.durata = :durata) " +
            "AND (s.timestamp >= :timestampFrom) " +
            "GROUP BY s.idImpianto, s.idCartellone, s.idPalinsesto")
    List<Object[]> searchImpressions(
            @Param("idImpianto") String idImpianto,
            @Param("idPalinsesto") String idPalinsesto,
            @Param("idCartellone") String idCartellone,
            @Param("durata") Long durata,
            @Param("timestampFrom") LocalDateTime timestampFrom
    );
}
