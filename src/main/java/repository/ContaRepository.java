package com.claudiocastro.banco.api.repository;

import com.claudiocastro.banco.api.model.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<ContaCorrente, Long> {

}