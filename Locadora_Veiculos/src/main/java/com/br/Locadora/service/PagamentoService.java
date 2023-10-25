package com.br.Locadora.service;

import com.br.Locadora.entity.Pagamento;
import com.br.Locadora.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> encontrarPorStatus(Boolean status) {
        return pagamentoRepository.findByStatus(status);
    }

}
