package com.example.demo.repository;

import com.example.demo.model.CalcoloRendimentoInvestimento;
import com.example.demo.model.SimulazioneInvestimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalcoloInvestimentoRepository extends JpaRepository<CalcoloRendimentoInvestimento,Long> {
}
