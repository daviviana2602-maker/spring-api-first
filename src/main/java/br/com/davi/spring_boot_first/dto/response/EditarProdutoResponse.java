package br.com.davi.spring_boot_first.dto.response;

import lombok.*;

@Getter
@Setter

@AllArgsConstructor


public class EditarProdutoResponse {
    private int id;
    private String nome;
    private int quantidade;
}