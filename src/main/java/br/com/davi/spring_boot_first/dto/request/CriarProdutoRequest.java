package br.com.davi.spring_boot_first.dto.request;

import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter


// o que o usuário envia (tipo Schema)
    public class CriarProdutoRequest {
        private String name;
        private double preco;
        private int quantidade;
    }
