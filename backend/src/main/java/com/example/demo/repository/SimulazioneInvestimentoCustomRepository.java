package com.example.demo.repository;

import com.example.demo.dto.AssetDTO;
import com.example.demo.model.SimulazioneInvestimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimulazioneInvestimentoCustomRepository {

   List<AssetDTO> getSimulazioniInvestimenti(Long idUtente);
}
