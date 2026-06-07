package br.com.davi.spring_boot_first.controllers;

import br.com.davi.spring_boot_first.dto.request.CreateAccountRequest;
import br.com.davi.spring_boot_first.dto.request.LoginRequest;
import br.com.davi.spring_boot_first.dto.response.CreateAccountResponse;
import br.com.davi.spring_boot_first.dto.response.LoginResponse;
import br.com.davi.spring_boot_first.service.CreateAccountService;
import br.com.davi.spring_boot_first.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor


public class UserController {

    private final CreateAccountService createAccountService;
    private final LoginService loginService;


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

}
