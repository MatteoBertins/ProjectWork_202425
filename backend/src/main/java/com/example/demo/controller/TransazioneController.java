package com.example.demo.controller;

import com.example.demo.dto.TransazioneDTO;
import com.example.demo.service.TransazioneService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transazioni")
@CrossOrigin(origins = "http://localhost:4200")
public class TransazioneController {

    @Autowired
    private TransazioneService transazioneService;

    @PostMapping(value = "salvaTransazione/{idUtente}")
    public ResponseEntity<Boolean> saveTransazione(@RequestBody TransazioneDTO transazioneDTO ,@PathVariable Long idUtente){
        try {
            transazioneService.saveTransazione(transazioneDTO,idUtente);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }


    @PostMapping(value = "saveSaldo/{idUtente}")
    public ResponseEntity<Boolean> saveSaldo(@RequestBody Double saldo ,@PathVariable Long idUtente){
        try {
            transazioneService.saveSaldo(saldo,idUtente);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }



    @GetMapping(value = "findTransazioni/{idUtente}")
    public ResponseEntity<List<TransazioneDTO>> findTransazioni(@PathVariable Long idUtente){

        try {
            return ResponseEntity.ok(transazioneService.findTransazioni(idUtente));
        }catch (Exception e){
            return ResponseEntity.status(500).build();

        }
    }

    @GetMapping(value = "findTransazioniMesePrecedente/{idUtente}")
    public ResponseEntity<List<TransazioneDTO>> findTransazioniMesePrecedente(@PathVariable Long idUtente){

        try {
            return ResponseEntity.ok(transazioneService.findTransazioniMesePrecedente(idUtente));
        }catch (Exception e){
            return ResponseEntity.status(500).build();

        }
    }


    @GetMapping(value = "findTransazioniMeseCorrente/{idUtente}")
    public ResponseEntity<List<TransazioneDTO>> findTransazioniMeseCorrente(@PathVariable Long idUtente){

        try {
            return ResponseEntity.ok(transazioneService.findTransazioniMeseCorrente(idUtente));
        }catch (Exception e){
            return ResponseEntity.status(500).build();

        }
    }
}
