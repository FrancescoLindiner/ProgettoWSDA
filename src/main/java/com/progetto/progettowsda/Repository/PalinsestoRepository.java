package com.progetto.progettowsda.Repository;

import com.progetto.progettowsda.Model.Palinsesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalinsestoRepository extends JpaRepository<Palinsesto, Long> {
    Palinsesto findByIdImpianto(String idImpianto);
}