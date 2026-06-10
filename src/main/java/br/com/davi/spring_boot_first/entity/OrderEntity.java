package br.com.davi.spring_boot_first.entity;

import br.com.davi.spring_boot_first.enums.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "orders")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(nullable = false)
    private BigDecimal price  = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatusEnum status;
}
