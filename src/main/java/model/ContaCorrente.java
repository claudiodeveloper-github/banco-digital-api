package com.claudiocastro.banco.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "conta_corrente")
public class ContaCorrente {

    @Id
    private Integer numero;

    private Integer agencia;
    private String nomeCliente;
    private LocalDate dataNascimento;
    private Double saldo;
    private Boolean ativo;

    public ContaCorrente() {}

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public Integer getAgencia() { return agencia; }
    public void setAgencia(Integer agencia) { this.agencia = agencia; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public Double getSaldo() { return saldo; }
    public void setSaldo(Double saldo) { this.saldo = saldo; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}