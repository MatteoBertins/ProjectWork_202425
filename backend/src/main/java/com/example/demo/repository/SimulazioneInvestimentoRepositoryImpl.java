package com.example.demo.repository;

import com.example.demo.dto.AssetDTO;
import com.example.demo.model.SimulazioneInvestimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SimulazioneInvestimentoRepositoryImpl implements SimulazioneInvestimentoCustomRepository {


    private final NamedParameterJdbcTemplate jdbcTemplate;



    public SimulazioneInvestimentoRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AssetDTO> getSimulazioniInvestimenti(Long idUtente) {

        Map<String , Object> param = new HashMap<>();
        param.put("idUtente",idUtente);
        String sql = """
                SELECT
                	sim.NOME AS nome,
                	sim.IMPORTO AS importo,
                	sim.DURATA AS durata,
                	sim.RENDIMENTO_ATTESO AS rendimentoAtteso,
                	tpi.NOME_TIPO AS piano,
                	cri.IMPORTO_FINALE AS importoFinale,
                	sim.ID_CALCOLO AS idCalcolo
                FROM
                	Simulazione_Investimento sim,
                	Calcolo_Rendimento_Investimento cri,
                	TIPO_PIANO_INVESTIMENTO tpi ,
                	SIMULAZIONE s
                WHERE
                	cri.id_calcolo = sim.id_calcolo
                	AND tpi.ID_TIPO = sim.TIPO_PIANO
                	AND s.ID_SIMULAZIONE = sim.ID_SIMULAZIONE
                	AND s.ID_UTENTE =:idUtente """;

        return jdbcTemplate.query(sql, param, (rs, rowNum) ->
                new AssetDTO(
                        rs.getString("nome"),
                        rs.getDouble("importo"),
                        rs.getLong("durata"),
                        rs.getLong("rendimentoAtteso"),
                        rs.getString("piano"),
                        rs.getDouble("importoFinale"),
                        rs.getLong("idCalcolo")
                )
        );
    }
}
