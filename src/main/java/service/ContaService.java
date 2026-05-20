package com.claudiocastro.banco.api.service;

import com.claudiocastro.banco.api.model.ContaCorrente;
import com.claudiocastro.banco.api.repository.ContaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    private final ContaRepository repository;

    public ContaService(ContaRepository repository) {
        this.repository = repository;
    }

    public ContaCorrente criar(ContaCorrente conta) {
        return repository.save(conta);
    }

    public ContaCorrente buscar(Integer numero) {
        return repository.findById(numero)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada: " + numero));
    }

    public ContaCorrente depositar(Integer numero, Double valor) {
        ContaCorrente conta = buscar(numero);
        conta.setSaldo(conta.getSaldo() + valor);
        return repository.save(conta);
    }
}