package br.com.davi.spring_boot_first.dto.response;

import br.com.davi.spring_boot_first.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor


public class LoginResponse {
    private Long id;
    private String name;
    private String email;
    private RoleEnum role;
    private String accessToken;
    private String refreshToken;
}
