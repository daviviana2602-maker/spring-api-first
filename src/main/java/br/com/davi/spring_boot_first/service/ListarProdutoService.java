package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.database.entity.ProdutoEntity;
import br.com.davi.spring_boot_first.database.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ListarProdutoService {

    private final ProdutoRepository produtoRepository;     // declarando o campo da classe (declarado mas ainda sem valor)


    // construtor tem o mesmo nome da classe e NÃO tem tipo de retorno
    // o construtor recebe o objeto pronto do Spring (ponto onde o Spring injeta o objeto)
    public ListarProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;     // atribui ao campo da classe
    }


    public List<ProdutoEntity> listarTodos() {
        return produtoRepository.findAll();
    }

}
