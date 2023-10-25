package com.br.Locadora.service;

import com.br.Locadora.entity.Contato;
import com.br.Locadora.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> encontrarPorNome(String nome) {
        return contatoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Contato> encontrarPorEmail(String email) {
        return contatoRepository.findByEmailContainingIgnoreCase(email);
    }

    public List<Contato> encontrarPorTelefone(String telefone) {
        return contatoRepository.findByTelefoneContainingIgnoreCase(telefone);
    }

}
