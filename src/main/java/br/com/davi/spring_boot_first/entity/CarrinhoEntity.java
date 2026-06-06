package br.com.davi.spring_boot_first.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "carrinho")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class CarrinhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pedido_id", nullable = false)
    private Long pedidoId;

    @Column(name = "produto_id", nullable = false)
    private Long produtoId;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "preco_unit", nullable = false)
    private BigDecimal precoUnit  = BigDecimal.ZERO;

    @Column(name = "preco_total", nullable = false)
    private BigDecimal precoTotal  = BigDecimal.ZERO;
}