package com.example.demo.repository;

import com.example.demo.model.SimulazioneContoDeposito;
import com.example.demo.model.SimulazioneInvestimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulazioneContoDepositoRepository extends JpaRepository<SimulazioneContoDeposito,Long> {
}
