package br.com.davi.spring_boot_first.controllers;


import br.com.davi.spring_boot_first.dto.request.CarrinhoRequest;
import br.com.davi.spring_boot_first.dto.response.CarrinhoResponse;
import br.com.davi.spring_boot_first.dto.response.ConcluirPedidoResponse;
import br.com.davi.spring_boot_first.dto.response.PedidoResponse;
import br.com.davi.spring_boot_first.entity.ConcluidosEntity;
import br.com.davi.spring_boot_first.service.CancelarPedidoService;
import br.com.davi.spring_boot_first.service.CarrinhoService;
import br.com.davi.spring_boot_first.service.ConcluirPedidoService;
import br.com.davi.spring_boot_first.service.CriarPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pedido")
@RequiredArgsConstructor    // Pega todos os private final e joga dentro do construtor


public class PedidoController {


    private final CriarPedidoService criarPedidoService;
    private final CarrinhoService carrinhoService;
    private final CancelarPedidoService cancelarPedidoService;
    private final ConcluirPedidoService concluirPedidoService;


    @PostMapping("/criar/{usuarioId}")
    public PedidoResponse gerarPedido(
        @PathVariable Long usuarioId
    )
    {
        return criarPedidoService.criarPedido(usuarioId);
    }


    @PostMapping("/itens")
    public CarrinhoResponse Carrinho(
        @RequestBody CarrinhoRequest carrinhoRequest
    )
    {
        return carrinhoService.editarCarrinho(
            carrinhoRequest.getPedidoId(),
            carrinhoRequest.getProdutoId(),
            carrinhoRequest.getQuantidade()
        );
    }


    @PostMapping("/cancelar/{pedidoId}")
    public Long excluirPedido(
        @PathVariable Long pedidoId
    )
    {
        return cancelarPedidoService.cancelarPedido(pedidoId);
    }


    @PostMapping("/concluir/{pedidoId}")
    public List<ConcluirPedidoResponse> realizarPedido(
            @PathVariable Long pedidoId
    )
    {
        return concluirPedidoService.concluirPedido(pedidoId);
    }


}
