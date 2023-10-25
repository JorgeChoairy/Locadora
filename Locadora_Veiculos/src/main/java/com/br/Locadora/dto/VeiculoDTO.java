package com.br.Locadora.dto;

import lombok.Data;

@Data
public class VeiculoDTO {
    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private Double precoDiaria;
    private Boolean disponivel;
}
