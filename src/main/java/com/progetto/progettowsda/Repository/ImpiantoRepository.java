package com.progetto.progettowsda.Repository;

import com.progetto.progettowsda.Model.Impianto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpiantoRepository extends JpaRepository<Impianto, Long> {
    Impianto findByIdImpianto(String idImpianto);
    Boolean existsByIdImpianto(String idImpianto);
}
