package com.br.Locadora.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AluguelDTO {
    private Long id;
    private Long clienteId;
    private Long veiculoId;
    private Date dataInicio;
    private Date dataFim;
    private Double valorTotal;
    private Boolean pago;
}
