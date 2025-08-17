package com.example.demo.service;

import com.example.demo.dto.AssetDTO;
import com.example.demo.dto.TransazioneDTO;
import com.example.demo.model.CalcoloRendimentoInvestimento;
import com.example.demo.model.Simulazione;
import com.example.demo.model.SimulazioneInvestimento;
import com.example.demo.model.Transazione;
import com.example.demo.repository.CalcoloInvestimentoRepository;
import com.example.demo.repository.SimulazioneInvestimentoRepository;
import com.example.demo.repository.SimulazioneRepository;
import com.example.demo.repository.TransazioniRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class SimulazioneInvestimentoService {

    @Autowired
    private SimulazioneInvestimentoRepository simulazioneInvestimentoRepository;

    @Autowired
    private CalcoloInvestimentoRepository calcoloInvestimentoRepository;


    @Autowired
    private SimulazioneRepository simulazioneRepository;

    public Boolean saveSimulazioneInvestimento(List<AssetDTO> assetDTO,Long idUtente){

        Simulazione simulazione = new Simulazione();
        simulazione.setDataCreazione(new Date());
        simulazione.setIdTipo(1L);
        simulazione.setIdUtente(idUtente);
       Simulazione simulazioneSaved = simulazioneRepository.save(simulazione);

        CalcoloRendimentoInvestimento calcoloRendimentoInvestimento = new CalcoloRendimentoInvestimento();
        CalcoloRendimentoInvestimento calcoloRendimentoInvestimentoSaved = calcoloInvestimentoRepository.saveAndFlush(calcoloRendimentoInvestimento);
        Double importoFinale = 0d;
        for(int i = 0; i<assetDTO.size();i++){
            SimulazioneInvestimento simulazioneInvestimento = new SimulazioneInvestimento();
            simulazioneInvestimento.setDurata(assetDTO.get(i).getDurata());
            simulazioneInvestimento.setImporto(assetDTO.get(i).getImporto());
            simulazioneInvestimento.setNome(assetDTO.get(i).getNome());
            simulazioneInvestimento.setRendimentoAtteso(assetDTO.get(i).getRendimentoAtteso());
            simulazioneInvestimento.setTipoPiano(assetDTO.get(i).getTipoPiano());
            simulazioneInvestimento.setIdCalcolo(calcoloRendimentoInvestimentoSaved.getIdCalcolo());
            simulazioneInvestimento.setIdSimulazione(simulazioneSaved.getIdSimulazione());
            if(assetDTO.get(i).getTipoPiano() == 1L) {
                double r = (assetDTO.get(i).getRendimentoAtteso() / 100.0) / 12.0;
                int n = Math.toIntExact(assetDTO.get(i).getDurata() * 12);
                importoFinale += assetDTO.get(i).getImporto() * ((Math.pow(1 + r, n) - 1) / r);
            }
            if(assetDTO.get(i).getTipoPiano() == 2L){
                double r = assetDTO.get(i).getRendimentoAtteso() / 100.0;
                importoFinale += assetDTO.get(i).getImporto() * Math.pow(1 + r, assetDTO.get(i).getDurata());
            }
            simulazioneInvestimentoRepository.save(simulazioneInvestimento);
        }
        calcoloRendimentoInvestimentoSaved.setImportoFinale(importoFinale);
        calcoloInvestimentoRepository.save(calcoloRendimentoInvestimentoSaved);
        return true;
    }

    public List<AssetDTO> findSimulazioniInvestimenti(Long idUtente){
       List<AssetDTO>  simulazioneInvestimentoList= simulazioneInvestimentoRepository.getSimulazioniInvestimenti(idUtente);
        return simulazioneInvestimentoList;
    }
}
