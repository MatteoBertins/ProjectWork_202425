package com.example.demo.controller;

import com.example.demo.dto.UtenteDTO;
import com.example.demo.service.UtenteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AutorizzazioneController {

    @Autowired
    private UtenteService utenteService;
    private static final String secretKey = "1234567890123456"; // stessa chiave 16 char


    @PostMapping(value = "/login")
    public ResponseEntity<Long> login(@RequestBody UtenteDTO utenteDTO){
        try {

            String datiCriptati = utenteDTO.getDatiCriptati();

            byte[] decodeBytes = Base64.getDecoder().decode(datiCriptati);
            byte[] keyBytes = secretKey.getBytes("UTF-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes,0,16,"AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
            byte[] byteOriginale = cipher.doFinal(decodeBytes);
            String datiDecriptati = new String(byteOriginale);
            ObjectMapper mapper = new ObjectMapper();
            UtenteDTO utenteDTOVero = mapper.readValue(datiDecriptati, UtenteDTO.class);

            return ResponseEntity.ok(utenteService.loadUserByUsername(utenteDTOVero.getUsername(), utenteDTOVero.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Boolean> register(@RequestBody UtenteDTO utenteDTO){
        try {

            String datiCriptati = utenteDTO.getDatiCriptati();

            byte[] decodeBytes = Base64.getDecoder().decode(datiCriptati);
            byte[] keyBytes = secretKey.getBytes("UTF-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes,0,16,"AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
            byte[] byteOriginale = cipher.doFinal(decodeBytes);
            String datiDecriptati = new String(byteOriginale);
            ObjectMapper mapper = new ObjectMapper();
            UtenteDTO utenteDTOVero = mapper.readValue(datiDecriptati, UtenteDTO.class);

            return ResponseEntity.ok(utenteService.registerUtente(utenteDTOVero.getUsername(), utenteDTOVero.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
