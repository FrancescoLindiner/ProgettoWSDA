package com.progetto.progettowsda.Repository;

import com.progetto.progettowsda.Model.Impressione;
import com.progetto.progettowsda.Model.ImpressioneDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ImpressioniRepository extends JpaRepository<Impressione, Integer> {
    @Query("SELECT new com.progetto.progettowsda.Model.ImpressioneDTO(s.idImpianto, s.idPalinsesto, SUM(s.durata)) " +
            "FROM Impressione s " +
            "WHERE s.idImpianto = :idImpianto " +
            "AND s.idPalinsesto = :idPalinsesto " +
            "GROUP BY s.idImpianto, s.idPalinsesto")
    List<ImpressioneDTO> searchIdImpiantoIdPalinsesto(@Param("idImpianto") String idImpianto, @Param("idPalinsesto") String idPalinsesto);
    @Query("SELECT new com.progetto.progettowsda.Model.ImpressioneDTO(s.idImpianto, s.idPalinsesto, s.idCartellone, SUM(s.durata)) " +
            "FROM Impressione s " +
            "WHERE s.idImpianto = :idImpianto " +
            "AND s.idPalinsesto = :idPalinsesto " +
            "AND s.idCartellone = :idCartellone " +
            "GROUP BY s.idImpianto, s.idPalinsesto, s.idCartellone")
    List<ImpressioneDTO> searchIdImpiantoIdPalinsestoIdCartellone(String idImpianto, String idPalinsesto, String idCartellone);
    @Query("SELECT new com.progetto.progettowsda.Model.ImpressioneDTO(s.idImpianto, s.idPalinsesto, SUM(s.durata)) " +
            "FROM Impressione s " +
            "WHERE s.idImpianto = :idImpianto " +
            "AND s.idPalinsesto = :idPalinsesto " +
            "AND s.timestamp >= :timestampFrom AND s.timestamp <= :timestampTo " +
            "GROUP BY s.idImpianto, s.idPalinsesto")
    List<ImpressioneDTO> searchIdImpiantoIdPalinsestoDate(String idImpianto, String idPalinsesto, LocalDateTime timestampFrom, LocalDateTime timestampTo);
    @Query("SELECT new com.progetto.progettowsda.Model.ImpressioneDTO(s.idImpianto, s.idPalinsesto, s.idCartellone, SUM(s.durata)) " +
            "FROM Impressione s " +
            "WHERE s.idImpianto = :idImpianto " +
            "AND s.idPalinsesto = :idPalinsesto " +
            "AND s.idCartellone = :idCartellone " +
            "AND s.timestamp BETWEEN :timestampFrom AND :timestampTo " +
            "GROUP BY s.idImpianto, s.idPalinsesto, s.idCartellone")
    List<ImpressioneDTO> searchAll(String idImpianto, String idPalinsesto, String idCartellone, LocalDateTime timestampFrom, LocalDateTime timestampTo);
    @Query("SELECT new com.progetto.progettowsda.Model.ImpressioneDTO(s.idImpianto, s.idPalinsesto, s.idCartellone, SUM(s.durata)) " +
            "FROM Impressione s " +
            "WHERE s.idImpianto = :idImpianto " +
            "AND s.idPalinsesto = :idPalinsesto " +
            "AND s.idCartellone = :idCartellone " +
            "AND s.timestamp >= :timestampFrom " +
            "GROUP BY s.idImpianto, s.idPalinsesto, s.idCartellone")
    List<ImpressioneDTO> searchIdImpiantoIdPalinsestoIdCartelloneDateFrom(String idImpianto, String idPalinsesto, String idCartellone, LocalDateTime timestampFrom);
    @Query("SELECT new com.progetto.progettowsda.Model.ImpressioneDTO(s.idImpianto, s.idPalinsesto, s.idCartellone, SUM(s.durata)) " +
            "FROM Impressione s " +
            "WHERE s.idImpianto = :idImpianto " +
            "AND s.idPalinsesto = :idPalinsesto " +
            "AND s.idCartellone = :idCartellone " +
            "AND s.timestamp <= :timestampTo " +
            "GROUP BY s.idImpianto, s.idPalinsesto, s.idCartellone")
    List<ImpressioneDTO> searchIdImpiantoIdPalinsestoIdCartelloneDateTo(String idImpianto, String idPalinsesto, String idCartellone, LocalDateTime timestampTo);
    @Query("SELECT new com.progetto.progettowsda.Model.ImpressioneDTO(s.idImpianto, s.idPalinsesto, SUM(s.durata)) " +
            "FROM Impressione s " +
            "WHERE s.idImpianto = :idImpianto " +
            "AND s.idPalinsesto = :idPalinsesto " +
            "AND s.timestamp <= :timestampTo " +
            "GROUP BY s.idImpianto, s.idPalinsesto")
    List<ImpressioneDTO> searchIdImpiantoIdPalinsestoDateTo(String idImpianto, String idPalinsesto, LocalDateTime timestampTo);
    @Query("SELECT new com.progetto.progettowsda.Model.ImpressioneDTO(s.idImpianto, s.idPalinsesto, SUM(s.durata)) " +
            "FROM Impressione s " +
            "WHERE s.idImpianto = :idImpianto " +
            "AND s.idPalinsesto = :idPalinsesto " +
            "AND s.timestamp >= :timestampFrom " +
            "GROUP BY s.idImpianto, s.idPalinsesto")
    List<ImpressioneDTO> searchIdImpiantoIdPalinsestoDateFrom(String idImpianto, String idPalinsesto, LocalDateTime timestampFrom);

    @Query("SELECT new com.progetto.progettowsda.Model.ImpressioneDTO(s.idImpianto, SUM(s.durata)) " +
            "FROM Impressione s " +
            "GROUP BY s.idImpianto " +
            "ORDER BY SUM(s.durata) DESC " +
            "LIMIT 1")
    List<ImpressioneDTO> getImpiantoAttivo();
    @Query("SELECT new com.progetto.progettowsda.Model.ImpressioneDTO(s.idPalinsesto, SUM(s.durata)) " +
            "FROM Impressione s " +
            "GROUP BY s.idPalinsesto " +
            "ORDER BY SUM(s.durata) DESC " +
            "LIMIT 1")
    List<ImpressioneDTO> getPalinsestoAttivo();

    @Query("SELECT new com.progetto.progettowsda.Model.ImpressioneDTO(s.idImpianto, s.idCartellone, SUM(s.durata)) " +
            "FROM Impressione s " +
            "GROUP BY s.idImpianto, s.idCartellone " +
            "ORDER BY SUM(s.durata) DESC " +
            "LIMIT 1")
    List<ImpressioneDTO> getCartelloneAttivo();
}