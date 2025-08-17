package com.example.demo.controller;

import com.example.demo.dto.AssetDTO;
import com.example.demo.dto.TransazioneDTO;
import com.example.demo.model.SimulazioneInvestimento;
import com.example.demo.service.SimulazioneInvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulazioneInvestimento")
@CrossOrigin(origins = "http://localhost:4200")
public class SimulazioneInvestimentoController {

    @Autowired
    private SimulazioneInvestimentoService simulazioneInvestimentoService;

    @PostMapping(value = "salvaSimulazioneInvestimento/{idUtente}")
    public ResponseEntity<Boolean> salvaSimulazioneInvestimento(@RequestBody List<AssetDTO> assetDTO,@PathVariable Long idUtente){

        try {
            simulazioneInvestimentoService.saveSimulazioneInvestimento(assetDTO,idUtente);
            return ResponseEntity.ok().build();

        }catch (Exception e){
            return ResponseEntity.status(500).build();

        }
    }


    @GetMapping(value = "findSimulazioniInvestimenti/{idUtente}")
    public ResponseEntity<List<AssetDTO>> findSimulazioniInvestimenti(@PathVariable Long idUtente){

        try {

            return ResponseEntity.ok(simulazioneInvestimentoService.findSimulazioniInvestimenti(idUtente));

        }catch (Exception e){
            return ResponseEntity.status(500).build();

        }
    }
}
