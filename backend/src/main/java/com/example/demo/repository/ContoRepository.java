package com.example.demo.repository;

import com.example.demo.model.Conto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContoRepository extends JpaRepository<Conto,Long> {

    @Query(value = """
            SELECT c.ID_CONTO FROM CONTO c ,UTENTE u WHERE u.ID_UTENTE  = c.ID_UTENTE AND u.ID_UTENTE =:idUtente
            """,nativeQuery = true)
    Long getIdContoByUtente(Long idUtente);
}
