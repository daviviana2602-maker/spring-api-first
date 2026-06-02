package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.database.entity.ProdutoEntity;
import br.com.davi.spring_boot_first.database.repository.ProdutoRepository;
import org.springframework.stereotype.Service;



@Service
public class DeletarProdutoService {


    private final ProdutoRepository produtoRepository;     // declarando o campo da classe (declarado mas ainda sem valor)


    // o construtor recebe o objeto pronto do Spring (ponto onde o Spring injeta o objeto)
    public DeletarProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;     // atribui ao campo da classe
    }


    private ProdutoEntity buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }


    public Long deletarProduto(Long id) {

        ProdutoEntity produto = buscarPorId(id);
        produtoRepository.delete(produto);

        return id;

    }
}