package br.com.davi.spring_boot_first.dto.response;

import br.com.davi.spring_boot_first.enums.PedidoStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class PedidoResponse {
    private Long id;
    private Long usuarioId;
    private String nome;
    private PedidoStatusEnum status;
}