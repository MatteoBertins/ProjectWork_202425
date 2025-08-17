package com.example.demo.service;

import com.example.demo.dto.ContoDepositoCalcolatoDTO;
import com.example.demo.dto.ContoDepositoVincolatoDTO;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;

@Service
public class ContoDepositoService {

    @Autowired
    private TransazioniRepository transazioniRepository;

    @Autowired
    private ContoRepository contoRepository;

    @Autowired
    private SimulazioneRepository simulazioneRepository;
    @Autowired
    private ContoDepositoRepository contoDepositoRepository;


    @Autowired
    private SimulazioneContoDepositoRepository simulazioneContoDepositoRepository;

    public void vincolaSoldi(ContoDepositoVincolatoDTO contoDepositoVincolatoDTO,Long iduente){

        Long conto = contoRepository.getIdContoByUtente(iduente);
        Transazione transazione = new Transazione();
        transazione.setIdContoOrigine(conto);
        transazione.setImporto(BigDecimal.valueOf(contoDepositoVincolatoDTO.getImportoVincolato()));
        transazione.setData(new Date());
        transazione.setIdCategoria(2L);
        transazione.setDescrizione("Conto Deposito");
        transazioniRepository.save(transazione);
        ContoDeposito vincolatoDTO = new ContoDeposito();
        vincolatoDTO.setImportoVincolato(contoDepositoVincolatoDTO.getImportoVincolato());
        vincolatoDTO.setDataInizio(new Date());
        vincolatoDTO.setDataFine(Date.from(vincolatoDTO.getDataInizio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusMonths(contoDepositoVincolatoDTO.getMesi()).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        contoDepositoRepository.save(vincolatoDTO);
    }


    public ContoDepositoCalcolatoDTO simulaContoDeposito(ContoDepositoCalcolatoDTO contoDepositoCalcolatoDTO,Long idUtente){

        Simulazione simulazione = new Simulazione();
        simulazione.setIdTipo(3L);
        simulazione.setIdUtente(idUtente);
        simulazione.setDataCreazione(new Date());
        Simulazione simulazioneSaved = simulazioneRepository.save(simulazione);

        SimulazioneContoDeposito simulazioneContoDeposito = new SimulazioneContoDeposito();
        simulazioneContoDeposito.setIdSimulazione(simulazioneSaved.getIdSimulazione());
        simulazioneContoDeposito.setImporto(contoDepositoCalcolatoDTO.getImportoDaVincolare());
        simulazioneContoDeposito.setDurata(contoDepositoCalcolatoDTO.getDurata());
        simulazioneContoDeposito.setTasso(contoDepositoCalcolatoDTO.getTasso());
        simulazioneContoDepositoRepository.save(simulazioneContoDeposito);



        double durataAnni = contoDepositoCalcolatoDTO.getDurata() / 12.0;

        double interessi = (contoDepositoCalcolatoDTO.getImportoDaVincolare() * contoDepositoCalcolatoDTO.getTasso() * durataAnni) / 100.0;

        double totale = contoDepositoCalcolatoDTO.getImportoDaVincolare() + interessi;

        contoDepositoCalcolatoDTO.setInteressiMaturati(interessi);
        contoDepositoCalcolatoDTO.setTotaleScadenza(totale);
        return contoDepositoCalcolatoDTO;
    }
}
