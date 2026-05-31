package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.database.entity.ProdutoEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProdutoService {   // @Service faz o Spring criar: ProdutoService produtoService = new ProdutoService(); (um Bean)

    public static final List<ProdutoEntity> PRODUTOS = List.of(
            ProdutoEntity.builder()
                    .id(1)
                    .nome("celular")
                    .preco(600.38)
                    .quantidade(20)
                    .build(),
            ProdutoEntity.builder()
                    .id(2)
                    .nome("computador")
                    .preco(350.97)
                    .quantidade(5)
                    .build(),
            ProdutoEntity.builder()
                    .id(3)
                    .nome("tablet")
                    .preco(187.90)
                    .quantidade(15)
                    .build()
    );

    public List<ProdutoEntity> getProdutos() {
        return PRODUTOS;
    }

}
