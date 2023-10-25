package com.br.Locadora.controller;

import com.br.Locadora.entity.Funcionario;
import com.br.Locadora.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarTodos() {
        List<Funcionario> funcionarios = funcionarioService.listarTodos();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> encontrarPorId(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.encontrarPorId(id);
        return funcionario.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioCriado = funcionarioService.criarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Endpoint para atualizar um Funcionário existente (se necessário)
    // @PutMapping("/{id}")
}
