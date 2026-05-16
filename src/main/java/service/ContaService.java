package com.claudiocastro.banco.api.service;

import com.claudiocastro.banco.api.model.ContaCorrente;
import com.claudiocastro.banco.api.repository.ContaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    private final ContaRepository repo;

    public ContaService(ContaRepository repo) {
        this.repo = repo;
    }

    public ContaCorrente criar(ContaCorrente c) {
        c.setSaldo(0.0);
        c.setAtivo(true);
        return repo.save(c);
    }

    public ContaCorrente buscar(Integer numero) {
        return repo.findById(numero).orElse(null);
    }

    public ContaCorrente depositar(Integer numero, Double valor) {
        ContaCorrente c = buscar(numero);
        if (c != null && valor > 0) {
            c.setSaldo(c.getSaldo() + valor);
            return repo.save(c);
        }
        return null;
    }
}