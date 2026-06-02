package br.com.davi.spring_boot_first.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter

@AllArgsConstructor


public class EditarProdutoResponse {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}