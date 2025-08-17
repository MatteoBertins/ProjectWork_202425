package com.example.demo.repository;

import com.example.demo.model.FinanziamentoMutui;
import com.example.demo.model.FinanziamentoPrestiti;
import com.example.demo.model.Transazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinanziamentiMutuiRepository extends JpaRepository<FinanziamentoMutui,Long> {

    @Query(value = """
            SELECT * FROM simulazione_finanziamento_mutui sfp, SIMULAZIONE s WHERE s.ID_SIMULAZIONE = sfp.ID_SIMULAZIONE AND s.ID_UTENTE =:idUtente
            """,nativeQuery = true)
    List<FinanziamentoMutui> getFinanziamentiMutuiByIdUtente(Long idUtente);

}
