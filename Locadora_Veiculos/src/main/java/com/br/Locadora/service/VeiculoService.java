package com.br.Locadora.service;

import com.br.Locadora.entity.Veiculo;
import com.br.Locadora.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> encontrarPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo criarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void deletarVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }
}