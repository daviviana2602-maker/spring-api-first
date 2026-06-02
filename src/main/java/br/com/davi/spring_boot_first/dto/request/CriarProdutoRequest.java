package br.com.davi.spring_boot_first.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
    @Setter


// o que o usuário envia (tipo Schema)
    public class CriarProdutoRequest {

        @NotBlank
        @Size(min = 3, max = 50)
        private String name;

        @NotNull
        @Positive
        private BigDecimal preco;

        @NotNull
        @Positive
        private Integer quantidade;
    }
