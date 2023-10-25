package com.br.Locadora.controller;

import com.br.Locadora.entity.Pagamento;
import com.br.Locadora.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @Autowired
    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Pagamento>> encontrarPorStatus(@PathVariable Boolean status) {
        List<Pagamento> pagamentos = pagamentoService.encontrarPorStatus(status);
        return ResponseEntity.ok(pagamentos);
    }

    // Endpoint para criar um novo pagamento, se necessário
    // @PostMapping

    // Endpoint para encontrar um pagamento por ID, se necessário
    // @GetMapping("/{id}")

    // Endpoint para atualizar um pagamento existente, se necessário
    // @PutMapping("/{id}")

    // Endpoint para deletar um pagamento por ID, se necessário
    // @DeleteMapping("/{id}")
}
