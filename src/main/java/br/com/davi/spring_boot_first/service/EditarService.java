package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.database.entity.ProdutoEntity;
import br.com.davi.spring_boot_first.dto.response.ProdutoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class EditarService {

    public ProdutoResponse editar(int id, int quantidade) {

        for (ProdutoEntity produto : ProdutoService.PRODUTOS) {

            if (produto.getId() == id) {

                if (quantidade + produto.getQuantidade() < 0)  {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST
                    );
                }

                quantidade += produto.getQuantidade();
                produto.setQuantidade(quantidade);

                return new ProdutoResponse(id, quantidade);     // Retornando dto com AllArgsConstructor
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND
        );

    }
}


