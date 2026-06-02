package br.com.davi.spring_boot_first.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter


public class EditarProdutoRequest {
        private Long id;
        private String nome;
        private BigDecimal preco;
        private Integer quantidade;
    }
