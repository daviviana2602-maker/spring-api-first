package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.database.entity.ProdutoEntity;
import br.com.davi.spring_boot_first.database.repository.ProdutoRepository;
import br.com.davi.spring_boot_first.dto.response.CriarProdutoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;


@Service
public class CriarProdutoService {

    private final ProdutoRepository produtoRepository;     // declarando o campo da classe (declarado mas ainda sem valor)


    // o construtor recebe o objeto pronto do Spring (ponto onde o Spring injeta o objeto)
    public CriarProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;     // atribui ao campo da classe
    }


    public CriarProdutoResponse criarNovoProduto(String nome, BigDecimal preco, int quantidade) {


        if (nome.isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST
            );
        }

        if (preco.compareTo(BigDecimal.valueOf(5000)) > 0 || preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST
            );
        }

        if (quantidade <= 0 || quantidade > 100) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST
            );
        }


        ProdutoEntity produto = new ProdutoEntity();

        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);

        produtoRepository.save(produto);


        return new CriarProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidade()
        );

    }

}
