package com.example.demo.repository;

import com.example.demo.model.Transazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransazioniRepository extends JpaRepository<Transazione,Long> {


    @Query(value = """
SELECT * FROM TRANSAZIONE t , CONTO c , UTENTE u WHERE u.ID_UTENTE = c.ID_UTENTE AND t.ID_CONTO_ORIGINE =c.ID_CONTO AND c.ID_UTENTE  =:idUtente order by  t.data desc
            """,nativeQuery = true)
    List<Transazione> findAllByIdUtente(Long idUtente);


    @Query(value = """
            SELECT * FROM TRANSAZIONE t , CONTO c , UTENTE u WHERE u.ID_UTENTE = c.ID_UTENTE AND t.ID_CONTO_ORIGINE =c.ID_CONTO AND c.ID_UTENTE  =:idUtente AND
                                                 t.data >= TRUNC(SYSDATE, 'MM') AND t.data < TRUNC(ADD_MONTHS(SYSDATE, 1), 'MM') 
                                              order by  t.data asc
            """,nativeQuery = true)
    List<Transazione> findAllByIdUtenteMeseCorrente(Long idUtente);

    @Query(value = """
            
            SELECT * FROM TRANSAZIONE t , CONTO c , UTENTE u WHERE u.ID_UTENTE = c.ID_UTENTE AND t.ID_CONTO_ORIGINE =c.ID_CONTO AND c.ID_UTENTE  =:idUtente AND
                t.data >= TRUNC(ADD_MONTHS(SYSDATE, -1), 'MM') AND t.data < TRUNC(SYSDATE, 'MM')
            order by  t.data asc   """,nativeQuery = true)
    List<Transazione> findAllByIdUtenteMesePrecedente(Long idUtente);
}
