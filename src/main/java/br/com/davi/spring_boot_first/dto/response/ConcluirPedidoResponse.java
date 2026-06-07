package br.com.davi.spring_boot_first.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor

public class ConcluirPedidoResponse {
    private Long id;
    private Long pedidoId;
    private Long produtoId;
    private Integer quantidade;
    private BigDecimal precoUnit;
    private BigDecimal precoTotal;
}

