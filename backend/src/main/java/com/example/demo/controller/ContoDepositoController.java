package com.example.demo.controller;

import com.example.demo.dto.AssetDTO;
import com.example.demo.dto.ContoDepositoCalcolatoDTO;
import com.example.demo.dto.ContoDepositoVincolatoDTO;
import com.example.demo.service.ContoDepositoService;
import com.example.demo.service.SimulazioneInvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contoDeposito")
@CrossOrigin(origins = "http://localhost:4200")
public class ContoDepositoController {

    @Autowired
    private ContoDepositoService contoDepositoService;

    @PostMapping(value = "vincolaSoldi/{idUtente}")
    public ResponseEntity<ContoDepositoCalcolatoDTO> vincolaSoldi(@RequestBody ContoDepositoVincolatoDTO contoDepositoVincolatoDTO, @PathVariable Long idUtente){

        try {
            contoDepositoService.vincolaSoldi(contoDepositoVincolatoDTO,idUtente);
            return ResponseEntity.ok().build();

        }catch (Exception e){
            return ResponseEntity.status(500).build();

        }
    }
    @PostMapping(value = "simulaContoDeposito/{idUtente}")
    public ResponseEntity<ContoDepositoCalcolatoDTO> simulaContoDeposito(@RequestBody ContoDepositoCalcolatoDTO contoDepositoVincolatoDTO, @PathVariable Long idUtente){

        try {
            return ResponseEntity.ok(contoDepositoService.simulaContoDeposito(contoDepositoVincolatoDTO,idUtente));

        }catch (Exception e){
            return ResponseEntity.status(500).build();

        }
    }


}
