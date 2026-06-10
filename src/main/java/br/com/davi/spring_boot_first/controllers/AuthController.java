package br.com.davi.spring_boot_first.controllers;

import br.com.davi.spring_boot_first.dto.request.CreateAccountRequest;
import br.com.davi.spring_boot_first.dto.request.LoginRequest;
import br.com.davi.spring_boot_first.dto.response.CreateAccountResponse;
import br.com.davi.spring_boot_first.dto.response.LoginResponse;
import br.com.davi.spring_boot_first.service.CreateAccountService;
import br.com.davi.spring_boot_first.service.LoginService;
import br.com.davi.spring_boot_first.service.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor


public class AuthController {

    private final CreateAccountService createAccountService;
    private final LoginService loginService;
    private final TokenService tokenService;


    @PostMapping("/create")
        public CreateAccountResponse createUser(
            @Valid @RequestBody CreateAccountRequest createAccountRequest
    )
    {
        return createAccountService.createAccount(
            createAccountRequest.getName(),
            createAccountRequest.getEmail(),
            createAccountRequest.getPassword()
        );
    }


    @PostMapping("/login")
        public LoginResponse log(
            @Valid @RequestBody LoginRequest loginRequest
    )
    {
        return loginService.systemLogin(
            loginRequest.getEmail(),
            loginRequest.getPassword()
        );
    }


    @PostMapping("/{refreshToken}")
    public String token(
        @PathVariable String refreshToken
    )
    {
        return tokenService.refreshAccessToken(refreshToken);
    }

}
