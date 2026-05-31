package br.com.davi.spring_boot_first.database.entity;

import lombok.*;

// Lombok Gera automaticamente os Getters e Setters para os atributos da entidade
@Getter
@Setter

@AllArgsConstructor // Gera um construtor com todos os atributos
@NoArgsConstructor // Gera um construtor vazio (sem parâmetros)
@Builder    // Permite criar objetos usando o padrão Builder (tipo pra popular)

@ToString // Cria uma representação textual do objeto para impressão e debug


public class ProdutoEntity {

    private int id;
    private String nome;
    private Double preco;
    private Integer quantidade;

}
