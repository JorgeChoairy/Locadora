package com.br.Locadora.controller;

import com.br.Locadora.entity.Aluguel;
import com.br.Locadora.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelService aluguelService;

    @Autowired
    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping
    public ResponseEntity<List<Aluguel>> listarTodos() {
        List<Aluguel> alugueis = aluguelService.listarTodos();
        return ResponseEntity.ok(alugueis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> encontrarPorId(@PathVariable Long id) {
        Optional<Aluguel> aluguel = aluguelService.encontrarPorId(id);
        return aluguel.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Aluguel> criarAluguel(@RequestBody Aluguel aluguel) {
        Aluguel aluguelCriado = aluguelService.criarAluguel(aluguel);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluguelCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluguel(@PathVariable Long id) {
        aluguelService.deletarAluguel(id);
        return ResponseEntity.noContent().build();
    }
}