package br.com.davi.spring_boot_first.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class CreateAccountResponse {
    private Long id;
    private String name;
    private String email;
}
