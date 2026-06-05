package br.com.davi.spring_boot_first.entity;

import br.com.davi.spring_boot_first.enums.PedidoStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "pedidos")

@Getter
@Setter
@AllArgsConstructor    // permite construir no formato de entity ou DTO passando argumentos necessários
@NoArgsConstructor


public class PedidoEntity {

    @Id     // mostra que é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)      // deixando a coluna snake_case pro SQL
    private Long usuarioId;                             // deixando camelCase pro Java

    @Column(nullable = false)
    private BigDecimal preco  = BigDecimal.ZERO;   // precisão exata, não perde casas decimais

    @Enumerated(EnumType.STRING)    // salvar como TEXTO (nome do enum), não como número
    @Column(nullable = false)
    private PedidoStatusEnum status;
}
