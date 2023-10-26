package com.br.Locadora.repository;

import com.br.Locadora.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Consulta personalizada usando JPQL para encontrar clientes por parte do nome (ignorando maiúsculas/minúsculas)
    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    // Consulta para encontrar um cliente por CPF
    @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    Cliente encontrarPorCpf(String cpf);
}
