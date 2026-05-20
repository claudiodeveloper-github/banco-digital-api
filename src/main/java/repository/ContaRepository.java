package com.claudiocastro.banco.api.repository;

import com.claudiocastro.banco.api.model.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<ContaCorrente, Integer> {
    // O Spring Data JPA já fornece: save, findById, findAll, delete...
    // Não precisa escrever nada aqui por enquanto
}