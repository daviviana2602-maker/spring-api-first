package br.com.davi.spring_boot_first.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "usuarios")

@Getter
@Setter
@AllArgsConstructor    // permite construir no formato de entity ou DTO passando argumentos necessários
@NoArgsConstructor


public class UsuarioEntity {

    @Id     // mostra que é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(nullable = false)
    private String senha;
}