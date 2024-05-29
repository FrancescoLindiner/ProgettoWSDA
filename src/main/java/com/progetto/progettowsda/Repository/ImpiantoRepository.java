package com.progetto.progettowsda.Repository;

import com.progetto.progettowsda.Model.Impianto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImpiantoRepository extends JpaRepository<Impianto, Long> {
    Optional<Impianto> findByIdImpianto(String idImpianto);
    // No need to define findAll, JpaRepository provides it
}
