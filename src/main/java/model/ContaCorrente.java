package com.claudiocastro.banco.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contas")
public class ContaCorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;

    @NotBlank(message = "O nome do titular não pode ser nulo ou em branco.")
    private String titular;

    @NotBlank(message = "O tipo da conta deve ser informado.")
    private String tipo;

    @PositiveOrZero(message = "O saldo inicial deve ser maior ou igual a zero.")
    private Double saldo;
}