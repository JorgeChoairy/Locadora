package com.br.Locadora.repository;

import com.br.Locadora.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    @Query("SELECT p FROM Pagamento p WHERE p.status = :status")
    List<Pagamento> encontrarPorStatus(Boolean status);

    List<Pagamento> findByStatus(Boolean status);
}
