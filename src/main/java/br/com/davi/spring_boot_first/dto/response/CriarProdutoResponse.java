package br.com.davi.spring_boot_first.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor


public class CriarProdutoResponse {
    private int id;
    private String nome;
    private double preco;
    private int quantidade;
}
