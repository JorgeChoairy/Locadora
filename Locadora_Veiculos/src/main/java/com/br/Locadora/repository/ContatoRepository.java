package com.br.Locadora.repository;

import com.br.Locadora.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    @Query("SELECT c FROM Contato c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Contato> encontrarPorNomeContendoIgnoreCase(String nome);

    @Query("SELECT c FROM Contato c WHERE LOWER(c.email) LIKE LOWER(CONCAT('%', :email, '%'))")
    List<Contato> encontrarPorEmailContendoIgnoreCase(String email);

    @Query("SELECT c FROM Contato c WHERE LOWER(c.telefone) LIKE LOWER(CONCAT('%', :telefone, '%'))")
    List<Contato> encontrarPorTelefoneContendoIgnoreCase(String telefone);

    List<Contato> findByNomeContainingIgnoreCase(String nome);

    List<Contato> findByEmailContainingIgnoreCase(String email);

    List<Contato> findByTelefoneContainingIgnoreCase(String telefone);
}

