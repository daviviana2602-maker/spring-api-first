package br.com.davi.spring_boot_first.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class CreateAccountRequest {

    @NotBlank
    @Email
    String email;

    @NotBlank
    @Size(min = 3, max = 50)
    String name;

    @NotBlank
    @Size(min = 3, max = 50)
    String password;
}
