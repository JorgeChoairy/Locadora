package com.br.Locadora.repository;

import com.br.Locadora.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query("SELECT f FROM Funcionario f WHERE f.cargo = :cargo")
    List<Funcionario> encontrarPorCargo(String cargo);
}
