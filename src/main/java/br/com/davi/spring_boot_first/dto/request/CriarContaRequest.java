package br.com.davi.spring_boot_first.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class CriarContaRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    String nome;

    @NotBlank
    @Size(min = 3, max = 50)
    String senha;
}
