package br.com.davi.spring_boot_first.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class CarrinhoRequest {

    @NotNull
    Long pedidoId;

    @NotNull
    Long ProdutoId;

    @NotNull
    Integer quantidade;
}
