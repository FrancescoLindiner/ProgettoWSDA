package com.progetto.progettowsda.Repository;

import com.progetto.progettowsda.Model.Cartellone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartelloneRepository extends JpaRepository<Cartellone, Long> {
}
