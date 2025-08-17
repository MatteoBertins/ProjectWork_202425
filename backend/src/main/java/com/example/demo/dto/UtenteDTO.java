package com.example.demo.dto;



import java.util.Collection;
import java.util.List;

public class UtenteDTO  {

    private String username;
    private String password;
    private String datiCriptati;

    public String getDatiCriptati() {
        return datiCriptati;
    }

    public void setDatiCriptati(String datiCriptati) {
        this.datiCriptati = datiCriptati;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
