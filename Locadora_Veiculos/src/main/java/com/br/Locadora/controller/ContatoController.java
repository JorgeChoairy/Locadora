package com.br.Locadora.controller;

import com.br.Locadora.entity.Contato;
import com.br.Locadora.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    @Autowired
    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<Contato>> encontrarPorNome(@RequestParam String nome) {
        List<Contato> contatos = contatoService.encontrarPorNome(nome);
        return ResponseEntity.ok(contatos);
    }

    @GetMapping("/por-email")
    public ResponseEntity<List<Contato>> encontrarPorEmail(@RequestParam String email) {
        List<Contato> contatos = contatoService.encontrarPorEmail(email);
        return ResponseEntity.ok(contatos);
    }

    @GetMapping("/por-telefone")
    public ResponseEntity<List<Contato>> encontrarPorTelefone(@RequestParam String telefone) {
        List<Contato> contatos = contatoService.encontrarPorTelefone(telefone);
        return ResponseEntity.ok(contatos);
    }

    // Endpoint para criar um novo Contato (se necessário)
    // @PostMapping

    // Endpoint para atualizar um Contato existente (se necessário)
    // @PutMapping

    // Endpoint para deletar um Contato pelo ID (se necessário)
    // @DeleteMapping("/{id}")
}
