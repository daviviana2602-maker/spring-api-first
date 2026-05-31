package br.com.davi.spring_boot_first.dto.response;

import lombok.*;

@Getter
@Setter

@AllArgsConstructor // permite construir no formato de entity ou DTO passando argumentos necessários


// O que a API devolve/retorna
public class ProdutoResponse {
    private int id;
    private String nome;
    private int quantidade;
}