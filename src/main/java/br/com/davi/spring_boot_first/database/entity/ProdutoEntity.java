package br.com.davi.spring_boot_first.database.entity;

import lombok.*;


@Getter
@Setter

@AllArgsConstructor

@Builder    // Permite criar objetos usando o padrão Builder (tipo pra popular)


// representa o modelo interno do sistema (geralmente banco)
public class ProdutoEntity {
    private int id;
    private String nome;
    private double preco;
    private int quantidade;
}
