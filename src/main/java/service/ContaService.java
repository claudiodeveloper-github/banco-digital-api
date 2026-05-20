package com.claudiocastro.banco.api.service;

import com.claudiocastro.banco.api.exception.ContaNaoEncontradaException;
import com.claudiocastro.banco.api.model.ContaCorrente;
import com.claudiocastro.banco.api.repository.ContaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<ContaCorrente> listarTodas() {
        return contaRepository.findAll();
    }

    public ContaCorrente buscarPorNumero(Long numero) {
        return contaRepository.findById(numero)
                .orElseThrow(() -> new ContaNaoEncontradaException(numero));
    }

    @Transactional
    public ContaCorrente criarConta(ContaCorrente conta) {
        return contaRepository.save(conta);
    }

    @Transactional
    public ContaCorrente depositar(Long numero, Double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        ContaCorrente conta = buscarPorNumero(numero);
        conta.setSaldo(conta.getSaldo() + valor);
        return contaRepository.save(conta);
    }
}