package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.entity.ProdutoEntity;
import br.com.davi.spring_boot_first.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;



@Service
public class DeletarProdutoService {


    private final ProdutoRepository produtoRepository;


    public DeletarProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Transactional
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