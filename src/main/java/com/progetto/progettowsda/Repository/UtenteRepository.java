package com.progetto.progettowsda.Repository;

import com.progetto.progettowsda.Model.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UtenteRepository extends CrudRepository<Utente, Long> {
    @Query("SELECT u FROM Utente u WHERE u.username = :username")
    Utente getUserByUsername(@Param("username") String username);
}
