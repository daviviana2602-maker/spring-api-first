package br.com.davi.spring_boot_first.controllers;


import br.com.davi.spring_boot_first.dto.request.CartRequest;
import br.com.davi.spring_boot_first.dto.response.CartResponse;
import br.com.davi.spring_boot_first.dto.response.ConcludeOrderResponse;
import br.com.davi.spring_boot_first.dto.response.OrderResponse;
import br.com.davi.spring_boot_first.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor


public class OrderController {


    private final CreateOrderService createOrderService;
    private final CartService cartService;
    private final CancelOrderService cancelOrderService;
    private final ConcludeOrderService concludeOrderService;
    private final ListOrderService listOrderService;


    @PostMapping("/create/{userId}")
    public OrderResponse generateOrder(
        @PathVariable Long userId
    )
    {
        return createOrderService.createOrder(userId);
    }


    @PostMapping("/items")
    public CartResponse Cart(
        @Valid @RequestBody CartRequest cartRequest
    )
    {
        return cartService.editCart(
            cartRequest.getOrderId(),
            cartRequest.getProductId(),
            cartRequest.getQuantity()
        );
    }


    @PostMapping("/cancel/{orderId}")
    public Long excludeOrder(
        @PathVariable Long orderId
    )
    {
        return cancelOrderService.cancelOrder(orderId);
    }


    @PostMapping("/conclude/{orderId}")
    public List<ConcludeOrderResponse> buyOrder(
        @PathVariable Long orderId
    )
    {
        return concludeOrderService.concludeOrder(orderId);
    }


    @GetMapping("/listar/{orderId}")
    public List<CartResponse> listItems(
        @PathVariable Long orderId
    )
    {
        return listOrderService.listarItens(orderId);
    }


}
