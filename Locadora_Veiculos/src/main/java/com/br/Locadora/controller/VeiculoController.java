package com.br.Locadora.controller;

import com.br.Locadora.entity.Veiculo;
import com.br.Locadora.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarTodos() {
        List<Veiculo> veiculos = veiculoService.listarTodos();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> encontrarPorId(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoService.encontrarPorId(id);
        return veiculo.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Veiculo> criarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoService.criarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        Optional<Veiculo> veiculoExistente = veiculoService.encontrarPorId(id);
        if (veiculoExistente.isPresent()) {
            veiculo.setId(id);
            Veiculo veiculoAtualizado = veiculoService.criarVeiculo(veiculo);
            return ResponseEntity.ok(veiculoAtualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        Optional<Veiculo> veiculoExistente = veiculoService.encontrarPorId(id);
        if (veiculoExistente.isPresent()) {
            veiculoService.deletarVeiculo(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
