package br.com.davi.spring_boot_first.controllers;

import br.com.davi.spring_boot_first.dto.request.CriarContaRequest;
import br.com.davi.spring_boot_first.dto.response.CriarContaResponse;
import br.com.davi.spring_boot_first.service.CriarContaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/usuario")
@RequiredArgsConstructor    // Pega todos os private final e joga dentro do construtor


public class UsuarioController {


    private final CriarContaService criarContaService;



    @PostMapping("/criar")
        public CriarContaResponse criarUsuario(
            @Valid @RequestBody CriarContaRequest criarContaRequest
    )
    {
        return criarContaService.criarConta(
            criarContaRequest.getNome(),
            criarContaRequest.getSenha()
        );
    }




}
