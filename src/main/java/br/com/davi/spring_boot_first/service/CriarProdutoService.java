package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.database.entity.ProdutoEntity;
import br.com.davi.spring_boot_first.dto.response.CriarProdutoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static br.com.davi.spring_boot_first.service.ProdutoService.PRODUTOS;


@Service
public class CriarProdutoService {

    public CriarProdutoResponse criarNovoProduto(String nome, Double preco, int quantidade) {


        if (nome.isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST
            );
        }

        if (preco > 5000 || preco <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST
            );
        }

        if (quantidade <= 0 || quantidade > 100) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST
            );
        }

        int id = 0;

        for (ProdutoEntity produto : PRODUTOS) {

            if (produto.getId() > id) {
                id = produto.getId();
            }

        }

        id += 1;


        ProdutoEntity produto = new ProdutoEntity(id, nome, preco, quantidade);

        PRODUTOS.add(produto);

        return new CriarProdutoResponse(id, nome, preco, quantidade);

    }

}
