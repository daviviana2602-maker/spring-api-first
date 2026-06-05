package br.com.davi.spring_boot_first.controllers;


import br.com.davi.spring_boot_first.dto.response.PedidoResponse;
import br.com.davi.spring_boot_first.service.CriarPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pedido")
@RequiredArgsConstructor    // Pega todos os private final e joga dentro do construtor


public class PedidoController {


    private final CriarPedidoService criarPedidoService;


    @PostMapping("/{usuarioId}")
    public PedidoResponse gerarPedido(
        @PathVariable Long usuarioId
    )
    {
        return criarPedidoService.criarPedido(usuarioId);
    }


}
