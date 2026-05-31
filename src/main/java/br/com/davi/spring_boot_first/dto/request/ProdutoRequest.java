package br.com.davi.spring_boot_first.dto.request;

import lombok.*;

@Getter
@Setter


// o que o usuário envia (tipo Schema)
public class ProdutoRequest {
        private int id;
        private int quantidade;
    }
