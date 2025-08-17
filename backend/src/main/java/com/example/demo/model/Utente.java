package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Utente")
public class Utente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utente")
    private Long idUtente;

    @Column(name = "nome")
    private String userName;

    @Column(name = "password")
    private String password;

    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNome() {
        return userName;
    }

    public void setNome(String nome) {
        this.userName = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
