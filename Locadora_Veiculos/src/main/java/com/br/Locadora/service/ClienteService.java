package com.br.Locadora.service;

import com.br.Locadora.entity.Cliente;
import com.br.Locadora.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> encontrarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

}
