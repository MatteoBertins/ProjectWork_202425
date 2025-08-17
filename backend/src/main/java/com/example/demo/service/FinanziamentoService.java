package com.example.demo.service;

import com.example.demo.dto.FinanziamentoCalcolatoDTO;
import com.example.demo.dto.FinanziamentoDTO;
import com.example.demo.dto.TransazioneDTO;
import com.example.demo.model.FinanziamentoMutui;
import com.example.demo.model.FinanziamentoPrestiti;
import com.example.demo.model.Simulazione;
import com.example.demo.model.Transazione;
import com.example.demo.repository.FinanziamentiMutuiRepository;
import com.example.demo.repository.FinanziamentiPrestitiRepository;
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
public class FinanziamentoService {

    @Autowired
    private FinanziamentiMutuiRepository finanziamentiMutuiRepository;

    @Autowired
    private SimulazioneRepository simulazioneRepository;


    @Autowired
    private FinanziamentiPrestitiRepository finanziamentiPrestitiRepository;

    public FinanziamentoCalcolatoDTO saveFinanziamentoMutui(FinanziamentoDTO finanziamentoDTO,Long idUtente){
        Simulazione simulazione = new Simulazione();

        simulazione.setIdUtente(idUtente);
        simulazione.setIdTipo(2L);
        simulazione.setDataCreazione(new Date());
        Simulazione simulazioneSaved = simulazioneRepository.save(simulazione);

        FinanziamentoMutui finanziamentoMutui = new FinanziamentoMutui();
        finanziamentoMutui.setFinalita(finanziamentoDTO.getFinalita());
        finanziamentoMutui.setValoreCasa(finanziamentoDTO.getValoreCasa());
        finanziamentoMutui.setImportoRichiesto(finanziamentoDTO.getImportoRichiesto());
        finanziamentoMutui.setDurata(finanziamentoDTO.getDurata());
        finanziamentoMutui.setEtaRichiedente(finanziamentoDTO.getEtaRichiedente());
        finanziamentoMutui.setTipoTasso(finanziamentoDTO.getTipoTasso());
        finanziamentoMutui.setIncludiAssicurazione(finanziamentoDTO.getIncludiAssicurazione());
        finanziamentoMutui.setIdSimulazione(simulazioneSaved.getIdSimulazione());
        finanziamentoMutui.setIdTipo(1L);
        double tassoAnnuo = 0d;
        if(finanziamentoDTO.getTipoTasso() != null){
            if ("FISSO".equals(finanziamentoDTO.getTipoTasso())) {
                tassoAnnuo = 2.0;
            } else {
                // Tasso variabile random tra 1.5% e 3.5%
                tassoAnnuo = 1.5 + new java.util.Random().nextDouble() * 2.0;
            }

        }

        double importo = finanziamentoDTO.getImportoRichiesto();
        long durataMesi = finanziamentoDTO.getDurata() * 12; // se la durata è in anni
        double tassoMensile = tassoAnnuo / 12 / 100;

        double rataMensile = (importo * tassoMensile) / (1 - Math.pow(1 + tassoMensile, -durataMesi));
        double costoTotale = rataMensile * durataMesi;
        double totInteressi = costoTotale - importo;

        double assicurazione = 0.0;
        if ("S".equalsIgnoreCase(finanziamentoDTO.getIncludiAssicurazione())) {
            assicurazione = importo * 0.01;
            costoTotale += assicurazione; // attenzione, qui sommi un importo totale, non mensile
        }

        FinanziamentoCalcolatoDTO finanziamentoCalcolatoDTO = new FinanziamentoCalcolatoDTO();
        finanziamentoCalcolatoDTO.setRataMensile(Math.round(rataMensile * 100.0) / 100.0);
        finanziamentoCalcolatoDTO.setTotInteressi(Math.round(totInteressi * 100.0) / 100.0);
        finanziamentoCalcolatoDTO.setCostoTotale(Math.round(costoTotale * 100.0) / 100.0);
        finanziamentoMutui.setRataMensile(Math.round(rataMensile * 100.0) / 100.0);
        finanziamentoMutui.setCostoTotale(Math.round(rataMensile * 100.0) / 100.0);
        finanziamentoMutui.setTotInteressi(Math.round(totInteressi * 100.0) / 100.0);
        finanziamentoMutui.setTasso(Math.round(tassoAnnuo * 100.0) / 100.0);

        finanziamentiMutuiRepository.save(finanziamentoMutui);


        return finanziamentoCalcolatoDTO;
    }

    public List<FinanziamentoDTO> findFinanziamentiMutui(Long idUtente){
       List<FinanziamentoMutui>  transazioneList= finanziamentiMutuiRepository.getFinanziamentiMutuiByIdUtente(idUtente);
       List<FinanziamentoDTO> transazioneDTOS = transazioneList.stream().map(t-> new FinanziamentoDTO(t.getFinalita(),t.getValoreCasa(),t.getImportoRichiesto(),t.getDurata(),t.getEtaRichiedente(),t.getTipoTasso(),t.getIncludiAssicurazione())).collect(Collectors.toList());
        return transazioneDTOS;
    }

    public FinanziamentoCalcolatoDTO saveFinanziamentoPrestiti(FinanziamentoDTO finanziamentoDTO,Long idUtente){

        Simulazione simulazione = new Simulazione();

        simulazione.setIdUtente(idUtente);
        simulazione.setIdTipo(2L);
        simulazione.setDataCreazione(new Date());
        Simulazione simulazioneSaved = simulazioneRepository.save(simulazione);


        FinanziamentoPrestiti finanziamentoPrestiti = new FinanziamentoPrestiti();
        finanziamentoPrestiti.setMotivazione(finanziamentoDTO.getMotivazione());
        finanziamentoPrestiti.setImporto(finanziamentoDTO.getImporto());
        finanziamentoPrestiti.setDurata(finanziamentoDTO.getDurata());
        finanziamentoPrestiti.setTipoTasso(finanziamentoDTO.getTipoTasso());
        finanziamentoPrestiti.setIncludiAssicurazione(finanziamentoDTO.getIncludiAssicurazione());
        finanziamentoPrestiti.setIdTipo(2L);

        finanziamentoPrestiti.setIdSimulazione(simulazioneSaved.getIdSimulazione());

        // Calcolo tasso d'interesse
        double tassoAnnuo = 0d;
        if(finanziamentoDTO.getTipoTasso() != null){
            if ("FISSO".equals(finanziamentoDTO.getTipoTasso())) {
                tassoAnnuo = 5.0;
            } else {
                // Tasso variabile random tra 4% e 7%
                tassoAnnuo = 4.0 + new java.util.Random().nextDouble() * 3.0;
            }
        }


        double importo = finanziamentoDTO.getImporto();
        long durataMesi = finanziamentoDTO.getDurata() * 12; // se la durata è in anni
        double tassoMensile = tassoAnnuo / 12 / 100;
        double rataMensile = (importo * tassoMensile) / (1 - Math.pow(1 + tassoMensile, -durataMesi));
        double costoTotale = rataMensile * durataMesi;
        double totInteressi = costoTotale - importo;

        double assicurazione = 0.0;
        if ("S".equalsIgnoreCase(finanziamentoDTO.getIncludiAssicurazione())) {
            assicurazione = importo * 0.01;
            costoTotale += assicurazione; // attenzione, qui sommi un importo totale, non mensile
        }

        FinanziamentoCalcolatoDTO finanziamentoCalcolatoDTO = new FinanziamentoCalcolatoDTO();
        finanziamentoCalcolatoDTO.setRataMensile(Math.round(rataMensile * 100.0) / 100.0);
        finanziamentoCalcolatoDTO.setTotInteressi(Math.round(totInteressi * 100.0) / 100.0);
        finanziamentoCalcolatoDTO.setCostoTotale(Math.round(costoTotale * 100.0) / 100.0);
        finanziamentoPrestiti.setRataMensile(Math.round(rataMensile * 100.0) / 100.0);
        finanziamentoPrestiti.setCostoTotale(Math.round(rataMensile * 100.0) / 100.0);
        finanziamentoPrestiti.setTotInteressi(Math.round(totInteressi * 100.0) / 100.0);
        finanziamentoPrestiti.setTasso(Math.round(tassoAnnuo * 100.0) / 100.0);
        finanziamentiPrestitiRepository.save(finanziamentoPrestiti);

        return finanziamentoCalcolatoDTO;
    }


    public List<FinanziamentoDTO> findFinanziamentiPrestiti(Long idUtente){
        List<FinanziamentoPrestiti>  transazioneList= finanziamentiPrestitiRepository.getFinanziamentiPrestitiByIdUtente(idUtente);
        List<FinanziamentoDTO> transazioneDTOS = transazioneList.stream().map(t-> new FinanziamentoDTO(t.getMotivazione(),t.getImporto(),t.getDurata(),t.getTipoTasso(),t.getIncludiAssicurazione())).collect(Collectors.toList());
        return transazioneDTOS;
    }
}
