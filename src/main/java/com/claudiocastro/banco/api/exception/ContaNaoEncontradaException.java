package com.claudiocastro.banco.api.exception;

public class ContaNaoEncontradaException extends RuntimeException {

    public ContaNaoEncontradaException(Long numero) {
        super("Conta de número " + numero + " não foi encontrada.");
    }
}