package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.entity.ProdutoEntity;
import br.com.davi.spring_boot_first.repository.ProdutoRepository;
import br.com.davi.spring_boot_first.dto.response.EditarProdutoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;


@Service
public class EditarProdutoService {


    private final ProdutoRepository produtoRepository;     // declarando o campo da classe (declarado mas ainda sem valor)


    // o construtor recebe o objeto pronto do Spring (ponto onde o Spring injeta o objeto)
    public EditarProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;     // atribui ao campo da classe
    }


    private ProdutoEntity buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }


    public EditarProdutoResponse editar(long id, String nome, BigDecimal preco, Integer quantidade) {


        ProdutoEntity produto = buscarPorId(id);


        if (nome != null) {
            if (nome.length() < 3 || nome.length() > 50) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST
                );
            }
            produto.setNome(nome);
        }


        if (quantidade != null) {
            if (quantidade + produto.getQuantidade() < 0 || quantidade > 100) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST
                );
            }
            quantidade += produto.getQuantidade();
            produto.setQuantidade(quantidade);
        }


        if (preco != null) {
            if (preco.compareTo(BigDecimal.valueOf(5000)) >= 0 || preco.compareTo(BigDecimal.ZERO) <= 0) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST
                );
            }
            produto.setPreco(preco);
        }


        produtoRepository.save(produto);

        return new EditarProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidade()
        );

    }
}