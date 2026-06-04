package br.com.davi.spring_boot_first.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

@AllArgsConstructor


public class ListarProdutoResponse {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}
