package com.example.demo.repository;

import com.example.demo.model.SimulazioneInvestimento;
import com.example.demo.model.Transazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulazioneInvestimentoRepository extends JpaRepository<SimulazioneInvestimento,Long>, SimulazioneInvestimentoCustomRepository {
}
