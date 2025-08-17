package com.example.demo.controller;

import com.example.demo.dto.FinanziamentoCalcolatoDTO;
import com.example.demo.dto.FinanziamentoDTO;
import com.example.demo.dto.TransazioneDTO;
import com.example.demo.service.FinanziamentoService;
import com.example.demo.service.TransazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finanziamenti")
@CrossOrigin(origins = "http://localhost:4200")
public class FinanziamentoController {

    @Autowired
    private FinanziamentoService finanziamentoService;

    @PostMapping(value = "salvaFinanaziamentoMutui/{idUtente}")
    public ResponseEntity<FinanziamentoCalcolatoDTO> salvaFinanaziamento(@RequestBody FinanziamentoDTO finanziamentoDTO,@PathVariable Long idUtente){
        try {

            return ResponseEntity.ok(finanziamentoService.saveFinanziamentoMutui(finanziamentoDTO,idUtente));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }
    @PostMapping(value = "salvaFinanaziamentoPrestiti/{idUtente}")
    public ResponseEntity<FinanziamentoCalcolatoDTO> salvaFinanaziamentoPrestiti(@RequestBody FinanziamentoDTO finanziamentoDTO,@PathVariable Long idUtente){
        try {
            return ResponseEntity.ok(finanziamentoService.saveFinanziamentoPrestiti(finanziamentoDTO,idUtente));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping(value = "findFinanziamentiPrestiti/{idUtente}")
    public ResponseEntity<List<FinanziamentoDTO>> findFinanziamentiPrestiti(@PathVariable Long idUtente){

        try {
            return ResponseEntity.ok(finanziamentoService.findFinanziamentiPrestiti(idUtente));
        }catch (Exception e){
            return ResponseEntity.status(500).build();

        }
    }


    @GetMapping(value = "findFinanziamentiMutui/{idUtente}")
    public ResponseEntity<List<FinanziamentoDTO>> findFinanziamentiMutui(@PathVariable Long idUtente){

        try {
            return ResponseEntity.ok(finanziamentoService.findFinanziamentiMutui(idUtente));
        }catch (Exception e){
            return ResponseEntity.status(500).build();

        }
    }
}
