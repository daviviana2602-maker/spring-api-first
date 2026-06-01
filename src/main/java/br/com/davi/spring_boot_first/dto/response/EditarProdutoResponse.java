package br.com.davi.spring_boot_first.dto.response;

import lombok.*;

@Getter
@Setter

@AllArgsConstructor


public class EditarProdutoResponse {
    private Long id;
    private String nome;
    private Integer quantidade;
}