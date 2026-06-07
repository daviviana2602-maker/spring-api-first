package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.dto.response.CartResponse;
import br.com.davi.spring_boot_first.entity.CartEntity;
import br.com.davi.spring_boot_first.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ListOrderService {

    private final CartRepository cartRepository;


    public ListOrderService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    public List<CartResponse> listarItens(Long orderId) {

        List<CartEntity> carrinho = cartRepository.findByOrderId(orderId);


        return carrinho.stream()
                .map(item -> new CartResponse(
                        item.getId(),
                        item.getOrderId(),
                        item.getProductId(),
                        item.getQuantity(),
                        item.getUnitPrice(),
                        item.getFullPrice()
                ))
                .toList();

    }

}
