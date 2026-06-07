package br.com.davi.spring_boot_first.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class CartRequest {

    @NotNull
    Long orderId;

    @NotNull
    Long productId;

    @NotNull
    Integer quantity;
}
