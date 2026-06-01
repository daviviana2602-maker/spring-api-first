package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.database.entity.ProdutoEntity;
import br.com.davi.spring_boot_first.database.repository.ProdutoRepository;
import br.com.davi.spring_boot_first.dto.response.EditarProdutoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class EditarProdutoService {


    private final ProdutoRepository produtoRepository;     // declarando o campo da classe (declarado mas ainda sem valor)


    // construtor tem o mesmo nome da classe e NÃO tem tipo de retorno
    // o construtor recebe o objeto pronto do Spring (ponto onde o Spring injeta o objeto)
    public EditarProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;     // atribui ao campo da classe
    }


    public EditarProdutoResponse editar(long id, int quantidade) {

        for (ProdutoEntity produto : produtoRepository.findAll()) {

            if (produto.getId() == id) {

                if (quantidade + produto.getQuantidade() < 0 || quantidade > 100)  {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST
                    );
                }

                quantidade += produto.getQuantidade();
                produto.setQuantidade(quantidade);


                return new EditarProdutoResponse(
                        produto.getId(),
                        produto.getNome(),
                        produto.getQuantidade()
                );
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND
        );

    }
}


