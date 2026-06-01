package br.com.davi.spring_boot_first.dto.request;

import lombok.*;

@Getter
@Setter


public class EditarProdutoRequest {
        private Long id;
        private Integer quantidade;
    }
