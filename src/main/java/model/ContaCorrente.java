package com.claudiocastro.banco.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contas")
public class ContaCorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;

    private String titular;   // ← mesmo nome que o JS envia: "titular"
    private String tipo;      // ← mesmo nome que o JS envia: "tipo"
    private Double saldo;     // ← mesmo nome que o JS envia: "saldo"

    // Construtor vazio (obrigatório para o Spring deserializar o JSON)
    public ContaCorrente() {}

    // Getters
    public Integer getNumero() { return numero; }
    public String getTitular() { return titular; }
    public String getTipo()    { return tipo; }
    public Double getSaldo()   { return saldo; }

    // Setters
    public void setNumero(Integer numero)   { this.numero = numero; }
    public void setTitular(String titular)  { this.titular = titular; }
    public void setTipo(String tipo)        { this.tipo = tipo; }
    public void setSaldo(Double saldo)      { this.saldo = saldo; }
}