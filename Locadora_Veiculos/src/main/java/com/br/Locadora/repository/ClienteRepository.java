package com.br.Locadora.repository;

import com.br.Locadora.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    Cliente encontrarPorCpf(String cpf);

    List<Cliente> encontrarClientesPorNome(String nome);
}