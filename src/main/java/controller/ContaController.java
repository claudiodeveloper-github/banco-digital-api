package com.claudiocastro.banco.api.controller;

import com.claudiocastro.banco.api.model.ContaCorrente;
import com.claudiocastro.banco.api.service.ContaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
@CrossOrigin(origins = "*")   // ← ADICIONE ESTA LINHA
public class ContaController {

    private final ContaService service;

    public ContaController(ContaService service) {
        this.service = service;
    }

    @PostMapping
    public ContaCorrente criar(@RequestBody ContaCorrente conta) {
        return service.criar(conta);
    }

    @GetMapping("/{numero}")
    public ContaCorrente buscar(@PathVariable Integer numero) {
        return service.buscar(numero);
    }

    @PostMapping("/{numero}/deposito")
    public ContaCorrente depositar(@PathVariable Integer numero,
                                   @RequestParam Double valor) {
        return service.depositar(numero, valor);
    }
}