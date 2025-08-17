package com.example.demo.service;

import com.example.demo.dto.UtenteDTO;
import com.example.demo.model.Conto;
import com.example.demo.model.Utente;
import com.example.demo.repository.ContoRepository;
import com.example.demo.repository.UtenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService  {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private ContoRepository contoRepository;
    public Long loadUserByUsername(String username,String password){
        Utente utente = utenteRepository.findByUserNameAndPassword(username,password);
        if(utente != null){
            return utente.getIdUtente();
        }else{
            return null;
        }

    }

    public Boolean registerUtente(String username,String password){
        Utente utente = new Utente();
        utente.setNome(username);
        utente.setPassword(password);
     Utente utenteSaved =  utenteRepository.save(utente);
     Conto conto = new Conto();
     conto.setIdUtente(utenteSaved.getIdUtente());
     conto.setSaldo(0d);
     contoRepository.save(conto);
       return true;
    }



}
