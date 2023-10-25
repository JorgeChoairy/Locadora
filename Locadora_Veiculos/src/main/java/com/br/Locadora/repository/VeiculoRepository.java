package com.br.Locadora.repository;

import com.br.Locadora.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query("SELECT v FROM Veiculo v WHERE v.disponivel = true")
    List<Veiculo> encontrarPorDisponibilidade();

    @Query("SELECT v FROM Veiculo v WHERE v.marca = :marca")
    List<Veiculo> encontrarPorMarca(String marca);
}
