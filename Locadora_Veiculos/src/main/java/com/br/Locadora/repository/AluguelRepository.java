package com.br.Locadora.repository;

import com.br.Locadora.entity.Aluguel;
import com.br.Locadora.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    @Query("SELECT a FROM Aluguel a WHERE a.cliente = : cliente")
    List<Aluguel> encontrarPorCliente(Cliente cliente);

    @Query("SELECT a FROM Aluguel a WHERE a.veiculo.disponivel = true")
    List<Aluguel> encontrarPorVeiculoDisponivel();

    @Query("SELECT a FROM Aluguel a WHERE a.dataInicio > : data")
    List<Aluguel> encontrarPorDataInicioDepoisDe(Date data);

    @Query("SELECT a FROM Aluguel a WHERE a.cliente = : cliente AND a.dataInicio BETWEEN :dataInicio AND :dataFim")
    List<Aluguel> encontrarPorClienteEDataDeInicioEntre(Cliente cliente, Date dataInicio, Date dataFim);
}
