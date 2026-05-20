package com.claudiocastro.banco.api.controller;

import com.claudiocastro.banco.api.model.ContaCorrente;
import com.claudiocastro.banco.api.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
@CrossOrigin(origins = "*")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public ResponseEntity<List<ContaCorrente>> listarTodas() {
        return ResponseEntity.ok(contaService.listarTodas());
    }

    @GetMapping("/{numero}")
    public ResponseEntity<ContaCorrente> buscarPorNumero(@PathVariable Long numero) {
        return ResponseEntity.ok(contaService.buscarPorNumero(numero));
    }

    @PostMapping
    public ResponseEntity<ContaCorrente> criarConta(@RequestBody ContaCorrente conta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.criarConta(conta));
    }

    @PostMapping("/{numero}/deposito")
    public ResponseEntity<ContaCorrente> depositar(
            @PathVariable Long numero,
            @RequestParam Double valor) {
        return ResponseEntity.ok(contaService.depositar(numero, valor));
    }
}