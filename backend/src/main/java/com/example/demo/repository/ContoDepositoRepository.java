package com.example.demo.repository;

import com.example.demo.model.Conto;
import com.example.demo.model.ContoDeposito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContoDepositoRepository extends JpaRepository<ContoDeposito,Long> {


}
