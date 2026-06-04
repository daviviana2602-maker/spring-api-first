package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.entity.ProdutoEntity;
import br.com.davi.spring_boot_first.repository.ProdutoRepository;
import br.com.davi.spring_boot_first.dto.response.ListarProdutoResponse;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ListarProdutoService {

    private final ProdutoRepository produtoRepository;     // declarando o campo da classe (declarado mas ainda sem valor)


    // o construtor recebe o objeto pronto do Spring (ponto onde o Spring injeta o objeto)
    public ListarProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;     // atribui ao campo da classe
    }


    public List<ListarProdutoResponse> listarProdutos() {

        List<ProdutoEntity> produtos = produtoRepository.findAll();

        return produtos.stream()    // passa por cada item da lista em sequência
            .map(produto -> new ListarProdutoResponse(  // transforma Entity em Response
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidade()
            ))
            .toList();  // chama o stream e insere itens passados na lista

        }

}
