package com.example.demo.service;

import com.example.demo.dto.TransazioneDTO;
import com.example.demo.model.Conto;
import com.example.demo.model.Transazione;
import com.example.demo.repository.ContoRepository;
import com.example.demo.repository.TransazioniRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class TransazioneService {

    @Autowired
    private TransazioniRepository transazioniRepository;

    @Autowired
    private ContoRepository contoRepository;

    public Boolean saveTransazione(TransazioneDTO transazioneDTO,Long idUtente){
        Transazione transazione = new Transazione();
        transazione.setData(transazioneDTO.getData());
        transazione.setDescrizione(transazioneDTO.getDescrizione());
        transazione.setIdCategoria(transazioneDTO.getTipologiaTransazione());
        transazione.setImporto(transazioneDTO.getImporto());
        transazione.setIdContoOrigine(contoRepository.getIdContoByUtente(idUtente));
        transazioniRepository.save(transazione);

        return true;
    }

    public Boolean saveSaldo(Double saldo,Long idUtente){
     Long idConto =  contoRepository.getIdContoByUtente(idUtente);
        Conto conto = contoRepository.findById(idConto).get();
        conto.setSaldo(saldo);

        contoRepository.save(conto);

        return true;
    }

    public List<TransazioneDTO> findTransazioni(Long idUtente){
       List<Transazione>  transazioneList= transazioniRepository.findAllByIdUtente(idUtente);
       List<TransazioneDTO> transazioneDTOS = transazioneList.stream().map(t-> new TransazioneDTO(t.getIdContoOrigine(),t.getImporto(),t.getData(),t.getDescrizione(),t.getIdCategoria())).collect(Collectors.toList());
        return transazioneDTOS;
    }

    public List<TransazioneDTO> findTransazioniMeseCorrente(Long idUtente){
        List<Transazione>  transazioneList= transazioniRepository.findAllByIdUtenteMeseCorrente(idUtente);
        List<TransazioneDTO> transazioneDTOS = transazioneList.stream().map(t-> new TransazioneDTO(t.getIdContoOrigine(),t.getImporto(),t.getData(),t.getDescrizione(),t.getIdCategoria())).collect(Collectors.toList());
        return transazioneDTOS;
    }
    public List<TransazioneDTO> findTransazioniMesePrecedente(Long idUtente){
        List<Transazione>  transazioneList= transazioniRepository.findAllByIdUtenteMesePrecedente(idUtente);
        List<TransazioneDTO> transazioneDTOS = transazioneList.stream().map(t-> new TransazioneDTO(t.getIdContoOrigine(),t.getImporto(),t.getData(),t.getDescrizione(),t.getIdCategoria())).collect(Collectors.toList());
        return transazioneDTOS;
    }
}
