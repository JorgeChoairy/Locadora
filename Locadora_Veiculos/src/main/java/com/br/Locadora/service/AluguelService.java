package com.br.Locadora.service;

import com.br.Locadora.entity.Aluguel;
import com.br.Locadora.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    public List<Aluguel> listarTodos() {
        return aluguelRepository.findAll();
    }

    public Optional<Aluguel> encontrarPorId(Long id) {
        return aluguelRepository.findById(id);
    }

    public Aluguel criarAluguel(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    public void deletarAluguel(Long id) {
        aluguelRepository.deleteById(id);
    }

}
